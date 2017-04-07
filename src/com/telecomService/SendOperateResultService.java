package com.telecomService;

import javax.jws.WebService;

@WebService(endpointInterface = "com.telecomService.SendResultService", serviceName = "SendOperateResultService")
public class SendOperateResultService implements SendResultService {

    public String SendOperateResult(String str) {
	String resultString = "Success";
	System.out.println(str);
	return resultString;
    }


}
