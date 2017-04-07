package com.stock.caiwuhedui.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;


public class ZhangMuForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void setHidden(){
		this.quyuCodeHidden=this.quyuCode;
		//this.telNoCodeHidden = this.telNoCode;
		this.stateCodeHidden = this.stateCode;
		this.addressCodeHidden = this.addressCode;
		//this.userNameCodeHidden = this.userNameCode;
		this.sen1Hidden = this.sen1;
		this.senValue1Hidden = this.senValue1;
		this.sen2Hidden = this.sen2;
		this.senValue2Hidden = this.senValue2;
		this.sen3Hidden = this.sen3;
		this.senValue3Hidden = this.senValue3;


		this.sen4Hidden = this.sen4;
		this.senValue4Hidden = this.senValue4;
		this.sen5Hidden = this.sen5;
		this.senValue5Hidden = this.senValue5;
		this.sen6Hidden = this.sen6;
		this.senValue6Hidden = this.senValue6;




		this.zmUUIDHidden = this.zmUUID;




		this.UUIDHidden = this.UUID;
		this.zhifuleixingHidden = this.zhifuleixing;
		
		this.kaijisHidden = this.kaijis;
		this.kaijieHidden = this.kaijie;
		this.tingjisHidden = this.tingjis;
		this.tingjieHidden = this.tingjie;
		this.cunkuanshijiansHidden = this.cunkuanshijians;
		this.cunkuanshijianeHidden = this.cunkuanshijiane;
		
		this.shijianleixingHidden = this.shijianleixing;
		this.UUIDSHidden1 = this.UUIDS;
		
		this.heduiHidden = this.hedui;
		this.zmidHidden = this.zmid;


