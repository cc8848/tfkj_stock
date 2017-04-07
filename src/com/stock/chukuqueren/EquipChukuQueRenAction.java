package com.stock.chukuqueren;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessAction;
import com.stock.equipStock.EquipStockEntiyForm;

public class EquipChukuQueRenAction extends BusinessAction{
	
	private EquipStockChuKuService service = new EquipStockChuKuService();
	
	/**
	 * 出库确认操作
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward chuku(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EquipChuKuQueRenForm form1 = (EquipChuKuQueRenForm)form;
		String[] UUIDS = form1.getUUIDS();
		for (String UUID : UUIDS) {
			form1.setUUID(UUID);
			form1.setState("3");//确认出库
			String result = service.update((EquipChuKuQueRenForm)form);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		
		return mapping.findForward(FW_SUCCESS);
		
	}
	
	/**
	 * 重入库
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward ruku(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EquipChuKuQueRenForm form1 = (EquipChuKuQueRenForm)form;
		String[] UUIDS = form1.getUUIDS();
		for (String UUID : UUIDS) {
			form1.setUUID(UUID);
			form1.setState("1");//重新入库
			String result = service.update((EquipChuKuQueRenForm)form);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		
		return mapping.findForward(FW_SUCCESS);
		
	}
	/**
	 * 损坏确认
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward sunhuai(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EquipChuKuQueRenForm form1 = (EquipChuKuQueRenForm)form;
		String[] UUIDS = form1.getUUIDS();
		for (String UUID : UUIDS) {
			form1.setUUID(UUID);
			form1.setState("4");//设备已损坏
			String result = service.update((EquipChuKuQueRenForm)form);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		return mapping.findForward(FW_SUCCESS);
		
	}
	
}
