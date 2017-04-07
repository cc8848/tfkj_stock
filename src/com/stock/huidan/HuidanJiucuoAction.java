package com.stock.huidan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessPaginationAction;
import com.stock.chugongdanHistory.PaiGongDanService;
import com.stock.fenPeiIp.FenguangKeService;
import com.stock.kucun.KucunService;
import com.stock.paigongdan.PaiGongDanPreImportForm;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.util.Common;

public class HuidanJiucuoAction extends BusinessPaginationAction {
	
	private PaiGongDanService  srv = new PaiGongDanService();
	private HuidanDataService  service = new HuidanDataService();
	private HuidanService service1 = new HuidanService();
	FenguangKeService fgservice = new FenguangKeService();
	KucunService kucunService = new KucunService();
	/**
	 * 放入小区列表
	 * 
	 * @param request
	 * @throws Exception
	 */
	private void savedInRequest(HttpServletRequest request)throws Exception{
		List<CommonModule> xiaoquList = srv.getXiaoQuCodeAll();
		request.setAttribute("xiaoquList", xiaoquList);

		List<CommonModule> dianxintaocan = srv.getDianxintaocan();
		request.setAttribute("dianxintaocan", dianxintaocan);
		
		List<CommonModule> shichangList = srv.getShichangAll();
		request.setAttribute("shichangList", shichangList);
		
		List<CommonModule> shichangtvList = srv.getShichangtvAll();
		request.setAttribute("shichangtvList", shichangtvList);
	}
	/**
	 * user data init method.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=100;
		savedInRequest(request);
		return firstPage(mapping, form, request, response);
	}
	/**
	 * get user data list by query.
	 * contain all combox data for init page data.
	 * 
	 * @param form
	 * @param first
	 * @param request
	 * @return DataSet<DataRow>
	 */
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.rows=500;
		savedInRequest(request);
		HuidanForm f = (HuidanForm)form;
		f.setHidden();
		return firstPage(mapping, f, request, response);
	}
	/**
	 * framework package method.
	 * 
	 * @param mapping
	 * @return ActionForward
	 */
	public ActionForward getActionForward(ActionMapping mapping) {
		return mapping.findForward(FW_INIT);
	}
	/**
	 * get user data list.
	 * contain all combox data for init page data.
	 * 
	 * @param form
	 * @param first
	 * @param request
	 * @return DataSet<DataRow>
	 */
	public DataSet<DataRow> getResult(ActionForm form, int first, int rows)
			throws Exception {
		HuidanForm f =  (HuidanForm) form;
		List<CommonModule> xiaoquList = srv.getXiaoQuCodeAll();
		f.setXiaoquList(xiaoquList);
		
		return service1.getResult(f, first, rows, "3");
	}
	/**
	 * get init or query result count.
	 * 
	 * @param request
	 * @throws Exception
	 */
	public int getResultCount(ActionForm form) throws Exception {
		return service1.getResultCount((HuidanForm) form, "3");
	}
	/**
	 * 回单纠错——编辑
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		f.setUUIDHidden(f.getUUID());
		f.setXiaoquList(srv.getXiaoQuCodeAll());
		service1.getHuidanForm_ByID(f.getUUID(), f);
		savedInRequest(request);
		return mapping.findForward(FW_INIT_EDIT);

	}
	/**
	 * 回单纠错编辑提交保存
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward edit_save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		service1.updateHuidan(f, request);
		return mapping.findForward(FW_SUCCESS);

	}
	/**
	 * 回单纠错—错误打回
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward cuowudahui(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		service1.tuihui(f, request, "错误打回", "2");
		return mapping.findForward(FW_SUCCESS);

	}
	/**
	 * 回单纠错-纠正确认
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward jiuzhengqueren(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm)form;
		if(service1.get_yonghuzhuangtai(f).equals("纠错中")){
			service1.tuihui(f, request, "已安装", "4");
			return mapping.findForward(FW_SUCCESS);
		}
		else{
			saveMessage( new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"只能提交'纠错中'的记录！"), request);
			return mapping.findForward(FW_SUCCESS);
		}
		

	}
	/**
	 * 回单纠错-开票拆分
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward kaipiaochaifen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm) form;
		f.setUUIDHidden(f.getUUID());
		if (service1.get_yonghuzhuangtai(f).equals("开票拆分")) {
			service1.getHuidanForm_ByID(f.getUUID(), f);
			return mapping.findForward("chaifen");
		} else {
			saveMessage(new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "只能提交'开票拆分'的记录！"), request);
			return mapping.findForward(FW_SUCCESS);
		}
	}
	/**
	 * 回单纠错-开票拆分 确认拆分
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 
	 */
	public ActionForward querenchaifen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm f = (HuidanForm) form;
		String uuid = f.getUUIDHidden();
		f.setUUID(uuid);
		service1.getHuidanForm_ByID(uuid, f);
		
		HuidanForm huidan = new HuidanForm();
		huidan.setFeikaipiaoshouju(f.getFeikaipiaoshouju());
		huidan.setKaipiaoshouju(f.getKaipiaoshouju());
		huidan.setUUID(uuid);
		huidan.setChecks(f.getChecks());//checks是前面传过来的checkbox勾选的内容
		service1.getHuidanForm_ByID(uuid, huidan);

		service1.get_1(f);
		service1.get_2(huidan);
		service1.get_into(huidan, request, "4", "已维修");
		service1.update_into(f, request, "已安装", "4");
		return mapping.findForward(FW_SUCCESS);
	}
	/*****
	 * 一览界面点击分光回收使用按钮执行action
	 *****/
	public ActionForward pipeipgd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm fenguangform = (HuidanForm) form;
		String[] uuids = fenguangform.getUUIDS();
		StringBuffer wrongdata = new StringBuffer();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getDataByUUID(uuids[i]);
			//取得所选派工单的小区
			String xiaoqu = dataRow.getDataElement("xiaoqu").getString();
			//取得所选派工单的地址
			String dizhi = dataRow.getDataElement("dizhi").getString();
			// 取得所选派工单的当前分光信息
			String currentFenguang = dataRow.getDataElement("fenguang").getString();
			//只对当前分光是非空非0的进行操作
			if(currentFenguang==null||"".equals(currentFenguang)||"　".equals(currentFenguang)||"0".equals(currentFenguang)) {
				String fenguangID = fgservice.pipeipgd(xiaoqu, dizhi,request);
				if(fenguangID.contains("@")) {
					//更新当前派工单信息
					fgservice.updateJiucuofenguang(uuids[i],fenguangID.split("@")[0],fenguangID.split("@")[1]);
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
		HuidanForm fenguangform = (HuidanForm) form;
		String[] uuids = fenguangform.getUUIDS();
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getDataByUUID(uuids[i]);
			// 取得所选派工单的当前分光信息
			String currentFenguang = dataRow.getDataElement("fenguangID").getString();
			if(currentFenguang!=null) {
				fgservice.recyclefenguang(currentFenguang,request);
			}
			fgservice.updateJiucuofenguang(uuids[i],"", "");
		}
		CommonMessage message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "分光回收成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * 一览界面点击维修界面关联设备更换按钮执行action
	 *****/
	public ActionForward weijiugenghuan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm huidanform = (HuidanForm) form;
		String devicekbn = request.getParameter("device");
		String[] uuids = huidanform.getUUIDS();
		String xiaoqu = "";
		String dizhi = "";
		String onumac = "";
		String stbmcid = "";
		String cp1 = "";
		String cp2 = "";
		CommonMessage message = null;
		
		/**
		 	检查所选小区、地址、onumac、STB MCID一致性检查
		*/
		for(int i=0;i<uuids.length;i++) {
			DataRow dataRow = service.getDataByUUID(uuids[i]);
			// 取得所选派工单的当前分光信息
			String xiaoqu1 = dataRow.getDataElement("xiaoqu").getString();
			String dizhi1 = dataRow.getDataElement("dizhi").getString();
			String onumac1 = dataRow.getDataElement("onumac").getString();
			String stbmcid1 = dataRow.getDataElement("stbmcid").getString();
			String cp11 = dataRow.getDataElement("CommunityPile_ID").getString();
			String cp21 = dataRow.getDataElement("CommunityPile_ID2").getString();
			if(i!=0) {
//				if("0".equals(devicekbn)) {
					if(!(xiaoqu1.equals(xiaoqu)&&dizhi1.equals(dizhi)&&onumac1.equals(onumac))) {
						message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"小区、地址、onumac不一致，更换失败！");
						saveMessage(message, request);
						return mapping.findForward(FW_SUCCESS);
					}
//				}else{
//					if(!(xiaoqu1.equals(xiaoqu)&&dizhi1.equals(dizhi)&&stbmcid1.equals(stbmcid))) {
//						message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"小区、地址、STB MCID不一致，更换失败！");
//						saveMessage(message, request);
//						return mapping.findForward(FW_SUCCESS);
//					}
//				}
			}else{
				xiaoqu = xiaoqu1;
				dizhi = dizhi1;
				onumac = onumac1;
				stbmcid = stbmcid1;
				cp1 = cp11;
				cp2 = cp21;
			}
		}
		
		/**
		 * 检查是否存在小区地址onumac或STBMCID相同但未被选选择的项目
		 */
		List<DataRow> allhuidan = new ArrayList<DataRow>();
