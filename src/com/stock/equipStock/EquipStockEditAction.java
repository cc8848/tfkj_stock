package com.stock.equipStock; 

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 上午11:04:34 
 * 类说明 
 */
public class EquipStockEditAction extends BusinessAction{
	EquipStockService service = new EquipStockService();
	
	
	/**
	 * 跳转到添加设备页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initInsert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward(FW_INIT_INSERT);
	}
	
	/**
	 * 添加设备
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result = service.insert((EquipStockEntiyForm)form);
		if(saveMessage(result,request)){
			return mapping.findForward(FW_ERROR_INSERT);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 跳转到更新页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		EquipStockEntiyForm equipForm = (EquipStockEntiyForm) form;
		String UUID = request.getParameter("EQUUID");
		
		DataRow dataRow = service.getEquipByUUID(UUID);
		if(!dataRow.getDataElement("state").getString().equals("1")){
			CommonMessage message = new CommonMessage(ErrorConstant.UPDATE_EQM_STATE);
			if(saveMessage(message,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		equipForm.setUUID(dataRow.getDataElement("PK_ID").getString());
		equipForm.setTypeString(dataRow.getDataElement("TYPE").getString());
		equipForm.setXianghaoString(dataRow.getDataElement("xianghao").getString());
		equipForm.setRukudateString(dataRow.getDataElement("rukudate").getString());
		equipForm.setRukupersonString(dataRow.getDataElement("rukuperson").getString());
		equipForm.setXinghaoString(dataRow.getDataElement("xinghao").getString());
		equipForm.setMacsString(dataRow.getDataElement("mac").getString());
		equipForm.setZhucejifangString(dataRow.getDataElement("zhucejifang").getString());
		equipForm.settVipString(dataRow.getDataElement("tvip").getString());
		equipForm.setBeizhuString(dataRow.getDataElement("beizhu").getString());
	
	//	employeeForm.setEmployeeName(dataRow.getDataElement("EMP_NAME").getString());
	//	employeeForm.setDepartmentCode(dataRow.getDataElement("DEPT_ID").getString());
		//List<CommonModule> departments = departmentService.getAllDepartment();
		//request.setAttribute("departments",departments);
		
		return mapping.findForward(FW_INIT_EDIT);
	}
	
	/**
	 * 更新
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String result = service.update((EquipStockEntiyForm)form);
		if(saveMessage(result,request)){
			return mapping.findForward(FW_ERROR_EDIT);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 跳转到移库页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward editYiku(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EquipStockEntiyForm form1 = (EquipStockEntiyForm) form;
		request.setAttribute("UUIDSS", form1.getUUIDS());
		/*String[] UUIDS = form1.getUUIDS();
		for (String string : UUIDS) {
			System.out.println("---------------------"+string);
		}
		form1.setUUIDS(UUIDS);*/
		return mapping.findForward("yiku");
	}
	
	/**
	 * 移库
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward yiku(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		EquipStockEntiyForm form1 = (EquipStockEntiyForm) form;
		System.out.println(form1.getChukuplaceString());
		String[] UUIDS=form1.getUUIDS();
		for (String uuid : UUIDS) {
			if(null!=uuid&&""!=uuid){
				CommonMessage message = checkYiku(uuid);
				if(saveMessage(message, request)){
					return mapping.findForward(FW_SUCCESS);
				}else{
					form1.setUUID(uuid);
					service.yiku(form1);
				}
			}
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 删除
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
		EquipStockEntiyForm form1 = (EquipStockEntiyForm) form;
		String[] UUIDS=form1.getUUIDS();
		for (String string : UUIDS) {
			
			if(null!=string&&""!=string){
				CommonMessage message = checkDelet(string);
				if(saveMessage(message, request)){
					return mapping.findForward(FW_SUCCESS);
				}else{
					form1.setUUID(string);
					service.delete(form1);
				}
			}
		}
		
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 校验是否可以删除
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public CommonMessage checkDelet(String UUID)throws Exception{
		DataRow daterow = service.getEquipByUUID(UUID);
		String state = daterow.getDataElement("state").getString();
		if(!state.equals("1")){
			return new CommonMessage(ErrorConstant.DELETE_EQM_STATE);
		}else{
			return new CommonMessage("SUCCESS");
		}
		
	}
	
	public CommonMessage checkYiku(String UUID)throws Exception{
		DataRow daterow = service.getEquipByUUID(UUID);
		String state = daterow.getDataElement("state").getString();
		if(!state.equals("1")){
			return new CommonMessage(ErrorConstant.YIKU_EQM_STATE);
		}else{
			return new CommonMessage("SUCCESS");
		}
		
	}
}

