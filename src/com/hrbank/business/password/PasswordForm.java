/*
 * ���ܱ�ţ�S002
 * �������ƣ������޸�
 * 
 * @author aceeci
 * @date 2009-08-25
 */
package com.hrbank.business.password;

import org.apache.struts.action.ActionForm;

/**
 * �����޸ı���.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class PasswordForm extends ActionForm {

	private static final long serialVersionUID = 10200907161429L;

	private String oldPassword = ""; // ������
	private String newPassword = ""; // ������
	private String newPasswordConfirm = ""; // ������ȷ��

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
