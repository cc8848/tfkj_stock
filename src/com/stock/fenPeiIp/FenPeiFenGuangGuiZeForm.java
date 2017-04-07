package com.stock.fenPeiIp;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.takucin.aceeci.common.CommonModule;

public class FenPeiFenGuangGuiZeForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5293569816472042048L;

	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	
	private String UUID;
	
	private String xiaoqu;
	
	private String louhao;
	
	private String loumen;
	
	private String louceng;
	
	private String danyuan;
	
	private String fenguangID;
	
	private String beizhu;
	
	private FormFile formFile;

	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public String getXiaoqu() {
		return xiaoqu;
	}

	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}

	public String getLouhao() {
		return louhao;
	}

	public void setLouhao(String louhao) {
		this.louhao = louhao;
	}

	public String getLoumen() {
		return loumen;
	}

	public void setLoumen(String loumen) {
		this.loumen = loumen;
	}

	public String getLouceng() {
		return louceng;
	}

	public void setLouceng(String louceng) {
		this.louceng = louceng;
	}

	public String getDanyuan() {
		return danyuan;
	}

	public void setDanyuan(String danyuan) {
		this.danyuan = danyuan;
	}

	public String getFenguangID() {
		return fenguangID;
	}

	public void setFenguangID(String fenguangID) {
		this.fenguangID = fenguangID;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public FormFile getFormFile() {
		return formFile;
	}

	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}
	
}
