package com.stock.yuyue;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

public class YuyueEidtForm extends ActionForm{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2093361558775164048L;
	
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	private List<CommonModule> quyuList = new ArrayList<CommonModule>();
	
	private String UUID;
	
	private String xiaoqu;
	
	private String riqi;
	
	private String shijian;
	
	private String azjh;
	
	private String azsy;
	
	private String qjjh;
	
	private String qjsy;
	
	private String yujing;

	public String getXiaoqu() {
		return xiaoqu;
	}

	public void setXiaoqu(String xiaoqu) {
		this.xiaoqu = xiaoqu;
	}

	public String getRiqi() {
		return riqi;
	}

	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}

	public String getShijian() {
		return shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
	}

	public String getAzjh() {
		return azjh;
	}

	public void setAzjh(String azjh) {
		this.azjh = azjh;
	}

	public String getAzsy() {
		return azsy;
	}

	public void setAzsy(String azsy) {
		this.azsy = azsy;
	}

	public String getQjjh() {
		return qjjh;
	}

	public void setQjjh(String qjjh) {
		this.qjjh = qjjh;
	}

	public String getQjsy() {
		return qjsy;
	}

	public void setQjsy(String qjsy) {
		this.qjsy = qjsy;
	}

	public String getYujing() {
		return yujing;
	}

	public void setYujing(String yujing) {
		this.yujing = yujing;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}

	public List<CommonModule> getQuyuList() {
		return quyuList;
	}

	public void setQuyuList(List<CommonModule> quyuList) {
		this.quyuList = quyuList;
	}
	
}
