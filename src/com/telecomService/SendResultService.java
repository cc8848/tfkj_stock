package com.telecomService;

import javax.jws.WebService;

@WebService
public interface SendResultService {
    /**
     * 发送报文数据操作完成后的结果
     * @param str
     * @return
     */
    public String SendOperateResult(String str);
}
