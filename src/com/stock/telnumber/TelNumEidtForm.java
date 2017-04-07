package com.stock.telnumber;

import org.apache.struts.action.ActionForm;

public class TelNumEidtForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3972147941842385814L;

	
	private String UUID;
	
	private String quyu;
	
	
	private String telNo;
	
	
	private String state;
	
	private String desc;


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getUUID() {
		return UUID;
	}


	public void setUUID(String uUID) {
		UUID = uUID;
	}


	public String getQuyu() {
		return quyu;
	}


	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}


	public String getTelNo() {
		return telNo;
	}


	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	

}
