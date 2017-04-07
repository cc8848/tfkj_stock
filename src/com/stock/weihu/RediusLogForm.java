package com.stock.weihu;

import org.apache.struts.action.ActionForm;

import java.util.Date;

/**
 * redius接口的日志对象
 * Created by wangqingxiang on 2016/6/20.
 */
public class RediusLogForm extends ActionForm {
    private String uuid;
    private String type;//日志类型
    private String status;//返回状态
    private String resultCode;//结果编码
    private String resultMsg;//结果信息
    private String account;//账号
    private String  createDt;//创建时间
    private String createBy;//创建人
    private String serverIp;//服务器ip
    private String xiaoqu ;//小区
    private String dizhi ;//地址
    private String isweb;//是否网上续费

    public String getIsweb() {
        return isweb;
    }

    public void setIsweb(String isweb) {
        this.isweb = isweb;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }



    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
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
}
