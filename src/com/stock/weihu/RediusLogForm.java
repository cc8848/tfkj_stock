package com.stock.weihu;

import org.apache.struts.action.ActionForm;

import java.util.Date;

/**
 * redius�ӿڵ���־����
 * Created by wangqingxiang on 2016/6/20.
 */
public class RediusLogForm extends ActionForm {
    private String uuid;
    private String type;//��־����
    private String status;//����״̬
    private String resultCode;//�������
    private String resultMsg;//�����Ϣ
    private String account;//�˺�
    private String  createDt;//����ʱ��
    private String createBy;//������
    private String serverIp;//������ip
    private String xiaoqu ;//С��
    private String dizhi ;//��ַ
    private String isweb;//�Ƿ���������

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