//		if("0".equals(devicekbn)) {
			allhuidan =service.getDataByUUIDOnu(xiaoqu, dizhi, onumac);
//		}else{
//			allhuidan =service.getDataByUUIDStb(xiaoqu, dizhi, stbmcid);
//		}
		if(allhuidan.size()!=uuids.length) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"存在未被选择的项目，更换失败！");
			saveMessage(message, request);
			return mapping.findForward(FW_SUCCESS);
		}
		
		/**
		 * 检查在查询维修界面是否存在相应小区地址onumac或STBMCID为非空非0状态是”维修待处理“的项目
		 */
		List<DataRow> allweixiu = new ArrayList<DataRow>();
//		if("0".equals(devicekbn)) {
			allweixiu =service.getWXDataByUUIDOnu(xiaoqu, dizhi);
//		}else{
//			allweixiu =service.getWXDataByUUIDStb(xiaoqu, dizhi);
//		}
		if(allweixiu==null||allweixiu.size()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"维修待处理数据不存在，更换失败！");
			saveMessage(message, request);
			return mapping.findForward(FW_SUCCESS);
		}else if(allweixiu.size()>1){
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"存在多条维修待处理数据，更换失败！请先关闭一条维修待处理。");
			saveMessage(message, request);
			return mapping.findForward(FW_SUCCESS);
		}
		
		/**
		 * 执行更换操作
		 * 1、更新安装信息到所选的状态
		 * 2、把相应维修信息改为“已维修”，设备状态变为“已安装”
		 * 3、把相应维修设备信息更新到安装信息中来	
		 */
