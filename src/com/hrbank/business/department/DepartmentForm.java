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
public class DepartmentForm extends ActionForm {

	private static final long serialVersionUID = 10201107031849L;

	private String departmentCode;
	private String departmentName;

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
