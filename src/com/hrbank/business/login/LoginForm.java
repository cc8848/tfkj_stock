/*
 * ���ܱ�ţ�S001
 * �������ƣ��û���¼
 * 
 * @author aceeci
 * @date 2011-06-27
 */
package com.hrbank.business.login;

import org.apache.struts.action.ActionForm;

/**
 * �û���¼�ñ�������.
 * 
 * @author aceeci
 * @date 2011-06-27
 */
public class LoginForm extends ActionForm {

	private static final long serialVersionUID = 10201106272315L;

	private String userName; // �û���
	private String password; // ����

	public LoginForm() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
