/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data init and query.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2015-12-15   DaiZhen            Create
 */
package com.stock.kucun;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class ZongkufangInfoForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7354673949715433796L;
	
	private String UUID;
	//���
	private String zongkufang_ID;
	
	//�豸����
	private String eqType;
	
	//�豸�ͺ�
	private String eqVersion;
	
	//�������
	private int kucunSuu;
	
	//��ע��Ϣ
	private String remark;

	//�ܿⷿ��־ID
	private int zongkufangHistory_ID;
	
	//��������
	private String operateType;
	
	//�����ʱ��
	private String operateTime;
	
	//����
	private int operateSuu;
	
	//�����ⷿ
	private String operateStore;
	
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();

	/**
	 * @return the �ܿⷿ���
	 */
	public String getZongkufang_ID() {
		return zongkufang_ID;
	}

	/**
	 * @param zongkufang_ID the �ܿⷿ��� to set
	 */
	public void setZongkufang_ID(String zongkufang_ID) {
		this.zongkufang_ID = zongkufang_ID;
	}

	/**
	 * @return the �豸����
	 */
	public String getEqType() {
		return eqType;
	}

	/**
	 * @param eqType the �豸���� to set
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}

	/**
	 * @return the �豸�ͺ�
	 */
	public String getEqVersion() {
		return eqVersion;
	}

	/**
	 * @param eqVersion the �豸�ͺ� to set
	 */
	public void setEqVersion(String eqVersion) {
		this.eqVersion = eqVersion;
	}

	/**
	 * @return the �������
	 */
	public int getKucunSuu() {
		return kucunSuu;
	}

	/**
	 * @param kucunSuu the ������� to set
	 */
	public void setKucunSuu(int kucunSuu) {
		this.kucunSuu = kucunSuu;
	}

	/**
	 * @return the ��ע
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the ��ע to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the �ܿⷿ��־ID
	 */
	public int getZongkufangHistory_ID() {
		return zongkufangHistory_ID;
	}

	/**
	 * @param zongkufangHistory_ID the �ܿⷿ��־ID to set
	 */
	public void setZongkufangHistory_ID(int zongkufangHistory_ID) {
		this.zongkufangHistory_ID = zongkufangHistory_ID;
	}

	/**
	 * @return the ��������
	 */
	public String getOperateType() {
		return operateType;
	}

	/**
	 * @param operateType the �������� to set
	 */
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	/**
	 * @return the �����ʱ��
	 */
	public String getOperateTime() {
		return operateTime;
	}

	/**
	 * @param operateTime the �����ʱ�� to set
	 */
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	/**
	 * @return the ����
	 */
	public int getOperateSuu() {
		return operateSuu;
	}

	/**
	 * @param operateSuu the ���� to set
	 */
	public void setOperateSuu(int operateSuu) {
		this.operateSuu = operateSuu;
	}

	/**
	 * @return the �����ⷿ
	 */
	public String getOperateStore() {
		return operateStore;
	}

	/**
	 * @param operateStore the �����ⷿ to set
	 */
	public void setOperateStore(String operateStore) {
		this.operateStore = operateStore;
	}

	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @return the xiaoquList
	 */
	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	/**
	 * @param xiaoquList the xiaoquList to set
	 */
	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}
	
}
