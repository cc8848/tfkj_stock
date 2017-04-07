package com.webService.entity;

import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;
import com.webService.xmlStr.BaseString;

/**
 * ��������1.0ҵ�������д�����DataRowת����ʵ�����
 * @author Xinhua-Zhao
 * @date�� ���ڣ�2015-1-28 ʱ�䣺����1:56:33
 */
public class EntityFactroy extends BaseString {
    
    /**
     * ����һ���û���������
     * @param dataRow
     * @return
     */
    public static CUSTOMER_ORDER_TYPE create_CUSTOMER_ORDER_TYPE(DataRow dataRow) {
	CUSTOMER_ORDER_TYPE cot = new CUSTOMER_ORDER_TYPE();
	cot.setM_cust_order_id(Get12ID());
	cot.setM_cust_id(Get12ID());
	//cot.setCust_name("��������һ");
	cot.setCust_name("������췿�Ƽ���չ�ɷ����޹�˾");
	cot.setM_accept_time(GetTimeString());
	cot.setM_lan_id("22003");
	cot.setM_pre_handle_flag("F");
	cot.setM_staff_id("2004138004");
	cot.setStaff_name("�췿���������");
	//cot.setStaff_name(dataRow.getDataElement("shigongren").getString());
	cot.setChannel_id("37772");
	cot.setChannel_name("�췿�����������");
	cot.setExt_system("TJSJ001");
	cot.setCert_type("1");
	//cot.setCartNumber("371122198710216338");
	cot.setCartNumber(dataRow.getDataElement("shenfenzheng").getString());
	cot.setCartAddress(dataRow.getDataElement("xiaoqu").getString() + dataRow.getDataElement("dizhi").getString());
	cot.setAccept_time(GetTimeString());
	return cot;
    }
    
    /**
     * �ͻ�������ʵ��
     * @param dataRow
     * @return
     */
    public static ORDER_ITEM_GROUP_TYPE create_ORDER_ITEM_GROUP_TYPE(DataRow dataRow, String code, String name) {
	ORDER_ITEM_GROUP_TYPE c_oigt = new ORDER_ITEM_GROUP_TYPE();
	c_oigt.setOrder_item_group_id(Get12ID());
	c_oigt.setCust_order_id(Get12ID());
	c_oigt.setService_offer_id(code);
	c_oigt.setService_offer_name(name);
	c_oigt.setAccept_time(GetTimeString());
   	return c_oigt;
    }
    
    /**
     * �ͻ�ʵ��
     * @param dataRow
     * @return
     */
    public static Customer create_Customer(DataRow dataRow) {
	Customer customer = new Customer();
	customer.setCustomerId(Get12ID());
	//customer.setCustomerName("���˻�");
	customer.setCustomerName(dataRow.getDataElement("xingming").getString());
	customer.setCustomerAddress(dataRow.getDataElement("xiaoqu").getString() + dataRow.getDataElement("dizhi").getString());
	customer.setCustomerType("12");
	customer.setCustomerLan_ID("22003");
	customer.setStatus_cd("");
   	return customer;
    }
    
    /**
     * �˻�ʵ��
     * @param dataRow
     * @return
     */
    public static ACCOUNT create_ACCOUNT(DataRow dataRow) {
	ACCOUNT at = new ACCOUNT();
	at.setAccount_id(Get12ID());
	at.setCust_id(Get12ID());
	//at.setAccount_name("192.168.60.14");
	//at.setPhone("13163033587");
	at.setAccount_name(dataRow.getDataElement("xingming").getString());
	at.setPhone(dataRow.getDataElement("lianxidianhua").getString());
	at.setStatus_cd("");
   	return at;
    }
 
    /**
     * ֧����ʽʵ��
     * @param dataRow
     * @return
     */
    public static Payment create_Payment(DataRow dataRow) {
	Payment pt = new Payment();
	pt.setPaymentId(Get12ID());
	pt.setAccountId(Get12ID());
	pt.setPayMethodId("1");
   	return pt;
    }
 
    /**
     * ��Ʒʵ��
     * @param dataRow
     * @return
     */
    public static Product create_Product(DataRow dataRow,String accBbr) {
	Product product = new Product();
	product.setProd_inst_id(Get12ID());
	product.setAcc_prod_inst_id(Get12ID());
	product.setLan_id("22003");
	product.setAddress_id("");
	product.setAddress_desc("");
	product.setAcc_nbr(dataRow.getDataElement("wangluoip").getString());
	//product.setProduct_password("123456");
	String pwd = "123456";
	//ȡ����������
	String netPortSpeedText = dataRow.getDataElement("wangluo").getString();
	//Fix By DaiZhen On 2015-4-7 START
	//�췿�����3�����ʶ�Ӧ����3�����ʣ�֮ǰ��ƴ��xml�ļ���д����
	if(netPortSpeedText.indexOf("20")!=-1) {
		//�췿20M��Ӧ���ADSL�ӿ�����20M
		product.setNetPortSpeed("20M");
	}else if (netPortSpeedText.indexOf("100")!=-1) {
		product.setNetPortSpeed("100M");
	}else if (netPortSpeedText.indexOf("50")!=-1) {	
		product.setNetPortSpeed("50M");
	}else if (netPortSpeedText.indexOf("10")!=-1||netPortSpeedText.indexOf("12")!=-1) {
		//�췿10M��12M��Ӧ���ADSL�ӿ�����12M
		product.setNetPortSpeed("12M");
	}else if (netPortSpeedText.indexOf("4")!=-1) {
		//�췿4M��Ӧ���ADSL�ӿ�����4M
		product.setNetPortSpeed("4M");
	}else{
		product.setNetPortSpeed("4M");
	}
	//Fix By DaiZhen On 2015-4-7 END
	if (dataRow.getDataElement("lianxidianhua").getString() != null) {
	    if (!"null".equals(dataRow.getDataElement("lianxidianhua").getString()) && !"".equals(dataRow.getDataElement("lianxidianhua").getString())) {
		pwd = dataRow.getDataElement("lianxidianhua").getString();
	    }
	}
	product.setProduct_password(pwd);
	product.setProduct_code("9");
   	return product;
    }
    
    public static Product create_Product(DataRow dataRow) {
   	Product product = new Product();
   	product.setProd_inst_id(Get12ID());
   	product.setAcc_prod_inst_id(Get12ID());
   	product.setLan_id("22003");
   	product.setAddress_id("");
   	product.setAddress_desc("");
   	product.setAcc_nbr(dataRow.getDataElement("wangluoip").getString());
   	//Fix By DaiZhen On 2015-4-7 START
   	//�����userid�ǡ����������޸�/�˶���ʱ���޸ĵ�����
   	DataElement userid = dataRow.getDataElement("userId");
   	String pwd = "";
   	if(userid!=null) {
   		pwd = userid.getString();
   	}else{
   		if (dataRow.getDataElement("lianxidianhua").getString() != null) {
   		    if (!"null".equals(dataRow.getDataElement("lianxidianhua").getString()) && !"".equals(dataRow.getDataElement("lianxidianhua").getString())) {
   			pwd = dataRow.getDataElement("lianxidianhua").getString();
   		    }
   		}
   	}
	product.setProduct_password(pwd);
	//Fix By DaiZhen On 2015-4-7 END
   	product.setProduct_code("9");
      	return product;
      }
    
}
