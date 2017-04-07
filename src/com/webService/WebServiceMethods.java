package com.webService;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.webService.entity.ACCOUNT;
import com.webService.entity.CUSTOMER_ORDER_TYPE;
import com.webService.entity.Customer;
import com.webService.entity.EntityFactroy;
import com.webService.entity.ORDER_ITEM_GROUP_TYPE;
import com.webService.entity.Payment;
import com.webService.entity.Product;
import com.webService.log.WebServiceLogForm;
import com.webService.log.WebServiceService;
import com.webService.webServiceTools.WSTools;
import com.webService.xmlStr.BaseString;
import com.webService.xmlStr.CUST_CERTString;
import com.webService.xmlStr.ChaiJi;
import com.webService.xmlStr.ChangePWD;
import com.webService.xmlStr.ChangeSuLv;
import com.webService.xmlStr.FuJi;
import com.webService.xmlStr.KHString;
import com.webService.xmlStr.TingJi;

/**
 * ���Ŷ�WebService�ӿڵ���
 * 
 * @author Xinhua-Zhao
 * 
 */
public class WebServiceMethods extends BaseString {

    /**
     * ͬ����װ����
     * 
     * @return ��װ��Ʒ���ݽṹ�� ����ͻ����� �ͻ���������� �ͻ�ʵ�� �ͻ�֤��ʵ�� �˻���������� �˻�ʵ�� �˻�֧��ʵ�� ��Ʒ���������
     *         ��Ʒʵ�� ��Ʒ��������Ϣ
     */
    public static String AnZhuang(DataSet<DataRow> query, String accBbr) {
	String backMess = "";

	// �ͻ�����ʵ��
	CUSTOMER_ORDER_TYPE cot = EntityFactroy.create_CUSTOMER_ORDER_TYPE(query.get(0));

	// �ͻ�������ʵ��
	ORDER_ITEM_GROUP_TYPE c_oigt = EntityFactroy.create_ORDER_ITEM_GROUP_TYPE(query.get(0), "100", "�½��ͻ�");
	c_oigt.setCust_order_id(cot.getM_cust_order_id());
	c_oigt.setAccept_time(cot.getAccept_time());

	// �˻�������ʵ��
	ORDER_ITEM_GROUP_TYPE a_oigt = EntityFactroy.create_ORDER_ITEM_GROUP_TYPE(query.get(0), "200", "�½��˻�");
	c_oigt.setCust_order_id(cot.getM_cust_order_id());
	c_oigt.setAccept_time(cot.getAccept_time());

	// ��Ʒ������ʵ��
	ORDER_ITEM_GROUP_TYPE p_oigt = EntityFactroy.create_ORDER_ITEM_GROUP_TYPE(query.get(0), "300", "��Ʒ��װ");
	c_oigt.setCust_order_id(cot.getM_cust_order_id());
	c_oigt.setAccept_time(cot.getAccept_time());

	// �ͻ�ʵ��
	Customer customer = EntityFactroy.create_Customer(query.get(0));
	customer.setCustomerId(cot.getM_cust_id());

	// �˻�ʵ��
	ACCOUNT at = EntityFactroy.create_ACCOUNT(query.get(0));
	at.setCust_id(cot.getM_cust_id());

	// ֧����ʽʵ��
	Payment pt = EntityFactroy.create_Payment(query.get(0));
	pt.setAccountId(at.getAccount_id());

	// ��Ʒʵ��
	Product product = EntityFactroy.create_Product(query.get(0),accBbr);
	
	
	String xmlId = "5000000100" + GetTimeString() + GetUUNum();
	String xmlString = GetForm(xmlId, BaseString.SAVE_CUSTOMER_ORDER_REQ_TYPE("101", cot) + 
		//BaseString.ADD_ORDER_ITEM_GROUP_REQ_TYPE("102", c_oigt) + 
		//KHString.ADD_CUST_REQ_TYPE3("103", c_oigt.getOrder_item_group_id(), customer) + 
		//CUST_CERTString.ADD_CUST_CERT_REQ_TYPE("104", c_oigt.getOrder_item_group_id(), cot) + 
		//BaseString.ADD_ORDER_ITEM_GROUP_REQ_TYPE("105", a_oigt) + 
		//KHString.ADD_ACCOUNT_REQ_TYPE5("106", a_oigt.getOrder_item_group_id(), at) + 
		//KHString.ADD_PAYMENT_PLAN_REQ_TYPE6("107", a_oigt.getOrder_item_group_id(), pt) + 
		BaseString.ADD_ORDER_ITEM_GROUP_REQ_TYPE("108", p_oigt) + 
		KHString.SAVE_PROD_INST_REQ_TYPE10("109", p_oigt.getOrder_item_group_id(), product,cot,at) + 
		KHString.SAVE_PROD_INST_ACCT_REQ_TYPE11("110", p_oigt.getOrder_item_group_id()));

	try {
	    //������װ���ģ�����ȡ���ؽ��
//	    backMess = WSTools.SyncMess(xmlString);
	} catch (Exception e) {
	    e.printStackTrace();
	    backMess = "9";
	}

	// ת�����ݣ������е�װ������־Form
	WebServiceLogForm f = GetWebServiceLogForm(query.get(0), backMess, "anzhuang",cot.getM_cust_id(), xmlId, xmlString);
	// ��¼�ӿڵ�����־
	WebServiceService.InsertWebServiceLog(f);
	return backMess;
    }

