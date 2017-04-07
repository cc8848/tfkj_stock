package com.webService.xmlStr;

import java.util.HashMap;
import java.util.Map;

import com.webService.entity.Product;

public class ChangePWD extends BaseString {
    
    /**
     * 修改产品实例状态，修改产品密码
     */
    public static String MOD_PROD_INST_REQ_TYPE(String soo_id, String group_id, Product pt) {
	String str = "<SOO type='MOD_PROD_INST_REQ_TYPE'><ORDER_REQ>" +
		FlagString("ORDER_ITEM_GROUP_ID", group_id) + "</ORDER_REQ><PUB_REQ>" +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ><PROD_INST>" + 
		//:getProdInstIdByAccNbr(22001,021,18951760001,9)
		FlagString("PROD_INST_ID", ":getProdInstIdByAccNbr(22003,022," + pt.getAcc_nbr() + ",9)") +
		FlagString("ACC_PROD_INST_ID", ":getProdInstIdByAccNbr(22003,022," + pt.getAcc_nbr() + ",9)") +
		FlagString("PRODUCT_CODE", pt.getProduct_code()) +
		FlagString("ACC_NBR", pt.getAcc_nbr()) +
		FlagString("LAN_ID", pt.getLan_id()) ;
	Map<String, String> valueMap = new HashMap<String, String>();
	valueMap.put("OLDVAL", "13163033587");
	str += FlagString("PRODUCT_PASSWORD", pt.getProduct_password(), valueMap) + "</PROD_INST></SOO>";	
	
	return str;
    }
    
}
