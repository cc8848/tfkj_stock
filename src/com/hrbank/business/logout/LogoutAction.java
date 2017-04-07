/*
 * ���ܱ�ţ�S019
 * �������ƣ��û�ע��
 * 
 * @author aceeci
 * @date 2009-08-25
 */
package com.hrbank.business.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.common.Constant;

/**
 * �û�ע�������������.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class LogoutAction extends BusinessAction {

	/**
	 * �û�ע�����ӱ�����.
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.getSession().removeAttribute(Constant.LOGIN_USER);
		return mapping.findForward(FW_SUCCESS);
	}
}
