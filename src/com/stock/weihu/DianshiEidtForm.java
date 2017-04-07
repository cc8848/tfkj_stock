package com.stock.weihu;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class DianshiEidtForm extends ActionForm{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2093361558775164048L;
	
	private List<CommonModule> shichangList = new ArrayList<CommonModule>();
	
	private String shichangName;
	private String UUID;
	private String UUIDHidden;
	private String seq;
	private String shichangLeibie;
	private String yewuLeibie;
	private String jine;
	private String shichangyue;
	public List<CommonModule> getShichangList() {
		return shichangList;
	}
	public void setShichangList(List<CommonModule> shichangList) {
		this.shichangList = shichangList;
	}
	public String getShichangName() {
		return shichangName;
	}
	public void setShichangName(String shichangName) {
		this.shichangName = shichangName;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getUUIDHidden() {
		return UUIDHidden;
	}
	public void setUUIDHidden(String uUIDHidden) {
		UUIDHidden = uUIDHidden;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getShichangLeibie() {
		return shichangLeibie;
	}
	public void setShichangLeibie(String shichangLeibie) {
		this.shichangLeibie = shichangLeibie;
	}
	public String getYewuLeibie() {
		return yewuLeibie;
	}
	public void setYewuLeibie(String yewuLeibie) {
		this.yewuLeibie = yewuLeibie;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
