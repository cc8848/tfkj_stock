/*
 * TFTECH corporation (c)2012 all rights reserved.
 * Description: user data entity class.
 * 
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Zhu.Xiao-Lei          Create
 */
package com.webService.log;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

/**
 * User data entity class.
 * 
 * @author Zhu.Xiao-Lei
 * 
 */
public class WebServiceLogForm extends ActionForm {

    private static final long serialVersionUID = 1132343464673456L;
    
    private String id;
    private String UUID;
    private String yonghuzhuangtai;
    private String xiaoqu;
    private String dizhi;
    private String interfaceDetail;
    private String interfaceResult;
    private String tradeAccount;
    private String logState;
    private String createDt;
    private String tradeDetail;
    private String daikuan;
    
    private String userId;
    
    private String xmlId;
    private String xmlString;
    private String xmlState;
    
    private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
    

    public String getTradeDetail() {
        return tradeDetail;
    }

    public void setTradeDetail(String tradeDetail) {
        this.tradeDetail = tradeDetail;
    }

    public String getDaikuan() {
        return daikuan;
    }

    public void setDaikuan(String daikuan) {
        this.daikuan = daikuan;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getUUID() {
	return UUID;
    }

    public void setUUID(String uUID) {
	UUID = uUID;
    }

    public String getYonghuzhuangtai() {
	return yonghuzhuangtai;
    }

    public void setYonghuzhuangtai(String yonghuzhuangtai) {
	this.yonghuzhuangtai = yonghuzhuangtai;
    }

    public String getXiaoqu() {
	return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
	this.xiaoqu = xiaoqu;
    }

    public String getDizhi() {
	return dizhi;
    }

    public void setDizhi(String dizhi) {
	this.dizhi = dizhi;
    }

    public String getInterfaceDetail() {
        return interfaceDetail;
    }

    public void setInterfaceDetail(String interfaceDetail) {
        this.interfaceDetail = interfaceDetail;
    }

    public String getInterfaceResult() {
        return interfaceResult;
    }

    public void setInterfaceResult(String interfaceResult) {
        this.interfaceResult = interfaceResult;
    }

    public String getTradeAccount() {
	return tradeAccount;
    }

    public void setTradeAccount(String tradeAccount) {
	this.tradeAccount = tradeAccount;
    }

    public String getLogState() {
	return logState;
    }

    public void setLogState(String logState) {
	this.logState = logState;
    }

    public String getCreateDt() {
	return createDt;
    }

    public void setCreateDt(String createDt) {
	this.createDt = createDt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getXmlId() {
        return xmlId;
    }

    public void setXmlId(String xmlId) {
        this.xmlId = xmlId;
    }

    public String getXmlString() {
        return xmlString;
    }

    public void setXmlString(String xmlString) {
        this.xmlString = xmlString;
    }

    public String getXmlState() {
        return xmlState;
    }

    public void setXmlState(String xmlState) {
        this.xmlState = xmlState;
    }

    public List<CommonModule> getXiaoquList() {
	return xiaoquList;
    }
    
    public void setXiaoquList(List<CommonModule> xiaoquList) {
    	this.xiaoquList = xiaoquList;
    }

    
}
