package com.webService.xmlStr;

import com.webService.entity.Product;

/**
 * 天津CRM转订_改变产品速率
 * @author Xinhua-Zhao
 * @date： 日期：2015-1-26 时间：上午9:00:03
 */
public class ChangeSuLv extends BaseString {

    
    /**
     * 修改产品速率
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
		" <ATTR CD='301045' VAL='" + NetSpeedValChangeUtil.getTeleSpeedByTf(val)+ "' OLDVAL='" + NetSpeedValChangeUtil.getTeleSpeedByTf(oldVal) + "' ACTION='MOD'>广电ADSL端口速率</ATTR></PROD_INST></SOO>";
	return str;
    }
    
    
}
