/*
 * ���ܱ�ţ�S024
 * �������ƣ���ӭ����
 * 
 * @author aceeci
 * @date 2009-08-25
 */
package com.hrbank.business.main;

import org.apache.struts.action.ActionForm;

/**
 * ��ӭ�����������.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class MainForm extends ActionForm {

	private static final long serialVersionUID = 10200907151540L;

	private String employeeCode;
	private String employeeName;
	private String departmentCode;
	private String departmentName;

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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