    /**
     * ����
     * 
     * @return
     */
    public static String XuFei(DataSet<DataRow> query) {
	String backMess = "0";
	return backMess;
    }

    /**
     * �˵�
     * 
     * @return
     */
    public static String TuiDan(DataSet<DataRow> query) {
	String backMess = "0";
	return backMess;
    }
    
    /**
     * ͣ��
     * 
     * @return
     */
    public static String Tingji(DataRow dataRow) {
	String backMess = "0";
	// �ͻ�����ʵ��
	CUSTOMER_ORDER_TYPE cot = EntityFactroy.create_CUSTOMER_ORDER_TYPE(dataRow);
	cot.setM_cust_id(":getCustIdByAccNbr(22003,022," + dataRow.getDataElement("wangluoip").getString() + ",9)");
	// ͣ�����������
	ORDER_ITEM_GROUP_TYPE t_oigt = EntityFactroy.create_ORDER_ITEM_GROUP_TYPE(dataRow, "301", "ͣ��");
	t_oigt.setCust_order_id(cot.getM_cust_order_id());
	// ��Ʒʵ��
	Product product = EntityFactroy.create_Product(dataRow);
	
	String xmlId = "5000000100" + GetTimeString() + GetUUNum();
	String xmlString = GetForm(xmlId, 
		BaseString.SAVE_CUSTOMER_ORDER_REQ_TYPE_forTrade("401", cot) + 
		BaseString.ADD_ORDER_ITEM_GROUP_REQ_TYPE("402", t_oigt) + 
		TingJi.MOD_PROD_INST_REQ_TYPE("403", t_oigt.getOrder_item_group_id(), product));
	try {
	    backMess = WSTools.SyncMess(xmlString);
	} catch (Exception e) {
	    e.printStackTrace();
	    backMess = "9";
	}

	// ת������
	WebServiceLogForm f = GetWebServiceLogForm(dataRow, backMess, "tingji",cot.getM_cust_id(), xmlId, xmlString);
	// ��¼�ӿڵ�����־
	WebServiceService.InsertWebServiceLog(f);
	return backMess;
    }
    
    
    /**
     *����
     * 
     * @return
     */
    public static String Fuji(DataRow dataRow) {
	String backMess = "0";
	// �ͻ�����ʵ��
	CUSTOMER_ORDER_TYPE cot = EntityFactroy.create_CUSTOMER_ORDER_TYPE(dataRow);
	cot.setM_cust_id(":getCustIdByAccNbr(22003,022," + dataRow.getDataElement("wangluoip").getString() + ",9)");
	//�������������
	ORDER_ITEM_GROUP_TYPE f_oigt = EntityFactroy.create_ORDER_ITEM_GROUP_TYPE(dataRow, "302", "����");
	f_oigt.setCust_order_id(cot.getM_cust_order_id());
	// ��Ʒʵ��
	Product product = EntityFactroy.create_Product(dataRow);
	String xmlId = "5000000100" + GetTimeString() + GetUUNum();
	String xmlString = GetForm(xmlId, 
		BaseString.SAVE_CUSTOMER_ORDER_REQ_TYPE_forTrade("501", cot) + 
		BaseString.ADD_ORDER_ITEM_GROUP_REQ_TYPE("502", f_oigt) + 
		FuJi.MOD_PROD_INST_REQ_TYPE("503", f_oigt.getOrder_item_group_id(), product));
	try {
//	    backMess = WSTools.SyncMess(xmlString);
	} catch (Exception e) {
	    e.printStackTrace();
	    backMess = "9";
	}

	// ת������
	WebServiceLogForm f = GetWebServiceLogForm(dataRow, backMess, "fuji",cot.getM_cust_id(), xmlId, xmlString);
	// ��¼�ӿڵ�����־
	WebServiceService.InsertWebServiceLog(f);
	return backMess;
    }
    
