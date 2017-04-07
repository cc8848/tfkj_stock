/*
 * 机能编号：S017
 * 机能名称：最低工资设置
 * 
 * @author fanlp
 * @date 2009-07-17
 */
package com.hrbank.business.department;

import org.apache.struts.action.ActionForm;

/**
 * 五险一金比例查询条件表单属性类
 * 
 * @author zhangyin
 * @date 2009-07-15
 */
public class DepartmentConditionForm extends ActionForm {

	private static final long serialVersionUID = 17200907171324L;

	private String departmentCodeCond;
	private String departmentNameCond;
	private String departmentCodeHidden = "";
	private String departmentNameHidden = "";

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

	public void setHidden() {
		this.departmentCodeHidden = this.departmentCodeCond;
		this.departmentNameHidden = this.departmentNameCond;
	}

}
