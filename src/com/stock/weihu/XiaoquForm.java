package com.stock.weihu;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class XiaoquForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2682253727028716989L;

	public void setHidden(){
		
	}
	private String UUID;
	private String name;
	private String netcode;
	private String tvcode;
	private String quyu;
	private String quyuName;
	private String seq;
	
	private String uuidHidden;
	private String nameHidden;
	private String address;
	private String costumeCount;
	private String suoshuquyu;
	
	private String kufang;
	private String remark;

	private List<CommonModule> quyuList = new ArrayList<CommonModule>();
	private List<CommonModule> kufangList = new ArrayList<CommonModule>();
	
	private String[] rightselect;
	
	public String getQuyuName() {
		return quyuName;
	}
	public void setQuyuName(String quyuName) {
		this.quyuName = quyuName;
	}
	public List<CommonModule> getQuyuList() {
		return quyuList;
	}
	public void setQuyuList(List<CommonModule> quyuList) {
		this.quyuList = quyuList;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNetcode() {
		return netcode;
	}
	public void setNetcode(String netcode) {
		this.netcode = netcode;
	}
	public String getTvcode() {
		return tvcode;
	}
	public void setTvcode(String tvcode) {
		this.tvcode = tvcode;
	}
	public String getQuyu() {
		return quyu;
	}
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUuidHidden() {
		return uuidHidden;
	}
	public void setUuidHidden(String uuidHidden) {
		this.uuidHidden = uuidHidden;
	}
	public String getNameHidden() {
		return nameHidden;
	}
	public void setNameHidden(String nameHidden) {
		this.nameHidden = nameHidden;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCostumeCount() {
		return costumeCount;
	}
	public void setCostumeCount(String costumeCount) {
		this.costumeCount = costumeCount;
	}
	public String getSuoshuquyu() {
		return suoshuquyu;
	}
	public void setSuoshuquyu(String suoshuquyu) {
		this.suoshuquyu = suoshuquyu;
	}
	public String getKufang() {
		return kufang;
	}
	public void setKufang(String kufang) {
		this.kufang = kufang;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<CommonModule> getKufangList() {
		return kufangList;
	}
	public void setKufangList(List<CommonModule> kufangList) {
		this.kufangList = kufangList;
	}
	public String[] getRightselect() {
		return rightselect;
	}
	public void setRightselect(String[] rightselect) {
		this.rightselect = rightselect;
	}

}
