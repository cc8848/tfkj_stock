/*
 * 机能编号：S001
 * 机能名称：用户登录
 * 
 * @author aceeci
 * @date 2009-08-25
 */
package com.hrbank.business.login;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.employee.Employee;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.ParameterSet;

/**
 * 用户登录服务层实现类.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class LoginService extends BusinessService {

	private CommonDao dao = new CommonDao();

	public Employee getLoginEmployee(LoginForm loginForm) throws Exception {
		String userId = loginForm.getUserName();
		// String password = Encrypt.getMD5Message(loginForm.getPassword());
		String password = loginForm.getPassword();
		ParameterSet set = new ParameterSet();
		set.add("employeeId", "@employeeId", userId);
		set.add("employeePassword", "@employeePassword", password);
		Employee emp = null;
		DataRow row = dao.executeQueryToDataRow("LoadEmployee", set);
		if (row != null) {
			emp = new Employee();
			emp.setEmployeeCode(row.getDataElement("ID").getString());
			emp.setEmployeeName(row.getDataElement("NAME").getString());
			emp.setDepartmentCode(row.getDataElement("DEPT_ID").getString());
			emp.setRoleCode(row.getDataElement("ROLE_ID").getString());
		}
		return emp;
	}

}