//		if("0".equals(devicekbn)) {
			kucunService.zhuangTaiChange(cp1,huidanform.getEqsta(),xiaoqu,"安装用",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
			service.updateWXByUUID(allweixiu.get(0).getDataElement("PK_ID").getString(), "已维修");
			kucunService.zhuangTaiChange(allweixiu.get(0).getDataElement("CommunityPile_ID").getString(),"4",xiaoqu,"安装用",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
			for(int i=0;i<uuids.length;i++) {
				service.updateHuidanEQByUUID(uuids[i], "0", allweixiu.get(0).getDataElement("CommunityPile_ID").getString(), allweixiu.get(0).getDataElement("onumac").getString());
			}
//		}else{
//			kucunService.zhuangTaiChange(cp2,huidanform.getEqsta(),xiaoqu,"安装用",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
//			service.updateWXByUUID(allweixiu.get(0).getDataElement("PK_ID").getString(), "已维修");
//			kucunService.zhuangTaiChange(allweixiu.get(0).getDataElement("CommunityPile_ID2").getString(),"5",xiaoqu,"安装用",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
//			for(int i=0;i<uuids.length;i++) {
//				service.updateHuidanEQByUUID(uuids[i], "1", allweixiu.get(0).getDataElement("CommunityPile_ID2").getString(), allweixiu.get(0).getDataElement("stbmcid").getString());
//			}
//		}
		
		
		message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "维修界面关联设备更换成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
	
	/*****
	 * 一览界面点击维修界面关联设备更换按钮执行action
	 *****/
	public ActionForward weijiugenghuanSTB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HuidanForm huidanform = (HuidanForm) form;
		String uuid = huidanform.getUUID();
		CommonMessage message = null;
		
		/**
		 	检查所选小区、地址、onumac、STB MCID一致性检查
		*/
			DataRow dataRow = service.getDataByUUID(uuid);
			// 取得所选派工单的当前分光信息
			String xiaoqu = dataRow.getDataElement("xiaoqu").getString();
			String dizhi = dataRow.getDataElement("dizhi").getString();
			String stbmcid = dataRow.getDataElement("stbmcid").getString();
			String cp1 = dataRow.getDataElement("CommunityPile_ID").getString();
			String cp2 = dataRow.getDataElement("CommunityPile_ID2").getString();
		
		/**
		 * 检查是否存在小区地址onumac或STBMCID相同但未被选选择的项目
		 */
//		List<DataRow> allhuidan = new ArrayList<DataRow>();
//		if("0".equals(devicekbn)) {
//			allhuidan =service.getDataByUUIDOnu(xiaoqu, dizhi, onumac);
//		}else{
//			allhuidan =service.getDataByUUIDStb(xiaoqu, dizhi, stbmcid);
//		}
//		if(allhuidan.size()!=uuids.length) {
//			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"存在未被选择的项目，更换失败！");
//			saveMessage(message, request);
//			return mapping.findForward(FW_SUCCESS);
//		}
		
		/**
		 * 检查在查询维修界面是否存在相应小区地址onumac或STBMCID为非空非0状态是”维修待处理“的项目
		 */
		List<DataRow> allweixiu = new ArrayList<DataRow>();
		allweixiu =service.getWXDataByUUIDStb(xiaoqu, dizhi);
		if(allweixiu==null||allweixiu.size()==0) {
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"维修待处理数据不存在，更换失败！");
			saveMessage(message, request);
			return mapping.findForward(FW_SUCCESS);
		}else if(allweixiu.size()>1){
			message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"存在多条维修待处理数据，更换失败！请先关闭一条维修待处理。");
			saveMessage(message, request);
			return mapping.findForward(FW_SUCCESS);
		}
		
		/**
		 * 执行更换操作
		 * 1、更新安装信息到所选的状态
		 * 2、把相应维修信息改为“已维修”，设备状态变为“已安装”
		 * 3、把相应维修设备信息更新到安装信息中来	
		 */
			kucunService.zhuangTaiChange(cp2,huidanform.getEqsta(),xiaoqu,"安装用",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
			service.updateWXByUUID(allweixiu.get(0).getDataElement("PK_ID").getString(), "已维修");
			kucunService.zhuangTaiChange(allweixiu.get(0).getDataElement("CommunityPile_ID2").getString(),"4",xiaoqu,"安装用",dizhi,Common.formatDate(new Date(), "yyyy-MM-dd"));
			service.updateHuidanEQByUUID(uuid, "1", allweixiu.get(0).getDataElement("CommunityPile_ID2").getString(), allweixiu.get(0).getDataElement("stbmcid").getString());
		
		
		message = new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "维修界面关联设备更换成功！");
		saveMessage(message, request);
		return mapping.findForward(FW_SUCCESS);
	}
}
