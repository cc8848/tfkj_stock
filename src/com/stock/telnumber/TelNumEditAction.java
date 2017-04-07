package com.stock.telnumber;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.stock.paigongdan.PaiGongDanEntiyForm;
import com.stock.yonghushuju.ImportDataService;
import com.stock.yonghushuju.JiaofeiDataFrom;
import com.stock.yonghushuju.YonghuDataEntityForm;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;

public class TelNumEditAction extends BusinessAction{

	TelNumberService service = new TelNumberService();
	
	/**
	 * É¾³ý
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
		TelNumEidtForm telNumEidtForm = (TelNumEidtForm)form;
		CommonMessage message = checkDelet(telNumEidtForm.getUUID());
		if(saveMessage(message, request)){
			return mapping.findForward(FW_SUCCESS);
		}else{
			service.delete((TelNumEidtForm) form);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * É¾³ýÐ£Ñé
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public CommonMessage checkDelet(String UUID)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		DataRow data =  service.getTelByUUID(UUID);
		String state = data.getDataElement("state").getString();
		if(!state.equals("0")){
			return new CommonMessage(ErrorConstant.DELETE_TEL_STATE);
		}else{
			return new CommonMessage("SUCCESS");
		}
		
	}
	
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TelNumEidtForm telNumEidtForm = (TelNumEidtForm)form;
		CommonMessage message = service.update(telNumEidtForm.getUUID());
		if(saveMessage(message, request)){
			return mapping.findForward(FW_SUCCESS);
		}else{
			service.delete((TelNumEidtForm) form);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	public ActionForward updateLock(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TelNumEidtForm telNumEidtForm = (TelNumEidtForm)form;
		CommonMessage message = service.updateLock(telNumEidtForm.getUUID());
		if(saveMessage(message, request)){
			return mapping.findForward(FW_SUCCESS);
		}else{
			service.delete((TelNumEidtForm) form);
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	public ActionForward initEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TelNumEidtForm dataForm = (TelNumEidtForm) form;
		DataRow dataRow = service.getTelByUUID(dataForm.getUUID());
		CommonMessage message = new CommonMessage("SUCCESS");
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_SUCCESS);
		} else {
			dataForm.setUUID(dataRow.getDataElement("PK_ID").getString());
			dataForm.setQuyu(dataRow.getDataElement("quyu").getString());
			dataForm.setTelNo(dataRow.getDataElement("telno").getString());
			dataForm.setDesc(dataRow.getDataElement("beizhu").getString());
			
			
			return mapping.findForward(FW_INIT_EDIT);
		}
	}
	
	public ActionForward updateTel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CommonMessage message = service.updateTel((TelNumEidtForm)form);
		if(saveMessage(message, request)){
			
			return mapping.findForward(FW_INIT_EDIT);
		}
		
		return mapping.findForward(FW_SUCCESS);
	}
}
