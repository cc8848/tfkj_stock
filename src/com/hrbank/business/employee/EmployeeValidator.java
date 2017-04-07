package com.hrbank.business.employee;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;
import com.hrbank.business.reset.ResetForm;

public class EmployeeValidator extends Validator {

	public String insertValidate(EmployeeForm form) throws Exception {
		initErrors();
		String code = form.getEmployeeCode();
		String name = form.getEmployeeName();
		// 人员代码不能为空
		addError(isEmpty(code, ErrorConstant.EMPLOYEE_CODE_EMPTY));
		// 人员代码必须为6位数字
		// addError(isEffectiveRegex(code,
		// "\\d{6}",ErrorConstant.EMPLOYEE_CODE_FORMAT_ILLEGAL));
		// 人员姓名不能为空
		addError(isEmpty(name, ErrorConstant.EMPLOYEE_NAME_EMPTY));
		// 人员姓名不能超过50个字符
		addError(isOutOfLength(name, 50, ErrorConstant.EMPLOYEE_NAME_OUT_OF_LENGTH));
		return getErrorCode();
	}

	public String updateValidate(EmployeeForm form) throws Exception {
		initErrors();
		String name = form.getEmployeeName();
		// 人员姓名不能为空
		addError(isEmpty(name, ErrorConstant.EMPLOYEE_NAME_EMPTY));
		// 人员姓名不能超过50个字符
		addError(isOutOfLength(name, 50, ErrorConstant.EMPLOYEE_NAME_OUT_OF_LENGTH));
		return getErrorCode();
	}

	public String resetValidate(ResetForm form) throws Exception {
		initErrors();
		String code = form.getEmployeeCode();
		// 人员代码不能为空
		addError(isEmpty(code, ErrorConstant.EMPLOYEE_CODE_EMPTY));
		return getErrorCode();
	}
}
