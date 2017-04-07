package com.hrbank.business.password;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;

public class PasswordValidator extends Validator {

	public String validate(PasswordForm form) throws Exception {
		initErrors();
		String oldPassword = form.getOldPassword();
		String newPassword = form.getNewPassword();
		String confirmPassword = form.getNewPasswordConfirm();
		addError(isEmpty(oldPassword, ErrorConstant.OLD_PASSWORD_EMPTY));
		addError(isEmpty(newPassword, ErrorConstant.NEW_PASSWORD_EMPTY));
		addError(isEffectiveRegex(newPassword, "\\w+", ErrorConstant.NEW_PASSWORD_FORMAT_ILLEGAL));
		addError(isOutOfLength(newPassword, 20, ErrorConstant.NEW_PASSWORD_OUT_OF_LENGTH));
		addError(isEmpty(confirmPassword, ErrorConstant.CONFIRM_PASSWORD_EMPTY));
		if (!newPassword.equals(confirmPassword)) {
			addError(ErrorConstant.PASSWORD_NOT_EQUALS);
		}
		return getErrorCode();
	}
}
