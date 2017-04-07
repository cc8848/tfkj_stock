package com.stock.huidan;

import org.apache.struts.action.ActionForm;

public class HuidanEntityForm extends ActionForm{
	private String xianghao;
	private String jidinghehao;
	
	private String kaijishijian;
	private String tingjishijian;
	//20141027billy新增有效时间存储功能
	private String youxiaoshijian;
	private String xiaoqu;
	private String dizhi;
	private String lianxidianhua;
	private String wangluo;
	private String dianshi;
	private String dianhua;
	private String yewu;
	private String fenguang;
	private String onuMAC;
	private String STB_MCID;
	private String dianshiIP;
	private String wangluoIP;
	private String dianhuaIP;
	private String dianhuaVLAN;
	private String wangluoVLAN;
	private String shangmenshijian;
	private String danzheng;
	private String suoxuandianhua;
	private String onuyj;
	private String jidingheyj;
	private String shoushifei;
	private String kuandaifei;
	private String chuzhuangfei;
	private String shebeixiaoshoufei;
	private String cailiaofei;
	private String yunyingshang;
	private String bzygf;
	private String nianfei;
	private String beizhu;
	
	private String yonghuzhuangtai;
	private String shoukuanshijian;
	private String zongshoufei;
	private String pipeizhuangtai;
	private String xingming;
	private String shenfenzheng;
	private String shoujuhao;
	private String fenguanxianhao;
	private String jiexuweizhi;
	private String shoujubenhao;
	private String kaipiaoxinxi;
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
	private String sxdhhm;
	
	private String UUID;
	private String UUIDHidden;
	
	private String zhuangtai;
	private String zhuangtaiHidden;
	
	private String yewutype;
	
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
	public String getOnuMAC() {
		return onuMAC;
	}
	public void setOnuMAC(String onuMAC) {
		this.onuMAC = onuMAC;
	}
	public String getSTB_MCID() {
		return STB_MCID;
	}
	public void setSTB_MCID(String sTB_MCID) {
		STB_MCID = sTB_MCID;
	}
	public String getDianshiIP() {
		return dianshiIP;
	}
	public void setDianshiIP(String dianshiIP) {
		this.dianshiIP = dianshiIP;
	}
	public String getWangluoIP() {
		return wangluoIP;
	}
	public void setWangluoIP(String wangluoIP) {
		this.wangluoIP = wangluoIP;
	}
	public String getDianhuaIP() {
		return dianhuaIP;
	}
	public void setDianhuaIP(String dianhuaIP) {
		this.dianhuaIP = dianhuaIP;
	}
	public String getDianhuaVLAN() {
		return dianhuaVLAN;
	}
	public void setDianhuaVLAN(String dianhuaVLAN) {
		this.dianhuaVLAN = dianhuaVLAN;
	}
	public String getWangluoVLAN() {
		return wangluoVLAN;
	}
	public void setWangluoVLAN(String wangluoVLAN) {
		this.wangluoVLAN = wangluoVLAN;
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
	public String getSuoxuandianhua() {
		return suoxuandianhua;
	}
	public void setSuoxuandianhua(String suoxuandianhua) {
		this.suoxuandianhua = suoxuandianhua;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
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
	public String getShebeixiaoshoufei() {
		return shebeixiaoshoufei;
	}
	public void setShebeixiaoshoufei(String shebeixiaoshoufei) {
		this.shebeixiaoshoufei = shebeixiaoshoufei;
	}
	public String getCailiaofei() {
		return cailiaofei;
	}
	public void setCailiaofei(String cailiaofei) {
		this.cailiaofei = cailiaofei;
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
	public String getYonghuzhuangtai() {
		return yonghuzhuangtai;
	}
	public void setYonghuzhuangtai(String yonghuzhuangtai) {
		this.yonghuzhuangtai = yonghuzhuangtai;
	}
	public String getShoukuanshijian() {
		return shoukuanshijian;
	}
	public void setShoukuanshijian(String shoukuanshijian) {
		this.shoukuanshijian = shoukuanshijian;
	}
	public String getZongshoufei() {
		return zongshoufei;
	}
	public void setZongshoufei(String zongshoufei) {
		this.zongshoufei = zongshoufei;
	}
	public String getPipeizhuangtai() {
		return pipeizhuangtai;
	}
	public void setPipeizhuangtai(String pipeizhuangtai) {
		this.pipeizhuangtai = pipeizhuangtai;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	public String getShoujuhao() {
		return shoujuhao;
	}
	public void setShoujuhao(String shoujuhao) {
		this.shoujuhao = shoujuhao;
	}
	public String getFenguanxianhao() {
		return fenguanxianhao;
	}
	public void setFenguanxianhao(String fenguanxianhao) {
		this.fenguanxianhao = fenguanxianhao;
	}
	public String getJiexuweizhi() {
		return jiexuweizhi;
	}
	public void setJiexuweizhi(String jiexuweizhi) {
		this.jiexuweizhi = jiexuweizhi;
	}
	public String getShoujubenhao() {
		return shoujubenhao;
	}
	public void setShoujubenhao(String shoujubenhao) {
		this.shoujubenhao = shoujubenhao;
	}
	public String getKaipiaoxinxi() {
		return kaipiaoxinxi;
	}
	public void setKaipiaoxinxi(String kaipiaoxinxi) {
		this.kaipiaoxinxi = kaipiaoxinxi;
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
	public String getSxdhhm() {
		return sxdhhm;
	}
	public void setSxdhhm(String sxdhhm) {
		this.sxdhhm = sxdhhm;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getUUIDHidden() {
		return UUIDHidden;
	}
	public void setUUIDHidden(String uUIDHidden) {
		UUIDHidden = uUIDHidden;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getZhuangtaiHidden() {
		return zhuangtaiHidden;
	}
	public void setZhuangtaiHidden(String zhuangtaiHidden) {
		this.zhuangtaiHidden = zhuangtaiHidden;
	}
	public String getXianghao() {
		return xianghao;
	}
	public void setXianghao(String xianghao) {
		this.xianghao = xianghao;
	}
	public String getJidinghehao() {
		return jidinghehao;
	}
	public void setJidinghehao(String jidinghehao) {
		this.jidinghehao = jidinghehao;
	}
	public String getYouxiaoshijian() {
		return youxiaoshijian;
	}
	public void setYouxiaoshijian(String youxiaoshijian) {
		this.youxiaoshijian = youxiaoshijian;
	}
	public String getYewutype() {
		return yewutype;
	}
	public void setYewutype(String yewutype) {
		this.yewutype = yewutype;
	}
	

}
