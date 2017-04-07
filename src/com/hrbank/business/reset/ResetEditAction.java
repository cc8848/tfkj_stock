package com.hrbank.business.reset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.SuccessContant;
import com.hrbank.business.frame.BusinessAction;

public class ResetEditAction extends BusinessAction {

	private ResetService service = new ResetService();

	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward(FW_INIT);
	}

	public ActionForward reset(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String result = service.update((ResetForm) form);
		if (saveMessage(result, request)) {
			return mapping.findForward(FW_ERROR);
		}
		saveMessage(SuccessContant.PASSWORD_RESET_SUCCESS, request);
		return mapping.findForward(FW_SUCCESS);
	}

}
