package com.stock.paigongdan;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class PaiGongDanPreImportForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8340655817816771591L;

	//用户列表
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	
	private String UUID;
	
	private String[] UUIDS;
	
	//用户小区
	private String xiaoqu;
	
	//用户地址
	private String dizhi;
	
	//派工日期
	private String paigongriqis;
	
	//开机时间
	private String kaijishijian;
	
	//停机时间
	private String tingjishijian;
	
	//操作时间
	private String caozuoshijian;
	
	//业务类型
	private String yewutype;
	
	//备注
	private String beizhu;

	/**
	 * @return the 用户列表
	 */
	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	/**
	 * @param xiaoquList the 用户列表 to set
	 */
	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}

	/**
	 * @return the 用户小区
	 */
	public String getXiaoqu() {
		return xiaoqu;
	}

	/**
	 * @param xiaoqu the 用户小区 to set
	 */
	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}

	/**
	 * @return the 用户地址
	 */
	public String getDizhi() {
		return dizhi;
	}

	/**
	 * @param dizhi the 用户地址 to set
	 */
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	/**
	 * @return the 派工日期
	 */
	public String getPaigongriqis() {
		return paigongriqis;
	}

	/**
	 * @param paigongriqis the 派工日期 to set
	 */
	public void setPaigongriqis(String paigongriqis) {
		this.paigongriqis = paigongriqis;
	}

	/**
	 * @return the 开机时间
	 */
	public String getKaijishijian() {
		return kaijishijian;
	}

	/**
	 * @param kaijishijian the 开机时间 to set
	 */
	public void setKaijishijian(String kaijishijian) {
		this.kaijishijian = kaijishijian;
	}

	/**
	 * @return the 停机时间
	 */
	public String getTingjishijian() {
		return tingjishijian;
	}

	/**
	 * @param tingjishijian the 停机时间 to set
	 */
	public void setTingjishijian(String tingjishijian) {
		this.tingjishijian = tingjishijian;
	}

	/**
	 * @return the 业务类型
	 */
	public String getYewutype() {
		return yewutype;
	}

	/**
	 * @param yewutype the 业务类型 to set
	 */
	public void setYewutype(String yewutype) {
		this.yewutype = yewutype;
	}

	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @return the uUIDS
	 */
	public String[] getUUIDS() {
		return UUIDS;
	}

	/**
	 * @param uUIDS the uUIDS to set
	 */
	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
	}

	/**
	 * @return the caozuoshijian
	 */
	public String getCaozuoshijian() {
		return caozuoshijian;
	}

	/**
	 * @param caozuoshijian the caozuoshijian to set
	 */
	public void setCaozuoshijian(String caozuoshijian) {
		this.caozuoshijian = caozuoshijian;
	}

	/**
	 * @return the beizhu
	 */
	public String getBeizhu() {
		return beizhu;
	}

	/**
	 * @param beizhu the beizhu to set
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
}
