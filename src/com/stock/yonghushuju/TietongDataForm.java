/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data form class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Zhu.Xiao-Lei          Create
 */
package com.stock.yonghushuju;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

/**
 * User data form class.
 * 
 * @author Zhu.Xiao-Lei
 *
 */
public class TietongDataForm extends ActionForm {
	private static final long serialVersionUID = 3972147941842385814L;
	private String daochuriqiStart;
	private String yonghuleixing = "";
	private String dengluming= "";
	private String mima= "";	
	private String xingming= "";
	private String dizhi= "";
	private String lianxidianhua = "";
	private String zhuceri = "";
	private String daoqiri = "";
	private String jierufangshi = "";	
	private String yonghuguimo = "";
	private String zifeidaima = "";
	private String zifeimiaosu ="";
	private String yonghuzhuangtai ;
	private String xiaoqudaima = "";
	
	
	private String yufujine = "";
	private String yufuriqi ="";
	private String houfujine = "";
	private String houfuriqi = "";
	
	private String xiaoqumiaosu="";
	private String zhuangtaidaima="";
	private String beizhushuoming="";
	
	
	private String xianshidaikuan="";	
	private String shichang ="";
	private String zifei ="";
	private String yuejunfeiyong;
	private String shangxingdaikuan="";
	private String xiaxingdaikuan="";
	private String xiaoqu="";
	
	private String zhuangtai="";
	
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getXiaoqu() {
		return xiaoqu;
	}
	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}
	public String getYonghuleixing() {
		return yonghuleixing;
	}
	public void setYonghuleixing(String yonghuleixing) {
		this.yonghuleixing = yonghuleixing;
	}
	public String getDengluming() {
		return dengluming;
	}
	public void setDengluming(String dengluming) {
		this.dengluming = dengluming;
	}
	public String getMima() {
		return mima;
	}
	public void setMima(String mima) {
		this.mima = mima;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	public String getZhuceri() {
		return zhuceri;
	}
	public void setZhuceri(String zhuceri) {
		this.zhuceri = zhuceri;
	}
	public String getDaoqiri() {
		return daoqiri;
	}
	public void setDaoqiri(String daoqiri) {
		this.daoqiri = daoqiri;
	}
	public String getJierufangshi() {
		return jierufangshi;
	}
	public void setJierufangshi(String jierufangshi) {
		this.jierufangshi = jierufangshi;
	}
	public String getYonghuguimo() {
		return yonghuguimo;
	}
	public void setYonghuguimo(String yonghuguimo) {
		this.yonghuguimo = yonghuguimo;
	}
	public String getZifeidaima() {
		return zifeidaima;
	}
	public void setZifeidaima(String zifeidaima) {
		this.zifeidaima = zifeidaima;
	}
	public String getZifeimiaosu() {
		return zifeimiaosu;
	}
	public void setZifeimiaosu(String zifeimiaosu) {
		this.zifeimiaosu = zifeimiaosu;
	}
	public String getYonghuzhuangtai() {
		return yonghuzhuangtai;
	}
	public void setYonghuzhuangtai(String yonghuzhuangtai) {
		this.yonghuzhuangtai = yonghuzhuangtai;
	}
	public String getXiaoqudaima() {
		return xiaoqudaima;
	}
	public void setXiaoqudaima(String xiaoqudaima) {
		this.xiaoqudaima = xiaoqudaima;
	}
	public String getYufujine() {
		return yufujine;
	}
	public void setYufujine(String yufujine) {
		this.yufujine = yufujine;
	}
	public String getYufuriqi() {
		return yufuriqi;
	}
	public void setYufuriqi(String yufuriqi) {
		this.yufuriqi = yufuriqi;
	}
	public String getHoufujine() {
		return houfujine;
	}
	public void setHoufujine(String houfujine) {
		this.houfujine = houfujine;
	}
	public String getHoufuriqi() {
		return houfuriqi;
	}
	public void setHoufuriqi(String houfuriqi) {
		this.houfuriqi = houfuriqi;
	}
	public String getXiaoqumiaosu() {
		return xiaoqumiaosu;
	}
	public void setXiaoqumiaosu(String xiaoqumiaosu) {
		this.xiaoqumiaosu = xiaoqumiaosu;
	}
	public String getZhuangtaidaima() {
		return zhuangtaidaima;
	}
	public void setZhuangtaidaima(String zhuangtaidaima) {
		this.zhuangtaidaima = zhuangtaidaima;
	}
	public String getBeizhushuoming() {
		return beizhushuoming;
	}
	public void setBeizhushuoming(String beizhushuoming) {
		this.beizhushuoming = beizhushuoming;
	}
	public String getXianshidaikuan() {
		return xianshidaikuan;
	}
	public void setXianshidaikuan(String xianshidaikuan) {
		this.xianshidaikuan = xianshidaikuan;
	}
	public String getShichang() {
		return shichang;
	}
	public void setShichang(String shichang) {
		this.shichang = shichang;
	}
	public String getZifei() {
		return zifei;
	}
	public void setZifei(String zifei) {
		this.zifei = zifei;
	}
	public String getYuejunfeiyong() {
		return yuejunfeiyong;
	}
	public void setYuejunfeiyong(String yuejunfeiyong) {
		this.yuejunfeiyong = yuejunfeiyong;
	}
	public String getShangxingdaikuan() {
		return shangxingdaikuan;
	}
	public void setShangxingdaikuan(String shangxingdaikuan) {
		this.shangxingdaikuan = shangxingdaikuan;
	}
	public String getXiaxingdaikuan() {
		return xiaxingdaikuan;
	}
	public void setXiaxingdaikuan(String xiaxingdaikuan) {
		this.xiaxingdaikuan = xiaxingdaikuan;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDaochuriqiStart() {
		return daochuriqiStart;
	}
	public void setDaochuriqiStart(String daochuriqiStart) {
		this.daochuriqiStart = daochuriqiStart;
	}

}
