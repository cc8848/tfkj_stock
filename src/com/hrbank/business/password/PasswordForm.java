/*
 * 机能编号：S002
 * 机能名称：密码修改
 * 
 * @author aceeci
 * @date 2009-08-25
 */
package com.hrbank.business.password;

import org.apache.struts.action.ActionForm;

/**
 * 密码修改表单类.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class PasswordForm extends ActionForm {

	private static final long serialVersionUID = 10200907161429L;

	private String oldPassword = ""; // 旧密码
	private String newPassword = ""; // 新密码
	private String newPasswordConfirm = ""; // 新密码确认

	public PasswordForm() {

	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}

	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

}
