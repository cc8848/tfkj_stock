package com.stock.weihu;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class IptvlogEidtForm extends ActionForm{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2093361558775164048L;
	
	public void setHidden(){
			this.tingjizhanghaoHidden = this.tingjizhanghao;
			this.tingjishijianHidden = this.tingjishijian;
			this.shifouchenggongHidden = this.shifouchenggong;
	}
	
	private List<CommonModule> iptvlogList = new ArrayList<CommonModule>();
	
	private String UUID;
	private String tingjizhanghao;
	private String tingjishijian;
	private String createdt;
	private String shifouchenggong;
	private String shibaibianhao;
	private String shibaixinxi;
	private String tingjizhanghaoHidden="";
	private String tingjishijianHidden="";
	private String shifouchenggongHidden="";
	private String serverip="";
	//是否网上续费
	private String isweb;

	public String getIsweb() {
		return isweb;
	}

	public void setIsweb(String isweb) {
		this.isweb = isweb;
	}

	/**
	 * 调用的接口类型
	 */
	private String interfaceType;

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<CommonModule> getIptvlogList() {
		return iptvlogList;
	}
	public void setIptvlogList(List<CommonModule> iptvlogList) {
		this.iptvlogList = iptvlogList;
	}
	public String getTingjishijian() {
		return tingjishijian;
	}
	public void setTingjishijian(String tingjishijian) {
		this.tingjishijian = tingjishijian;
	}
	public String getTingjizhanghao() {
		return tingjizhanghao;
	}
	public void setTingjizhanghao(String tingjizhanghao) {
		this.tingjizhanghao = tingjizhanghao;
	}
	public String getTingjizhanghaoHidden() {
		return tingjizhanghaoHidden;
	}
	public void setTingjizhanghaoHidden(String tingjizhanghaoHidden) {
		this.tingjizhanghaoHidden = tingjizhanghaoHidden;
	}
	public String getTingjishijianHidden() {
		return tingjishijianHidden;
	}
	public void setTingjishijianHidden(String tingjishijianHidden) {
		this.tingjishijianHidden = tingjishijianHidden;
	}
	public String getCreatedt() {
		return createdt;
	}
	public void setCreatedt(String createdt) {
		this.createdt = createdt;
	}
	public String getShifouchenggong() {
		return shifouchenggong;
	}
	public void setShifouchenggong(String shifouchenggong) {
		this.shifouchenggong = shifouchenggong;
	}
	public String getShibaibianhao() {
		return shibaibianhao;
	}
	public void setShibaibianhao(String shibaibianhao) {
		this.shibaibianhao = shibaibianhao;
	}
	public String getShibaixinxi() {
		return shibaixinxi;
	}
	public void setShibaixinxi(String shibaixinxi) {
		this.shibaixinxi = shibaixinxi;
	}
	public String getShifouchenggongHidden() {
		return shifouchenggongHidden;
	}
	public void setShifouchenggongHidden(String shifouchenggongHidden) {
		this.shifouchenggongHidden = shifouchenggongHidden;
	}
	public String getServerip() {
		return serverip;
	}
	public void setServerip(String serverip) {
		this.serverip = serverip;
	}
	
}
