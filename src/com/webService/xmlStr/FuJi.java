package com.webService.xmlStr;

import com.webService.entity.Product;

/**
 * ͣ������
 * @author Xinhua-Zhao
 * @date�� ���ڣ�2015-1-30 ʱ�䣺����9:24:30
 */
public class FuJi extends BaseString {
    /**
     * ����
     * @return
     */
    public static String MOD_PROD_INST_REQ_TYPE(String soo_id, String group_id, Product pt) {
	String str = "<SOO type='MOD_PROD_INST_REQ_TYPE'><ORDER_REQ>" +
		FlagString("ORDER_ITEM_GROUP_ID", group_id) + "</ORDER_REQ><PUB_REQ>" +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ><PROD_INST>" +
		FlagString("PROD_INST_ID", ":getProdInstIdByAccNbr(22003,022," + pt.getAcc_nbr() + ",9)") + 
		FlagString("ACC_PROD_INST_ID", ":getProdInstIdByAccNbr(22003,022," + pt.getAcc_nbr() + ",9)") + 
		FlagString("PRODUCT_CODE", "9") + 
		FlagString("ACC_NBR", pt.getAcc_nbr()) + 
		FlagString("LAN_ID", "22003") + 
		"<STATUS_CD OLDVAL='2'>1</STATUS_CD> </PROD_INST></SOO>";
	return str;
    }
}
