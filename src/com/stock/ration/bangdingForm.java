package com.stock.ration;

import org.apache.struts.action.ActionForm;

public class bangdingForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6262124664055883979L;
	
	private String UUID;//�豸UUID
	
	private String pgdUUID;//�ɹ���UUID

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public String getPgdUUID() {
		return pgdUUID;
	}

	public void setPgdUUID(String pgdUUID) {
		this.pgdUUID = pgdUUID;
	}
	
	

}
