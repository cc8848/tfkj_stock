package com.stock.caiwuhedui.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.caiwuhedui.entity.ZhangMuForm;
import com.stock.caiwuhedui.service.ZhangMuEditService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.frame.BusinessAction;

public class ZhangMuEditAction extends BusinessAction{
	ZhangMuEditService service = new ZhangMuEditService();

	public ActionForward insertPipeiZhangmu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm f =  (ZhangMuForm) form;
		
		CommonMessage message = service.savePipeidata(f);
		if (saveMessage(message, request)) {
			return mapping.findForward(FW_INIT_INSERT);
		}
		
		return mapping.findForward(FW_INIT_INSERT);
		
	}
	
	public ActionForward insertShenheZhangmu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ZhangMuForm f =  (ZhangMuForm) form;
		
		CommonMessage message = service.saveShenhe(f);
		if (saveMessage(message, request)) {
			return mapping.findForward("reback.hedui");
		}

		return mapping.findForward("reback.hedui");
		
	}
	
	
}
