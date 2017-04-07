package com.webService.service;

import java.util.ArrayList;
import java.util.List;

import com.hrbank.business.common.CommonDao;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.webService.xmlStr.BaseString;

public class UserManage extends BaseString {

    private static CommonDao dao = new CommonDao();

    /**
     * 将原有的用户数据记录对应插入一条用户记录
     * 
     * @param query
     * @return 12位ID:成功，1表示失败
     */
    public static List<String> InsertUAP(DataSet<DataRow> query) {
	DataRow dr = query.get(0);
	List<String> resultList = new ArrayList<String>();
	ParameterModel m = new ParameterModel();
	String userId = Get12ID();
	m.put("userId", userId);
	m.put("userName", dr.getDataElement("xingming").getString());
	m.put("xiaoqu", dr.getDataElement("xiaoqu").getString());
	m.put("dizhi", dr.getDataElement("dizhi").getString());
	m.put("shenfenzheng", dr.getDataElement("shenfenzheng").getString());
	m.put("phone", dr.getDataElement("lianxidianhua").getString());
	m.put("accountId", dr.getDataElement("wangluoip").getString());
	m.put("accountName", dr.getDataElement("xiaoqu").getString() + dr.getDataElement("dizhi").getString());
	m.put("productId", dr.getDataElement("wangluoip").getString());
	m.put("daikuan",  dr.getDataElement("wangluo").getString());
	m.put("kaijishijian",  dr.getDataElement("kaijishijian").getString());
	m.put("tingjishijian",  dr.getDataElement("youxiaoshijian").getString());
	m.put("ywState",  "0");
	
	try {
	    if (dao.insert("user_account_product", m) == 1) {
		resultList.add(userId);
		resultList.add(dr.getDataElement("wangluoip").getString());
		return resultList;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
	return null;
    }
}
