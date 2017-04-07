package com.hrbank.business.employee;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;
import com.hrbank.business.reset.ResetForm;

public class EmployeeValidator extends Validator {

	public String insertValidate(EmployeeForm form) throws Exception {
		initErrors();
		String code = form.getEmployeeCode();
		String name = form.getEmployeeName();
		// ��Ա���벻��Ϊ��
		addError(isEmpty(code, ErrorConstant.EMPLOYEE_CODE_EMPTY));
		// ��Ա�������Ϊ6λ����
		// addError(isEffectiveRegex(code,
		// "\\d{6}",ErrorConstant.EMPLOYEE_CODE_FORMAT_ILLEGAL));
		// ��Ա��������Ϊ��
		addError(isEmpty(name, ErrorConstant.EMPLOYEE_NAME_EMPTY));
		// ��Ա�������ܳ���50���ַ�
		addError(isOutOfLength(name, 50, ErrorConstant.EMPLOYEE_NAME_OUT_OF_LENGTH));
		return getErrorCode();
	}

	public String updateValidate(EmployeeForm form) throws Exception {
		initErrors();
		String name = form.getEmployeeName();
		// ��Ա��������Ϊ��
		addError(isEmpty(name, ErrorConstant.EMPLOYEE_NAME_EMPTY));
		// ��Ա�������ܳ���50���ַ�
		addError(isOutOfLength(name, 50, ErrorConstant.EMPLOYEE_NAME_OUT_OF_LENGTH));
		return getErrorCode();
	}

	public String resetValidate(ResetForm form) throws Exception {
		initErrors();
		String code = form.getEmployeeCode();
		// ��Ա���벻��Ϊ��
		addError(isEmpty(code, ErrorConstant.EMPLOYEE_CODE_EMPTY));
		return getErrorCode();
	}
}
