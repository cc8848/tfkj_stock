package com.stock.telnumber;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;

public class TelValidator extends Validator{
	
	public String insertValidate(EntityTel pgd) throws Exception{
		initErrors();
		addError(isEmpty(pgd.getQuyu(),ErrorConstant.IMPORT_QUYU_EMPTY));
		addError(isEmpty(pgd.getTelNo(),ErrorConstant.IMPORT_TELNO_EMPTY));
		
		addError(isEmpty(pgd.getState(),ErrorConstant.IMPORT_STATE_EMPTY));
		return getErrorCode();
	}	
}
