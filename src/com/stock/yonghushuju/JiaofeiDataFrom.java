package com.stock.yonghushuju;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class JiaofeiDataFrom  extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String UUID;
	private String yonghuzhuangtai;
	private String xingming;
	private String shenfensheng;
	private String shoujuhao;
	private String fenguangxianhao;
	private String jiexuweizhi;
	private String kaijishijian;
	private String tingjishijian;
	private String xiaoqu;
	private String [] UUIDS;
	private String dizhi;
	private String lianxidianhua;
	private String wangluo;
	private String dianshi;
	private String dianhua;
	private String yewu;
	private String fenguang;
	private String onumac;
	private String stbmcid;
	private String dianshiip;
	private String wangluoip;
	private String dianhuaip;
	private String dianhuavlan;
	private String wangluovlan;
	private String shangmenshijian;
	private String danzheng;
	private String sxdhhm;
	private String onuyj;
	private String jidingheyj;
	private String shoushifei;
	private String kuandaifei;
	private String chuzhuangfei;
	private String yunyingshang;
	private String bzygf;
	private String nianfei;
	private String beizhu;
	private String zongshoufei;
	private String shoujubenhao;
	private String qtsbsyqk;
	private String qitahaocai;
	private String jiexianzi;
	private String rj11;
	private String rj45;
	private String mokuai;
	private String mianban;
	private String wangxian;
	private String shigongren;
	private String xianchangbeizhu;
	private String beizhuhuizong;
	private String cteatedt;
	private String cteateby;
	private String nowdata;
	private String nowdataHidden;
	private String zhongkuandai;
	private String shebeixiaoshou;
	private String cailiaofei;
	private String kaipiaoxinxi;
	private String shoukuanshijian;
	private String weixiushijian;
	private String weixiuneirong;
	private String shichang;
	private String shichangRadius;
	private String weixiuleixing;
	private String shichangtv;
	private String yewushijian;
	
	private String selectCommunityPileID;
	private String eqboxnum;
	private String selectCommunityPileID2;
	private String eqboxnum2;
	
	private String oldCPID;
	private String oldCPID2;
	
	private String accountInfo;
	
	private String fenguangID;
	
	private String beishuselect;
	private String beishutype;
	
	public String getShichangRadius() {
		return shichangRadius;
	}
	public void setShichangRadius(String shichangRadius) {
		this.shichangRadius = shichangRadius;
	}
	public String getShichang() {
		return shichang;
	}
	public void setShichang(String shichang) {
		this.shichang = shichang;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String[] getUUIDS() {
		return UUIDS;
	}
	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
	}
	public String getWeixiuneirong() {
		return weixiuneirong;
	}
	public void setWeixiuneirong(String weixiuneirong) {
		this.weixiuneirong = weixiuneirong;
	}
	public String getWeixiushijian() {
		return weixiushijian;
	}
	public void setWeixiushijian(String weixiushijian) {
		this.weixiushijian = weixiushijian;
	}
	public String getShoukuanshijian() {
		return shoukuanshijian;
	}
	public void setShoukuanshijian(String shoukuanshijian) {
		this.shoukuanshijian = shoukuanshijian;
	}
	public String getZhongkuandai() {
		return zhongkuandai;
	}
	public void setZhongkuandai(String zhongkuandai) {
		this.zhongkuandai = zhongkuandai;
	}
	public String getNowdataHidden() {
		return nowdataHidden;
	}
	public void setNowdataHidden(String nowdataHidden) {
		this.nowdataHidden = nowdataHidden;
	}
	public String getNowdata() {
		return nowdata;
	}
	public void setNowdata(String nowdata) {
		this.nowdata = nowdata;
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	private List<CommonModule> shichangList = new ArrayList<CommonModule>();
	private List<CommonModule> wangluoList = new ArrayList<CommonModule>();
	private List<CommonModule> shichangtvList = new ArrayList<CommonModule>();
	public List<CommonModule> getWangluoList() {
		return wangluoList;
	}
	public void setWangluoList(List<CommonModule> wangluoList) {
		this.wangluoList = wangluoList;
	}
	public List<CommonModule> getShichangList() {
		return shichangList;
	}
	public void setShichangList(List<CommonModule> shichangList) {
		this.shichangList = shichangList;
	}
	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}
	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}
	public List<CommonModule> getShichangtvList() {
		return shichangtvList;
	}
	public void setShichangtvList(List<CommonModule> shichangtvList) {
		this.shichangtvList = shichangtvList;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getYonghuzhuangtai() {
		return yonghuzhuangtai;
	}
	public void setYonghuzhuangtai(String yonghuzhuangtai) {
		this.yonghuzhuangtai = yonghuzhuangtai;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getShenfensheng() {
		return shenfensheng;
	}
	public void setShenfensheng(String shenfensheng) {
		this.shenfensheng = shenfensheng;
	}
	public String getShoujuhao() {
		return shoujuhao;
	}
	public void setShoujuhao(String shoujuhao) {
		this.shoujuhao = shoujuhao;
	}
	public String getFenguangxianhao() {
		return fenguangxianhao;
	}
	public void setFenguangxianhao(String fenguangxianhao) {
		this.fenguangxianhao = fenguangxianhao;
	}
	public String getJiexuweizhi() {
		return jiexuweizhi;
	}
	public void setJiexuweizhi(String jiexuweizhi) {
		this.jiexuweizhi = jiexuweizhi;
	}
	public String getKaijishijian() {
		return kaijishijian;
	}
	public void setKaijishijian(String kaijishijian) {
		this.kaijishijian = kaijishijian;
	}
	public String getTingjishijian() {
		return tingjishijian;
	}
	public void setTingjishijian(String tingjishijian) {
		this.tingjishijian = tingjishijian;
	}
	public String getXiaoqu() {
		return xiaoqu;
	}
	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
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
	public String getWangluo() {
		return wangluo;
	}
	public void setWangluo(String wangluo) {
		this.wangluo = wangluo;
	}
	public String getDianshi() {
		return dianshi;
	}
	public void setDianshi(String dianshi) {
		this.dianshi = dianshi;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	public String getYewu() {
		return yewu;
	}
	public void setYewu(String yewu) {
		this.yewu = yewu;
	}
	public String getFenguang() {
		return fenguang;
	}
	public void setFenguang(String fenguang) {
		this.fenguang = fenguang;
	}
	public String getOnumac() {
		return onumac;
	}
	public void setOnumac(String onumac) {
		this.onumac = onumac;
	}
	public String getStbmcid() {
		return stbmcid;
	}
	public void setStbmcid(String stbmcid) {
		this.stbmcid = stbmcid;
	}
	public String getDianshiip() {
		return dianshiip;
	}
	public void setDianshiip(String dianshiip) {
		this.dianshiip = dianshiip;
	}
	public String getWangluoip() {
		return wangluoip;
	}
	public void setWangluoip(String wangluoip) {
		this.wangluoip = wangluoip;
	}
	public String getDianhuaip() {
		return dianhuaip;
	}
	public void setDianhuaip(String dianhuaip) {
		this.dianhuaip = dianhuaip;
	}
	public String getDianhuavlan() {
		return dianhuavlan;
	}
	public void setDianhuavlan(String dianhuavlan) {
		this.dianhuavlan = dianhuavlan;
	}
	public String getWangluovlan() {
		return wangluovlan;
	}
	public void setWangluovlan(String wangluovlan) {
		this.wangluovlan = wangluovlan;
	}
	public String getShangmenshijian() {
		return shangmenshijian;
	}
	public void setShangmenshijian(String shangmenshijian) {
		this.shangmenshijian = shangmenshijian;
	}
	public String getDanzheng() {
		return danzheng;
	}
	public void setDanzheng(String danzheng) {
		this.danzheng = danzheng;
	}
	public String getSxdhhm() {
		return sxdhhm;
	}
	public void setSxdhhm(String sxdhhm) {
		this.sxdhhm = sxdhhm;
	}
	public String getOnuyj() {
		return onuyj;
	}
	public void setOnuyj(String onuyj) {
		this.onuyj = onuyj;
	}
	public String getJidingheyj() {
		return jidingheyj;
	}
	public void setJidingheyj(String jidingheyj) {
		this.jidingheyj = jidingheyj;
	}
	public String getShoushifei() {
		return shoushifei;
	}
	public void setShoushifei(String shoushifei) {
		this.shoushifei = shoushifei;
	}
	public String getKuandaifei() {
		return kuandaifei;
	}
	public void setKuandaifei(String kuandaifei) {
		this.kuandaifei = kuandaifei;
	}
	public String getChuzhuangfei() {
		return chuzhuangfei;
	}
	public void setChuzhuangfei(String chuzhuangfei) {
		this.chuzhuangfei = chuzhuangfei;
	}
	public String getYunyingshang() {
		return yunyingshang;
	}
	public void setYunyingshang(String yunyingshang) {
		this.yunyingshang = yunyingshang;
	}
	public String getBzygf() {
		return bzygf;
	}
	public void setBzygf(String bzygf) {
		this.bzygf = bzygf;
	}
	public String getNianfei() {
		return nianfei;
	}
	public void setNianfei(String nianfei) {
		this.nianfei = nianfei;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getZongshoufei() {
		return zongshoufei;
	}
	public void setZongshoufei(String zongshoufei) {
		this.zongshoufei = zongshoufei;
	}
	public String getShoujubenhao() {
		return shoujubenhao;
	}
	public void setShoujubenhao(String shoujubenhao) {
		this.shoujubenhao = shoujubenhao;
	}
	public String getQtsbsyqk() {
		return qtsbsyqk;
	}
	public void setQtsbsyqk(String qtsbsyqk) {
		this.qtsbsyqk = qtsbsyqk;
	}
	public String getQitahaocai() {
		return qitahaocai;
	}
	public void setQitahaocai(String qitahaocai) {
		this.qitahaocai = qitahaocai;
	}
	public String getJiexianzi() {
		return jiexianzi;
	}
	public void setJiexianzi(String jiexianzi) {
		this.jiexianzi = jiexianzi;
	}
	public String getRj11() {
		return rj11;
	}
	public void setRj11(String rj11) {
		this.rj11 = rj11;
	}
	public String getRj45() {
		return rj45;
	}
	public void setRj45(String rj45) {
		this.rj45 = rj45;
	}
	public String getMokuai() {
		return mokuai;
	}
	public void setMokuai(String mokuai) {
		this.mokuai = mokuai;
	}
	public String getMianban() {
		return mianban;
	}
	public void setMianban(String mianban) {
		this.mianban = mianban;
	}
	public String getWangxian() {
		return wangxian;
	}
	public void setWangxian(String wangxian) {
		this.wangxian = wangxian;
	}
	public String getShigongren() {
		return shigongren;
	}
	public void setShigongren(String shigongren) {
		this.shigongren = shigongren;
	}
	public String getXianchangbeizhu() {
		return xianchangbeizhu;
	}
	public void setXianchangbeizhu(String xianchangbeizhu) {
		this.xianchangbeizhu = xianchangbeizhu;
	}
	public String getBeizhuhuizong() {
		return beizhuhuizong;
	}
	public void setBeizhuhuizong(String beizhuhuizong) {
		this.beizhuhuizong = beizhuhuizong;
	}
	public String getCteatedt() {
		return cteatedt;
	}
	public void setCteatedt(String cteatedt) {
		this.cteatedt = cteatedt;
	}
	public String getCteateby() {
		return cteateby;
	}
	public void setCteateby(String cteateby) {
		this.cteateby = cteateby;
	}
	public String getShebeixiaoshou() {
		return shebeixiaoshou;
	}
	public void setShebeixiaoshou(String shebeixiaoshou) {
		this.shebeixiaoshou = shebeixiaoshou;
	}
	public String getCailiaofei() {
		return cailiaofei;
	}
	public void setCailiaofei(String cailiaofei) {
		this.cailiaofei = cailiaofei;
	}
	public String getKaipiaoxinxi() {
		return kaipiaoxinxi;
	}
	public void setKaipiaoxinxi(String kaipiaoxinxi) {
		this.kaipiaoxinxi = kaipiaoxinxi;
	}
	public String getWeixiuleixing() {
		return weixiuleixing;
	}
	public void setWeixiuleixing(String weixiuleixing) {
		this.weixiuleixing = weixiuleixing;
	}
	public String getShichangtv() {
		return shichangtv;
	}
	public void setShichangtv(String shichangtv) {
		this.shichangtv = shichangtv;
	}
	public String getYewushijian() {
		return yewushijian;
	}
	public void setYewushijian(String yewushijian) {
		this.yewushijian = yewushijian;
	}
	public String getSelectCommunityPileID() {
		return selectCommunityPileID;
	}
	public void setSelectCommunityPileID(String selectCommunityPileID) {
		this.selectCommunityPileID = selectCommunityPileID;
	}
	public String getEqboxnum() {
		return eqboxnum;
	}
	public void setEqboxnum(String eqboxnum) {
		this.eqboxnum = eqboxnum;
	}
	public String getSelectCommunityPileID2() {
		return selectCommunityPileID2;
	}
	public void setSelectCommunityPileID2(String selectCommunityPileID2) {
		this.selectCommunityPileID2 = selectCommunityPileID2;
	}
	public String getEqboxnum2() {
		return eqboxnum2;
	}
	public void setEqboxnum2(String eqboxnum2) {
		this.eqboxnum2 = eqboxnum2;
	}
	public String getOldCPID() {
		return oldCPID;
	}
	public void setOldCPID(String oldCPID) {
		this.oldCPID = oldCPID;
	}
	public String getOldCPID2() {
		return oldCPID2;
	}
	public void setOldCPID2(String oldCPID2) {
		this.oldCPID2 = oldCPID2;
	}
	public String getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(String accountInfo) {
		this.accountInfo = accountInfo;
	}
	public String getFenguangID() {
		return fenguangID;
	}
	public void setFenguangID(String fenguangID) {
		this.fenguangID = fenguangID;
	}
	public String getBeishuselect() {
		return beishuselect;
	}
	public void setBeishuselect(String beishuselect) {
		this.beishuselect = beishuselect;
	}
	public String getBeishutype() {
		return beishutype;
	}
	public void setBeishutype(String beishutype) {
		this.beishutype = beishutype;
	}

}
