package com.stock.paigongdan;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.action.ActionForm;
import com.takucin.aceeci.common.CommonModule;

public class XufeilvForm extends ActionForm{
	private static final long serialVersionUID = 8553936447853671062L;
	public void setHidden(){
		this.xiaoquHidden = this.xiaoqu;
		this.kaijisHidden=this.kaijis;
		this.kaijieHidden=this.kaijie;
		this.xiaoqutextHidden = this.xiaoqutext;
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	private String xiaoqu;//用户小区
	private String xiaoquHidden="";//
	private String kaijis="";
	private String kaijie="";
	private String xiaoqutextHidden="";
	private String xiaoqutext;
	private String kaijisHidden="";
	private String kaijieHidden="";
	
	private String xufeishudianshi;
	private String hejizhidianshi;
	private Double xufeilvdianshi;
	private String xufeishuwangluo;
	private String hejizhiwangluo;
	private Double xufeilvwangluo;
	
	
	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}
	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}
	public String getXiaoqu() {
		return xiaoqu;
	}
	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
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
	public String getXiaoqutextHidden() {
		return xiaoqutextHidden;
	}
	public void setXiaoqutextHidden(String xiaoqutextHidden) {
		this.xiaoqutextHidden = xiaoqutextHidden;
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
	public String getXufeishudianshi() {
		return xufeishudianshi;
	}
	public void setXufeishudianshi(String xufeishudianshi) {
		this.xufeishudianshi = xufeishudianshi;
	}
	public String getHejizhidianshi() {
		return hejizhidianshi;
	}
	public void setHejizhidianshi(String hejizhidianshi) {
		this.hejizhidianshi = hejizhidianshi;
	}
	
	public String getXufeishuwangluo() {
		return xufeishuwangluo;
	}
	public void setXufeishuwangluo(String xufeishuwangluo) {
		this.xufeishuwangluo = xufeishuwangluo;
	}
	public String getHejizhiwangluo() {
		return hejizhiwangluo;
	}
	public void setHejizhiwangluo(String hejizhiwangluo) {
		this.hejizhiwangluo = hejizhiwangluo;
	}
	
	public String getXiaoqutext() {
		return xiaoqutext;
	}
	public void setXiaoqutext(String xiaoqutext) {
		this.xiaoqutext = xiaoqutext;
	}
	public String getXiaoquHidden() {
		return xiaoquHidden;
	}
	public void setXiaoquHidden(String xiaoquHidden) {
		this.xiaoquHidden = xiaoquHidden;
	}
	public Double getXufeilvdianshi() {
		return xufeilvdianshi;
	}
	public void setXufeilvdianshi(Double xufeilvdianshi) {
		this.xufeilvdianshi = xufeilvdianshi;
	}
	public Double getXufeilvwangluo() {
		return xufeilvwangluo;
	}
	public void setXufeilvwangluo(Double xufeilvwangluo) {
		this.xufeilvwangluo = xufeilvwangluo;
	}
	
}