    /**
     * �ı�����ImportDataService 1466
     * 
     * @return
     */
    public static String ChangeSL(DataSet<DataRow> query,String val, String oldVal) {
	String backMess = "0";
	DataRow dataRow = query.get(0);
	if("10m".equals(val)||"10M".equals(val)||"12m".equals(val)||"12M".equals(val)) {
		val = "12M";
	}
	// �ͻ�����ʵ��
	CUSTOMER_ORDER_TYPE cot = EntityFactroy.create_CUSTOMER_ORDER_TYPE(dataRow);
	cot.setM_cust_id(":getCustIdByAccNbr(22003,022," + dataRow.getDataElement("wangluoip").getString() + ",9)");
	// �޸����붩�������
	ORDER_ITEM_GROUP_TYPE c_oigt = EntityFactroy.create_ORDER_ITEM_GROUP_TYPE(dataRow, "304", "�޸��û�����");
	c_oigt.setCust_order_id(cot.getM_cust_order_id());

	// ��Ʒʵ��
	Product product = EntityFactroy.create_Product(dataRow);

	String xmlId = "5000000100" + GetTimeString() + GetUUNum();
	String xmlString = GetForm(xmlId, 
		BaseString.SAVE_CUSTOMER_ORDER_REQ_TYPE_forTrade("601", cot) + 
		BaseString.ADD_ORDER_ITEM_GROUP_REQ_TYPE("602", c_oigt) + 
		ChangeSuLv.MOD_PROD_INST_REQ_TYPE("603", c_oigt.getOrder_item_group_id(), product, val, oldVal));
	try {
//	    backMess = WSTools.SyncMess(xmlString);
	} catch (Exception e) {
	    e.printStackTrace();
	    backMess = "9";
	}

	// ת������
	WebServiceLogForm f = GetWebServiceLogForm(query.get(0), backMess, "changeSL",cot.getM_cust_id(), xmlId, xmlString);
	// ��¼�ӿڵ�����־
	WebServiceService.InsertWebServiceLog(f);
	return backMess;
    }
    

    /**
     * �޸�����com.stock.yonghushuju.ImportDataService;daiXiugai()
     * 
     * @return
     */
    public static String ChangePwd(DataSet<DataRow> query) {
	String backMess = "0";
	DataRow dataRow = query.get(0);
	// �ͻ�����ʵ��
	CUSTOMER_ORDER_TYPE cot = EntityFactroy.create_CUSTOMER_ORDER_TYPE(dataRow);
	cot.setM_cust_id(":getCustIdByAccNbr(22003,022," + dataRow.getDataElement("wangluoip").getString() + ",9)");

	// �޸����붩�������
	ORDER_ITEM_GROUP_TYPE c_oigt = EntityFactroy.create_ORDER_ITEM_GROUP_TYPE(dataRow, "303", "�޸��û�����");
	c_oigt.setCust_order_id(cot.getM_cust_order_id());

	// ��Ʒʵ��
	Product product = EntityFactroy.create_Product(dataRow);

	String xmlId = "5000000100" + GetTimeString() + GetUUNum();
	String xmlString = GetForm(xmlId, 
		BaseString.SAVE_CUSTOMER_ORDER_REQ_TYPE_forTrade("201", cot) + 
		BaseString.ADD_ORDER_ITEM_GROUP_REQ_TYPE("202", c_oigt) + 
		ChangePWD.MOD_PROD_INST_REQ_TYPE("203", c_oigt.getOrder_item_group_id(), product));
	try {
//	    backMess = WSTools.SyncMess(xmlString);
	} catch (Exception e) {
	    e.printStackTrace();
	    backMess = "9";
	}

	// ת������
	WebServiceLogForm f = GetWebServiceLogForm(query.get(0), backMess, "changePwd",cot.getM_cust_id(), xmlId, xmlString);
	// ��¼�ӿڵ�����־
	WebServiceService.InsertWebServiceLog(f);
	return backMess;
    }

