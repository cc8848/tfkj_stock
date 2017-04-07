package com.stock.kucun;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

@SuppressWarnings("serial")
public class KuncunForm extends ActionForm{

	
	public void setHidden(){
		this.quyuCodeHidden = this.quyuCode;
		this.UUIDHidden = this.UUID;
	}
	
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	private List<CommonModule> userNameList = new ArrayList<CommonModule>();
	private List<CommonModule> statusList = new ArrayList<CommonModule>();
	private List<CommonModule> senList = new ArrayList<CommonModule>();
	
	private String quyuCode;
	private String quyuCodeHidden = "";
	
	private String userName;
	private String userNameHidden = "";
	
	private String status;
	private String statusHidden = "";
	
	private String UUID;
	private String UUIDHidden;
	private String xianghao;
	private String shebeizhuangtai;
	private String rukuriqi;
	private String rukuren;
	private String shebeileixing;
	private String shebeixinghao;
	private String xiaoqurukuriqi;
	private String rukuxiaoqu;
	private String lingquren;
	private String anzhuangdidian;
	private String anzhuangshijian;
	private String zhuceweizhi;
	private String mac;
	private String mcid;
	private String shujuip;
	private String beizhu;
	private String zhuangtai;
	private String zhuangtaiHidden = "";
	
	private String shijianleixing = "";
	private String kaishi = "";
	private String jieshu = "";
	private String sen = "";
	private String senValue = "";
	private String qmac;
	private String qmcid;
	private String install_site;
	private String [] UUIDS;
	
	private String shebeitype;
	
	
	
	public String getInstall_site() {
		return install_site;
	}
	public void setInstall_site(String install_site) {
		this.install_site = install_site;
	}
	public String getQmac() {
		return qmac;
	}
	public void setQmac(String qmac) {
		this.qmac = qmac;
	}
	public String getQmcid() {
		return qmcid;
	}
	public void setQmcid(String qmcid) {
		this.qmcid = qmcid;
	}
	public String getSenValue() {
		return senValue;
	}
	public void setSenValue(String senValue) {
		this.senValue = senValue;
	}
	public String getSen() {
		return sen;
	}
	public void setSen(String sen) {
		this.sen = sen;
	}
	public String getKaishi() {
		return kaishi;
	}
	public void setKaishi(String kaishi) {
		this.kaishi = kaishi;
	}
	public String getJieshu() {
		return jieshu;
	}
	public void setJieshu(String jieshu) {
		this.jieshu = jieshu;
	}
	public String getShijianleixing() {
		return shijianleixing;
	}
	public void setShijianleixing(String shijianleixing) {
		this.shijianleixing = shijianleixing;
	}
	public String getZhuangtaiHidden() {
		return zhuangtaiHidden;
	}
	public void setZhuangtaiHidden(String zhuangtaiHidden) {
		this.zhuangtaiHidden = zhuangtaiHidden;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getUUIDHidden() {
		return UUIDHidden;
	}
	public void setUUIDHidden(String uUIDHidden) {
		UUIDHidden = uUIDHidden;
	}
	public String[] getUUIDS() {
		return UUIDS;
	}
	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusHidden() {
		return statusHidden;
	}
	public void setStatusHidden(String statusHidden) {
		this.statusHidden = statusHidden;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNameHidden() {
		return userNameHidden;
	}
	public void setUserNameHidden(String userNameHidden) {
		this.userNameHidden = userNameHidden;
	}
	public String getQuyuCode() {
		return quyuCode;
	}
	public void setQuyuCode(String quyuCode) {
		this.quyuCode = quyuCode;
	}
	public String getQuyuCodeHidden() {
		return quyuCodeHidden;
	}
	public void setQuyuCodeHidden(String quyuCodeHidden) {
		this.quyuCodeHidden = quyuCodeHidden;
	}
	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}
	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}
	public List<CommonModule> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<CommonModule> statusList) {
		this.statusList = statusList;
	}
	public List<CommonModule> getSenList() {
		return senList;
	}
	public void setSenList(List<CommonModule> senList) {
		this.senList = senList;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getXianghao() {
		return xianghao;
	}
	public void setXianghao(String xianghao) {
		this.xianghao = xianghao;
	}
	public String getShebeizhuangtai() {
		return shebeizhuangtai;
	}
	public void setShebeizhuangtai(String shebeizhuangtai) {
		this.shebeizhuangtai = shebeizhuangtai;
	}
	public String getRukuriqi() {
		return rukuriqi;
	}
	public void setRukuriqi(String rukuriqi) {
		this.rukuriqi = rukuriqi;
	}
	public String getRukuren() {
		return rukuren;
	}
	public void setRukuren(String rukuren) {
		this.rukuren = rukuren;
	}
	public String getShebeileixing() {
		return shebeileixing;
	}
	public void setShebeileixing(String shebeileixing) {
		this.shebeileixing = shebeileixing;
	}
	public String getShebeixinghao() {
		return shebeixinghao;
	}
	public void setShebeixinghao(String shebeixinghao) {
		this.shebeixinghao = shebeixinghao;
	}
	public String getXiaoqurukuriqi() {
		return xiaoqurukuriqi;
	}
	public void setXiaoqurukuriqi(String xiaoqurukuriqi) {
		this.xiaoqurukuriqi = xiaoqurukuriqi;
	}
	public String getRukuxiaoqu() {
		return rukuxiaoqu;
	}
	public void setRukuxiaoqu(String rukuxiaoqu) {
		this.rukuxiaoqu = rukuxiaoqu;
	}
	public String getLingquren() {
		return lingquren;
	}
	public void setLingquren(String lingquren) {
		this.lingquren = lingquren;
	}
	public String getAnzhuangdidian() {
		return anzhuangdidian;
	}
	public void setAnzhuangdidian(String anzhuangdidian) {
		this.anzhuangdidian = anzhuangdidian;
	}
	public String getAnzhuangshijian() {
		return anzhuangshijian;
	}
	public void setAnzhuangshijian(String anzhuangshijian) {
		this.anzhuangshijian = anzhuangshijian;
	}
	public String getZhuceweizhi() {
		return zhuceweizhi;
	}
	public void setZhuceweizhi(String zhuceweizhi) {
		this.zhuceweizhi = zhuceweizhi;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getMcid() {
		return mcid;
	}
	public void setMcid(String mcid) {
		this.mcid = mcid;
	}
	public String getShujuip() {
		return shujuip;
	}
	public void setShujuip(String shujuip) {
		this.shujuip = shujuip;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public List<CommonModule> getUserNameList() {
		return userNameList; 
	}
	public void setUserNameList(List<CommonModule> userNameList) {
		this.userNameList = userNameList;
	}
	public String getShebeitype() {
		return shebeitype;
	}
	public void setShebeitype(String shebeitype) {
		this.shebeitype = shebeitype;
	}

}
