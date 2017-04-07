package com.webService.xmlStr;

import com.webService.entity.ACCOUNT;
import com.webService.entity.CUSTOMER_ORDER_TYPE;
import com.webService.entity.Customer;
import com.webService.entity.Payment;
import com.webService.entity.Product;

/**
 * 天津CRM转订_新装请求样例
 * @author Xinhua-Zhao
 * @date： 日期：2015-1-26 时间：上午9:11:04
 */
public class KHString extends BaseString {
    
    /**
    * 新建客户SOO实体
    * @param customer
    * @return
    */
    public static String ADD_CUST_REQ_TYPE3(String soo_id, String group_id, Customer customer) {
	String customerString = "<SOO type='ADD_CUST_REQ_TYPE'><CUST>" +
		FlagString("CUST_ID", "$-2$") +
		FlagString("CUST_NAME", customer.getCustomerName()) +
		FlagString("CUST_ADDRESS", customer.getCustomerAddress()) +
		FlagString("CUST_TYPE", customer.getCustomerType()) +
		FlagString("LAN_ID", customer.getCustomerLan_ID()) +
		FlagString("STATUS_CD", customer.getStatus_cd()) + "</CUST><ORDER_REQ>" +
		FlagString("ORDER_ITEM_GROUP_ID", group_id) + "</ORDER_REQ><PUB_REQ>" + 
		FlagString("SOO_ID", soo_id) + "</PUB_REQ> </SOO>";
	return customerString;
    }
    
    /**
     * 新建账户SOO实体
     * @return
     */
    public static String ADD_ACCOUNT_REQ_TYPE5(String soo_id, String group_id, ACCOUNT at) {
	String str5 = "<SOO type='ADD_ACCOUNT_REQ_TYPE'><ACCOUNT>" +
		FlagString("ACCOUNT_ID", "$-8$") + 
		FlagString("CUST_ID", "$-2$") + 
		FlagString("ACCOUNT_NAME", at.getAccount_name()) + 
		FlagString("CONTACT_PHONE", at.getPhone()) + 
		FlagString("LAN_ID", at.getLan_id()) + 
		FlagString("STATUS_CD", at.getStatus_cd()) + "</ACCOUNT><ORDER_REQ>" +
		FlagString("ORDER_ITEM_GROUP_ID", group_id) + "</ORDER_REQ><PUB_REQ>" +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ></SOO>";
	return str5;
    }
    
    /**
     * 新建账户支付方式SOO
     * @return
     */
    public static String ADD_PAYMENT_PLAN_REQ_TYPE6(String soo_id, String group_id, Payment pt) {
	String str6 = "<SOO type='ADD_PAYMENT_PLAN_REQ_TYPE'><ORDER_REQ>" +
		FlagString("ORDER_ITEM_GROUP_ID", group_id) + "</ORDER_REQ><PUB_REQ>" +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ><PAYMENT_PLAN>" + 
		FlagString("PAYMENT_PLAN_ID", "$-9$") +
		FlagString("ACCOUNT_ID", "$-8$") +
		FlagString("PAYMENT_METHOD_CD", pt.getPayMethodId()) +
		FlagString("PAYMENT_BANK_ID", pt.getPayBankId()) +
		FlagString("PAYMENT_ACCOUNT", pt.getAccountId()) +
		FlagString("PAYMENT_ACCOUNT_NAME", pt.getPaymentAccountName()) +
		"</PAYMENT_PLAN> </SOO>";
	return str6;
    }
    
    /**
     * 保存产品实例实体对象
     * @return
     */
    public static String SAVE_PROD_INST_REQ_TYPE10(String soo_id, String group_id, Product pt, CUSTOMER_ORDER_TYPE cot,ACCOUNT at) {
	String str10 = "<SOO type='SAVE_PROD_INST_REQ_TYPE'><ORDER_REQ>" +
		FlagString("ORDER_ITEM_GROUP_ID", group_id) + "</ORDER_REQ><PUB_REQ>" +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ><PROD_INST> " +
		FlagString("PROD_INST_ID", "$-5$") +
		FlagString("ACC_PROD_INST_ID", "$-5$") +
		FlagString("ACC_NBR", pt.getAcc_nbr()) +
		FlagString("LAN_ID", pt.getLan_id()) +
		FlagString("ADDRESS_ID", pt.getAddress_id()) +
		FlagString("ADDRESS_DETAIL", cot.getCartAddress()) +
		FlagString("PRODUCT_CODE", pt.getProduct_code()) +
		FlagString("PRODUCT_NAME", pt.getProduct_name()) +
		FlagString("PAYMENT_MODE_CD", "1") +
		FlagString("PRODUCT_PASSWORD", pt.getProduct_password()) +
		FlagString("OWNER_CUST_ID", "225009498001") +
		"<ATTR CD='100000260' VAL='0'>停拆类型</ATTR>" +
		"<ATTR CD='600000127' VAL='9'>用户类型</ATTR>" +
		"<ATTR CD='301045' VAL='"+NetSpeedValChangeUtil.getTeleSpeedByTf(pt.getNetPortSpeed())+"'>广电ADSL端口速率</ATTR>" +
		"<ATTR CD='12879' VAL='"+at.getAccount_name()+"'>用户名称</ATTR>" +
		"<ATTR CD='12886' VAL='0'>用户证件类型</ATTR>" +
		"<ATTR CD='12885' VAL='"+cot.getCartNumber()+"'>用户证件号码</ATTR>" +
		"<ATTR CD='12883' VAL='"+at.getPhone()+"'>用户联系电话</ATTR>" +
		"<ATTR CD='12882' VAL='"+cot.getCartAddress()+"'>用户地址</ATTR>" +
		"</PROD_INST> </SOO>";
	return str10;
    }
    
    /**
     * 保存产品实例帐务定制信息
     * @return
     */
    public static String SAVE_PROD_INST_ACCT_REQ_TYPE11(String soo_id, String group_id) {
	String str11 = "<SOO type='SAVE_PROD_INST_ACCT_REQ_TYPE'><ORDER_REQ>" +
		FlagString("ORDER_ITEM_GROUP_ID", group_id) + "</ORDER_REQ><PUB_REQ>" +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ><PROD_INST_ACCT>" +
		FlagString("PROD_INST_ID", "$-5$") + 
		FlagString("ACCOUNT_ID", "221047439617") + 
			"</PROD_INST_ACCT> </SOO>";
	return str11;
    }
    
}
