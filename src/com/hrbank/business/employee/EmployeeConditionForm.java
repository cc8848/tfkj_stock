package com.hrbank.business.employee;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class EmployeeConditionForm extends ActionForm {

	private static final long serialVersionUID = 6479780506076737884L;

	private String employeeCodeCond;

	private String employeeNameCond;

	private String departmentCodeCond;

	private String departmentNameCond;

	private String employeeCodeHidden = "";

	private String employeeNameHidden = "";

	private String departmentCodeHidden = "";

	private String departmentNameHidden = "";

	private List<CommonModule> roleList = new ArrayList<CommonModule>();

	public List<CommonModule> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<CommonModule> roleList) {
		this.roleList = roleList;
	}

	public String getDepartmentCodeCond() {
		return departmentCodeCond;
	}

	public void setDepartmentCodeCond(String departmentCodeCond) {
		this.departmentCodeCond = departmentCodeCond;
	}

	public String getDepartmentCodeHidden() {
		return departmentCodeHidden;
	}

	public void setDepartmentCodeHidden(String departmentCodeHidden) {
		this.departmentCodeHidden = departmentCodeHidden;
	}

	public String getDepartmentNameCond() {
		return departmentNameCond;
	}

	public void setDepartmentNameCond(String departmentNameCond) {
		this.departmentNameCond = departmentNameCond;
	}

	public String getDepartmentNameHidden() {
		return departmentNameHidden;
	}

	public void setDepartmentNameHidden(String departmentNameHidden) {
		this.departmentNameHidden = departmentNameHidden;
	}

	public String getEmployeeCodeCond() {
		return employeeCodeCond;
	}

	public void setEmployeeCodeCond(String employeeCodeCond) {
		this.employeeCodeCond = employeeCodeCond;
	}

	public String getEmployeeCodeHidden() {
		return employeeCodeHidden;
	}

	public void setEmployeeCodeHidden(String employeeCodeHidden) {
		this.employeeCodeHidden = employeeCodeHidden;
	}

	public String getEmployeeNameCond() {
		return employeeNameCond;
	}

	public void setEmployeeNameCond(String employeeNameCond) {
		this.employeeNameCond = employeeNameCond;
	}

	public String getEmployeeNameHidden() {
		return employeeNameHidden;
	}

	public void setEmployeeNameHidden(String employeeNameHidden) {
		this.employeeNameHidden = employeeNameHidden;
	}

	public void setHidden() {
		this.employeeCodeHidden = this.employeeCodeCond;
		this.employeeNameHidden = this.employeeNameCond;
		this.departmentCodeHidden = this.departmentCodeCond;
		this.departmentNameHidden = this.departmentNameCond;
	}

}
