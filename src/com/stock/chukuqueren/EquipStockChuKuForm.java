package com.stock.chukuqueren;
import org.apache.struts.action.ActionForm;

/** 
 * @author wangdl 
 * @version ����ʱ�䣺2012-6-13 ����09:06:43 
 * ��˵�� 
 */
public class EquipStockChuKuForm extends ActionForm{
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
	}
	private String equUUID;//�豸id
	
	private String type;//�豸���
	
	private String state;//�豸״̬
	
	private String xinghao;//�ͺ�
	
	private String mac;//mac��ַ
	
	private String equUUIDHidden="";
	private String typeHidden="";
	private String stateHidden="";
	private String xinghaoHidden="";
	private String macHidden="";
	
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
 
	
}

