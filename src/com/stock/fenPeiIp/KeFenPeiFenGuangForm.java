package com.stock.fenPeiIp;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.takucin.aceeci.common.CommonModule;

public class KeFenPeiFenGuangForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4002190135164716690L;

	private String UUID;
	
	private String[] UUIDS;
	
	private String fenguangID;
	
	private String kuang;
	
	private String fenguang;
	
	private String mask;
	
	private String remark;
	
	private FormFile formFile;

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public String getFenguangID() {
		return fenguangID;
	}

	public void setFenguangID(String fenguangID) {
		this.fenguangID = fenguangID;
	}

	public String getKuang() {
		return kuang;
	}

	public void setKuang(String kuang) {
		this.kuang = kuang;
	}

	public String getFenguang() {
		return fenguang;
	}

	public void setFenguang(String fenguang) {
		this.fenguang = fenguang;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public FormFile getFormFile() {
		return formFile;
	}

	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}

	public String[] getUUIDS() {
		return UUIDS;
	}

	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
	}

}
