package com.webService.xmlStr;

import com.webService.entity.Product;

/**
 * ���CRMת��_�����ͻ�֤����Ϣ��������
 * @author Xinhua-Zhao
 * @date�� ���ڣ�2015-1-26 ʱ�䣺����9:00:03
 */
public class ChaiJi extends BaseString {

    
    /**
     * ɾ����Ʒ
     * @return
     */
    public static String DEL_PROD_INST_REQ_TYPE(String soo_id, String group_id, Product pt) {
	String str = "<SOO type='DEL_PROD_INST_REQ_TYPE'><ORDER_REQ>" +
		FlagString("ORDER_ITEM_GROUP_ID", group_id) + "</ORDER_REQ><PUB_REQ>" +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ>" +
		FlagString("PROD_INST_ID", ":getProdInstIdByAccNbr(22003,022," + pt.getAcc_nbr() + ",9)") + " </SOO>";
	return str;
    }
    
}
