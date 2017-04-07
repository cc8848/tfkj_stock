package com.stock.ration; 

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 下午02:37:28 
 * 派工单查询form 
 */
public class rationForm extends ActionForm{

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
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	
	private String stateDate;//查询开始时间
	
	private String endDate;//查询结束时间
	
	private String xiaoqu;//用户小区
	
	private String userTel;//用户电话
	
	private String state;//派工单状态
	
	private String stateDateHidden="";//
	
	private String endDateHidden="";//
	
	private String xiaoquHidden="";//
	
	private String userTelHidden="";//

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

	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}

}

