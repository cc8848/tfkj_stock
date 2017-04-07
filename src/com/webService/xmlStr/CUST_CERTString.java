package com.webService.xmlStr;

import com.webService.entity.CUSTOMER_ORDER_TYPE;

/**
 * ���CRMת��_�����ͻ�֤����Ϣ��������
 * @author Xinhua-Zhao
 * @date�� ���ڣ�2015-1-26 ʱ�䣺����9:00:03
 */
public class CUST_CERTString extends BaseString {

    
    /**
     * �����ͻ�֤����Ϣ
     * @return
     */
    public static String ADD_CUST_CERT_REQ_TYPE(String soo_id, String group_id, CUSTOMER_ORDER_TYPE cot) {
	String str = "<SOO type='ADD_CUST_CERT_REQ_TYPE'><PUB_REQ> " +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ><ORDER_REQ> " +
		FlagString("ORDER_ITEM_GROUP_ID", group_id) + "</ORDER_REQ><CUST_CERT>";
	str += FlagString("CUST_CERTI_ID",  "$-7$");
	str += FlagString("CUST_ID", "$-2$");
	str += FlagString("CERT_TYPE", "1");//֤�����Ͷ�Ϊ���֤
	str += FlagString("CERT_NUMBER", cot.getCartNumber());
	str += FlagString("CERT_ADDRESS", cot.getCartAddress());
	str += "</CUST_CERT></SOO>";
	return str;
    }
    
}
