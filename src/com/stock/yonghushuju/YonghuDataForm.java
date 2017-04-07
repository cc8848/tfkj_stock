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
public class YonghuDataForm extends ActionForm {
	private static final long serialVersionUID = 3972147941842385814L;

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
	
		this.sen1Hidden = this.sen1;
		this.senValue1Hidden = this.senValue1;
		this.sen2Hidden = this.sen2;
		this.senValue2Hidden = this.senValue2;
		this.sen3Hidden = this.sen3;
		this.senValue3Hidden = this.senValue3;
		this.shijianleixingHidden = this.shijianleixing;
		
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	private List<CommonModule> statusList = new ArrayList<CommonModule>();
	private List<CommonModule> senList = new ArrayList<CommonModule>();
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
	
	private String kaijis = "";
	private String kaijisHidden = "";
	
	private String kaijie = "";
	private String kaijieHidden = "";
	
	private String tingjis = "";
	private String tingjisHidden = "";
	
	private String tingjie = "";
	private String tingjieHidden = "";

	private String zhuangtai = "";
	
	private String shijianleixing = "";
	private String shijianleixingHidden = "";
	
	private String daochuriqiStart = "";
	private String daochuriqiEnd = "";
	
	

	public String getDaochuriqiStart() {
		return daochuriqiStart;
	}

	public void setDaochuriqiStart(String daochuriqiStart) {
		this.daochuriqiStart = daochuriqiStart;
	}

	public String getDaochuriqiEnd() {
		return daochuriqiEnd;
	}

	public void setDaochuriqiEnd(String daochuriqiEnd) {
		this.daochuriqiEnd = daochuriqiEnd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getZhuangtai() {
		return zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
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

	public String getFenguang() {
		return fenguang;
	}

	public void setFenguang(String fenguang) {
		this.fenguang = fenguang;
	}

	public String getShoujuhao() {
		return shoujuhao;
	}

	public void setShoujuhao(String shoujuhao) {
		this.shoujuhao = shoujuhao;
	}

	public String getKaijis() {
		return kaijis;
	}

	public void setKaijis(String kaijis) {
		this.kaijis = kaijis;
	}

	public String getKaijie() {
		return kaijie;
	}

	public void setKaijie(String kaijie) {
		this.kaijie = kaijie;
	}

	public String getTingjis() {
		return tingjis;
	}

	public void setTingjis(String tingjis) {
		this.tingjis = tingjis;
	}

	public String getTingjie() {
		return tingjie;
	}

	public void setTingjie(String tingjie) {
		this.tingjie = tingjie;
	}

	public String getFenguangHidden() {
		return fenguangHidden;
	}

	public void setFenguangHidden(String fenguangHidden) {
		this.fenguangHidden = fenguangHidden;
	}

	public String getShoujuhaoHidden() {
		return shoujuhaoHidden;
	}

	public void setShoujuhaoHidden(String shoujuhaoHidden) {
		this.shoujuhaoHidden = shoujuhaoHidden;
	}

	public String getKaijisHidden() {
		return kaijisHidden;
	}

	public void setKaijisHidden(String kaijisHidden) {
		this.kaijisHidden = kaijisHidden;
	}

	public String getKaijieHidden() {
		return kaijieHidden;
	}

	public void setKaijieHidden(String kaijieHidden) {
		this.kaijieHidden = kaijieHidden;
	}

	public String getTingjisHidden() {
		return tingjisHidden;
	}

	public void setTingjisHidden(String tingjisHidden) {
		this.tingjisHidden = tingjisHidden;
	}

	public String getTingjieHidden() {
		return tingjieHidden;
	}

	public void setTingjieHidden(String tingjieHidden) {
		this.tingjieHidden = tingjieHidden;
	}

	public List<CommonModule> getSenList() {
		return senList;
	}

	public void setSenList(List<CommonModule> senList) {
		this.senList = senList;
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

	
	
}
