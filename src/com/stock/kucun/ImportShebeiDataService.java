package com.stock.kucun; 

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.stock.yonghushuju.ImportService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-14 上午09:44:35 
 * 类说明 
 */
public class ImportShebeiDataService extends BusinessService {
	
	private Log log = LogFactory.getLog(this.getClass());
	private ImportService service = new ImportService();
	private CommonDao dao = new CommonDao();
	boolean  flag = true;
	
	//private DataValidator validator = new DataValidator();
	//StringBuffer sb = new StringBuffer();
	Integer count = 0 ;
	String uuid = null ;
	
	/**
	 * parse input to list.
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public List<ShebeiEntityData> parse(InputStream input) throws Exception{
		List<ShebeiEntityData> list = new ArrayList<ShebeiEntityData>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);
		DataSet<DataRow> query = dao.executeQuery("getUserInfoJobId", new ParameterSet());
		int i = 1;//从excel第一行开始取数据
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			ShebeiEntityData entityTel = new ShebeiEntityData();
			String[] values = service.convertRow(hssfRow, 53);//excel 读取的列数

			entityTel.setXianghao(values[0]);//箱号
			entityTel.setShebeizhuangtai(values[1]);//设备状态
			entityTel.setRukuriqi(values[2]);//入库日期
			for (int j = 0; j < query.size(); j++) {
				if (query.get(j).getDataElement("Job_ID").getString().equals(values[3])) {
					flag = true;
					break ;	
				} else {
					flag = false;
					continue;	
				}
			}
			if(flag == false) {
				break;
			} else {
				entityTel.setRukuren(values[3]);//入库人
			}
			entityTel.setShebeileixing(values[4]);//设备类型
			entityTel.setShebeixinghao(values[5]);//设备型号
			entityTel.setXiaoqurukuriqi(values[6]);//小区入库日期
			entityTel.setRukuxiaoqu(values[7]);//入库小区
			entityTel.setLingquren(values[8]);//领取人
			entityTel.setAnzhuangdidian(values[9]);//安装地点
			entityTel.setAnzhuangshijian(values[10]);//安装时间
			entityTel.setZhuceweizhi(values[11]);//注册位置
			entityTel.setMac(values[12]);//MAC
			entityTel.setMcid(values[13]);//MCID
			entityTel.setShujuip(values[14]);//数据ip
			entityTel.setBeizhu(values[15]);//备注
			
				
			list.add(entityTel);
			i++;
		}
		
		return list;
	}
	
	public List<ShebeiEntityData> parse1(InputStream input) throws Exception{
		List<ShebeiEntityData> list = new ArrayList<ShebeiEntityData>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);
		//DataSet<DataRow> query = dao.executeQuery("getUserInfoJobId", new ParameterSet());
		int i = 1;//从excel第四行开始取数据
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			ShebeiEntityData entityTel = new ShebeiEntityData();
			String[] values = service.convertRow(hssfRow, 53);//excel 读取的列数
			entityTel.setUUID(values[0]);//编号
			entityTel.setXianghao(values[1]);//箱号
			entityTel.setShebeizhuangtai(values[2]);//设备状态
			entityTel.setRukuriqi(values[3]);//入库日期
			entityTel.setRukuren(values[4]);//入库人
			entityTel.setShebeileixing(values[5]);//设备类型
			entityTel.setShebeixinghao(values[6]);//设备型号
			entityTel.setXiaoqurukuriqi(values[7]);//小区入库日期
			entityTel.setRukuxiaoqu(values[8]);//入库小区
			entityTel.setLingquren(values[9]);//领取人
			entityTel.setAnzhuangdidian(values[10]);//安装地点
			entityTel.setAnzhuangshijian(values[11]);//安装时间
			entityTel.setZhuceweizhi(values[12]);//注册位置
			entityTel.setMac(values[13]);//MAC
			entityTel.setMcid(values[14]);//MCID
			entityTel.setShujuip(values[15]);//数据ip
			entityTel.setBeizhu(values[16]);//备注
			
				
			list.add(entityTel);
			i++;
		}
		
		return list;
	}
	
	/**
	 * 插入用户数据
	 * 
	 * @param classid
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public CommonMessage insert(InputStream input) throws Exception {
		List<ShebeiEntityData> list = new ArrayList<ShebeiEntityData>();
		
		try {
			list = parse(input);
			if (flag == false) {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "入库人员工编号不存在！");
			}
			if (null == list || list.size() == 0) {
				return new CommonMessage(ErrorConstant.IMPORT_PGD_EXECL_SAMECARDID);
			}
		
		} catch (Exception e) {
			return new CommonMessage(ErrorConstant.UP_DATA_ERROR);
		}
		
		
		try {
			openTransaction();
			//int i = 1;
			for (ShebeiEntityData sbData : list) {
				//空行校验
				//String error = validator.insertValidate(pgd);
				/*if(error != null) {
					return new CommonMessage(error, String.valueOf(i));
				}*/
				//getUserInfo().getEmployeeName()
				//Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss")
				ParameterModel model = new ParameterModel();
				model.put("Name", "");
				model.put("Price", "");
				model.put("EqInPerson", sbData.getRukuren());
				model.put("EqInTime",sbData.getRukuriqi());
				model.put("Create_person", getUserInfo().getEmployeeName());
				model.put("Create_time", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				model.put("Lifecycle_sta", "0");
				model.put("EqState", "1");
				model.put("EqRemark", sbData.getBeizhu());
				model.put("EqQuantity", "1");
				model.put("EqType", sbData.getShebeileixing());
				model.put("EqVersion", sbData.getShebeixinghao());
				model.put("EqRegister", sbData.getZhuceweizhi());
				model.put("EqMAC", sbData.getMac());
				model.put("EqMCID", sbData.getMcid());
				model.put("EqIp", sbData.getShujuip());
				model.put("EqBoxNum", sbData.getXianghao());
				dao.insert("product", model);
				 
			}
			commit();
		}
		catch (Exception e) {
				rollback();
				log.error(e);
				return new CommonMessage(ErrorConstant.PGD_DATA_ERROR);
			}
			return new CommonMessage(Constant.SUCCESS);
		}
	
	public CommonMessage update(InputStream input) throws Exception {
		List<ShebeiEntityData> list = new ArrayList<ShebeiEntityData>();
		boolean  flag1 = true;
		String error = "系统编号：";
		try {
			list = parse1(input);
			if (null == list || list.size() == 0) {
				return new CommonMessage(ErrorConstant.IMPORT_PGD_EXECL_SAMECARDID);
			}
		
		} catch (Exception e) {
			log.error(e);
			return new CommonMessage(ErrorConstant.UP_DATA_ERROR);
		}
		String employeeName = getUserInfo().getEmployeeName();
		String nowDate = Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		
		try {
			openTransaction();
		
			for (ShebeiEntityData sbData : list) {
			
				String uuid = sbData.getUUID();
				String mcid = sbData.getMcid();
				ParameterSet set = new ParameterSet();
				set.add("CommunityPile_ID", "@CommunityPile_ID", uuid);
				
				DataSet<DataRow> executeQuery = dao.executeQuery("getDaipipeiShebeiInfo", set);
				if (executeQuery.size() < 1){
					return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "系统编号不存在，请重新导出数据！");
				}
				String eqsta_name = executeQuery.get(0).getDataElement("eqsta_name").getString();
				String cRemark = executeQuery.get(0).getDataElement("CpRemark").getString();
				String product_ID = executeQuery.get(0).getDataElement("Product_ID").getString();
				if(!eqsta_name.equals("待匹配")) {
					error += "," + uuid;
					flag1 = false;
				} else {
					dao.execute("insertDaipipeiInfo", set);
					//ParameterModel model  = new ParameterModel(); 
				/*	ParameterSet set1 = new ParameterSet();
					set1.add("@mcid", "@mcid", mcid);
					if (sbData.getAnzhuangdidian().equals("")) {
					} else {
						set1.add("@Install_site", "@Install_site", sbData.getAnzhuangdidian());
					}
					if (sbData.getAnzhuangshijian().equals("")) {
					} else {
						set1.add("@Install_time", "@Install_time", sbData.getAnzhuangshijian());
					}
					set1.add("@EqRegister", "@EqRegister", sbData.getZhuceweizhi());
					if (cRemark == null || cRemark.trim().equals("")){
						if (sbData.getBeizhu().trim().equals("")) {
							set1.add("@Remark", "@Remark", "");
						} else {
							set1.add("@Remark", "@Remark", "数据配置导入备注：" + sbData.getBeizhu());
						}
					} else {
						if (sbData.getBeizhu().trim().equals("")) {
							set1.add("@Remark", "@Remark", cRemark);
						} else {
							set1.add("@Remark", "@Remark", cRemark + "、数据配置导入备注：" +sbData.getBeizhu());
						}
					}
					set1.add("@EqIp", "@EqIp", sbData.getShujuip());
					set1.add("@EqSta_ID", "@EqSta_ID", "4");
					set1.add("Update_person", "@Update_person", employeeName);
					set1.add("Update_time", "@Update_time", nowDate);
					set1.add("@CommunityPile_ID", "@CommunityPile_ID", uuid);
					dao.execute("updateDataImport", set1);*/
					
					
					ParameterModel model  = new ParameterModel(); 
					if (cRemark == null || cRemark.trim().equals("")){
						if (sbData.getBeizhu().trim().equals("")) {
							//set1.add("@Remark", "@Remark", "");
							 //model.put("Remark", "");
						} else {
							//set1.add("@Remark", "@Remark", "数据配置导入备注：" + sbData.getBeizhu());
							 model.put("Remark", "数据配置导入备注：" + sbData.getBeizhu());
						}
					} else {
						if (sbData.getBeizhu().trim().equals("")) {
							//set1.add("@Remark", "@Remark", cRemark);
							 model.put("Remark", cRemark);
						} else {
							//set1.add("@Remark", "@Remark", cRemark + "、数据配置导入备注：" +sbData.getBeizhu());
							 model.put("Remark", cRemark + "、数据配置导入备注：" +sbData.getBeizhu());
						}
					}
					 model.put("Install_site", sbData.getAnzhuangdidian());
					 model.put("Install_time", sbData.getAnzhuangshijian());
					/* model.put("EqRegister", sbData.getZhuceweizhi());
					 model.put("EqIp", sbData.getShujuip());
					 model.put("EqMCID", mcid);*/
					 model.put("EqSta_ID", "4");
					 model.put("Update_person", employeeName);
					 model.put("Update_time", nowDate);
					 ParameterModel conds  = new ParameterModel(); 
					 conds.put("CommunityPile_ID", uuid);
					 dao.update("communitypile", model, conds);
					 
					 ParameterModel model1  = new ParameterModel();
					 model1.put("EqRegister", sbData.getZhuceweizhi());
					 model1.put("EqIp", sbData.getShujuip());
					 model1.put("EqMCID", mcid);
					 ParameterModel conds1  = new ParameterModel(); 
					 conds1.put("Product_ID", product_ID);
					 dao.update("product", model1, conds1);
				}
			}
			commit();
		} catch (Exception e) {
				rollback();
				log.error(e);
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "数据匹配导入中安装时间格式错误！");
			}
			if (flag1 == false){
				 error = error.replaceFirst(",", "");
				 error += "状态不为待匹配,不能匹配导入！";
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , error);
			} else {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "数据匹配导入成功！");
			}
		}

	public CommonMessage shebeixinxiOut(KuncunForm f ,String remoteAddr) {
		
		List<List<String>> list = new ArrayList<List<String>>();
		//String uuid = f.getUUIDS();
		String[] uuids = f.getUUIDS();
		try {
			for (int i = 0; i < uuids.length; i++){
				ParameterSet set = new ParameterSet();
				set.add("CommunityPile_ID", "@CommunityPile_ID", uuids[i]);
				DataSet<DataRow> executeQuery = dao.executeQuery("getDaipipeiShebeiInfo", set);
				String eqstaName = executeQuery.get(0).getDataElement("eqsta_name").getString();
				if (!eqstaName.equals("待匹配")){
					return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0 , "所选设备存在状态不为待匹配！");
				}
				List<String> listdata = new ArrayList<String>();
				listdata.add(executeQuery.get(0).getDataElement("CommunityPile_ID").getString());
				listdata.add(executeQuery.get(0).getDataElement("EqBoxNum").getString());
				listdata.add(eqstaName);
				listdata.add(executeQuery.get(0).getDataElement("EqInTime").getString());
				listdata.add(executeQuery.get(0).getDataElement("rukuren").getString());
				listdata.add(executeQuery.get(0).getDataElement("EqType").getString());
				listdata.add(executeQuery.get(0).getDataElement("EqVersion").getString());
				listdata.add(executeQuery.get(0).getDataElement("FirstEnterDate").getString());
				listdata.add(executeQuery.get(0).getDataElement("CommunityName").getString());
				listdata.add(executeQuery.get(0).getDataElement("lingquren").getString());
				listdata.add(executeQuery.get(0).getDataElement("Install_site").getString());
				listdata.add(executeQuery.get(0).getDataElement("Install_time").getString());
				listdata.add(executeQuery.get(0).getDataElement("EqRegister").getString());
				listdata.add(executeQuery.get(0).getDataElement("EqMAC").getString());
				listdata.add(executeQuery.get(0).getDataElement("EqMCID").getString());
				listdata.add(executeQuery.get(0).getDataElement("EqIp").getString());
				listdata.add(executeQuery.get(0).getDataElement("CpRemark").getString());//设备备注！
				list.add(listdata);
			}
			toExcel(list);
		} catch (Exception e) {
			log.error(e);
		}
		return new CommonMessage(ErrorConstant.DOWN_BIDUI_ANZHUANG , "<a href='http://"+remoteAddr+":8080/tfkj_stock/excel/a.xls'>设备信息导出Excel</a>");
	}
	
	private void toExcel(List<List<String>> listdata) throws IOException {
		
		ExportShebeiXinxiExcel<ShebeiEntityData> ex = new ExportShebeiXinxiExcel<ShebeiEntityData>();
	    String[] headers = { "系统编号","箱号","设备状态","入库日期","入库人","设备类型","设备型号","小区入库日期","入库小区","领取人","安装地点","安装时间","注册位置"
	    		,"MAC","MCID","数据IP","备注"};
	    String path = this.getClass().getClassLoader().getResource("/").getPath();
	    int index = path.indexOf("WEB-INF");   
	    path = path.substring(0, index);   
	    path = path + "excel/a.xls";
	    if (path.indexOf("%") >= 0) {
	    	try {
	    		path = URLDecoder.decode(path, "utf-8"); 

            } catch (Exception e) { 
                e.printStackTrace();
            } 
	    }

	    OutputStream out = new FileOutputStream(path);
	    ex.exportExcel1(headers, listdata, out);
	    out.close();
	}

	public CommonMessage chukushebeiEdit(KuncunForm f) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
