package com.stock.yonghushuju.json;

public class WLXufeiBean {
	
	private String iIspID;
	private String iBillType; //计费类型	int	0表示包月，1表示计时，2表示流量，4表示计时长、5表示计流量、6表示计次、7表示包天
	private String iPolicy;  // 带宽策略	int	对应到带宽策略序号
	private String sIspName;  // 带宽策略	int	对应到带宽策略序号
	public String getiIspID() {
		return iIspID;
	}
	public void setiIspID(String iIspID) {
		this.iIspID = iIspID;
	}
	public String getiBillType() {
		return iBillType;
	}
	public void setiBillType(String iBillType) {
		this.iBillType = iBillType;
	}
	public String getiPolicy() {
		return iPolicy;
	}
	public void setiPolicy(String iPolicy) {
		this.iPolicy = iPolicy;
	}
	public String getsIspName() {
		return sIspName;
	}
	public void setsIspName(String sIspName) {
		this.sIspName = sIspName;
	}

}
