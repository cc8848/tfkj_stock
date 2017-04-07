package com.stock.equipStock; 

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 上午11:07:24 
 * 类说明 
 */
public class EquipStockEntiyForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5583036729291493691L;
	
	private String[] UUIDS;
	
	private String UUID;
	
	private String typeString;//
	
	private String xianghaoString;
	
	private String rukudateString;
	
	private String stateString;
	
	private String rukupersonString;
	
	private String xinghaoString;
	
	private String macsString;
	
	private String zhucejifangString;
	
	private String tVipString;
	
	private String chukudateString;
	
	private String chukuplaceString;
	
	private String lingqurenString;
	
	private String anzhuangplaceString;
	
	private String beizhuString;

	public String getTypeString() {
		return typeString;
	}

	public String getXianghaoString() {
		return xianghaoString;
	}

	public String getRukudateString() {
		return rukudateString;
	}

	public String getStateString() {
		return stateString;
	}

	public String getRukupersonString() {
		return rukupersonString;
	}

	public String getXinghaoString() {
		return xinghaoString;
	}

	public String getMacsString() {
		return macsString;
	}

	public String getZhucejifangString() {
		return zhucejifangString;
	}

	public String gettVipString() {
		return tVipString;
	}

	public String getChukudateString() {
		return chukudateString;
	}

	public String getChukuplaceString() {
		return chukuplaceString;
	}

	public String getLingqurenString() {
		return lingqurenString;
	}

	public String getAnzhuangplaceString() {
		return anzhuangplaceString;
	}

	public String getBeizhuString() {
		return beizhuString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	public void setXianghaoString(String xianghaoString) {
		this.xianghaoString = xianghaoString;
	}

	public void setRukudateString(String rukudateString) {
		this.rukudateString = rukudateString;
	}

	public void setStateString(String stateString) {
		this.stateString = stateString;
	}

	public void setRukupersonString(String rukupersonString) {
		this.rukupersonString = rukupersonString;
	}

	public void setXinghaoString(String xinghaoString) {
		this.xinghaoString = xinghaoString;
	}

	public void setMacsString(String macsString) {
		this.macsString = macsString;
	}

	public void setZhucejifangString(String zhucejifangString) {
		this.zhucejifangString = zhucejifangString;
	}

	public void settVipString(String tVipString) {
		this.tVipString = tVipString;
	}

	public void setChukudateString(String chukudateString) {
		this.chukudateString = chukudateString;
	}

	public void setChukuplaceString(String chukuplaceString) {
		this.chukuplaceString = chukuplaceString;
	}

	public void setLingqurenString(String lingqurenString) {
		this.lingqurenString = lingqurenString;
	}

	public void setAnzhuangplaceString(String anzhuangplaceString) {
		this.anzhuangplaceString = anzhuangplaceString;
	}

	public void setBeizhuString(String beizhuString) {
		this.beizhuString = beizhuString;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public String[] getUUIDS() {
		return UUIDS;
	}

	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
	}
	
}

