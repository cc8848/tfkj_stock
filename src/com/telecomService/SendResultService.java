package com.telecomService;

import javax.jws.WebService;

@WebService
public interface SendResultService {
    /**
     * ���ͱ������ݲ�����ɺ�Ľ��
     * @param str
     * @return
     */
    public String SendOperateResult(String str);
}
