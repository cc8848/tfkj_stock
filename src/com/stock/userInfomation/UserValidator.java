package com.stock.userInfomation;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;

public class UserValidator extends Validator {
	
	public String insertValidate(UserInfomation user) throws Exception{
		initErrors();
		String	xq_name = user.getXiaoquname();
		String yonghu = user.getYonghu();
		String zjh = user.getZhenjianno();
		String dz = user.getDizi();
		addError(isEmpty(xq_name,ErrorConstant.IMPORT_USER_XQNAME_EMPTY));
		addError(isEmpty(yonghu,ErrorConstant.IMPORT_USER_YONGHU_EMPTY));
		addError(isEmpty(zjh,ErrorConstant.IMPORT_USER_ZJH_EMPTY));
		addError(isEmpty(dz,ErrorConstant.IMPORT_USER_DZ_EMPTY));
		
		return getErrorCode();
	}

}
