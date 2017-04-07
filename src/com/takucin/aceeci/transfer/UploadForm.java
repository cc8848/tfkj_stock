package com.takucin.aceeci.transfer;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UploadForm  extends ActionForm  {
	
	private static final long serialVersionUID = 10200908031555L;
	
	private FormFile formFile;

	public FormFile getFormFile() {
		return formFile;
	}

	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}
	
}
