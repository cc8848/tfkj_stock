/*
 * 机能编号：S002
 * 机能名称：密码修改
 * 
 * @author aceeci
 * @date 2009-08-25
 */
package com.hrbank.business.password;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.SuccessContant;
import com.hrbank.business.frame.BusinessAction;

/**
 * 密码修改处理控制器类.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class PasswordAction extends BusinessAction {

	private PasswordService service = new PasswordService();

	/**
	 * 页面初始化方法.
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		PasswordForm passwordForm = (PasswordForm) form;
		passwordForm.setOldPassword("");
		passwordForm.setNewPassword("");
		passwordForm.setNewPasswordConfirm("");
		return mapping.findForward(FW_INIT);
	}

	/**
	 * 密码修改按钮按下.
	 */
	public ActionForward change(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (saveMessage(service.change((PasswordForm) form), request)) {
			return mapping.findForward(FW_ERROR);
		}
		saveMessage(SuccessContant.PASSWORD_CHANGE_SUCCESS, request);
		return mapping.findForward(FW_SUCCESS);
	}
}
