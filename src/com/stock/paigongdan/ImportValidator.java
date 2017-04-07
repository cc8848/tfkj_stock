package com.stock.paigongdan;
import org.apache.struts.upload.FormFile;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;

public class ImportValidator extends Validator {

	private static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";
	
	public String fileUplodateValidate(FormFile file){
		initErrors();
		String name = file.getFileName();
		addError(isEmpty(name, ErrorConstant.UPLOAD_FILE_EMPTY));
		if(!file.getContentType().equals(CONTENT_TYPE_XLS)){
			System.out.println(name);
			System.out.println("not exs");
			addError(ErrorConstant.UPLOAD_FILE_NOT_XLS);
		}
		return getErrorCode();
	}
}
