package com.stock.ration; 

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

/** 
 * @author wangdl 
 * @version ����ʱ�䣺2012-6-13 ����02:37:28 
 * �ɹ�����ѯform 
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
	
	private String stateDate;//��ѯ��ʼʱ��
	
	private String endDate;//��ѯ����ʱ��
	
	private String xiaoqu;//�û�С��
	
	private String userTel;//�û��绰
	
	private String state;//�ɹ���״̬
	
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

