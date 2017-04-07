package com.stock.equipStock;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;

public class EquipValidator extends Validator{
	
	public String insertValidate(EntityEquip equ) throws Exception{
		initErrors();
		addError(isEmpty(equ.getKu(),ErrorConstant.IMPORT_KU_EMPTY));
		addError(isEmpty(equ.getMac(),ErrorConstant.IMPORT_MAC_EMPTY));
		addError(isEmpty(equ.getRukuperson(),ErrorConstant.IMPORT_RUKUREN_EMPTY));
		addError(isEmpty(equ.getType(),ErrorConstant.IMPORT_TYP_EMPTY));
		addError(isEmpty(equ.getXianghao(),ErrorConstant.IMPORT_XIANGHAO_EMPTY));
		addError(isEmpty(equ.getXinghao(),ErrorConstant.IMPORT_XIANHAO_EMPTY));
		/*addError(isEmpty(pgd.getXiaoquname(),ErrorConstant.IMPORT_XIAOQU_EMPTY));
		addError(isEmpty(pgd.getUserplace(),ErrorConstant.IMPORT_DIZHI_EMPTY));
		addError(isEmpty(pgd.getUsertel(),ErrorConstant.IMPORT_USERTEL_EMPTY));
		
		addError(isEmpty(pgd.getUsertel(),ErrorConstant.IMPORT_USERTEL_EMPTY));*/
		
		return getErrorCode();
	}	
}
