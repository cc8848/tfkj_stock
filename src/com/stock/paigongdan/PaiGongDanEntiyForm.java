package com.stock.paigongdan; 

import org.apache.struts.action.ActionForm;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 下午02:30:30 
 * 类说明 
 */
public class PaiGongDanEntiyForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8553936447853671062L;
	
	private String username;//用户姓名
	private String shenfenzheng;//身份证号
	
	
	private String[] TELUUIDS;//电话号码UUIDS
	
	private String tfkdczf;//tf宽带初装费
	private String tfkuandaifei;//tf宽带费
	private String tfiptvshoushifei;//tf收视费
	private String tfjidingheyajin;//tf机顶盒押金
	private String yuyingshang;//运营商
	private String qtbuzuyue;//不足月
	private String heji;//合计
	
	
	private String jiaohuanji;//交换机押金
	private String dxchuzhuangfei;//电信初装费
	private String telhaoma3;
	private String telhaoma4;
	
	
	private String fufeitype;
	
	
	private String UUID;
	private String[] UUIDS;
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
	
	
	private String paigongriqi;//派工日期
	
	
	private String anzhuangshijian;//安装时间 上午 下午 全天
	private String xiangmu;//项目  安装/维修
	private String tfkuandaidaikuan;//带宽
	private String tfkdnianxian;
	private String tfiptv;//数量
	private String tfiptvnianxian;
	private String qtye;//其他业务
	private String fufei;//年付
	private String telhaoma1;
	private String telhaoma2;
	private String dxfandan;
	private String zhengjian;
	private String shoushifei;
	private String nianfei;
	private String buzuyue;
	private String chuzhuangfei;
	private String kuaidaifei;
	private String shebeixiaoshou;
	private String cailiaofei;
	private String kaipiaoxinxi;
	private String shichangleixing;
	private String tfkuandaishichang;
	
	private String fenguang;
	private String selectCommunityPileID;
	private String selectCommunityPileID2;
	private String onumac;
	private String stbmcid;
	private String dianshiip;
	private String eqboxnum;
	private String eqboxnum2;
	
	private String bdfenguang;
	private String bdonumac;
	private String bdstbmcid;
	private String bddianshiip;
	
	private String yjfenguang;
	private String yjonumac;
	private String yjstbmcid;
	private String yjdianshiip;
	
	private String oldCPID;
	private String oldCPID2;
	
	private String isYiji;
	private String yichuxiaoqu;
	private String yichudizhi;
	private String yichuyewu;
	private String yichudianshi;
	private String yichuqita;
	private String yichutingjishijian;
	private String yichutingjishijiands;
	private String yichutingjishijianqt;
	
	private String isQiegai;
	private String qiegaidaikuan;
	private String qiegaitingjishijian;
	
	private String yewutype;
	
	private String biduikbn;
	private String fenguangID;
	
	private String beishuselect;
	private String kaijishijian;
	private String tingjishijian;
	private String busi;//业务状态
	
	private String wangluoip;
	private String dianhuaip;
	private String dianhuavlan;
	private String wangluovlan;
	
	private String tfsfyewu;
	
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

	public String getPaigongriqi() {
		return paigongriqi;
	}

	public void setPaigongriqi(String paigongriqi) {
		this.paigongriqi = paigongriqi;
	}

	public String getAnzhuangshijian() {
		return anzhuangshijian;
	}

	public void setAnzhuangshijian(String anzhuangshijian) {
		this.anzhuangshijian = anzhuangshijian;
	}

	public String getXiangmu() {
		return xiangmu;
	}

	public void setXiangmu(String xiangmu) {
		this.xiangmu = xiangmu;
	}

	public String getTfkuandaidaikuan() {
		return tfkuandaidaikuan;
	}

	public void setTfkuandaidaikuan(String tfkuandaidaikuan) {
		this.tfkuandaidaikuan = tfkuandaidaikuan;
	}

	public String getTfkdnianxian() {
		return tfkdnianxian;
	}

	public void setTfkdnianxian(String tfkdnianxian) {
		this.tfkdnianxian = tfkdnianxian;
	}

	public String getTfiptv() {
		return tfiptv;
	}

	public void setTfiptv(String tfiptv) {
		this.tfiptv = tfiptv;
	}

	public String getTfiptvnianxian() {
		return tfiptvnianxian;
	}

	public void setTfiptvnianxian(String tfiptvnianxian) {
		this.tfiptvnianxian = tfiptvnianxian;
	}

	public String getQtye() {
		return qtye;
	}

	public void setQtye(String qtye) {
		this.qtye = qtye;
	}

	public String getFufei() {
		return fufei;
	}

	public void setFufei(String fufei) {
		this.fufei = fufei;
	}

	public String getTelhaoma1() {
		return telhaoma1;
	}

	public void setTelhaoma1(String telhaoma1) {
		this.telhaoma1 = telhaoma1;
	}

	public String getTelhaoma2() {
		return telhaoma2;
	}

	public void setTelhaoma2(String telhaoma2) {
		this.telhaoma2 = telhaoma2;
	}

	public String getDxfandan() {
		return dxfandan;
	}

	public void setDxfandan(String dxfandan) {
		this.dxfandan = dxfandan;
	}

	public String getZhengjian() {
		return zhengjian;
	}

	public void setZhengjian(String zhengjian) {
		this.zhengjian = zhengjian;
	}

	public String getShoushifei() {
		return shoushifei;
	}

	public void setShoushifei(String shoushifei) {
		this.shoushifei = shoushifei;
	}

	public String getNianfei() {
		return nianfei;
	}

	public void setNianfei(String nianfei) {
		this.nianfei = nianfei;
	}

	public String getBuzuyue() {
		return buzuyue;
	}

	public void setBuzuyue(String buzuyue) {
		this.buzuyue = buzuyue;
	}

	public String getChuzhuangfei() {
		return chuzhuangfei;
	}

	public void setChuzhuangfei(String chuzhuangfei) {
		this.chuzhuangfei = chuzhuangfei;
	}

	public String getKuaidaifei() {
		return kuaidaifei;
	}

	public void setKuaidaifei(String kuaidaifei) {
		this.kuaidaifei = kuaidaifei;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String[] getTELUUIDS() {
		return TELUUIDS;
	}

	public void setTELUUIDS(String[] tELUUIDS) {
		TELUUIDS = tELUUIDS;
	}
	public String getFufeitype() {
		return fufeitype;
	}

	public void setFufeitype(String fufeitype) {
		this.fufeitype = fufeitype;
	}

	public String getTelhaoma3() {
		return telhaoma3;
	}

	public void setTelhaoma3(String telhaoma3) {
		this.telhaoma3 = telhaoma3;
	}

	public String getTelhaoma4() {
		return telhaoma4;
	}

	public void setTelhaoma4(String telhaoma4) {
		this.telhaoma4 = telhaoma4;
	}

	public String getDxchuzhuangfei() {
		return dxchuzhuangfei;
	}

	public void setDxchuzhuangfei(String dxchuzhuangfei) {
		this.dxchuzhuangfei = dxchuzhuangfei;
	}

	public String getJiaohuanji() {
		return jiaohuanji;
	}

	public void setJiaohuanji(String jiaohuanji) {
		this.jiaohuanji = jiaohuanji;
	}

	public String getHeji() {
		return heji;
	}

	public void setHeji(String heji) {
		this.heji = heji;
	}

	public String getTfkdczf() {
		return tfkdczf;
	}

	public void setTfkdczf(String tfkdczf) {
		this.tfkdczf = tfkdczf;
	}

	public String getTfkuandaifei() {
		return tfkuandaifei;
	}

	public void setTfkuandaifei(String tfkuandaifei) {
		this.tfkuandaifei = tfkuandaifei;
	}

	public String getTfiptvshoushifei() {
		return tfiptvshoushifei;
	}

	public void setTfiptvshoushifei(String tfiptvshoushifei) {
		this.tfiptvshoushifei = tfiptvshoushifei;
	}

	public String getTfjidingheyajin() {
		return tfjidingheyajin;
	}

	public void setTfjidingheyajin(String tfjidingheyajin) {
		this.tfjidingheyajin = tfjidingheyajin;
	}

	public String getYuyingshang() {
		return yuyingshang;
	}

	public void setYuyingshang(String yuyingshang) {
		this.yuyingshang = yuyingshang;
	}

	public String getQtbuzuyue() {
		return qtbuzuyue;
	}

	public void setQtbuzuyue(String qtbuzuyue) {
		this.qtbuzuyue = qtbuzuyue;
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

	public String getShichangleixing() {
		return shichangleixing;
	}

	public void setShichangleixing(String shichangleixing) {
		this.shichangleixing = shichangleixing;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTfkuandaishichang() {
		return tfkuandaishichang;
	}

	public void setTfkuandaishichang(String tfkuandaishichang) {
		this.tfkuandaishichang = tfkuandaishichang;
	}

	public String getShenfenzheng() {
	    return shenfenzheng;
	}

	public void setShenfenzheng(String shenfenzheng) {
	    this.shenfenzheng = shenfenzheng;
	}

	public String getFenguang() {
		return fenguang;
	}

	public void setFenguang(String fenguang) {
		this.fenguang = fenguang;
	}

	public String getSelectCommunityPileID() {
		return selectCommunityPileID;
	}

	public void setSelectCommunityPileID(String selectCommunityPileID) {
		this.selectCommunityPileID = selectCommunityPileID;
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

	public String getIsYiji() {
		return isYiji;
	}

	public void setIsYiji(String isYiji) {
		this.isYiji = isYiji;
	}

	public String getYichuxiaoqu() {
		return yichuxiaoqu;
	}

	public void setYichuxiaoqu(String yichuxiaoqu) {
		this.yichuxiaoqu = yichuxiaoqu;
	}

	public String getYichudizhi() {
		return yichudizhi;
	}

	public void setYichudizhi(String yichudizhi) {
		this.yichudizhi = yichudizhi;
	}

	public String getYichuyewu() {
		return yichuyewu;
	}

	public void setYichuyewu(String yichuyewu) {
		this.yichuyewu = yichuyewu;
	}

	public String getYewutype() {
		return yewutype;
	}

	public void setYewutype(String yewutype) {
		this.yewutype = yewutype;
	}

	/**
	 * @return the biduikbn
	 */
	public String getBiduikbn() {
		return biduikbn;
	}

	/**
	 * @param biduikbn the biduikbn to set
	 */
	public void setBiduikbn(String biduikbn) {
		this.biduikbn = biduikbn;
	}

	/**
	 * @return the bdfenguang
	 */
	public String getBdfenguang() {
		return bdfenguang;
	}

	/**
	 * @param bdfenguang the bdfenguang to set
	 */
	public void setBdfenguang(String bdfenguang) {
		this.bdfenguang = bdfenguang;
	}

	/**
	 * @return the bdonumac
	 */
	public String getBdonumac() {
		return bdonumac;
	}

	/**
	 * @param bdonumac the bdonumac to set
	 */
	public void setBdonumac(String bdonumac) {
		this.bdonumac = bdonumac;
	}

	/**
	 * @return the bdstbmcid
	 */
	public String getBdstbmcid() {
		return bdstbmcid;
	}

	/**
	 * @param bdstbmcid the bdstbmcid to set
	 */
	public void setBdstbmcid(String bdstbmcid) {
		this.bdstbmcid = bdstbmcid;
	}

	/**
	 * @return the bddianshiip
	 */
	public String getBddianshiip() {
		return bddianshiip;
	}

	/**
	 * @param bddianshiip the bddianshiip to set
	 */
	public void setBddianshiip(String bddianshiip) {
		this.bddianshiip = bddianshiip;
	}

	public String[] getUUIDS() {
		return UUIDS;
	}

	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
	}

	public String getFenguangID() {
		return fenguangID;
	}

	public void setFenguangID(String fenguangID) {
		this.fenguangID = fenguangID;
	}

	public String getIsQiegai() {
		return isQiegai;
	}

	public void setIsQiegai(String isQiegai) {
		this.isQiegai = isQiegai;
	}

	public String getQiegaidaikuan() {
		return qiegaidaikuan;
	}

	public void setQiegaidaikuan(String qiegaidaikuan) {
		this.qiegaidaikuan = qiegaidaikuan;
	}

	public String getQiegaitingjishijian() {
		return qiegaitingjishijian;
	}

	public void setQiegaitingjishijian(String qiegaitingjishijian) {
		this.qiegaitingjishijian = qiegaitingjishijian;
	}

	public String getYichudianshi() {
		return yichudianshi;
	}

	public void setYichudianshi(String yichudianshi) {
		this.yichudianshi = yichudianshi;
	}

	public String getYichutingjishijian() {
		return yichutingjishijian;
	}

	public void setYichutingjishijian(String yichutingjishijian) {
		this.yichutingjishijian = yichutingjishijian;
	}

	public String getYjfenguang() {
		return yjfenguang;
	}

	public void setYjfenguang(String yjfenguang) {
		this.yjfenguang = yjfenguang;
	}

	public String getYjonumac() {
		return yjonumac;
	}

	public void setYjonumac(String yjonumac) {
		this.yjonumac = yjonumac;
	}

	public String getYjstbmcid() {
		return yjstbmcid;
	}

	public void setYjstbmcid(String yjstbmcid) {
		this.yjstbmcid = yjstbmcid;
	}

	public String getYjdianshiip() {
		return yjdianshiip;
	}

	public void setYjdianshiip(String yjdianshiip) {
		this.yjdianshiip = yjdianshiip;
	}

	public String getYichutingjishijiands() {
		return yichutingjishijiands;
	}

	public void setYichutingjishijiands(String yichutingjishijiands) {
		this.yichutingjishijiands = yichutingjishijiands;
	}

	public String getYichuqita() {
		return yichuqita;
	}

	public void setYichuqita(String yichuqita) {
		this.yichuqita = yichuqita;
	}

	public String getYichutingjishijianqt() {
		return yichutingjishijianqt;
	}

	public void setYichutingjishijianqt(String yichutingjishijianqt) {
		this.yichutingjishijianqt = yichutingjishijianqt;
	}

	public String getBeishuselect() {
		return beishuselect;
	}

	public void setBeishuselect(String beishuselect) {
		this.beishuselect = beishuselect;
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

	public String getBusi() {
		return busi;
	}

	public void setBusi(String busi) {
		this.busi = busi;
	}

	/**
	 * @return the wangluoip
	 */
	public String getWangluoip() {
		return wangluoip;
	}

	/**
	 * @param wangluoip the wangluoip to set
	 */
	public void setWangluoip(String wangluoip) {
		this.wangluoip = wangluoip;
	}

	/**
	 * @return the dianhuaip
	 */
	public String getDianhuaip() {
		return dianhuaip;
	}

	/**
	 * @param dianhuaip the dianhuaip to set
	 */
	public void setDianhuaip(String dianhuaip) {
		this.dianhuaip = dianhuaip;
	}

	/**
	 * @return the dianhuavlan
	 */
	public String getDianhuavlan() {
		return dianhuavlan;
	}

	/**
	 * @param dianhuavlan the dianhuavlan to set
	 */
	public void setDianhuavlan(String dianhuavlan) {
		this.dianhuavlan = dianhuavlan;
	}

	/**
	 * @return the wangluovlan
	 */
	public String getWangluovlan() {
		return wangluovlan;
	}

	/**
	 * @param wangluovlan the wangluovlan to set
	 */
	public void setWangluovlan(String wangluovlan) {
		this.wangluovlan = wangluovlan;
	}

	/**
	 * @return the tfsfyewu
	 */
	public String getTfsfyewu() {
		return tfsfyewu;
	}

	/**
	 * @param tfsfyewu the tfsfyewu to set
	 */
	public void setTfsfyewu(String tfsfyewu) {
		this.tfsfyewu = tfsfyewu;
	}

}

