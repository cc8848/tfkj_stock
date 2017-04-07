/*
 * 机能编号：S001
 * 机能名称：用户登录
 * 
 * @author aceeci
 * @date 2011-06-27
 */
package com.hrbank.business.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessAction;
import com.takucin.aceeci.common.Constant;

/**
 * 用户登录处理控制器类.
 * 
 * @author aceeci
 * @date 2011-06-27
 */
public class LoginAction extends BusinessAction {

	private LoginService service = new LoginService();

	/**
	 * 初始化方法.
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		saveToken(request);
		return mapping.findForward(FW_INIT);
	}

	/**
	 * 登录.
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (request.getSession().getAttribute(Constant.LOGIN_USER) != null) {
			return mapping.findForward(FW_SUCCESS);
		}

		LoginForm loginForm = (LoginForm) form;
	   	//增加界面刷新检查，如果超时或服务器重启，form没有数据则返回到登录页
		if(loginForm.getPassword()==null||loginForm.getUserName()==null){
			return mapping.findForward(FW_ERROR);
		}
		Employee emp = service.getLoginEmployee(loginForm);
		if (emp == null) {
			saveMessage(ErrorConstant.LOGIN_ERROR, request);
			return mapping.findForward(FW_ERROR);
		}

		request.getSession().setAttribute(Constant.LOGIN_USER, emp);
		return mapping.findForward(FW_SUCCESS);
	}

	/**
	 * check username and password for 400.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward loginForKefu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("111");
		if (request.getParameter("username") == null || request.getParameter("username").toString().trim().equals("") || request.getParameter("password") == null || request.getParameter("password").toString().trim().equals("")) {
			return mapping.findForward(FW_ERROR);
		} else {
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			LoginForm loginForm = new LoginForm();
			loginForm.setUserName(username);
			loginForm.setPassword(password);
			Employee emp = service.getLoginEmployee(loginForm);

			if (emp == null) {
				saveMessage(ErrorConstant.LOGIN_ERROR, request);
				return mapping.findForward(FW_ERROR);
			}
			request.getSession().removeAttribute(Constant.LOGIN_USER);
			request.getSession().setAttribute(Constant.LOGIN_USER, emp);
		}

		return mapping.findForward(FW_SUCCESS);
	}
}
