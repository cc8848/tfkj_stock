package com.stock.yuyuequery;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class YuyueForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2682253727028716989L;

	public void setHidden(){
		this.xiaoqucodeHidden = this.xiaoqucode;
		this.riqicodeHidden = this.riqicode;
		this.starriqicodeHidden = this.starriqicode;
		this.endriqicodeHidden = this.endriqicode;
		
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	private List<CommonModule> quyulist = new ArrayList<CommonModule>();
	
	private String xiaoqucode;
	
	private String riqicode;
	
	private String starriqicode;
	
	private String endriqicode;
	
	private String starriqicodeHidden="";
	
	private String endriqicodeHidden="";
	private String xiaoqucodeHidden ="";
	
	private String riqicodeHidden = "";

	public String getXiaoqucode() {
		return xiaoqucode;
	}

	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}

	public void setXiaoqucode(String xiaoqucode) {
		this.xiaoqucode = xiaoqucode;
	}

	public String getRiqicode() {
		return riqicode;
	}

	public void setRiqicode(String riqicode) {
		this.riqicode = riqicode;
	}

	public String getXiaoqucodeHidden() {
		return xiaoqucodeHidden;
	}

	public void setXiaoqucodeHidden(String xiaoqucodeHidden) {
		this.xiaoqucodeHidden = xiaoqucodeHidden;
	}

	public String getRiqicodeHidden() {
		return riqicodeHidden;
	}

	public void setRiqicodeHidden(String riqicodeHidden) {
		this.riqicodeHidden = riqicodeHidden;
	}

	public String getStarriqicode() {
		return starriqicode;
	}

	public void setStarriqicode(String starriqicode) {
		this.starriqicode = starriqicode;
	}

	public String getEndriqicode() {
		return endriqicode;
	}

	public void setEndriqicode(String endriqicode) {
		this.endriqicode = endriqicode;
	}

	public String getStarriqicodeHidden() {
		return starriqicodeHidden;
	}

	public void setStarriqicodeHidden(String starriqicodeHidden) {
		this.starriqicodeHidden = starriqicodeHidden;
	}

	public String getEndriqicodeHidden() {
		return endriqicodeHidden;
	}

	public void setEndriqicodeHidden(String endriqicodeHidden) {
		this.endriqicodeHidden = endriqicodeHidden;
	}

	public List<CommonModule> getQuyulist() {
		return quyulist;
	}

	public void setQuyulist(List<CommonModule> quyulist) {
		this.quyulist = quyulist;
	}
	
}
