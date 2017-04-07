package com.stock.huidan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.employee.Employee;

import com.hrbank.business.frame.BusinessAction;
import com.stock.util.FileUpload;
import com.stock.yonghushuju.ImportValidator;
import com.stock.yonghushuju.YonghuDataService;
import com.takucin.aceeci.common.Constant;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.PropertyReader;

public class PhotoUploadEditAction extends BusinessAction{
	PhotoService  service = new PhotoService();
	YonghuDataService serviceData = new YonghuDataService();
	private ImportValidator validator = new ImportValidator();
	private Log log = LogFactory.getLog(this.getClass());
	public static final String FTP = PropertyReader.readProperty("BaseIp","photo_ftp_ip");	
	public static final String FTP_USER = PropertyReader.readProperty("BaseIp","photo_ftp_user");	
	public static final String FTP_PWD = PropertyReader.readProperty("BaseIp","photo_ftp_password");	
	 /**
     * 查看照片按钮，初始化查看照片界面
     */
	public ActionForward showPhoto(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		String selectuuid = request.getParameter("uuid");
		photoUploadForm.setUUID(selectuuid);
		DataRow photouploader = service.getPhotoUploadList(photoUploadForm);
		photoUploadForm.setUUID(photouploader.getDataElement("PK_ID").getString());
		photoUploadForm.setXiaoqu(photouploader.getDataElement("xiaoqu").getString());
		photoUploadForm.setDizhi(photouploader.getDataElement("dizhi").getString());
		photoUploadForm.setShoukuanshijian(photouploader.getDataElement("shoukuanshijian").getString());
		photoUploadForm.setWangluo(photouploader.getDataElement("wangluo").getString());
		photoUploadForm.setDianhua(photouploader.getDataElement("dianhua").getString());
		photoUploadForm.setYewu(photouploader.getDataElement("yewu").getString());
		return mapping.findForward(FW_INIT_INSERT);
	}
    /**
     * 查看照片按钮，异步获取当前账户所有图片
     */
    public ActionForward getAllPhotos(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	try {
	    String string = "";
	    String xiaoqu = request.getParameter("xiaoqu");
	    xiaoqu = java.net.URLDecoder.decode(xiaoqu, "utf-8");

	    String dizhi = request.getParameter("dizhi");
	    dizhi = java.net.URLDecoder.decode(dizhi, "utf-8");
	    String temppath = PropertyReader.readProperty("BaseIp","photo_temp_path");
	    String[] exts = new String[] {"jpg","png","JPG","PNG"};
		Collection<File> files =FileUtils.listFiles(new File(temppath),exts,true);
		for (Iterator iterator = files.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			String filename = file.getName();
			if(filename.startsWith(xiaoqu+dizhi)) {
				string = string + FileUpload.getImageStr(file.getAbsolutePath()) + "|" +file.getName() + "|";
			}
		}
		
	    if (string.length() > 1) {
		string = string.substring(0, string.length() - 1);
	    }
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html");
	    response.getWriter().print(string);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return mapping.findForward("null");

    }

	/*****
	 * 一览界面点击删除照片按钮执行action
	 *****/
	public ActionForward deletephotos(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		String[] uuids = photoUploadForm.getUUIDS();
		String temppath = PropertyReader.readProperty("BaseIp",
				"photo_temp_path");
		String[] exts = new String[] { "jpg", "png","JPG","PNG" };
		Collection<File> files = FileUtils.listFiles(new File(temppath), exts,
				true);
		for (int i = 0; i < uuids.length; i++) {
			photoUploadForm.setUUID(uuids[i]);
			DataRow photouploader = service.getPhotoUploadList(photoUploadForm);
			String yonghujti = photouploader.getDataElement("yonghuzhuangtai").getString();
			if(!"已上传".equals(yonghujti)) {
				CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "只能删除状态为已上传的照片！");
				saveMessage(message, request);
				return mapping.findForward(photoUploadForm.getGamenKbn());
			}
			for (Iterator iterator = files.iterator(); iterator.hasNext();) {
				File file = (File) iterator.next();
				String filename = file.getName();
				if (filename.startsWith(photouploader.getDataElement("xiaoqu")
						.getString()
						+ photouploader.getDataElement("dizhi").getString())) {
					FileUtils.deleteQuietly(file);
				}
			}
		}
		Employee loginuser = (Employee) request.getSession().getAttribute(Constant.LOGIN_USER);
		service.update_jti(photoUploadForm, "未上传",loginuser.getEmployeeName());
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "照片删除成功！");
		saveMessage(message, request);
		return mapping.findForward(photoUploadForm.getGamenKbn());
	}
	
	/*****
	 * 一览界面点击删除信息按钮执行action
	 *****/
	public ActionForward deleteinfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		Employee loginuser = (Employee) request.getSession().getAttribute(Constant.LOGIN_USER);
		String[] uuids = photoUploadForm.getUUIDS();
		for (int i = 0; i < uuids.length; i++) {
			photoUploadForm.setUUID(uuids[i]);
			DataRow photouploader = service.getPhotoUploadList(photoUploadForm);
			String yonghujti = photouploader.getDataElement("yonghuzhuangtai").getString();
			if("已上传".equals(yonghujti)) {
				CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "只能删除状态为未上传和套餐包含的信息！");
				saveMessage(message, request);
				return mapping.findForward(photoUploadForm.getGamenKbn());
			}
		}
		service.update_tijiao(photoUploadForm, "删除",loginuser.getEmployeeName());
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "信息删除成功！");
		saveMessage(message, request);
		return mapping.findForward(photoUploadForm.getGamenKbn());
	}
	/*****
	 * 一览界面点击核对提交按钮执行action
	 *****/
	public ActionForward auditphoto(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		Employee loginuser = (Employee) request.getSession().getAttribute(Constant.LOGIN_USER);
		service.update_tijiao(photoUploadForm,"1",loginuser.getEmployeeName());
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "核对提交成功！");
		saveMessage(message, request);
		return mapping.findForward(photoUploadForm.getGamenKbn());
	}
	/*****
	 * 审核一览界面点击核对提交按钮执行action
	 *****/
	public ActionForward auditphotoFTP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		String[] uuids = photoUploadForm.getUUIDS();
		String temppath = PropertyReader.readProperty("BaseIp",
				"photo_temp_path");
		String[] exts = new String[] { "jpg", "png","JPG","PNG" };
		Collection<File> files = FileUtils.listFiles(new File(temppath), exts,
				true);
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(FTP);
			ftpClient.login(FTP_USER, FTP_PWD);
			ftpClient.enterLocalPassiveMode();
		    ftpClient.setControlEncoding("GBK");
            //设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.changeWorkingDirectory("gd_ftp");
		} catch (Exception e1) {
			log.error("ftp异常：" + e1.toString());
        	CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "FTP连接不上！" + e1.toString());
    		saveMessage(message, request);
    		return mapping.findForward(photoUploadForm.getGamenKbn());
		} 
		FileInputStream fis1 = null;
		try {
		for (int i = 0; i < uuids.length; i++) {
			photoUploadForm.setUUID(uuids[i]);
			DataRow photouploader = service.getPhotoUploadList(photoUploadForm);
			for (Iterator iterator = files.iterator(); iterator.hasNext();) {
				File file = (File) iterator.next();
				String filename = file.getName();
				if (filename.startsWith(photouploader.getDataElement("xiaoqu")
						.getString()
						+ photouploader.getDataElement("dizhi").getString())) {
					fis1 = new FileInputStream(file);
					 boolean storeFile = ftpClient.storeFile(new String(file.getName().getBytes("GBK"),"ISO-8859-1"), fis1);
			            if(storeFile) {
			            	IOUtils.closeQuietly(fis1);
			            	FileUtils.deleteQuietly(file);
			            } else {
			            	 log.error("客户端网络异常！");
			            	 CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "客户端网络异常");
			         		saveMessage(message, request);
			         		return mapping.findForward(photoUploadForm.getGamenKbn());
			            }
				}
			}
		}
		}catch (IOException e) {
	            e.printStackTrace();
	            log.error("ftp异常："  + "FTP客户端出错！");
	            CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "FTP客户端出错！" + e.toString());
         		saveMessage(message, request);
         		return mapping.findForward(photoUploadForm.getGamenKbn());
	        } finally {
	            IOUtils.closeQuietly(fis1);
	            try {
	                ftpClient.disconnect();
	            } catch (IOException e) {
	                e.printStackTrace();
	                log.error("关闭FTP连接发生异常！" + e.toString());
	                CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "关闭FTP连接发生异常！" + e.toString());
	         		saveMessage(message, request);
	         		return mapping.findForward(photoUploadForm.getGamenKbn());
	            }
	        }
		Employee loginuser = (Employee) request.getSession().getAttribute(Constant.LOGIN_USER);
		service.update_tijiao(photoUploadForm,"2",loginuser.getEmployeeName());
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "核对提交成功！");
		saveMessage(message, request);
		return mapping.findForward(photoUploadForm.getGamenKbn());
	}
	
	/*****
	 * 一览界面点击错误退回按钮执行action
	 *****/
	public ActionForward wrongback(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		Employee loginuser = (Employee) request.getSession().getAttribute(Constant.LOGIN_USER);
		service.update_tijiao(photoUploadForm,"0",loginuser.getEmployeeName());
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "错误退回成功！");
		saveMessage(message, request);
		return mapping.findForward(photoUploadForm.getGamenKbn());
	}
	/*****
	 * 一览界面点击套餐包含按钮执行action
	 *****/
	public ActionForward taocaninclude(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		photoUploadForm.setUUIDS(new String[] {photoUploadForm.getUUID()});
		DataRow photouploader = service.getPhotoUploadList(photoUploadForm);
		String dianshi = photouploader.getDataElement("dianshi").getString();
		if(dianshi!=null&&!"".equals(dianshi)&&!"0".equals(dianshi)) {
			int count  = service.getPhotoUploadTaocan(photoUploadForm);
			if(count!=0) {
				Employee loginuser = (Employee) request.getSession().getAttribute(Constant.LOGIN_USER);
				service.update_jti(photoUploadForm,"套餐包含",loginuser.getEmployeeName());
				CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "套餐包含成功！");
				saveMessage(message, request);
				return mapping.findForward(photoUploadForm.getGamenKbn());
				
			}
		}
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "套餐包含失败！");
		saveMessage(message, request);
		return mapping.findForward(photoUploadForm.getGamenKbn());
	}
	/*****
	 * 一览界面点击照片上传按钮执行action
	 *****/
	public ActionForward uploadPhoto(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		String selectuuid = request.getParameter("uuid");
		photoUploadForm.setUUID(selectuuid);
		DataRow photouploader = service.getPhotoUploadList(photoUploadForm);
		photoUploadForm.setXiaoqu(photouploader.getDataElement("xiaoqu").getString());
		photoUploadForm.setDizhi(photouploader.getDataElement("dizhi").getString());
		photoUploadForm.setShoukuanshijian(photouploader.getDataElement("shoukuanshijian").getString());
		photoUploadForm.setWangluo(photouploader.getDataElement("wangluo").getString());
		photoUploadForm.setDianhua(photouploader.getDataElement("dianhua").getString());
		photoUploadForm.setYewu(photouploader.getDataElement("yewu").getString());
		return mapping.findForward(FW_INIT_INSERT2);
	}
	/*****
	 * 上传按钮执行action
	 *****/
	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		String temppath = PropertyReader.readProperty("BaseIp","photo_temp_path");
		FormFile file = photoUploadForm.getFormFile();
		String error = validator.fileUplodatePhotoValidate(file);
		CommonMessage message = null;
		String filename = file.getFileName();
		String xiaoqudizhi = photoUploadForm.getXiaoqu()+photoUploadForm.getDizhi();
		if(!filename.startsWith(xiaoqudizhi)) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "上传照片格式：“小区&地址”如，"+xiaoqudizhi);
			saveMessage(message, request);
			return mapping.findForward(FW_ERROR);
		}
		if (error != null) {
			saveMessage(error, request);
			return mapping.findForward(FW_INIT_INSERT2);
		} 
		InputStream input = file.getInputStream();
		String extName = file.getFileName().substring(file.getFileName().lastIndexOf("."));
		String time =  Common.formatDate(new Date(), "yyyy年MM月dd 日HH时mm分ss秒");
		File existfile = FileUtils.getFile(temppath+"\\"+xiaoqudizhi+"("+time+")"+extName);
		String[] exts = new String[] {"jpg","png","JPG","PNG"};
		Collection<File> files =FileUtils.listFiles(new File(temppath),exts,true);
		while(existfile.exists()) {
			time =  Common.formatDate(new Date(), "yyyy年MM月dd 日HH时mm分ss秒");
			existfile = FileUtils.getFile(temppath+"\\"+xiaoqudizhi+"("+time+")"+extName);
		}
		FileUpload.fileUp(file, temppath, xiaoqudizhi+"("+time+")");
		photoUploadForm.setUUIDS(new String[] {photoUploadForm.getUUID()});
		Employee loginuser = (Employee) request.getSession().getAttribute(Constant.LOGIN_USER);
		service.update_jti(photoUploadForm, "已上传",loginuser.getEmployeeName());
		message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "上传成功！");
		saveMessage(message, request);
		return mapping.findForward("autoclose");
	}
	
	 /**
     * 查看照片按钮，初始化查看FTP照片界面
     */
	public ActionForward showPhotoFTP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		String selectuuid = request.getParameter("uuid");
		photoUploadForm.setUUID(selectuuid);
		DataRow photouploader = serviceData.getDataByUUID(selectuuid);
		photoUploadForm.setXiaoqu(photouploader.getDataElement("xiaoqu").getString());
		photoUploadForm.setDizhi(photouploader.getDataElement("dizhi").getString());
		photoUploadForm.setShoukuanshijian(photouploader.getDataElement("shoukuanshijian").getString());
		photoUploadForm.setWangluo(photouploader.getDataElement("wangluo").getString());
		photoUploadForm.setDianhua(photouploader.getDataElement("dianhua").getString());
		photoUploadForm.setYewu(photouploader.getDataElement("yewu").getString());
		return mapping.findForward("toFTPview");
	}
    /**
     * 查看照片按钮，异步获取当前账户中FTP所有图片
     */
    public ActionForward getAllPhotosFTP(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	try {
	    String string = "";
	    String xiaoqu = request.getParameter("xiaoqu");
	    xiaoqu = java.net.URLDecoder.decode(xiaoqu, "utf-8");

	    String dizhi = request.getParameter("dizhi");
	    dizhi = java.net.URLDecoder.decode(dizhi, "utf-8");
	    
	    String temppath = PropertyReader.readProperty("BaseIp",
				"photo_temp_path")+"\\temp";
	    
	    FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(FTP);
			ftpClient.login(FTP_USER, FTP_PWD);
			ftpClient.enterLocalPassiveMode();
		    ftpClient.setControlEncoding("GBK");
            //设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.changeWorkingDirectory("gd_ftp");
		} catch (Exception e1) {
			log.error("ftp异常：" + e1.toString());
		} 
		FileOutputStream fis1 = null;
		try {
			FTPFile[] filelist = ftpClient.listFiles();
				for(int i=0;i<filelist.length;i++) {
				String filename = filelist[i].getName();
				if (filename.startsWith(xiaoqu + dizhi)) {
					File localFile = new File(temppath+"/"+filename);  
	                  
	               fis1 = new FileOutputStream(localFile);   
					 boolean storeFile =ftpClient.retrieveFile(new String(filename.getBytes("GBK"),"ISO-8859-1"), fis1);
			            if(storeFile) {
			            } else {
			            	 log.error("客户端网络异常！");
			            }
				}
				}
		}catch (IOException e) {
	            e.printStackTrace();
	            log.error("ftp异常："  + "FTP客户端出错！");
	        } finally {
	            IOUtils.closeQuietly(fis1);
	        }
		ftpClient.changeToParentDirectory();
		ftpClient.changeWorkingDirectory("normal");
		try {
			FTPFile[] filelist = ftpClient.listFiles();
				for(int i=0;i<filelist.length;i++) {
				String filename = filelist[i].getName();
				if (filename.startsWith(xiaoqu + dizhi)) {
					File localFile = new File(temppath+"/"+filename);  
	                  
	               fis1 = new FileOutputStream(localFile);   
					 boolean storeFile =ftpClient.retrieveFile(new String(filename.getBytes("GBK"),"ISO-8859-1"), fis1);
			            if(storeFile) {
			            } else {
			            	 log.error("客户端网络异常！");
			            }
				}
				}
		}catch (IOException e) {
	            e.printStackTrace();
	            log.error("ftp异常："  + "FTP客户端出错！");
	        } finally {
	            IOUtils.closeQuietly(fis1);
	            try {
	                ftpClient.disconnect();
	            } catch (IOException e) {
	                e.printStackTrace();
	                log.error("关闭FTP连接发生异常！" + e.toString());
	            }
	        }
	    
	    
	    String[] exts = new String[] {"jpg","png","JPG","PNG"};
		Collection<File> files =FileUtils.listFiles(new File(temppath),exts,true);
		for (Iterator iterator = files.iterator(); iterator.hasNext();) {
			File file = (File) iterator.next();
			String filename = file.getName();
			if(filename.startsWith(xiaoqu+dizhi)) {
				string = string + FileUpload.getImageStr(file.getAbsolutePath()) + "|" +file.getName() + "|";
				FileUtils.deleteQuietly(file);
			}
		}
		
	    if (string.length() > 1) {
		string = string.substring(0, string.length() - 1);
	    }
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html");
	    response.getWriter().print(string);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return mapping.findForward("null");

    }
    
    
	/*****
	 * 审核一览界面点击核对提交按钮执行action
	 *****/
	public ActionForward auditAndNext(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhotoUploadForm photoUploadForm = (PhotoUploadForm) form;
		String temppath = PropertyReader.readProperty("BaseIp",
				"photo_temp_path");
		String[] exts = new String[] { "jpg", "png","JPG","PNG" };
		Collection<File> files = FileUtils.listFiles(new File(temppath), exts,
				true);
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(FTP);
			ftpClient.login(FTP_USER, FTP_PWD);
			ftpClient.enterLocalPassiveMode();
		    ftpClient.setControlEncoding("GBK");
            //设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.changeWorkingDirectory("gd_ftp");
		} catch (Exception e1) {
			log.error("ftp异常：" + e1.toString());
        	CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "FTP连接不上！" + e1.toString());
    		saveMessage(message, request);
    		return mapping.findForward(photoUploadForm.getGamenKbn());
		} 
		FileInputStream fis1 = null;
		try {
			for (Iterator iterator = files.iterator(); iterator.hasNext();) {
				File file = (File) iterator.next();
				String filename = file.getName();
				if (filename.startsWith(photoUploadForm.getXiaoqu()+photoUploadForm.getDizhi())) {
					fis1 = new FileInputStream(file);
					 boolean storeFile = ftpClient.storeFile(new String(file.getName().getBytes("GBK"),"ISO-8859-1"), fis1);
			            if(storeFile) {
			            	IOUtils.closeQuietly(fis1);
			            	FileUtils.deleteQuietly(file);
			            } else {
			            	 log.error("客户端网络异常！");
			            	 CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "客户端网络异常");
			         		saveMessage(message, request);
			         		return mapping.findForward(photoUploadForm.getGamenKbn());
			            }
				}
			}
		}catch (IOException e) {
	            e.printStackTrace();
	            log.error("ftp异常："  + "FTP客户端出错！");
	            CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "FTP客户端出错！" + e.toString());
         		saveMessage(message, request);
         		return mapping.findForward(photoUploadForm.getGamenKbn());
	        } finally {
	            IOUtils.closeQuietly(fis1);
	            try {
	                ftpClient.disconnect();
	            } catch (IOException e) {
	                e.printStackTrace();
	                log.error("关闭FTP连接发生异常！" + e.toString());
	                CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "关闭FTP连接发生异常！" + e.toString());
	         		saveMessage(message, request);
	         		return mapping.findForward(photoUploadForm.getGamenKbn());
	            }
	        }
		Employee loginuser = (Employee) request.getSession().getAttribute(Constant.LOGIN_USER);
		photoUploadForm.setUUIDS(new String[] {photoUploadForm.getUUID()});
		service.update_tijiao(photoUploadForm,"2",loginuser.getEmployeeName());
		DataSet<DataRow> nextdata = service.getPhotoAuditList(photoUploadForm, 0, 10);
		if(nextdata.size()==0) {
			CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "没有剩余的需要审核的数据！");
			saveMessage(message, request);
			return mapping.findForward("autoclose");
		}
		String nextuuid = nextdata.get(0).getDataElement("PK_ID").getString();
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "核对提交成功！");
		saveMessage(message, request);
		photoUploadForm.setUUID(nextdata.get(0).getDataElement("PK_ID").getString());
		photoUploadForm.setXiaoqu(nextdata.get(0).getDataElement("xiaoqu").getString());
		photoUploadForm.setDizhi(nextdata.get(0).getDataElement("dizhi").getString());
		photoUploadForm.setShoukuanshijian(nextdata.get(0).getDataElement("shoukuanshijian").getString());
		photoUploadForm.setWangluo(nextdata.get(0).getDataElement("wangluo").getString());
		photoUploadForm.setDianhua(nextdata.get(0).getDataElement("dianhua").getString());
		photoUploadForm.setYewu(nextdata.get(0).getDataElement("yewu").getString());
		return mapping.findForward(FW_INIT_INSERT);
	}
	
    /**
     * 点击核对备注按钮，添加核对备注信息
     */
    public ActionForward heduibeizhu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	try {
	    String string = "";
	    String uuid = request.getParameter("uuid");

	    String text = request.getParameter("text");
	    text = java.net.URLDecoder.decode(text, "utf-8");
	    service.update_hedui(uuid,text);
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html");
	    response.getWriter().print(string);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return mapping.findForward("null");

    }
}
