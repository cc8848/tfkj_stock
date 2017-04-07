package com.stock.paigongdan;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.fenPeiIp.FenguangKeService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.common.Constant;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.util.Common;
/** 
 * @author daizhen 
 * @version 创建时间：2016-3-2 
 * 回单预导入查询
 */
public class HuidanPreImportAction extends BusinessPaginationAction{

	PaiGongDanService  pgdservice = new PaiGongDanService();
	HuidanPreImportService  service = new HuidanPreImportService();
	FenguangKeService fgservice = new FenguangKeService();
	
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}

	
	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		PaiGongDanPreImportForm f =  (PaiGongDanPreImportForm) form;
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResult((PaiGongDanPreImportForm) form, first, rows);
	}

	public int getResultCount(ActionForm form) throws Exception {
		PaiGongDanPreImportForm f =  (PaiGongDanPreImportForm) form;
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		return service.getResultCount((PaiGongDanPreImportForm) form);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	/**
	 * 放入小区列表
	 * @param request
	 * @throws Exception
	 */
	private  void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = pgdservice.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);

		List<CommonModule> dianxintaocan = pgdservice.getDianxintaocan();
		request.setAttribute("dianxintaocan", dianxintaocan);
		
		List<CommonModule> shichangList = pgdservice.getShichangAll();
		request.setAttribute("shichangList", shichangList);
		
		List<CommonModule> shichangtvList = pgdservice.getShichangtvAll();
		request.setAttribute("shichangtvList", shichangtvList);
	}
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		fenguangform.setKaijishijian("");
		fenguangform.setTingjishijian("");
		return firstPage(mapping, form, request, response);
	}
	
	/**
	 * 删除
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Employee em = (Employee) request.getSession().getAttribute(
				Constant.LOGIN_USER);
		service.delete((PaiGongDanPreImportForm) form,em.getEmployeeName(),Common.formatDate(new Date(),Common.DATE_FORMAT_FULL));
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * 一览界面点击第三方分光按钮执行action
	 *****/
	public ActionForward disanfangfenguang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			// 取得所选派工单的当前分光信息
			String fenguang = dataRow.getDataElement("fenguangD").getString();
			//取得所选派工单的小区
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//取得所选派工单的地址
			String dizhi = dataRow.getDataElement("userplace").getString();
			if(fenguang==null||"".equals(fenguang)||" ".equals(fenguang)||"　".equals(fenguang)) {
				service.sanfangfenguang(uuids[i]);
			}else{
				wrongdata.append(xiaoqu+dizhi+"分光必须为空！</br>");
			}
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "第三方分光成功！");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}	
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * 一览界面点击FTTB小区按钮执行action
	 *****/
	public ActionForward fttbxiaoqu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			// 取得所选派工单的当前分光信息
			String fenguang = dataRow.getDataElement("fenguangD").getString();
			String onumac = dataRow.getDataElement("onumacD").getString();
			//取得所选派工单的小区
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//取得所选派工单的地址
			String dizhi = dataRow.getDataElement("userplace").getString();
			if((fenguang==null||"".equals(fenguang)||" ".equals(fenguang)||"　".equals(fenguang))&&(onumac==null||"".equals(onumac)||" ".equals(onumac)||"　".equals(onumac))) {
				service.fttbxiaoqu(uuids[i]);
			}else{
				wrongdata.append(xiaoqu+dizhi+"分光或onumac必须全为空！</br>");
			}
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "FTTB小区成功！");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}	
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * 一览界面点击待分配ONU按钮执行action
	 *****/
	public ActionForward daifenpeionu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			// 取得所选派工单的当前分光信息
			String onumac = dataRow.getDataElement("onumacD").getString();
			//取得所选派工单的小区
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//取得所选派工单的地址
			String dizhi = dataRow.getDataElement("userplace").getString();
			if(onumac==null||"".equals(onumac)||" ".equals(onumac)||"　".equals(onumac)) {
				service.daifenpeionu(uuids[i]);
			}else{
				wrongdata.append(xiaoqu+dizhi+"onumac必须为空！</br>");
			}
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "待匹配ONU成功！");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * 一览界面点击待分配机顶盒按钮执行action
	 *****/
	public ActionForward daifenpeijidinghe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			// 取得所选派工单的当前分光信息
			String bdstbmcid = dataRow.getDataElement("stbmcidD").getString();
			//取得所选派工单的小区
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//取得所选派工单的地址
			String dizhi = dataRow.getDataElement("userplace").getString();
			if(bdstbmcid==null||"".equals(bdstbmcid)||" ".equals(bdstbmcid)||"　".equals(bdstbmcid)) {
				service.daifenpeijidinghe(uuids[i]);
			}else{
				wrongdata.append(xiaoqu+dizhi+"stbmcid必须为空！</br>");
			}
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "待匹配机顶盒成功！");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * 一览界面点击分光回收使用按钮执行action
	 *****/
	public ActionForward pipeipgd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			//取得所选派工单的小区
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//取得所选派工单的地址
			String dizhi = dataRow.getDataElement("userplace").getString();
			// 取得所选派工单的当前分光信息
			String currentFenguang = dataRow.getDataElement("fenguangD").getString();
			//只对当前分光是非空非0的进行操作
			if(currentFenguang==null||"".equals(currentFenguang)||"　".equals(currentFenguang)||"0".equals(currentFenguang)) {
				String fenguangID = fgservice.pipeipgd(xiaoqu, dizhi,request);
				if(fenguangID.contains("@")) {
					//更新当前派工单信息
					fgservice.updatePreImportfenguang(uuids[i],fenguangID.split("@")[0],fenguangID.split("@")[1]);
				}else{
					//没有获取到派工单信息吗，记录小区和地址
					if("NOGUIZE".equals(fenguangID)) {
						wrongdata.append(xiaoqu+dizhi+"没有分光分配规则</br>");
					}else{
						wrongdata.append(xiaoqu+dizhi+"没有可用的分光</br>");
					}
				}
			}else{
				wrongdata.append(xiaoqu+dizhi+"已存在分光，请回收后重新分配。</br>");
			}
			
			//service.updateMask(uuids[i],request, "0");
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "分光分配成功！");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * 一览界面点击分光回收使用按钮执行action
	 *****/
	public ActionForward recyclepgd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			// 取得所选派工单的当前分光信息
			String currentFenguang = dataRow.getDataElement("fenguangID").getString();
			if(currentFenguang!=null) {
				fgservice.recyclefenguang(currentFenguang,request);
			}
			fgservice.updatePreImportfenguang(uuids[i],"", "");
		}
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "分光回收成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * 一览界面点击【传输回单】按钮执行action
	 *****/
	public ActionForward transportHuidan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		Employee em = (Employee) request.getSession().getAttribute(
				Constant.LOGIN_USER);
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getPreImportByUUID(uuids[i]);
			//开机时间
			String kaijishijian = dataRow.getDataElement("newkaijishijian").getString();
			//停机时间
			String tingjishijian = dataRow.getDataElement("newtingjishijian").getString();
			//取得所选派工单的小区
			String xiaoqu = dataRow.getDataElement("xiaoquname").getString();
			//取得所选派工单的地址
			String dizhi = dataRow.getDataElement("userplace").getString();
			//联系电话
			String lianxidianhua = dataRow.getDataElement("usertel").getString();
			// 取得所选派工单的当前分光信息
			String currentFenguang = dataRow.getDataElement("fenguangD").getString();
			//onumac
			String onumac = dataRow.getDataElement("onumacD").getString();
			//上门时间
			String shangmenshijian = dataRow.getDataElement("anzhuangshijian").getString();
			//运营商
			String yunyingshang = dataRow.getDataElement("yuyingshang").getString();
			//业务类型
			String yewutype = dataRow.getDataElement("yewutype").getString();
			//网络
			String wangluo = dataRow.getDataElement("tfkuandaidaikuan").getString();
			//电视
			String dianshi = dataRow.getDataElement("tfiptv").getString();
			//电话
			String dianhua = dataRow.getDataElement("tfsfyewu").getString();
			//网络ip
			String wangluoip = dataRow.getDataElement("netip").getString();;
			//STB MCID
			String stbmcid = dataRow.getDataElement("stbmcidD").getString();;
			//电话ip
			String dianhuaip = dataRow.getDataElement("telip").getString();;
			if(checkdizhi(dizhi)) {
				wrongdata.append(xiaoqu+dizhi+"地址不正</br>");
			}else if(checkEmpty(kaijishijian)||checkEmpty(tingjishijian)) {
				wrongdata.append(xiaoqu+dizhi+"开机时间、停机时间不能为空</br>");
			}else if(checkEmpty(currentFenguang)||checkEmpty(onumac)) {		
				wrongdata.append(xiaoqu+dizhi+"分光、onumac不能为空</br>");
			}else if(checkEmpty(xiaoqu)||checkEmpty(dizhi)||
						checkEmptydx(lianxidianhua)||checkEmpty(shangmenshijian)||checkEmpty(yunyingshang)||checkEmpty(yewutype)) {
					wrongdata.append(xiaoqu+dizhi+"小区、地址、联系电话、上门时间、运营商、业务类型不能为空</br>");
			}else if(checkEmpty(wangluo)&&checkEmpty(dianshi)&&checkEmpty(dianhua)) {
				wrongdata.append(xiaoqu+dizhi+"网络、电视、电话不能同时为空</br>");
			}else if(!checkEmpty(wangluo)&&checkEmpty(wangluoip)) {
				wrongdata.append(xiaoqu+dizhi+"网络不为空时网络ip不能为空</br>");
			}else if(!checkEmpty(dianshi)&&(checkEmpty(stbmcid)||checkEmpty(dianhuaip))) {
				wrongdata.append(xiaoqu+dizhi+"电视不为空时STB MCID和电话ip不能为空</br>");
			}else if(wangluoip!=null&&(wangluoip.indexOf("有误")!=-1||wangluoip.indexOf("特殊")!=-1)) {
					wrongdata.append(xiaoqu+dizhi+"网络账号有误！</br>");
			}else if(dianhuaip!=null&&(dianhuaip.indexOf("有误")!=-1||dianhuaip.indexOf("特殊")!=-1)) {
				wrongdata.append(xiaoqu+dizhi+"电视账号有误！</br>");
			}else{
				service.insert(dataRow,em.getEmployeeName(),Common.formatDate(new Date(),Common.DATE_FORMAT_FULL));
			}
		}
		CommonMessage message = null;
		if(wrongdata.length()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "传输回单成功！");
		}else{
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,wrongdata.toString());
		}
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	private boolean checkdizhi(String dizhi) {
		if(dizhi.indexOf("别墅")!=-1) {
			if("00".equals(dizhi.split("-")[0])) {
				return true;
			}
		}else{
			String[] dizhiarr = dizhi.split("-");
			if(dizhiarr.length==3) {
				if("00".equals(dizhiarr[0])) {
					return true;
				}else if("0".equals(dizhiarr[1])){
					return true;
				}else if("0000".equals(dizhiarr[2])){
					return true;
				}else if(dizhiarr[2].startsWith("00")||dizhiarr[2].endsWith("00")){
					return true;
				}
			}else if(dizhiarr.length==2) {
				if("00".equals(dizhiarr[0])) {
					return true;
				}else if("00".equals(dizhiarr[1])){
					return true;
				}
			}
		}
		return false;
	}
	
	/*****
	 * 一览界面生成第二台IPTV按钮执行action
	 *****/
	public ActionForward diertaiiptv(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PaiGongDanPreImportForm fenguangform = (PaiGongDanPreImportForm) form;
		Employee em = (Employee) request.getSession().getAttribute(
				Constant.LOGIN_USER);
		service.diertaiiptv(fenguangform.getUUID(),fenguangform.getTingjishijian(),em.getEmployeeName(),Common.formatDate(new Date(),Common.DATE_FORMAT_FULL));
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "第二台IPTV生成成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	/**
	 * 内容为空时返回true
	 */
	private boolean checkEmpty(String content) {
		if(content==null||"".equals(content)||" ".equals(content)||"　".equals(content)||"0".equals(content)) {
			return true;
		}
		return false;
	}
	private boolean checkEmptydx(String content) {
		if(content==null||"".equals(content)||" ".equals(content)||"　".equals(content)) {
			return true;
		}
		return false;
	}
}
