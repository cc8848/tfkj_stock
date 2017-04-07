package com.stock.ration; 

import org.apache.struts.action.ActionForm;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 下午02:30:30 
 * 类说明 
 */
public class rationEntityForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8553936447853671062L;
	
	private String UUID;
	private String xiaoquname;
	
	private String userplace;//地址
	
	private String usertel;
	
	private String kuadnai;
	
	private String tv;
	
	private String tel;
	
	private String useryaoqiu;
	
	private String onu;
	
	private String jidinghe;
	
	private String beizhu;
	
	private String state;

	public String getXiaoquname() {
		return xiaoquname;
	}

	public String getUserplace() {
		return userplace;
	}

	public String getUsertel() {
		return usertel;
	}

	public String getKuadnai() {
		return kuadnai;
	}

	public String getTv() {
		return tv;
	}

	public String getTel() {
		return tel;
	}

	public String getUseryaoqiu() {
		return useryaoqiu;
	}

	public String getOnu() {
		return onu;
	}

	public String getJidinghe() {
		return jidinghe;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public String getState() {
		return state;
	}

	public void setXiaoquname(String xiaoquname) {
		this.xiaoquname = xiaoquname;
	}

	public void setUserplace(String userplace) {
		this.userplace = userplace;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public void setKuadnai(String kuadnai) {
		this.kuadnai = kuadnai;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setUseryaoqiu(String useryaoqiu) {
		this.useryaoqiu = useryaoqiu;
	}

	public void setOnu(String onu) {
		this.onu = onu;
	}

	public void setJidinghe(String jidinghe) {
		this.jidinghe = jidinghe;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
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

