package com.stock.paigongdan; 

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 下午02:37:28 
 * 派工单查询form 
 */
public class PaiGongDanForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8553936447853671062L;
	
	public void setHidden(){
		this.stateDateHidden=this.stateDate;
		this.endDateHidden = this.endDate;
		this.xiaoquHidden = this.xiaoqu;
		this.userTelHidden = this.userTel;
		this.stateHidden = this.state;
		this.userplaceHidden =this.userplaces;
		this.paigongriqisHidden=this.paigongriqis;
		this.xiangmusHidden = this.xiangmus;
		this.telnumbeHidden = this.telnumber;
		this.createbyCodeaHidden = this.createbyCode;
		this.createdtHiddenCode = this.createdtCode;
		this.createdtHiddenCode2 = this.createdtCode2;
		this.busiHidden = this.busi;
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	
	private String createbyCode;
	
	private String createbyCodeaHidden="";
	private String createdtHiddenCode2="";
	
	private String telnumber;
	
	private String telnumbeHidden="";
	
	private String stateDate;//查询开始时间
	
	private String endDate;//查询结束时间
	
	private String paigongriqis;//派工日期
	private String paigongriqisHidden="";
	
	private String xiangmus;//项目
	
	private String xiangmusHidden="";
	
	private String xiaoqu;//用户小区
	
	private String userTel;//用户电话
	
	private String state;//派工单状态
	private String busi;//业务状态
	private String userplaces;//用户地址
	
	private String createdtCode;
	private String createdtCode2;
	
	private String createdtHiddenCode="";
	
	private String stateDateHidden="";//
	
	private String endDateHidden="";//
	
	private String xiaoquHidden="";//
	
	private String userTelHidden="";//
	private String busiHidden="";//业务状态
	private String userplaceHidden="";
	
	private String stateHidden="";
	public String getStateDate() {
		return stateDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getXiaoqu() {
		return xiaoqu;
	}

	public String getUserTel() {
		return userTel;
	}

	public String getStateDateHidden() {
		return stateDateHidden;
	}

	public String getEndDateHidden() {
		return endDateHidden;
	}

	public String getXiaoquHidden() {
		return xiaoquHidden;
	}

	public String getUserTelHidden() {
		return userTelHidden;
	}

	public void setStateDate(String stateDate) {
		this.stateDate = stateDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public void setStateDateHidden(String stateDateHidden) {
		this.stateDateHidden = stateDateHidden;
	}

	public void setEndDateHidden(String endDateHidden) {
		this.endDateHidden = endDateHidden;
	}

	public void setXiaoquHidden(String xiaoquHidden) {
		this.xiaoquHidden = xiaoquHidden;
	}

	public void setUserTelHidden(String userTelHidden) {
		this.userTelHidden = userTelHidden;
	}

	public String getState() {
		return state;
	}

	public String getStateHidden() {
		return stateHidden;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStateHidden(String stateHidden) {
		this.stateHidden = stateHidden;
	}


	public String getUserplaces() {
		return userplaces;
	}

	public void setUserplaces(String userplaces) {
		this.userplaces = userplaces;
	}

	public String getUserplaceHidden() {
		return userplaceHidden;
	}

	public void setUserplaceHidden(String userplaceHidden) {
		this.userplaceHidden = userplaceHidden;
	}

	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}

	public String getPaigongriqis() {
		return paigongriqis;
	}

	public void setPaigongriqis(String paigongriqis) {
		this.paigongriqis = paigongriqis;
	}

	public String getXiangmus() {
		return xiangmus;
	}

	public void setXiangmus(String xiangmus) {
		this.xiangmus = xiangmus;
	}

	public String getPaigongriqisHidden() {
		return paigongriqisHidden;
	}

	public void setPaigongriqisHidden(String paigongriqisHidden) {
		this.paigongriqisHidden = paigongriqisHidden;
	}

	public String getXiangmusHidden() {
		return xiangmusHidden;
	}

	public void setXiangmusHidden(String xiangmusHidden) {
		this.xiangmusHidden = xiangmusHidden;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public String getTelnumbeHidden() {
		return telnumbeHidden;
	}

	public void setTelnumbeHidden(String telnumbeHidden) {
		this.telnumbeHidden = telnumbeHidden;
	}

	public String getCreatebyCode() {
		return createbyCode;
	}

	public void setCreatebyCode(String createbyCode) {
		this.createbyCode = createbyCode;
	}

	public String getCreatebyCodeaHidden() {
		return createbyCodeaHidden;
	}

	public void setCreatebyCodeaHidden(String createbyCodeaHidden) {
		this.createbyCodeaHidden = createbyCodeaHidden;
	}

	public String getCreatedtCode() {
		return createdtCode;
	}

	public void setCreatedtCode(String createdtCode) {
		this.createdtCode = createdtCode;
	}

	public String getCreatedtHiddenCode() {
		return createdtHiddenCode;
	}

	public void setCreatedtHiddenCode(String createdtHiddenCode) {
		this.createdtHiddenCode = createdtHiddenCode;
	}

	public String getBusi() {
		return busi;
	}

	public void setBusi(String busi) {
		this.busi = busi;
	}

	public String getBusiHidden() {
		return busiHidden;
	}

	public void setBusiHidden(String busiHidden) {
		this.busiHidden = busiHidden;
	}

	public String getCreatedtHiddenCode2() {
		return createdtHiddenCode2;
	}

	public void setCreatedtHiddenCode2(String createdtHiddenCode2) {
		this.createdtHiddenCode2 = createdtHiddenCode2;
	}

	public String getCreatedtCode2() {
		return createdtCode2;
	}

	public void setCreatedtCode2(String createdtCode2) {
		this.createdtCode2 = createdtCode2;
	}
	
}

