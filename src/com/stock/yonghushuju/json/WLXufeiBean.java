package com.stock.yonghushuju.json;

public class WLXufeiBean {
	
	private String iIspID;
	private String iBillType; //�Ʒ�����	int	0��ʾ���£�1��ʾ��ʱ��2��ʾ������4��ʾ��ʱ����5��ʾ��������6��ʾ�ƴΡ�7��ʾ����
	private String iPolicy;  // �������	int	��Ӧ������������
	private String sIspName;  // �������	int	��Ӧ������������
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
