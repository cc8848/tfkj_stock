package com.stock.tietongshuju; 

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/** 
 * @author wangdl 
 * @version ����ʱ�䣺2012-6-14 ����09:49:07 
 * ��˵�� 
 */
public class ImportDataForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6685090967672957484L;
	private FormFile formFile;
	
	public FormFile getFormFile() {
		return formFile;
	}
	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}
}

