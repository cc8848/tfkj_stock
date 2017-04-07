package com.stock.weihu;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class ShichangEidtForm extends ActionForm{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2093361558775164048L;
	
	private List<CommonModule> shichangList = new ArrayList<CommonModule>();
	
	private String shichang;
	private String UUID;
	private String UUIDHidden;
	private String seq;
	private String leixing;
	private String daikuan;
	private String jine;
	private String shichangyue;

	public List<CommonModule> getShichangList() {
		return shichangList;
	}

	
	public String getUUIDHidden() {
		return UUIDHidden;
	}


	public void setUUIDHidden(String uUIDHidden) {
		UUIDHidden = uUIDHidden;
	}


	public String getUUID() {
		return UUID;
	}


	public void setUUID(String uUID) {
		UUID = uUID;
	}


	public void setShichangList(List<CommonModule> shichangList) {
		this.shichangList = shichangList;
	}

	public String getShichang() {
		return shichang;
	}

	public void setShichang(String shichang) {
		this.shichang = shichang;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public String getDaikuan() {
		return daikuan;
	}


	public void setDaikuan(String daikuan) {
		this.daikuan = daikuan;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getJine() {
		return jine;
	}


	public void setJine(String jine) {
		this.jine = jine;
	}


	public String getShichangyue() {
		return shichangyue;
	}


	public void setShichangyue(String shichangyue) {
		this.shichangyue = shichangyue;
	}

}
