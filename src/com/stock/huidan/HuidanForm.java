package com.stock.huidan;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class HuidanForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setHidden(){
		this.quyuCodeHidden=this.quyuCode;
		this.telNoCodeHidden = this.telNoCode;
		this.stateCodeHidden = this.stateCode;
		this.addressCodeHidden = this.addressCode;
		this.userNameCodeHidden = this.userNameCode;
		this.onuCodeHidden = this.onuCode;
		this.mcidCodeHidden = this.mcidCode;
		this.tingjiDateHidden = this.tingjiDate;
		this.fenguangHidden = this.fenguang;
		this.shoujuhaoHidden = this.shoujuhao;
		this.kaijisHidden = this.kaijis;
		this.kaijieHidden = this.kaijie;
		this.tingjisHidden = this.tingjis;
		this.tingjieHidden = this.tingjie;
		this.userId = this.userId;
	
		this.sen1Hidden = this.sen1;
		this.senValue1Hidden = this.senValue1;
		this.sen2Hidden = this.sen2;
		this.senValue2Hidden = this.senValue2;
		this.sen3Hidden = this.sen3;
		this.senValue3Hidden = this.senValue3;
		this.shijianleixingHidden = this.shijianleixing;
		
	}
	private String xiaoqu;
	private String xiaoquHidden="";
	private String dizhi;
	private String dizhiHidden="";
	private String wangluo;
	private String wangluoHidden="";
	private String dianshi;
	private String dianshiHidden="";
	private String dianhua;
	private String dianhuaHidden="";
	private String yewu;
	private String yewuHidden="";
	private String dianshiip;
	private String dianshiipHidden="";
	private String wangluoip;
	private String wangluoipHidden="";
	private String dianhuaip;
	private String dianhuaipHidden="";
	private String dianhuavlan;
	private String dianhuavlanHidden="";
	private String wangluovlan;
	private String wangluovlanHidden="";
	private String shangmenshijian;
	private String shangmenshijianHidden="";
	private String danzheng;
	private String danzhengHidden="";
	private String sxdhhm;
	private String sxdhhmHidden="";
	private String onuyj;
	private String onuyjHidden="";
	private String jidingheyj;
	private String jidingheyjHidden="";
	private String shoushifei;
	private String shoushifeiHidden="";
	private String kuandaifei;
	private String kuandaifeiHidden="";
	private String chuzhuangfei;
	private String chuzhuangfeiHidden="";
	private String shebeixiaoshoufei;
	private String shebeixiaoshoufeiHidden="";
	private String cailiaofei;
	private String cailiaofeiHidden="";
	private String yunyingshang;
	private String yunyingshangHidden="";
	private String bzygf;
	private String bzygfHidden="";
	private String nianfei;
	private String nianfeiHidden="";
	private String beizhu;
	private String beizhuHidden="";
	private String beizhuhuizong;
	private String beizhuhuizongHidden="";
	private String yonghuzhuangtai;
	private String yonghuzhuangtaiHidden="";
	private String shigongren;
	private String shigongrenHidden="";
	private String xingming;
	private String xingmingHidden="";
	private String shenfenzheng;
	private String shenfenzhengHidden="";
	private String fenguangxianhao;
	private String fenguangxianhaoHidden="";
	private String jiexuweizhi;
	private String jiexuweizhiHidden="";
	private String zongshoufei;
	private String zongshoufeiHidden="";
	private String shoujubenhao;
	private String shoujubenhaoHidden="";
	private String kaipiaoxinxi;
	private String kaipiaoxinxiHidden="";
	private String qtsbsyqk;
	private String qtsbsyqkHidden="";
	private String qitahaocai;
	private String qitahaocaiHidden="";
	private String jiexianzi;
	private String jiexianziHidden="";
	private String rj11;
	private String rj11Hidden="";
	private String rj45;
	private String rj45Hidden="";
	private String mokuai;
	private String mokuaiHidden="";
	private String mianban;
	private String mianbanHidden="";
	private String wangxian;
	private String wangxianHidden="";
	private String xianchangbeizhu;
	private String xianchangbeizhuHidden="";
	private String tianxieren_tianxieshijian;
	private String youwuchuru;
	private String chayimiaoshu;
	private String kaipiaochaifen;
	private String pipeizhuangtai;
	private String kaipiaoshouju;
	private String feikaipiaoshouju;
	private String xiaoqu_cha;
	private String dizhi_cha;
	private String yonghuzhuangtai_cha;
	private String userId;
	
	
	public String getPipeizhuangtai() {
		return pipeizhuangtai;
	}
	public void setPipeizhuangtai(String pipeizhuangtai) {
		this.pipeizhuangtai = pipeizhuangtai;
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	private List<CommonModule> statusList = new ArrayList<CommonModule>();
	private List<CommonModule> senList    = new ArrayList<CommonModule>();
	private String UUID;
	private String UUIDHidden="";
	private String[] UUIDS;
	private String[] checks;
	private String quyuCode;
	private String quyuCodeHidden="";
	private String addressCode;	
	private String addressCodeHidden="";
	private String tingjiDate;
	private String tingjiDateHidden="";
	/*
	 * query not used.
	 */
	private String telNoCode;
	private String telNoCodeHidden="";
	private String userNameCode;	
	private String userNameCodeHidden="";
	private String onuCode;
	private String onuCodeHidden="";
	private String mcidCode;
	private String mcidCodeHidden = "";
	private String fenguang = "";
	private String fenguangHidden ="";
	private String shoujuhao = "";
	private String shoujuhaoHidden = "";
	private String stateCode;
	private String stateCodeHidden="";
	
	private String sen1;
	private String sen1Hidden="";
	private String senValue1;
	private String senValue1Hidden="";	
	private String sen2;
	private String sen2Hidden="";
	private String senValue2;
	private String senValue2Hidden="";
	private String sen3;
	private String sen3Hidden="";
	private String senValue3;
	private String senValue3Hidden="";
	
	private String shoukuanshijian ="";
	private String shoukuanshijianHidden = "";
	private String shoukuanshijian_b="";
	private String shoukuanshijian_e="";
	
	
	private String kaijis = "";
	private String kaijisHidden = "";
	private String kaijishijian_b="";
	private String kaijishijian_e="";
	
	private String kaijie = "";
	private String kaijieHidden = "";
	
	private String tingjis = "";
	private String tingjisHidden = "";
	private String tingjishijian_b="";
	private String tingjishijian_e="";
	
	private String tingjie = "";
	private String tingjieHidden = "";
	
	private String shijianleixing = "";
	private String shijianleixingHidden = "";
	
	private String zhuangtai = "";
	private String zhuangtaiHidden = "";
	
	//派工日期
	private String paigongriqi = "";
	//项目
	private String xiangmu = "";
	//已见电信返单
	private String dxfandan = "";
	//证件齐全
	private String zhengjian = "";
	private String biduikbn = "";
	private String fenguangID = "";
	private String shichangleixing = "";
	private String tfkuandaidaikuan = "";
	private String tfkdnianxian = "";
	private String beishuselect = "";
	private String tfkdczf = "";
	private String tfkuandaifei = "";
	private String tfkuandaishichang = "";
	private String tfiptv = "";
	private String tfiptvnianxian = "";
	private String qtye = "";
	private String selectCommunityPileID = "";
	private String selectCommunityPileID2 = "";
	private String eqboxnum = "";
	private String eqboxnum2 = "";
	private String bdfenguang = "";
	private String bdonumac = "";
	private String bdstbmcid = "";
	private String bddianshiip = "";
	private String telhaoma1 = "";
	private String telhaoma2 = "";
	private String telhaoma3 = "";
	private String telhaoma4 = "";
	//交换机
	private String jiaohuanji = "";
	//合计
	private String heji = "";
	//设备新状态
	private String eqsta = "";
	
	public String getKaipiaoshouju() {
		return kaipiaoshouju;
	}
	public void setKaipiaoshouju(String kaipiaoshouju) {
		this.kaipiaoshouju = kaipiaoshouju;
	}
	public String getFeikaipiaoshouju() {
		return feikaipiaoshouju;
	}
	public void setFeikaipiaoshouju(String feikaipiaoshouju) {
		this.feikaipiaoshouju = feikaipiaoshouju;
	}
	public String getTianxieren_tianxieshijian() {
		return tianxieren_tianxieshijian;
	}
	public void setTianxieren_tianxieshijian(String tianxieren_tianxieshijian) {
		this.tianxieren_tianxieshijian = tianxieren_tianxieshijian;
	}
	public String getYouwuchuru() {
		return youwuchuru;
	}
	public void setYouwuchuru(String youwuchuru) {
		this.youwuchuru = youwuchuru;
	}
	public String getChayimiaoshu() {
		return chayimiaoshu;
	}
	public void setChayimiaoshu(String chayimiaoshu) {
		this.chayimiaoshu = chayimiaoshu;
	}
	public String getKaipiaochaifen() {
		return kaipiaochaifen;
	}
	public void setKaipiaochaifen(String kaipiaochaifen) {
		this.kaipiaochaifen = kaipiaochaifen;
	}
	public String getShigongren() {
		return shigongren;
	}
	public void setShigongren(String shigongren) {
		this.shigongren = shigongren;
	}
	public String getShigongrenHidden() {
		return shigongrenHidden;
	}
	public void setShigongrenHidden(String shigongrenHidden) {
		this.shigongrenHidden = shigongrenHidden;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getXingmingHidden() {
		return xingmingHidden;
	}
	public void setXingmingHidden(String xingmingHidden) {
		this.xingmingHidden = xingmingHidden;
	}
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	public String getShenfenzhengHidden() {
		return shenfenzhengHidden;
	}
	public void setShenfenzhengHidden(String shenfenzhengHidden) {
		this.shenfenzhengHidden = shenfenzhengHidden;
	}
	public String getFenguangxianhao() {
		return fenguangxianhao;
	}
	public void setFenguangxianhao(String fenguangxianhao) {
		this.fenguangxianhao = fenguangxianhao;
	}
	public String getFenguangxianhaoHidden() {
		return fenguangxianhaoHidden;
	}
	public void setFenguangxianhaoHidden(String fenguangxianhaoHidden) {
		this.fenguangxianhaoHidden = fenguangxianhaoHidden;
	}
	public String getJiexuweizhi() {
		return jiexuweizhi;
	}
	public void setJiexuweizhi(String jiexuweizhi) {
		this.jiexuweizhi = jiexuweizhi;
	}
	public String getJiexuweizhiHidden() {
		return jiexuweizhiHidden;
	}
	public void setJiexuweizhiHidden(String jiexuweizhiHidden) {
		this.jiexuweizhiHidden = jiexuweizhiHidden;
	}
	public String getZongshoufei() {
		return zongshoufei;
	}
	public void setZongshoufei(String zongshoufei) {
		this.zongshoufei = zongshoufei;
	}
	public String getZongshoufeiHidden() {
		return zongshoufeiHidden;
	}
	public void setZongshoufeiHidden(String zongshoufeiHidden) {
		this.zongshoufeiHidden = zongshoufeiHidden;
	}
	public String getShoujubenhao() {
		return shoujubenhao;
	}
	public void setShoujubenhao(String shoujubenhao) {
		this.shoujubenhao = shoujubenhao;
	}
	public String getShoujubenhaoHidden() {
		return shoujubenhaoHidden;
	}
	public void setShoujubenhaoHidden(String shoujubenhaoHidden) {
		this.shoujubenhaoHidden = shoujubenhaoHidden;
	}
	public String getKaipiaoxinxi() {
		return kaipiaoxinxi;
	}
	public void setKaipiaoxinxi(String kaipiaoxinxi) {
		this.kaipiaoxinxi = kaipiaoxinxi;
	}
	public String getKaipiaoxinxiHidden() {
		return kaipiaoxinxiHidden;
	}
	public void setKaipiaoxinxiHidden(String kaipiaoxinxiHidden) {
		this.kaipiaoxinxiHidden = kaipiaoxinxiHidden;
	}
	public String getQtsbsyqk() {
		return qtsbsyqk;
	}
	public void setQtsbsyqk(String qtsbsyqk) {
		this.qtsbsyqk = qtsbsyqk;
	}
	public String getQtsbsyqkHidden() {
		return qtsbsyqkHidden;
	}
	public void setQtsbsyqkHidden(String qtsbsyqkHidden) {
		this.qtsbsyqkHidden = qtsbsyqkHidden;
	}
	public String getQitahaocai() {
		return qitahaocai;
	}
	public void setQitahaocai(String qitahaocai) {
		this.qitahaocai = qitahaocai;
	}
	public String getQitahaocaiHidden() {
		return qitahaocaiHidden;
	}
	public void setQitahaocaiHidden(String qitahaocaiHidden) {
		this.qitahaocaiHidden = qitahaocaiHidden;
	}
	public String getJiexianzi() {
		return jiexianzi;
	}
	public void setJiexianzi(String jiexianzi) {
		this.jiexianzi = jiexianzi;
	}
	public String getJiexianziHidden() {
		return jiexianziHidden;
	}
	public void setJiexianziHidden(String jiexianziHidden) {
		this.jiexianziHidden = jiexianziHidden;
	}
	public String getRj11() {
		return rj11;
	}
	public void setRj11(String rj11) {
		this.rj11 = rj11;
	}
	public String getRj11Hidden() {
		return rj11Hidden;
	}
	public void setRj11Hidden(String rj11Hidden) {
		this.rj11Hidden = rj11Hidden;
	}
	public String getRj45() {
		return rj45;
	}
	public void setRj45(String rj45) {
		this.rj45 = rj45;
	}
	public String getRj45Hidden() {
		return rj45Hidden;
	}
	public void setRj45Hidden(String rj45Hidden) {
		this.rj45Hidden = rj45Hidden;
	}
	public String getMokuai() {
		return mokuai;
	}
	public void setMokuai(String mokuai) {
		this.mokuai = mokuai;
	}
	public String getMokuaiHidden() {
		return mokuaiHidden;
	}
	public void setMokuaiHidden(String mokuaiHidden) {
		this.mokuaiHidden = mokuaiHidden;
	}
	public String getMianban() {
		return mianban;
	}
	public void setMianban(String mianban) {
		this.mianban = mianban;
	}
	public String getMianbanHidden() {
		return mianbanHidden;
	}
	public void setMianbanHidden(String mianbanHidden) {
		this.mianbanHidden = mianbanHidden;
	}
	public String getWangxian() {
		return wangxian;
	}
	public void setWangxian(String wangxian) {
		this.wangxian = wangxian;
	}
	public String getWangxianHidden() {
		return wangxianHidden;
	}
	public void setWangxianHidden(String wangxianHidden) {
		this.wangxianHidden = wangxianHidden;
	}
	public String getXianchangbeizhu() {
		return xianchangbeizhu;
	}
	public void setXianchangbeizhu(String xianchangbeizhu) {
		this.xianchangbeizhu = xianchangbeizhu;
	}
	public String getXianchangbeizhuHidden() {
		return xianchangbeizhuHidden;
	}
	public void setXianchangbeizhuHidden(String xianchangbeizhuHidden) {
		this.xianchangbeizhuHidden = xianchangbeizhuHidden;
	}
	public String getYonghuzhuangtai() {
		return yonghuzhuangtai;
	}
	public void setYonghuzhuangtai(String yonghuzhuangtai) {
		this.yonghuzhuangtai = yonghuzhuangtai;
	}
	public String getYonghuzhuangtaiHidden() {
		return yonghuzhuangtaiHidden;
	}
	public void setYonghuzhuangtaiHidden(String yonghuzhuangtaiHidden) {
		this.yonghuzhuangtaiHidden = yonghuzhuangtaiHidden;
	}
	public String getShoukuanshijian() {
		return shoukuanshijian;
	}
	public void setShoukuanshijian(String shoukuanshijian) {
		this.shoukuanshijian = shoukuanshijian;
	}
	public String getShoukuanshijianHidden() {
		return shoukuanshijianHidden;
	}
	public void setShoukuanshijianHidden(String shoukuanshijianHidden) {
		this.shoukuanshijianHidden = shoukuanshijianHidden;
	}
	public String getShoukuanshijian_b() {
		return shoukuanshijian_b;
	}
	public void setShoukuanshijian_b(String shoukuanshijian_b) {
		this.shoukuanshijian_b = shoukuanshijian_b;
	}
	public String getShoukuanshijian_e() {
		return shoukuanshijian_e;
	}
	public void setShoukuanshijian_e(String shoukuanshijian_e) {
		this.shoukuanshijian_e = shoukuanshijian_e;
	}
	public String getKaijishijian_b() {
		return kaijishijian_b;
	}
	public void setKaijishijian_b(String kaijishijian_b) {
		this.kaijishijian_b = kaijishijian_b;
	}
	public String getKaijishijian_e() {
		return kaijishijian_e;
	}
	public void setKaijishijian_e(String kaijishijian_e) {
		this.kaijishijian_e = kaijishijian_e;
	}
	public String getTingjishijian_b() {
		return tingjishijian_b;
	}
	public void setTingjishijian_b(String tingjishijian_b) {
		this.tingjishijian_b = tingjishijian_b;
	}
	public String getTingjishijian_e() {
		return tingjishijian_e;
	}
	public void setTingjishijian_e(String tingjishijian_e) {
		this.tingjishijian_e = tingjishijian_e;
	}
	public String getUUIDHidden() {
		return UUIDHidden;
	}
	public void setUUIDHidden(String uUIDHidden) {
		UUIDHidden = uUIDHidden;
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
	public String[] getUUIDS() {
		return UUIDS;
	}
	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
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
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public String getAddressCodeHidden() {
		return addressCodeHidden;
	}
	public void setAddressCodeHidden(String addressCodeHidden) {
		this.addressCodeHidden = addressCodeHidden;
	}
	public String getTingjiDate() {
		return tingjiDate;
	}
	public void setTingjiDate(String tingjiDate) {
		this.tingjiDate = tingjiDate;
	}
	public String getTingjiDateHidden() {
		return tingjiDateHidden;
	}
	public void setTingjiDateHidden(String tingjiDateHidden) {
		this.tingjiDateHidden = tingjiDateHidden;
	}
	public String getTelNoCode() {
		return telNoCode;
	}
	public void setTelNoCode(String telNoCode) {
		this.telNoCode = telNoCode;
	}
	public String getTelNoCodeHidden() {
		return telNoCodeHidden;
	}
	public void setTelNoCodeHidden(String telNoCodeHidden) {
		this.telNoCodeHidden = telNoCodeHidden;
	}
	public String getUserNameCode() {
		return userNameCode;
	}
	public void setUserNameCode(String userNameCode) {
		this.userNameCode = userNameCode;
	}
	public String getUserNameCodeHidden() {
		return userNameCodeHidden;
	}
	public void setUserNameCodeHidden(String userNameCodeHidden) {
		this.userNameCodeHidden = userNameCodeHidden;
	}
	public String getOnuCode() {
		return onuCode;
	}
	public void setOnuCode(String onuCode) {
		this.onuCode = onuCode;
	}
	public String getOnuCodeHidden() {
		return onuCodeHidden;
	}
	public void setOnuCodeHidden(String onuCodeHidden) {
		this.onuCodeHidden = onuCodeHidden;
	}
	public String getMcidCode() {
		return mcidCode;
	}
	public void setMcidCode(String mcidCode) {
		this.mcidCode = mcidCode;
	}
	public String getMcidCodeHidden() {
		return mcidCodeHidden;
	}
	public void setMcidCodeHidden(String mcidCodeHidden) {
		this.mcidCodeHidden = mcidCodeHidden;
	}
	public String getFenguang() {
		return fenguang;
	}
	public void setFenguang(String fenguang) {
		this.fenguang = fenguang;
	}
	public String getFenguangHidden() {
		return fenguangHidden;
	}
	public void setFenguangHidden(String fenguangHidden) {
		this.fenguangHidden = fenguangHidden;
	}
	public String getShoujuhao() {
		return shoujuhao;
	}
	public void setShoujuhao(String shoujuhao) {
		this.shoujuhao = shoujuhao;
	}
	public String getShoujuhaoHidden() {
		return shoujuhaoHidden;
	}
	public void setShoujuhaoHidden(String shoujuhaoHidden) {
		this.shoujuhaoHidden = shoujuhaoHidden;
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
	public String getSen1() {
		return sen1;
	}
	public void setSen1(String sen1) {
		this.sen1 = sen1;
	}
	public String getSen1Hidden() {
		return sen1Hidden;
	}
	public void setSen1Hidden(String sen1Hidden) {
		this.sen1Hidden = sen1Hidden;
	}
	public String getSenValue1() {
		return senValue1;
	}
	public void setSenValue1(String senValue1) {
		this.senValue1 = senValue1;
	}
	public String getSenValue1Hidden() {
		return senValue1Hidden;
	}
	public void setSenValue1Hidden(String senValue1Hidden) {
		this.senValue1Hidden = senValue1Hidden;
	}
	public String getSen2() {
		return sen2;
	}
	public void setSen2(String sen2) {
		this.sen2 = sen2;
	}
	public String getSen2Hidden() {
		return sen2Hidden;
	}
	public void setSen2Hidden(String sen2Hidden) {
		this.sen2Hidden = sen2Hidden;
	}
	public String getSenValue2() {
		return senValue2;
	}
	public void setSenValue2(String senValue2) {
		this.senValue2 = senValue2;
	}
	public String getSenValue2Hidden() {
		return senValue2Hidden;
	}
	public void setSenValue2Hidden(String senValue2Hidden) {
		this.senValue2Hidden = senValue2Hidden;
	}
	public String getSen3() {
		return sen3;
	}
	public void setSen3(String sen3) {
		this.sen3 = sen3;
	}
	public String getSen3Hidden() {
		return sen3Hidden;
	}
	public void setSen3Hidden(String sen3Hidden) {
		this.sen3Hidden = sen3Hidden;
	}
	public String getSenValue3() {
		return senValue3;
	}
	public void setSenValue3(String senValue3) {
		this.senValue3 = senValue3;
	}
	public String getSenValue3Hidden() {
		return senValue3Hidden;
	}
	public void setSenValue3Hidden(String senValue3Hidden) {
		this.senValue3Hidden = senValue3Hidden;
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
	public String getTingjis() {
		return tingjis;
	}
	public void setTingjis(String tingjis) {
		this.tingjis = tingjis;
	}
	public String getTingjisHidden() {
		return tingjisHidden;
	}
	public void setTingjisHidden(String tingjisHidden) {
		this.tingjisHidden = tingjisHidden;
	}
	public String getTingjie() {
		return tingjie;
	}
	public void setTingjie(String tingjie) {
		this.tingjie = tingjie;
	}
	public String getTingjieHidden() {
		return tingjieHidden;
	}
	public void setTingjieHidden(String tingjieHidden) {
		this.tingjieHidden = tingjieHidden;
	}
	public String getShijianleixing() {
		return shijianleixing;
	}
	public void setShijianleixing(String shijianleixing) {
		this.shijianleixing = shijianleixing;
	}
	public String getShijianleixingHidden() {
		return shijianleixingHidden;
	}
	public void setShijianleixingHidden(String shijianleixingHidden) {
		this.shijianleixingHidden = shijianleixingHidden;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getDizhiHidden() {
		return dizhiHidden;
	}
	public void setDizhiHidden(String dizhiHidden) {
		this.dizhiHidden = dizhiHidden;
	}
	public String getWangluo() {
		return wangluo;
	}
	public void setWangluo(String wangluo) {
		this.wangluo = wangluo;
	}
	public String getWangluoHidden() {
		return wangluoHidden;
	}
	public void setWangluoHidden(String wangluoHidden) {
		this.wangluoHidden = wangluoHidden;
	}
	public String getDianshi() {
		return dianshi;
	}
	public void setDianshi(String dianshi) {
		this.dianshi = dianshi;
	}
	public String getDianshiHidden() {
		return dianshiHidden;
	}
	public void setDianshiHidden(String dianshiHidden) {
		this.dianshiHidden = dianshiHidden;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	public String getDianhuaHidden() {
		return dianhuaHidden;
	}
	public void setDianhuaHidden(String dianhuaHidden) {
		this.dianhuaHidden = dianhuaHidden;
	}
	public String getYewu() {
		return yewu;
	}
	public void setYewu(String yewu) {
		this.yewu = yewu;
	}
	public String getYewuHidden() {
		return yewuHidden;
	}
	public void setYewuHidden(String yewuHidden) {
		this.yewuHidden = yewuHidden;
	}
	public String getDianshiip() {
		return dianshiip;
	}
	public void setDianshiip(String dianshiip) {
		this.dianshiip = dianshiip;
	}
	public String getDianshiipHidden() {
		return dianshiipHidden;
	}
	public void setDianshiipHidden(String dianshiipHidden) {
		this.dianshiipHidden = dianshiipHidden;
	}
	public String getWangluoip() {
		return wangluoip;
	}
	public void setWangluoip(String wangluoip) {
		this.wangluoip = wangluoip;
	}
	public String getWangluoipHidden() {
		return wangluoipHidden;
	}
	public void setWangluoipHidden(String wangluoipHidden) {
		this.wangluoipHidden = wangluoipHidden;
	}
	public String getDianhuaip() {
		return dianhuaip;
	}
	public void setDianhuaip(String dianhuaip) {
		this.dianhuaip = dianhuaip;
	}
	public String getDianhuaipHidden() {
		return dianhuaipHidden;
	}
	public void setDianhuaipHidden(String dianhuaipHidden) {
		this.dianhuaipHidden = dianhuaipHidden;
	}
	public String getDianhuavlan() {
		return dianhuavlan;
	}
	public void setDianhuavlan(String dianhuavlan) {
		this.dianhuavlan = dianhuavlan;
	}
	public String getDianhuavlanHidden() {
		return dianhuavlanHidden;
	}
	public void setDianhuavlanHidden(String dianhuavlanHidden) {
		this.dianhuavlanHidden = dianhuavlanHidden;
	}
	public String getWangluovlan() {
		return wangluovlan;
	}
	public void setWangluovlan(String wangluovlan) {
		this.wangluovlan = wangluovlan;
	}
	public String getWangluovlanHidden() {
		return wangluovlanHidden;
	}
	public void setWangluovlanHidden(String wangluovlanHidden) {
		this.wangluovlanHidden = wangluovlanHidden;
	}
	public String getShangmenshijian() {
		return shangmenshijian;
	}
	public void setShangmenshijian(String shangmenshijian) {
		this.shangmenshijian = shangmenshijian;
	}
	public String getShangmenshijianHidden() {
		return shangmenshijianHidden;
	}
	public void setShangmenshijianHidden(String shangmenshijianHidden) {
		this.shangmenshijianHidden = shangmenshijianHidden;
	}
	public String getDanzheng() {
		return danzheng;
	}
	public void setDanzheng(String danzheng) {
		this.danzheng = danzheng;
	}
	public String getDanzhengHidden() {
		return danzhengHidden;
	}
	public void setDanzhengHidden(String danzhengHidden) {
		this.danzhengHidden = danzhengHidden;
	}
	public String getSxdhhm() {
		return sxdhhm;
	}
	public void setSxdhhm(String sxdhhm) {
		this.sxdhhm = sxdhhm;
	}
	public String getSxdhhmHidden() {
		return sxdhhmHidden;
	}
	public void setSxdhhmHidden(String sxdhhmHidden) {
		this.sxdhhmHidden = sxdhhmHidden;
	}
	public String getOnuyj() {
		return onuyj;
	}
	public void setOnuyj(String onuyj) {
		this.onuyj = onuyj;
	}
	public String getOnuyjHidden() {
		return onuyjHidden;
	}
	public void setOnuyjHidden(String onuyjHidden) {
		this.onuyjHidden = onuyjHidden;
	}
	public String getJidingheyj() {
		return jidingheyj;
	}
	public void setJidingheyj(String jidingheyj) {
		this.jidingheyj = jidingheyj;
	}
	public String getJidingheyjHidden() {
		return jidingheyjHidden;
	}
	public void setJidingheyjHidden(String jidingheyjHidden) {
		this.jidingheyjHidden = jidingheyjHidden;
	}
	public String getShoushifei() {
		return shoushifei;
	}
	public void setShoushifei(String shoushifei) {
		this.shoushifei = shoushifei;
	}
	public String getShoushifeiHidden() {
		return shoushifeiHidden;
	}
	public void setShoushifeiHidden(String shoushifeiHidden) {
		this.shoushifeiHidden = shoushifeiHidden;
	}
	public String getKuandaifei() {
		return kuandaifei;
	}
	public void setKuandaifei(String kuandaifei) {
		this.kuandaifei = kuandaifei;
	}
	public String getKuandaifeiHidden() {
		return kuandaifeiHidden;
	}
	public void setKuandaifeiHidden(String kuandaifeiHidden) {
		this.kuandaifeiHidden = kuandaifeiHidden;
	}
	public String getChuzhuangfei() {
		return chuzhuangfei;
	}
	public void setChuzhuangfei(String chuzhuangfei) {
		this.chuzhuangfei = chuzhuangfei;
	}
	public String getChuzhuangfeiHidden() {
		return chuzhuangfeiHidden;
	}
	public void setChuzhuangfeiHidden(String chuzhuangfeiHidden) {
		this.chuzhuangfeiHidden = chuzhuangfeiHidden;
	}
	public String getShebeixiaoshoufei() {
		return shebeixiaoshoufei;
	}
	public void setShebeixiaoshoufei(String shebeixiaoshoufei) {
		this.shebeixiaoshoufei = shebeixiaoshoufei;
	}
	public String getShebeixiaoshoufeiHidden() {
		return shebeixiaoshoufeiHidden;
	}
	public void setShebeixiaoshoufeiHidden(String shebeixiaoshoufeiHidden) {
		this.shebeixiaoshoufeiHidden = shebeixiaoshoufeiHidden;
	}
	public String getCailiaofei() {
		return cailiaofei;
	}
	public void setCailiaofei(String cailiaofei) {
		this.cailiaofei = cailiaofei;
	}
	public String getCailiaofeiHidden() {
		return cailiaofeiHidden;
	}
	public void setCailiaofeiHidden(String cailiaofeiHidden) {
		this.cailiaofeiHidden = cailiaofeiHidden;
	}
	public String getYunyingshang() {
		return yunyingshang;
	}
	public void setYunyingshang(String yunyingshang) {
		this.yunyingshang = yunyingshang;
	}
	public String getYunyingshangHidden() {
		return yunyingshangHidden;
	}
	public void setYunyingshangHidden(String yunyingshangHidden) {
		this.yunyingshangHidden = yunyingshangHidden;
	}
	public String getBzygf() {
		return bzygf;
	}
	public void setBzygf(String bzygf) {
		this.bzygf = bzygf;
	}
	public String getBzygfHidden() {
		return bzygfHidden;
	}
	public void setBzygfHidden(String bzygfHidden) {
		this.bzygfHidden = bzygfHidden;
	}
	public String getNianfei() {
		return nianfei;
	}
	public void setNianfei(String nianfei) {
		this.nianfei = nianfei;
	}
	public String getNianfeiHidden() {
		return nianfeiHidden;
	}
	public void setNianfeiHidden(String nianfeiHidden) {
		this.nianfeiHidden = nianfeiHidden;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getBeizhuHidden() {
		return beizhuHidden;
	}
	public void setBeizhuHidden(String beizhuHidden) {
		this.beizhuHidden = beizhuHidden;
	}
	public String getBeizhuhuizong() {
		return beizhuhuizong;
	}
	public void setBeizhuhuizong(String beizhuhuizong) {
		this.beizhuhuizong = beizhuhuizong;
	}
	public String getBeizhuhuizongHidden() {
		return beizhuhuizongHidden;
	}
	public void setBeizhuhuizongHidden(String beizhuhuizongHidden) {
		this.beizhuhuizongHidden = beizhuhuizongHidden;
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
	public String getXiaoqu_cha() {
		return xiaoqu_cha;
	}
	public void setXiaoqu_cha(String xiaoqu_cha) {
		this.xiaoqu_cha = xiaoqu_cha;
	}
	public String getDizhi_cha() {
		return dizhi_cha;
	}
	public void setDizhi_cha(String dizhi_cha) {
		this.dizhi_cha = dizhi_cha;
	}
	public String getYonghuzhuangtai_cha() {
		return yonghuzhuangtai_cha;
	}
	public void setYonghuzhuangtai_cha(String yonghuzhuangtai_cha) {
		this.yonghuzhuangtai_cha = yonghuzhuangtai_cha;
	}
	public String[] getChecks() {
		return checks;
	}
	public void setChecks(String[] checks) {
		this.checks = checks;
	}
	public String getUserId() {
	    return userId;
	}
	public void setUserId(String userId) {
	    this.userId = userId;
	}
	/**
	 * @return the paigongriqi
	 */
	public String getPaigongriqi() {
		return paigongriqi;
	}
	/**
	 * @param paigongriqi the paigongriqi to set
	 */
	public void setPaigongriqi(String paigongriqi) {
		this.paigongriqi = paigongriqi;
	}
	/**
	 * @return the xiangmu
	 */
	public String getXiangmu() {
		return xiangmu;
	}
	/**
	 * @param xiangmu the xiangmu to set
	 */
	public void setXiangmu(String xiangmu) {
		this.xiangmu = xiangmu;
	}
	/**
	 * @return the dxfandan
	 */
	public String getDxfandan() {
		return dxfandan;
	}
	/**
	 * @param dxfandan the dxfandan to set
	 */
	public void setDxfandan(String dxfandan) {
		this.dxfandan = dxfandan;
	}
	/**
	 * @return the zhengjian
	 */
	public String getZhengjian() {
		return zhengjian;
	}
	/**
	 * @param zhengjian the zhengjian to set
	 */
	public void setZhengjian(String zhengjian) {
		this.zhengjian = zhengjian;
	}
	/**
	 * @return the fenguangID
	 */
	public String getFenguangID() {
		return fenguangID;
	}
	/**
	 * @param fenguangID the fenguangID to set
	 */
	public void setFenguangID(String fenguangID) {
		this.fenguangID = fenguangID;
	}
	/**
	 * @return the shichangleixing
	 */
	public String getShichangleixing() {
		return shichangleixing;
	}
	/**
	 * @param shichangleixing the shichangleixing to set
	 */
	public void setShichangleixing(String shichangleixing) {
		this.shichangleixing = shichangleixing;
	}
	/**
	 * @return the tfkuandaidaikuan
	 */
	public String getTfkuandaidaikuan() {
		return tfkuandaidaikuan;
	}
	/**
	 * @param tfkuandaidaikuan the tfkuandaidaikuan to set
	 */
	public void setTfkuandaidaikuan(String tfkuandaidaikuan) {
		this.tfkuandaidaikuan = tfkuandaidaikuan;
	}
	/**
	 * @return the tfkdnianxian
	 */
	public String getTfkdnianxian() {
		return tfkdnianxian;
	}
	/**
	 * @param tfkdnianxian the tfkdnianxian to set
	 */
	public void setTfkdnianxian(String tfkdnianxian) {
		this.tfkdnianxian = tfkdnianxian;
	}
	/**
	 * @return the beishuselect
	 */
	public String getBeishuselect() {
		return beishuselect;
	}
	/**
	 * @param beishuselect the beishuselect to set
	 */
	public void setBeishuselect(String beishuselect) {
		this.beishuselect = beishuselect;
	}
	/**
	 * @return the tfkdczf
	 */
	public String getTfkdczf() {
		return tfkdczf;
	}
	/**
	 * @param tfkdczf the tfkdczf to set
	 */
	public void setTfkdczf(String tfkdczf) {
		this.tfkdczf = tfkdczf;
	}
	/**
	 * @return the tfkuandaifei
	 */
	public String getTfkuandaifei() {
		return tfkuandaifei;
	}
	/**
	 * @param tfkuandaifei the tfkuandaifei to set
	 */
	public void setTfkuandaifei(String tfkuandaifei) {
		this.tfkuandaifei = tfkuandaifei;
	}
	/**
	 * @return the tfkuandaishichang
	 */
	public String getTfkuandaishichang() {
		return tfkuandaishichang;
	}
	/**
	 * @param tfkuandaishichang the tfkuandaishichang to set
	 */
	public void setTfkuandaishichang(String tfkuandaishichang) {
		this.tfkuandaishichang = tfkuandaishichang;
	}
	/**
	 * @return the tfiptv
	 */
	public String getTfiptv() {
		return tfiptv;
	}
	/**
	 * @param tfiptv the tfiptv to set
	 */
	public void setTfiptv(String tfiptv) {
		this.tfiptv = tfiptv;
	}
	/**
	 * @return the tfiptvnianxian
	 */
	public String getTfiptvnianxian() {
		return tfiptvnianxian;
	}
	/**
	 * @param tfiptvnianxian the tfiptvnianxian to set
	 */
	public void setTfiptvnianxian(String tfiptvnianxian) {
		this.tfiptvnianxian = tfiptvnianxian;
	}
	/**
	 * @return the qtye
	 */
	public String getQtye() {
		return qtye;
	}
	/**
	 * @param qtye the qtye to set
	 */
	public void setQtye(String qtye) {
		this.qtye = qtye;
	}
	/**
	 * @return the selectCommunityPileID
	 */
	public String getSelectCommunityPileID() {
		return selectCommunityPileID;
	}
	/**
	 * @param selectCommunityPileID the selectCommunityPileID to set
	 */
	public void setSelectCommunityPileID(String selectCommunityPileID) {
		this.selectCommunityPileID = selectCommunityPileID;
	}
	/**
	 * @return the selectCommunityPileID2
	 */
	public String getSelectCommunityPileID2() {
		return selectCommunityPileID2;
	}
	/**
	 * @param selectCommunityPileID2 the selectCommunityPileID2 to set
	 */
	public void setSelectCommunityPileID2(String selectCommunityPileID2) {
		this.selectCommunityPileID2 = selectCommunityPileID2;
	}
	/**
	 * @return the eqboxnum
	 */
	public String getEqboxnum() {
		return eqboxnum;
	}
	/**
	 * @param eqboxnum the eqboxnum to set
	 */
	public void setEqboxnum(String eqboxnum) {
		this.eqboxnum = eqboxnum;
	}
	/**
	 * @return the eqboxnum2
	 */
	public String getEqboxnum2() {
		return eqboxnum2;
	}
	/**
	 * @param eqboxnum2 the eqboxnum2 to set
	 */
	public void setEqboxnum2(String eqboxnum2) {
		this.eqboxnum2 = eqboxnum2;
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
	/**
	 * @return the telhaoma1
	 */
	public String getTelhaoma1() {
		return telhaoma1;
	}
	/**
	 * @param telhaoma1 the telhaoma1 to set
	 */
	public void setTelhaoma1(String telhaoma1) {
		this.telhaoma1 = telhaoma1;
	}
	/**
	 * @return the telhaoma2
	 */
	public String getTelhaoma2() {
		return telhaoma2;
	}
	/**
	 * @param telhaoma2 the telhaoma2 to set
	 */
	public void setTelhaoma2(String telhaoma2) {
		this.telhaoma2 = telhaoma2;
	}
	/**
	 * @return the telhaoma3
	 */
	public String getTelhaoma3() {
		return telhaoma3;
	}
	/**
	 * @param telhaoma3 the telhaoma3 to set
	 */
	public void setTelhaoma3(String telhaoma3) {
		this.telhaoma3 = telhaoma3;
	}
	/**
	 * @return the telhaoma4
	 */
	public String getTelhaoma4() {
		return telhaoma4;
	}
	/**
	 * @param telhaoma4 the telhaoma4 to set
	 */
	public void setTelhaoma4(String telhaoma4) {
		this.telhaoma4 = telhaoma4;
	}
	/**
	 * @return the jiaohuanji
	 */
	public String getJiaohuanji() {
		return jiaohuanji;
	}
	/**
	 * @param jiaohuanji the jiaohuanji to set
	 */
	public void setJiaohuanji(String jiaohuanji) {
		this.jiaohuanji = jiaohuanji;
	}
	/**
	 * @return the heji
	 */
	public String getHeji() {
		return heji;
	}
	/**
	 * @param heji the heji to set
	 */
	public void setHeji(String heji) {
		this.heji = heji;
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
	 * @return the eqsta
	 */
	public String getEqsta() {
		return eqsta;
	}
	/**
	 * @param eqsta the eqsta to set
	 */
	public void setEqsta(String eqsta) {
		this.eqsta = eqsta;
	}
	
	
}