    /**
     * �˶�
     * 
     * @return
     */
    public static String TuiDing(DataSet<DataRow> query) {
	String backMess = "0";
	DataRow dataRow = query.get(0);
	// �ͻ�����ʵ��
	CUSTOMER_ORDER_TYPE cot = EntityFactroy.create_CUSTOMER_ORDER_TYPE(dataRow);
	cot.setM_cust_id(":getCustIdByAccNbr(22003,022," + dataRow.getDataElement("wangluoip").getString() + ",9)");
	// ������������
	ORDER_ITEM_GROUP_TYPE c_oigt = EntityFactroy.create_ORDER_ITEM_GROUP_TYPE(dataRow, "305", "���");
	// ��Ʒʵ��
	Product product = EntityFactroy.create_Product(dataRow);

	String xmlId = "5000000100" + GetTimeString() + GetUUNum();
	String xmlString = GetForm(xmlId, 
		BaseString.SAVE_CUSTOMER_ORDER_REQ_TYPE_forTrade("301", cot) + 
		BaseString.ADD_ORDER_ITEM_GROUP_REQ_TYPE("302", c_oigt) + 
		ChaiJi.DEL_PROD_INST_REQ_TYPE("303", c_oigt.getOrder_item_group_id(), product));
	try {
//	    backMess = WSTools.SyncMess(xmlString);
	} catch (Exception e) {
	    e.printStackTrace();
	    backMess = "9";
	}

	// ת������
	WebServiceLogForm f = GetWebServiceLogForm(query.get(0), backMess, "tuiding",cot.getM_cust_id(), xmlId, xmlString);
	// ��¼�ӿڵ�����־
	WebServiceService.InsertWebServiceLog(f);
	return backMess;
    }

    /**
     * �������ݿ��DataRowת����WebServiveLogForm
     * 
     * @param obj
     * @return
     */
    private static WebServiceLogForm GetWebServiceLogForm(DataRow obj, String backMess, String operate,String userId,String xmlId, String xmlString) {
	WebServiceLogForm f = new WebServiceLogForm();

	f.setUUID(obj.getDataElement("uuid").getString());
	f.setXiaoqu(obj.getDataElement("xiaoqu").getString());
	f.setDizhi(obj.getDataElement("dizhi").getString());
	f.setLogState("0");
//	f.setYonghuzhuangtai(obj.getDataElement("yonghuzhuangtai").getString());
	
	f.setTradeDetail(obj.getDataElement("yewu").getString());
	f.setDaikuan(obj.getDataElement("wangluo").getString());
	f.setTradeAccount(obj.getDataElement("wangluoip").getString());
	if ("anzhuang".equals(operate)) {
	    f.setInterfaceDetail("�����˵��Žӿڣ�ִ�а�װ��Ϣͬ��������");
	    f.setYonghuzhuangtai("��װ");
	} else if ("changePwd".equals(operate)) {
	    f.setInterfaceDetail("�����˵��Žӿڣ�ִ���޸�����ͬ��������");
	    f.setYonghuzhuangtai("�޸�����");
	} else if ("changeSL".equals(operate)) {
	    f.setInterfaceDetail("�����˵��Žӿڣ�ִ���޸�ҵ��ͬ��������");
	    f.setYonghuzhuangtai("����");
	} else if ("tuiding".equals(operate)) {
	    f.setInterfaceDetail("�����˵��Žӿڣ�ִ���˶�ͬ��������");
	    f.setYonghuzhuangtai("�˶�");
	} else if ("tingji".equals(operate)) {
	    f.setInterfaceDetail("�����˵��Žӿڣ�ִ��ͣ������ͬ��������");
	    f.setYonghuzhuangtai("ͣ��");
	} else if ("fuji".equals(operate)) {
	    f.setInterfaceDetail("�����˵��Žӿڣ�ִ�и���ͬ��������");
	    f.setYonghuzhuangtai("����");
	}
	if ("0".equals(backMess)) {
	    f.setInterfaceResult("1");
	    f.setXmlState("0");
	} else {
	    f.setInterfaceResult("����ʧ�ܣ�");
	    f.setXmlState("3");

	}
	f.setCreateDt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	f.setUserId(userId);
	f.setXmlId(xmlId);
	f.setXmlString(xmlString);

	return f;
    }
}
