package com.stock.ration; 

import org.apache.struts.action.ActionForm;

/** 
 * @author wangdl 
 * @version ����ʱ�䣺2012-6-13 ����09:06:43 
 * ��˵�� 
 */
public class rationSecondForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2138804655858945860L;

	public void setHidden(){
		this.equUUIDHidden=this.equUUID;
		this.typeHidden=this.type;
		this.stateHidden=this.state;
		this.xinghaoHidden = this.xinghao;
		this.macHidden = this.mac;
		this.xianghaoHidden = this.xianghao;
		this.pgdUUIDHidden=this.pgdUUID;
		this.chukuplaceHidden = this.chukuplace;
	}
	private String UUID;//�豸uuid
	private String[] UUIDS;
	private String chukuplace;//����
	
	private String chukuplaceHidden="";
	
	public String[] getUUIDS() {
		return UUIDS;
	}
	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
	}
	
	
	private String pgdUUID;//�ɹ���UUID
	private String pgdUUIDHidden;
	
	
	public String getPgdUUIDHidden() {
		return pgdUUIDHidden;
	}
	public void setPgdUUIDHidden(String pgdUUIDHidden) {
		this.pgdUUIDHidden = pgdUUIDHidden;
	}
	public String getPgdUUID() {
		return pgdUUID;
	}
	public void setPgdUUID(String pgdUUID) {
		this.pgdUUID = pgdUUID;
	}
	
	
	private String equUUID;//�豸id
	
	private String type;//�豸���
	
	private String state;//�豸״̬
	
	private String xinghao;//�ͺ�
	
	private String xianghao;//���
	
	private String mac;//mac��ַ
	
	private String equUUIDHidden="";
	private String typeHidden="";
	private String stateHidden="";
	private String xinghaoHidden="";
	private String macHidden="";
	private String xianghaoHidden="";
	
	public String getEquUUID() {
		return equUUID;
	}
	public String getType() {
		return type;
	}
	public String getState() {
		return state;
	}
	public String getXinghao() {
		return xinghao;
	}
	public String getMac() {
		return mac;
	}
	public String getEquUUIDHidden() {
		return equUUIDHidden;
	}
	public String getTypeHidden() {
		return typeHidden;
	}
	public String getStateHidden() {
		return stateHidden;
	}
	
	public String getMacHidden() {
		return macHidden;
	}
	public void setEquUUID(String equUUID) {
		this.equUUID = equUUID;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public void setEquUUIDHidden(String equUUIDHidden) {
		this.equUUIDHidden = equUUIDHidden;
	}
	public void setTypeHidden(String typeHidden) {
		this.typeHidden = typeHidden;
	}
	public void setStateHidden(String stateHidden) {
		this.stateHidden = stateHidden;
	}
	
	public void setMacHidden(String macHidden) {
		this.macHidden = macHidden;
	}
	public String getXinghaoHidden() {
		return xinghaoHidden;
	}
	public void setXinghaoHidden(String xinghaoHidden) {
		this.xinghaoHidden = xinghaoHidden;
	}
	public String getXianghao() {
		return xianghao;
	}
	public void setXianghao(String xianghao) {
		this.xianghao = xianghao;
	}
	public String getXianghaoHidden() {
		return xianghaoHidden;
	}
	public void setXianghaoHidden(String xianghaoHidden) {
		this.xianghaoHidden = xianghaoHidden;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getChukuplace() {
		return chukuplace;
	}
	public void setChukuplace(String chukuplace) {
		this.chukuplace = chukuplace;
	}
	public String getChukuplaceHidden() {
		return chukuplaceHidden;
	}
	public void setChukuplaceHidden(String chukuplaceHidden) {
		this.chukuplaceHidden = chukuplaceHidden;
	}
 
}

