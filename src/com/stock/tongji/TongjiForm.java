package com.stock.tongji; 

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-13 下午02:37:28 
 * 派工单查询form 
 */
public class TongjiForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8553936447853671062L;
	
	public void setHidden(){
	//	this.stateDateHidden=this.stateDate;
	//	this.endDateHidden = this.endDate;
		this.xiaoquHidden = this.xiaoqu;
		this.userTelHidden = this.userTel;
		this.stateHidden = this.state;
		this.paigongriqiHidden = this.paigongriqi;
		this.dizhiHidden = this.dizhi;
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
//	private String stateDate;//查询开始时间
	
//	private String endDate;//查询结束时间
	
	private String username;
	
	private String shenfenzheng;
	
	private String xiaoqu;//用户小区
	
	private String userTel;//用户电话
	
	private String state;//派工单状态
	
	private String paigongriqi;//派工日期
	
	private String dizhi;//地址
	
	private String dizhiHidden="";
	
	private String paigongriqiHidden="";
	
	//private String stateDateHidden="";//
	
	//private String endDateHidden="";//
	
	private String xiaoquHidden="";//
	
	private String userTelHidden="";//

	private String stateHidden="";
	
	//提交状态
	private String importstate;
	/*public String getStateDate() {
		return stateDate;
	}

	public String getEndDate() {
		return endDate;
	}
*/
	public String getXiaoqu() {
		return xiaoqu;
	}

	public String getUserTel() {
		return userTel;
	}


	public String getXiaoquHidden() {
		return xiaoquHidden;
	}

	public String getUserTelHidden() {
		return userTelHidden;
	}

/*	public void setStateDate(String stateDate) {
		this.stateDate = stateDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}*/

	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
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

	public String getPaigongriqi() {
		return paigongriqi;
	}

	public void setPaigongriqi(String paigongriqi) {
		this.paigongriqi = paigongriqi;
	}

	public String getPaigongriqiHidden() {
		return paigongriqiHidden;
	}

	public void setPaigongriqiHidden(String paigongriqiHidden) {
		this.paigongriqiHidden = paigongriqiHidden;
	}

	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
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

	public String getUsername() {
	    return username;
	}

	public void setUsername(String username) {
	    this.username = username;
	}

	public String getShenfenzheng() {
	    return shenfenzheng;
	}

	public void setShenfenzheng(String shenfenzheng) {
	    this.shenfenzheng = shenfenzheng;
	}

	/**
	 * @return the 提交状态
	 */
	public String getImportstate() {
		return importstate;
	}

	/**
	 * @param importstate the 提交状态 to set
	 */
	public void setImportstate(String importstate) {
		this.importstate = importstate;
	}

}

