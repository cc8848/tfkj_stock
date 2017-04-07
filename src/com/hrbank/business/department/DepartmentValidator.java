package com.hrbank.business.department;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;

public class DepartmentValidator extends Validator {

	public String validate(DepartmentForm form) throws Exception {
		initErrors();
		String name = form.getDepartmentName();
		// 人员姓名不能为空
		addError(isEmpty(name, ErrorConstant.DEPARTMENT_NAME_EMPTY));
		// 人员姓名不能超过50个字符
		addError(isOutOfLength(name, 50, ErrorConstant.DEPARTMENT_NAME_OUT_OF_LENGTH));
		return getErrorCode();
	}
}
