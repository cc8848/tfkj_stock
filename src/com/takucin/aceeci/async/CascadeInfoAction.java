package com.takucin.aceeci.async;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.takucin.aceeci.frame.CommonAction;

public class CascadeInfoAction extends CommonAction {

	public ActionForward call(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String code = request.getParameter("code");
		String className = request.getParameter("className");
		printXml(response,new CascadeInfoService().getCascadeInfoXml(code, className));
		return null;
	}

}
