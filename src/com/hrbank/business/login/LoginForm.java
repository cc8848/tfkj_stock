/*
 * 机能编号：S001
 * 机能名称：用户登录
 * 
 * @author aceeci
 * @date 2011-06-27
 */
package com.hrbank.business.login;

import org.apache.struts.action.ActionForm;

/**
 * 用户登录用表单属性类.
 * 
 * @author aceeci
 * @date 2011-06-27
 */
public class LoginForm extends ActionForm {

	private static final long serialVersionUID = 10201106272315L;

	private String userName; // 用户名
	private String password; // 密码

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
