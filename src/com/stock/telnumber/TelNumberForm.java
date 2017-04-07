package com.stock.telnumber;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class TelNumberForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3972147941842385814L;

	public void setHidden(){
		this.quyuCodeHidden=this.quyuCode;
		this.telNoCodeHidden = this.telNoCode;
		this.stateCodeHidden = this.stateCode;
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	
	private String quyuCode;
	
	private String quyuCodeHidden="";
	
	private String telNoCode;
	
	private String telNoCodeHidden="";
	
	private String stateCode;
	
	private String stateCodeHidden="";

	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}

	public String getQuyuCode() {
		return quyuCode;
	}

	public void setQuyuCode(String quyuCode) {
		this.quyuCode = quyuCode;
	}

	public String getQuyuCodeHidden() {
		return quyuCodeHidden;
	}

	public void setQuyuCodeHidden(String quyuCodeHidden) {
		this.quyuCodeHidden = quyuCodeHidden;
	}

	public String getTelNoCode() {
		return telNoCode;
	}

	public void setTelNoCode(String telNoCode) {
		this.telNoCode = telNoCode;
	}

	public String getTelNoCodeHidden() {
		return telNoCodeHidden;
	}

	public void setTelNoCodeHidden(String telNoCodeHidden) {
		this.telNoCodeHidden = telNoCodeHidden;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateCodeHidden() {
		return stateCodeHidden;
	}

	public void setStateCodeHidden(String stateCodeHidden) {
		this.stateCodeHidden = stateCodeHidden;
	}
	
}
