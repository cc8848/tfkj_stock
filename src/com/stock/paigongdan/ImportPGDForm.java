package com.stock.paigongdan; 

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-14 上午09:49:07 
 * 类说明 
 */
public class ImportPGDForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6685090967672957484L;
	private FormFile formFile;
	
	private String dateString;//派工单日期
	
	public FormFile getFormFile() {
		return formFile;
	}
	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	
}

