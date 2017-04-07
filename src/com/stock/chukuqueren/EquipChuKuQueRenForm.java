package com.stock.chukuqueren;

import org.apache.struts.action.ActionForm;

public class EquipChuKuQueRenForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2938229776837706878L;
	
	private String UUID;

	private String state;
	
	private String[] UUIDS;//¸´Ñ¡¿ò
	
	

	public String[] getUUIDS() {
		return UUIDS;
	}

	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}
	
	
}
