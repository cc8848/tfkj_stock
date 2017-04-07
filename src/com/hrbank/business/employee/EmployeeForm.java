package com.hrbank.business.employee;

import org.apache.struts.action.ActionForm;

public class EmployeeForm extends ActionForm {

	private static final long serialVersionUID = -1475487458813981399L;

	private String employeeCode;
	private String employeeName;
	private String departmentCode;
	private String roleIdCode;

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getRoleIdCode() {
		return roleIdCode;
	}

	public void setRoleIdCode(String roleIdCode) {
		this.roleIdCode = roleIdCode;
	}
}
