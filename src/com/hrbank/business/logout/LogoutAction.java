/*
 * 机能编号：S019
 * 机能名称：用户注销
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
 * 用户注销处理控制器类.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class LogoutAction extends BusinessAction {

	/**
	 * 用户注销链接被按下.
	 */
	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.getSession().removeAttribute(Constant.LOGIN_USER);
		return mapping.findForward(FW_SUCCESS);
	}
}
