package com.stock.equipStock;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class ImportEquipForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 223287807608827551L;
	private FormFile formFile;

	public FormFile getFormFile() {
		return formFile;
	}

	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}
	
}
