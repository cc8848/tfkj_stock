package com.stock.qujianHistory; 

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

/** 
 * @author wangdl 
 * @version ����ʱ�䣺2012-6-13 ����02:37:28 
 * �ɹ�����ѯform 
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
	}
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	
	private String stateDate;//��ѯ��ʼʱ��
	
	private String endDate;//��ѯ����ʱ��
	
	private String paigongriqis;//�ɹ�����
	private String paigongriqisHidden="";
	
	private String xiangmus;//��Ŀ
	
	private String xiangmusHidden="";
	
	private String xiaoqu;//�û�С��
	
	private String userTel;//�û��绰
	
	private String state;//�ɹ���״̬
	
	private String userplaces;//�û���ַ
	
	private String stateDateHidden="";//
	
	private String endDateHidden="";//
	
	private String xiaoquHidden="";//
	
	private String userTelHidden="";//

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

}

