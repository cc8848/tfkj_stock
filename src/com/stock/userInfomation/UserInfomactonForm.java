package com.stock.userInfomation;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.takucin.aceeci.common.CommonModule;

public class UserInfomactonForm extends ActionForm{
	
	private static final long serialVersionUID = -883952113139675917L;
	
	public void setHidden(){
		this.xiaoqunameHidden=this.xiaoquname;
		this.dizhiHidden = this.dizhi;
		this.yonghuHidden = this.yonghu;
	}
	
	private String UUID;
	
	
	private String xiaoquname;
	
	private String xiaoqunameHidden="";
	
	private String dizhi;
	
	private String dizhiHidden="";
	
	private String yonghu;
	
	private String yonghuHidden="";
	
	private FormFile formFile;
	
	private List<CommonModule> xiaoquList;

	public FormFile getFormFile() {
		return formFile;
	}

	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}
	
	public String getDizhi() {
		return dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	public String getDizhiHidden() {
		return dizhiHidden;
	}

	public void setDizhiHidden(String dizhiHidden) {
		this.dizhiHidden = dizhiHidden;
	}

	public String getYonghu() {
		return yonghu;
	}

	public void setYonghu(String yonghu) {
		this.yonghu = yonghu;
	}

	public String getYonghuHidden() {
		return yonghuHidden;
	}

	public void setYonghuHidden(String yonghuHidden) {
		this.yonghuHidden = yonghuHidden;
	}

	public String getXiaoquname() {
		return xiaoquname;
	}

	public void setXiaoquname(String xiaoquname) {
		this.xiaoquname = xiaoquname;
	}

	public String getXiaoqunameHidden() {
		return xiaoqunameHidden;
	}

	public void setXiaoqunameHidden(String xiaoqunameHidden) {
		this.xiaoqunameHidden = xiaoqunameHidden;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}
 	
}
