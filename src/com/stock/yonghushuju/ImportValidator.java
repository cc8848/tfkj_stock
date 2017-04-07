package com.stock.yonghushuju;
import org.apache.struts.upload.FormFile;

import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.common.Validator;

public class ImportValidator extends Validator {

	private static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";
	
	private static final String CONTENT_TYPE_JPG = "image/jpeg";
	
	private static final String CONTENT_TYPE_PJPEG = "image/pjpeg";
	
	private static final String CONTENT_TYPE_PNG = "image/png";
	
	public String fileUplodateValidate(FormFile file){
		initErrors();
		String name = file.getFileName();
		addError(isEmpty(name, ErrorConstant.UPLOAD_FILE_EMPTY));
		
		if (!file.getContentType().equals(CONTENT_TYPE_XLS)) {
//			System.out.println(name);
//			System.out.println("not exs");
			
			addError(ErrorConstant.UPLOAD_FILE_NOT_XLS);
		}
		
		return getErrorCode();
	}
	
	public String fileUplodatePhotoValidate(FormFile file){
		initErrors();
		String name = file.getFileName();
		addError(isEmpty(name, ErrorConstant.UPLOAD_FILE_EMPTY));
		System.out.println(file.getContentType());
		if (!file.getContentType().equals(CONTENT_TYPE_JPG)&&!file.getContentType().equals(CONTENT_TYPE_PJPEG)&&!file.getContentType().equals(CONTENT_TYPE_PNG)) {
			addError(ErrorConstant.UPLOAD_FILE_NOT_XLS);
		}
		
		return getErrorCode();
	}
}
