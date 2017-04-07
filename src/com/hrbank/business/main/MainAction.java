/*
 * ���ܱ�ţ�S024
 * �������ƣ���ӭ����
 * 
 * @author aceeci
 * @date 2009-08-25
 */
package com.hrbank.business.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.common.Constant;

/**
 * ��ӭ���洦���������.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class MainAction extends BusinessAction {

	private MainService mainService = new MainService();

	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		form = mainService.initMainInfo();
		request.setAttribute(Constant.MAIN_INFO, form);

		return mapping.findForward(FW_SUCCESS);
	}

	public ActionForward back(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		return mapping.findForward(FW_SELF);
	}
}