		this.xiaoquHidden=this.xiaoqu;
		this.dizhiHidden=this.dizhi;
		this.shoujuhaoHidden=this.shoujuhao;
	}
	private String zmid;
	private String zmidHidden;
	private String UUID;
	private String zmUUID;
	private String UUIDHidden;
	private String zmUUIDHidden;
	private String [] UUIDS;
	private String [] zmUUIDS;
	private String [] UUIDSHidden1;
	private String UUIDSHidden;
	private String zhuangtai;
	private String cunkuanren;
	private String cunkuanshijian;
	private String cunkuanyinhang;
	private String wangdianhao;
	private String cunkuanjine;
	private String xinxishuliang;
	private String zongshoufeiheji;
	private String chazhi;
	private String zhifuleixing;
	private String yihedui;
	private String zongshoufeiHidden;
	private String zhifuleixingHidden;
	
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	private List<CommonModule> statusList = new ArrayList<CommonModule>();
	private List<CommonModule> senList = new ArrayList<CommonModule>();
	private String quyuCode;
	private String quyuCodeHidden="";
	private String addressCode;	
	private String addressCodeHidden="";
	private String kaijis = "";
	private String kaijisHidden = "";
	private String tingjis = "";
	private String tingjisHidden = "";
	private String stateCode;
	private String stateCodeHidden="";
	private String sen1;
	private String sen1Hidden="";
	private String senValue1;
	private String senValue1Hidden="";	
	private String zhangmuUUIDHidden="";	
	
	private String hedui="";	
	private String heduiHidden="";


	private String xiaoqu;
	private String dizhi;
	private String shoujuhao;
	private String xiaoquHidden;
	private String dizhiHidden;
	private String shoujuhaoHidden;

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

	public String getShoujuhao() {
		return shoujuhao;
	}

	public void setShoujuhao(String shoujuhao) {
		this.shoujuhao = shoujuhao;
	}

	public String getXiaoquHidden() {
		return xiaoquHidden;
	}

	public void setXiaoquHidden(String xiaoquHidden) {
		this.xiaoquHidden = xiaoquHidden;
	}

	public String getDizhiHidden() {
		return dizhiHidden;
	}

	public void setDizhiHidden(String dizhiHidden) {
		this.dizhiHidden = dizhiHidden;
	}

	public String getShoujuhaoHidden() {
		return shoujuhaoHidden;
	}

	public void setShoujuhaoHidden(String shoujuhaoHidden) {
		this.shoujuhaoHidden = shoujuhaoHidden;
	}

	public String getSen4() {
		return sen4;
	}

	public void setSen4(String sen4) {
		this.sen4 = sen4;
	}

	public String getSen4Hidden() {
		return sen4Hidden;
	}

	public void setSen4Hidden(String sen4Hidden) {
		this.sen4Hidden = sen4Hidden;
	}

	public String getSenValue4() {
		return senValue4;
	}

	public void setSenValue4(String senValue4) {
		this.senValue4 = senValue4;
	}

	public String getSenValue4Hidden() {
		return senValue4Hidden;
	}

	public void setSenValue4Hidden(String senValue4Hidden) {
		this.senValue4Hidden = senValue4Hidden;
	}

	public String getSen5() {
		return sen5;
	}

	public void setSen5(String sen5) {
		this.sen5 = sen5;
	}

	public String getSen5Hidden() {
		return sen5Hidden;
	}

	public void setSen5Hidden(String sen5Hidden) {
		this.sen5Hidden = sen5Hidden;
	}

	public String getSenValue5() {
		return senValue5;
	}

	public void setSenValue5(String senValue5) {
		this.senValue5 = senValue5;
	}

	public String getSenValue5Hidden() {
		return senValue5Hidden;
	}

	public void setSenValue5Hidden(String senValue5Hidden) {
		this.senValue5Hidden = senValue5Hidden;
	}

	public String getSen6() {
		return sen6;
	}

	public void setSen6(String sen6) {
		this.sen6 = sen6;
	}

	public String getSen6Hidden() {
		return sen6Hidden;
	}

	public void setSen6Hidden(String sen6Hidden) {
		this.sen6Hidden = sen6Hidden;
	}

	public String getSenValue6() {
		return senValue6;
	}

	public void setSenValue6(String senValue6) {
		this.senValue6 = senValue6;
	}

	public String getSenValue6Hidden() {
		return senValue6Hidden;
	}

	public void setSenValue6Hidden(String senValue6Hidden) {
		this.senValue6Hidden = senValue6Hidden;
	}

	public String getZmid() {
		return zmid;
	}
	public void setZmid(String zmid) {
		this.zmid = zmid;
	}
	public String getZmidHidden() {
		return zmidHidden;
	}
	public void setZmidHidden(String zmidHidden) {
		this.zmidHidden = zmidHidden;
	}

	private String sen2;
	private String sen2Hidden="";
	private String senValue2;
	private String senValue2Hidden="";
	private String sen3;
	private String sen3Hidden="";
	private String senValue3;
	private String senValue3Hidden="";


	private String sen4;
	private String sen4Hidden="";
	private String senValue4;
	private String senValue4Hidden="";
	private String sen5;
	private String sen5Hidden="";
	private String senValue5;
	private String senValue5Hidden="";
	private String sen6;
	private String sen6Hidden="";
	private String senValue6;
	private String senValue6Hidden="";





	private String kaijie = "";
	private String kaijieHidden = "";
	private String tingjie = "";
	private String tingjieHidden = "";
	private String shijianleixing = "";
	private String shijianleixingHidden = "";

	private String cunkuanshijians = "";
	private String cunkuanshijiansHidden = "";
	private String cunkuanshijiane = "";
	private String cunkuanshijianeHidden = "";
	
	
	
	public String[] getUUIDSHidden1() {
		return UUIDSHidden1;
	}
	public void setUUIDSHidden1(String[] uUIDSHidden1) {
		UUIDSHidden1 = uUIDSHidden1;
	}
	public String getShijianleixingHidden() {
		return shijianleixingHidden;
	}
	public void setShijianleixingHidden(String shijianleixingHidden) {
		this.shijianleixingHidden = shijianleixingHidden;
	}
	public String getCunkuanshijiansHidden() {
		return cunkuanshijiansHidden;
	}
	public void setCunkuanshijiansHidden(String cunkuanshijiansHidden) {
		this.cunkuanshijiansHidden = cunkuanshijiansHidden;
	}
	public String getCunkuanshijianeHidden() {
		return cunkuanshijianeHidden;
	}
	public void setCunkuanshijianeHidden(String cunkuanshijianeHidden) {
		this.cunkuanshijianeHidden = cunkuanshijianeHidden;
	}
	public String getCunkuanshijians() {
		return cunkuanshijians;
	}
	public void setCunkuanshijians(String cunkuanshijians) {
		this.cunkuanshijians = cunkuanshijians;
	}
	public String getCunkuanshijiane() {
		return cunkuanshijiane;
	}
	public void setCunkuanshijiane(String cunkuanshijiane) {
		this.cunkuanshijiane = cunkuanshijiane;
	}
	public String getShijianleixing() {
		return shijianleixing;
	}
	public void setShijianleixing(String shijianleixing) {
		this.shijianleixing = shijianleixing;
	}
	public String getUUIDSHidden() {
		return UUIDSHidden;
	}
	public void setUUIDSHidden(String uUIDSHidden) {
		UUIDSHidden = uUIDSHidden;
	}
	public String getHeduiHidden() {
		return heduiHidden;
	}
	public void setHeduiHidden(String heduiHidden) {
		this.heduiHidden = heduiHidden;
	}
	public String getHedui() {
		return hedui;
	}
	public void setHedui(String hedui) {
		this.hedui = hedui;
	}
	public String getZmUUID() {
		return zmUUID;
	}
	public void setZmUUID(String zmUUID) {
		this.zmUUID = zmUUID;
	}
	public String getZmUUIDHidden() {
		return zmUUIDHidden;
	}
	public void setZmUUIDHidden(String zmUUIDHidden) {
		this.zmUUIDHidden = zmUUIDHidden;
	}
	public String getUUIDHidden() {
		return UUIDHidden;
	}
	public void setUUIDHidden(String uUIDHidden) {
		UUIDHidden = uUIDHidden;
	}
	public String getZongshoufeiHidden() {
		return zongshoufeiHidden;
	}
	public void setZongshoufeiHidden(String zongshoufeiHidden) {
		this.zongshoufeiHidden = zongshoufeiHidden;
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
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getCunkuanshijian() {
		return cunkuanshijian;
	}
	public void setCunkuanshijian(String cunkuanshijian) {
		this.cunkuanshijian = cunkuanshijian;
	}
	public String getXinxishuliang() {
		return xinxishuliang;
	}
	public void setXinxishuliang(String xinxishuliang) {
		this.xinxishuliang = xinxishuliang;
	}
	public String getZongshoufeiheji() {
		return zongshoufeiheji;
	}
	public void setZongshoufeiheji(String zongshoufeiheji) {
		this.zongshoufeiheji = zongshoufeiheji;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getCunkuanren() {
		return cunkuanren;
	}
	public void setCunkuanren(String cunkuanren) {
		this.cunkuanren = cunkuanren;
	}

	public String getYihedui() {
		return yihedui;
	}
	public void setYihedui(String yihedui) {
		this.yihedui = yihedui;
	}
	public String getChazhi() {
		return chazhi;
	}
	public void setChazhi(String chazhi) {
		this.chazhi = chazhi;
	}
	public String getCunkuanyinhang() {
		return cunkuanyinhang;
	}
	public void setCunkuanyinhang(String cunkuanyinhang) {
		this.cunkuanyinhang = cunkuanyinhang;
	}
	public String getWangdianhao() {
		return wangdianhao;
	}
	public void setWangdianhao(String wangdianhao) {
		this.wangdianhao = wangdianhao;
	}
	public String getCunkuanjine() {
		return cunkuanjine;
	}
	public void setCunkuanjine(String cunkuanjine) {
		this.cunkuanjine = cunkuanjine;
	}
	public String[] getUUIDS() {
		return UUIDS;
	}
	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
	}
	public String getZhifuleixing() {
		return zhifuleixing;
	}
	public void setZhifuleixing(String zhifuleixing) {
		this.zhifuleixing = zhifuleixing;
	}
	public String getZhifuleixingHidden() {
		return zhifuleixingHidden;
	}
	public void setZhifuleixingHidden(String zhifuleixingHidden) {
		this.zhifuleixingHidden = zhifuleixingHidden;
	}
	public String getZhangmuUUIDHidden() {
		return zhangmuUUIDHidden;
	}
	public void setZhangmuUUIDHidden(String zhangmuUUIDHidden) {
		this.zhangmuUUIDHidden = zhangmuUUIDHidden;
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
	public String[] getZmUUIDS() {
		return zmUUIDS;
	}
	public void setZmUUIDS(String[] zmUUIDS) {
		this.zmUUIDS = zmUUIDS;
	}
	
}
