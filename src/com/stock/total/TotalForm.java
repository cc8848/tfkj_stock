/*
 * TianFang science corporation (c)2012 all rights reserved.
 * Description:  create TotalForm .
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-12-19   Li.Hai-Han(**)        Create
 */
package com.stock.total; 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

/**
 * Sava total bean.have getter and setter method.
 * 
 * @author Li.Hai-Han(**)
 */
public class TotalForm extends ActionForm implements Serializable {
	private static final long serialVersionUID = 8553936447853671062L;
	public void setHidden() {
		this.xiaoquHidden = this.xiaoqu;
		this.kaijisHidden =	this.kaijis;
		this.kaijieHidden = this.kaijie;
		this.shijianleixingHidden = this.shijianleixing;
		this.xiaoqutextHidden = this.xiaoqutext;
		this.shoufei1Hidden = this.shoufei1;
		this.shoufei2Hidden = this.shoufei2;
		this.shoufei3Hidden = this.shoufei3;
		this.gongzuoleibiehidden = this.gongzuoleibie;
		this.yunyingshanghidden = this.yunyingshang;
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	private List<CommonModule> shoufeiList = new ArrayList<CommonModule>();
	private List<CommonModule> stateList = new ArrayList<CommonModule>();
	private String xiaoqu;//用户小区
	private String xiaoquHidden="";//
	private String shoufei;
	private String shoufei1;
	private String shoufei1Hidden="";
	private String shoufei2;
	private String shoufei2Hidden="";
	private String shoufei3;
	private String shoufei3Hidden="";
	private String kaijis = "";
	private String kaijisHidden = "";
	private String kaijie = "";
	private String kaijieHidden = "";
	
	private String xiaoqutext = "";
	private String xiaoqutextHidden = "";
	
	private String stateCode = "";
	private String stateCodeHidden = "";

	private String pathA;
	private String pathB;
	private String anzhuangNum;
	private String weixiuNum;
	private String xufeiNum;
	private String tuidingNum;
	private String wideSize;
	private String heightSize;
	
	private String jiexianziNum;
	private String rj11Num;
	private String rj45Num;
	private String mokuaiNum;
	private String mianbanNum;
	private String wangxianNum;
	
	private String shigongren;
	private String yonghuzhuangtai;
	private String shijianleixing;
	private String shijianleixingHidden;
	
	private String gongzuoleibie;
	private String gongzuoleibiehidden;
	private String yunyingshang;
	private String yunyingshanghidden;	
	private List<CommonModule> gongzuoleibieList = new ArrayList<CommonModule>();
	private List<CommonModule> yunyingshangList = new ArrayList<CommonModule>();
	
	public String getShijianleixingHidden() {
		return shijianleixingHidden;
	}
	public void setShijianleixingHidden(String shijianleixingHidden) {
		this.shijianleixingHidden = shijianleixingHidden;
	}
	public String getKaijie() {
		return kaijie;
	}
	public void setKaijie(String kaijie) {
		this.kaijie = kaijie;
	}
	public String getKaijieHidden() {
		return kaijieHidden;
	}
	public void setKaijieHidden(String kaijieHidden) {
		this.kaijieHidden = kaijieHidden;
	}
	public String getShijianleixing() {
		return shijianleixing;
	}
	public void setShijianleixing(String shijianleixing) {
		this.shijianleixing = shijianleixing;
	}
	public String getXiaoqutext() {
		return xiaoqutext;
	}
	public void setXiaoqutext(String xiaoqutext) {
		this.xiaoqutext = xiaoqutext;
	}
	
	public String getXiaoqutextHidden() {
		return xiaoqutextHidden;
	}
	public void setXiaoqutextHidden(String xiaoqutextHidden) {
		this.xiaoqutextHidden = xiaoqutextHidden;
	}
	public String getShigongren() {
		return shigongren;
	}
	public void setShigongren(String shigongren) {
		this.shigongren = shigongren;
	}
	public String getYonghuzhuangtai() {
		return yonghuzhuangtai;
	}
	public void setYonghuzhuangtai(String yonghuzhuangtai) {
		this.yonghuzhuangtai = yonghuzhuangtai;
	}
	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}
	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}
	public String getShoufei() {
		return shoufei;
	}
	public void setShoufei(String shoufei) {
		this.shoufei = shoufei;
	}
	public List<CommonModule> getShoufeiList() {
		return shoufeiList;
	}
	public void setShoufeiList(List<CommonModule> shoufeiList) {
		this.shoufeiList = shoufeiList;
	}
	public List<CommonModule> getStateList() {
		return stateList;
	}
	public void setStateList(List<CommonModule> stateList) {
		this.stateList = stateList;
	}
	public String getXiaoqu() {
		return xiaoqu;
	}
	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}
	
	public String getXiaoquHidden() {
		return xiaoquHidden;
	}
	public void setXiaoquHidden(String xiaoquHidden) {
		this.xiaoquHidden = xiaoquHidden;
	}
	public String getKaijis() {
		return kaijis;
	}
	public void setKaijis(String kaijis) {
		this.kaijis = kaijis;
	}
	public String getKaijisHidden() {
		return kaijisHidden;
	}
	public void setKaijisHidden(String kaijisHidden) {
		this.kaijisHidden = kaijisHidden;
	}
	
	public String getShoufei1() {
		return shoufei1;
	}
	public void setShoufei1(String shoufei1) {
		this.shoufei1 = shoufei1;
	}
	public String getShoufei1Hidden() {
		return shoufei1Hidden;
	}
	public void setShoufei1Hidden(String shoufei1Hidden) {
		this.shoufei1Hidden = shoufei1Hidden;
	}
	public String getShoufei2() {
		return shoufei2;
	}
	public void setShoufei2(String shoufei2) {
		this.shoufei2 = shoufei2;
	}
	public String getShoufei2Hidden() {
		return shoufei2Hidden;
	}
	public void setShoufei2Hidden(String shoufei2Hidden) {
		this.shoufei2Hidden = shoufei2Hidden;
	}
	public String getShoufei3() {
		return shoufei3;
	}
	public void setShoufei3(String shoufei3) {
		this.shoufei3 = shoufei3;
	}
	public String getShoufei3Hidden() {
		return shoufei3Hidden;
	}
	public void setShoufei3Hidden(String shoufei3Hidden) {
		this.shoufei3Hidden = shoufei3Hidden;
	}
	public String getPathA() {
		return pathA;
	}
	public void setPathA(String pathA) {
		this.pathA = pathA;
	}
	public String getPathB() {
		return pathB;
	}
	public void setPathB(String pathB) {
		this.pathB = pathB;
	}
	public String getAnzhuangNum() {
		return anzhuangNum;
	}
	public void setAnzhuangNum(String anzhuangNum) {
		this.anzhuangNum = anzhuangNum;
	}
	public String getWeixiuNum() {
		return weixiuNum;
	}
	public void setWeixiuNum(String weixiuNum) {
		this.weixiuNum = weixiuNum;
	}
	public String getXufeiNum() {
		return xufeiNum;
	}
	public void setXufeiNum(String xufeiNum) {
		this.xufeiNum = xufeiNum;
	}
	public String getTuidingNum() {
		return tuidingNum;
	}
	public void setTuidingNum(String tuidingNum) {
		this.tuidingNum = tuidingNum;
	}
	public String getWideSize() {
		return wideSize;
	}
	public void setWideSize(String wideSize) {
		this.wideSize = wideSize;
	}
	public String getHeightSize() {
		return heightSize;
	}
	public void setHeightSize(String heightSize) {
		this.heightSize = heightSize;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateCodeHidden() {
		return stateCodeHidden;
	}
	public void setStateCodeHidden(String stateCodeHidden) {
		this.stateCodeHidden = stateCodeHidden;
	}
	public String getJiexianziNum() {
		return jiexianziNum;
	}
	public void setJiexianziNum(String jiexianziNum) {
		this.jiexianziNum = jiexianziNum;
	}
	public String getRj11Num() {
		return rj11Num;
	}
	public void setRj11Num(String rj11Num) {
		this.rj11Num = rj11Num;
	}
	public String getRj45Num() {
		return rj45Num;
	}
	public void setRj45Num(String rj45Num) {
		this.rj45Num = rj45Num;
	}
	public String getMokuaiNum() {
		return mokuaiNum;
	}
	public void setMokuaiNum(String mokuaiNum) {
		this.mokuaiNum = mokuaiNum;
	}
	public String getMianbanNum() {
		return mianbanNum;
	}
	public void setMianbanNum(String mianbanNum) {
		this.mianbanNum = mianbanNum;
	}
	public String getWangxianNum() {
		return wangxianNum;
	}
	public void setWangxianNum(String wangxianNum) {
		this.wangxianNum = wangxianNum;
	}
	public String getGongzuoleibie() {
		return gongzuoleibie;
	}
	public void setGongzuoleibie(String gongzuoleibie) {
		this.gongzuoleibie = gongzuoleibie;
	}
	public String getGongzuoleibiehidden() {
		return gongzuoleibiehidden;
	}
	public void setGongzuoleibiehidden(String gongzuoleibiehidden) {
		this.gongzuoleibiehidden = gongzuoleibiehidden;
	}
	public String getYunyingshang() {
		return yunyingshang;
	}
	public void setYunyingshang(String yunyingshang) {
		this.yunyingshang = yunyingshang;
	}
	public String getYunyingshanghidden() {
		return yunyingshanghidden;
	}
	public void setYunyingshanghidden(String yunyingshanghidden) {
		this.yunyingshanghidden = yunyingshanghidden;
	}
	public List<CommonModule> getGongzuoleibieList() {
		return gongzuoleibieList;
	}
	public void setGongzuoleibieList(List<CommonModule> gongzuoleibieList) {
		this.gongzuoleibieList = gongzuoleibieList;
	}
	public List<CommonModule> getYunyingshangList() {
		return yunyingshangList;
	}
	public void setYunyingshangList(List<CommonModule> yunyingshangList) {
		this.yunyingshangList = yunyingshangList;
	}
	
	
}

