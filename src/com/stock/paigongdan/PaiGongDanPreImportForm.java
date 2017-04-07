package com.stock.paigongdan;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class PaiGongDanPreImportForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8340655817816771591L;

	//�û��б�
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	
	private String UUID;
	
	private String[] UUIDS;
	
	//�û�С��
	private String xiaoqu;
	
	//�û���ַ
	private String dizhi;
	
	//�ɹ�����
	private String paigongriqis;
	
	//����ʱ��
	private String kaijishijian;
	
	//ͣ��ʱ��
	private String tingjishijian;
	
	//����ʱ��
	private String caozuoshijian;
	
	//ҵ������
	private String yewutype;
	
	//��ע
	private String beizhu;

	/**
	 * @return the �û��б�
	 */
	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	/**
	 * @param xiaoquList the �û��б� to set
	 */
	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}

	/**
	 * @return the �û�С��
	 */
	public String getXiaoqu() {
		return xiaoqu;
	}

	/**
	 * @param xiaoqu the �û�С�� to set
	 */
	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}

	/**
	 * @return the �û���ַ
	 */
	public String getDizhi() {
		return dizhi;
	}

	/**
	 * @param dizhi the �û���ַ to set
	 */
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	/**
	 * @return the �ɹ�����
	 */
	public String getPaigongriqis() {
		return paigongriqis;
	}

	/**
	 * @param paigongriqis the �ɹ����� to set
	 */
	public void setPaigongriqis(String paigongriqis) {
		this.paigongriqis = paigongriqis;
	}

	/**
	 * @return the ����ʱ��
	 */
	public String getKaijishijian() {
		return kaijishijian;
	}

	/**
	 * @param kaijishijian the ����ʱ�� to set
	 */
	public void setKaijishijian(String kaijishijian) {
		this.kaijishijian = kaijishijian;
	}

	/**
	 * @return the ͣ��ʱ��
	 */
	public String getTingjishijian() {
		return tingjishijian;
	}

	/**
	 * @param tingjishijian the ͣ��ʱ�� to set
	 */
	public void setTingjishijian(String tingjishijian) {
		this.tingjishijian = tingjishijian;
	}

	/**
	 * @return the ҵ������
	 */
	public String getYewutype() {
		return yewutype;
	}

	/**
	 * @param yewutype the ҵ������ to set
	 */
	public void setYewutype(String yewutype) {
		this.yewutype = yewutype;
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
	 * @return the uUIDS
	 */
	public String[] getUUIDS() {
		return UUIDS;
	}

	/**
	 * @param uUIDS the uUIDS to set
	 */
	public void setUUIDS(String[] uUIDS) {
		UUIDS = uUIDS;
	}

	/**
	 * @return the caozuoshijian
	 */
	public String getCaozuoshijian() {
		return caozuoshijian;
	}

	/**
	 * @param caozuoshijian the caozuoshijian to set
	 */
	public void setCaozuoshijian(String caozuoshijian) {
		this.caozuoshijian = caozuoshijian;
	}

	/**
	 * @return the beizhu
	 */
	public String getBeizhu() {
		return beizhu;
	}

	/**
	 * @param beizhu the beizhu to set
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
}
