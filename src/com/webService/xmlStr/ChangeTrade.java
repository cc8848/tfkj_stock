package com.webService.xmlStr;

import com.webService.entity.CUSTOMER_ORDER_TYPE;

public class ChangeTrade extends BaseString {

    /**
     * ��ȡ�޸�ҵ��Ŀ�ͷ
     * 
     * @return
     */
    public static String GetKHHead() {
	String KHHead = "<ActionCode>0</ActionCode><TransactionID>5000000100" + GetTimeString() + GetUUNum();
	KHHead += "</TransactionID><ServiceLevel>1</ServiceLevel>" + "<SrcOrgID>GD0000</SrcOrgID>" + "<SrcSysID>GD00000001</SrcSysID>" + "<SrcSysSign>1000000002</SrcSysSign>" + "<DstOrgID>609902</DstOrgID><DstSysID>6099020001</DstSysID><ReqTime>" + GetTimeString();
	KHHead += "</ReqTime><BusCode>BUST****</BusCode><ServiceCode>BUST****</ServiceCode><ServiceContractVer>SVCTJ00120140804</ServiceContractVer>";
	return KHHead;
    }

    /**
     * -����ͻ�����
     * 
     * @return
     */
    public static String SAVE_CUSTOMER_ORDER_REQ_TYPE(CUSTOMER_ORDER_TYPE cot) {
	String str = "<SOO type='SAVE_CUSTOMER_ORDER_REQ_TYPE'><PUB_REQ> <SOO_ID>100</SOO_ID> </PUB_REQ><CUSTOMER_ORDER>" + FlagString("CUST_ORDER_ID", cot.getM_cust_order_id())
		+
		// :getCustIdByExtId(LAN_ID,200000010000, $-1$)
		FlagString("CUST_ID", "225009498001") + FlagString("CUST_NAME", cot.getCust_name()) + FlagString("PRE_HANDLE_FLAG", "F") + FlagString("EXT_CUST_ORDER_ID", GetTimeString()) + FlagString("LAN_ID", cot.getM_lan_id()) + FlagString("STAFF_NBR", cot.getM_staff_id()) + FlagString("STAFF_NAME", cot.getStaff_name()) + FlagString("EXT_SYSTEM", "TJSJ001") + FlagString("REMARKS", "������ע") + FlagString("ACCEPT_TIME", GetTimeString())
		+ "<ATTR CD='140000004' VAL='15300000000'>��������ϵ�绰</ATTR>" + "<ATTR CD='140000005' VAL='zzzz@126.com'>������EMAIL</ATTR>" +

		"</CUSTOMER_ORDER> </SOO>";
	return str;
    }

    /**
     * ���Ӷ��������
     * 
     * @param cot
     * @return
     */
    public static String ADD_ORDER_ITEM_GROUP_REQ_TYPE(CUSTOMER_ORDER_TYPE cot) {
	String str = "<SOO type='ADD_ORDER_ITEM_GROUP_REQ_TYPE'><PUB_REQ> <SOO_ID>1200</SOO_ID> </PUB_REQ> <ORDER_ITEM_GROUP>" + FlagString("ORDER_ITEM_GROUP_ID", "3000") + FlagString("CUST_ORDER_ID", cot.getM_cust_order_id()) + FlagString("SERVICE_OFFER_ID", "����ķ������~~~~~~") + FlagString("SERVICE_OFFER_NAME", "���") + FlagString("ACCEPT_DATE", GetTimeString()) + "<ATTR CD='141000006' VAL=''>Ҫ���������</ATTR>" + "<ATTR CD='141000007' VAL=''>���ȼ���</ATTR>" + "<ATTR CD='141000008' VAL=''>�Ӽ�����</ATTR>"
		+ "</ORDER_ITEM_GROUP> </SOO>";

	return str;
    }

    public static String MOD_PROD_INST_REQ_TYPE(CUSTOMER_ORDER_TYPE cot) {
	String str = "<SOO type='MOD_PROD_INST_REQ_TYPE'><PUB_REQ> <SOO_ID>1300</SOO_ID> </PUB_REQ> <ORDER_REQ> <ORDER_ITEM_GROUP_ID>3000</ORDER_ITEM_GROUP_ID> </ORDER_REQ>" + "<PROD_INST><PROD_INST_ID>" + 
			":getProdInstIdByExtId(LAN_ID,201012141450003,$-40001$)</PROD_INST_ID>" + 
			"<ATTR CD='100000007' VAL='10M'>����</ATTR></PROD_INST>";
	return str;
    }

}
