package com.webService.xmlStr;

import com.webService.entity.Product;

/**
 * ���CRMת��_�ı��Ʒ����
 * @author Xinhua-Zhao
 * @date�� ���ڣ�2015-1-26 ʱ�䣺����9:00:03
 */
public class ChangeSuLv extends BaseString {

    
    /**
     * �޸Ĳ�Ʒ����
     * @return
     */
    public static String MOD_PROD_INST_REQ_TYPE(String soo_id, String group_id, Product pt,String val, String oldVal) {
	String str = "<SOO type='MOD_PROD_INST_REQ_TYPE'><ORDER_REQ>" +
		FlagString("ORDER_ITEM_GROUP_ID", group_id) + "</ORDER_REQ><PUB_REQ>" +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ><PROD_INST>" +
		FlagString("PROD_INST_ID", ":getProdInstIdByAccNbr(22003,022," + pt.getAcc_nbr() + ",9)") + 
		FlagString("ACC_PROD_INST_ID", ":getProdInstIdByAccNbr(22003,022," + pt.getAcc_nbr() + ",9)") + 
		FlagString("PRODUCT_CODE", pt.getProduct_code()) + 
		FlagString("ACC_NBR", pt.getAcc_nbr()) + 
		FlagString("LAN_ID", pt.getLan_id()) + 
		" <ATTR CD='301045' VAL='" + NetSpeedValChangeUtil.getTeleSpeedByTf(val)+ "' OLDVAL='" + NetSpeedValChangeUtil.getTeleSpeedByTf(oldVal) + "' ACTION='MOD'>���ADSL�˿�����</ATTR></PROD_INST></SOO>";
	return str;
    }
    
    
}
