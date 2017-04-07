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
	//序号
	private String zongkufang_ID;
	
	//设备类型
	private String eqType;
	
	//设备型号
	private String eqVersion;
	
	//库存数量
	private int kucunSuu;
	
	//备注信息
	private String remark;

	//总库房日志ID
	private int zongkufangHistory_ID;
	
	//操作类型
	private String operateType;
	
	//出入库时间
	private String operateTime;
	
	//数量
	private int operateSuu;
	
	//出入库库房
	private String operateStore;
	
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();

	/**
	 * @return the 总库房序号
	 */
	public String getZongkufang_ID() {
		return zongkufang_ID;
	}

	/**
	 * @param zongkufang_ID the 总库房序号 to set
	 */
	public void setZongkufang_ID(String zongkufang_ID) {
		this.zongkufang_ID = zongkufang_ID;
	}

	/**
	 * @return the 设备类型
	 */
	public String getEqType() {
		return eqType;
	}

	/**
	 * @param eqType the 设备类型 to set
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}

	/**
	 * @return the 设备型号
	 */
	public String getEqVersion() {
		return eqVersion;
	}

	/**
	 * @param eqVersion the 设备型号 to set
	 */
	public void setEqVersion(String eqVersion) {
		this.eqVersion = eqVersion;
	}

	/**
	 * @return the 库存数量
	 */
	public int getKucunSuu() {
		return kucunSuu;
	}

	/**
	 * @param kucunSuu the 库存数量 to set
	 */
	public void setKucunSuu(int kucunSuu) {
		this.kucunSuu = kucunSuu;
	}

	/**
	 * @return the 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the 备注 to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the 总库房日志ID
	 */
	public int getZongkufangHistory_ID() {
		return zongkufangHistory_ID;
	}

	/**
	 * @param zongkufangHistory_ID the 总库房日志ID to set
	 */
	public void setZongkufangHistory_ID(int zongkufangHistory_ID) {
		this.zongkufangHistory_ID = zongkufangHistory_ID;
	}

	/**
	 * @return the 操作类型
	 */
	public String getOperateType() {
		return operateType;
	}

	/**
	 * @param operateType the 操作类型 to set
	 */
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	/**
	 * @return the 出入库时间
	 */
	public String getOperateTime() {
		return operateTime;
	}

	/**
	 * @param operateTime the 出入库时间 to set
	 */
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	/**
	 * @return the 数量
	 */
	public int getOperateSuu() {
		return operateSuu;
	}

	/**
	 * @param operateSuu the 数量 to set
	 */
	public void setOperateSuu(int operateSuu) {
		this.operateSuu = operateSuu;
	}

	/**
	 * @return the 出入库库房
	 */
	public String getOperateStore() {
		return operateStore;
	}

	/**
	 * @param operateStore the 出入库库房 to set
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
