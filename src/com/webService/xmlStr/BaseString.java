package com.webService.xmlStr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import com.webService.entity.CUSTOMER_ORDER_TYPE;
import com.webService.entity.ORDER_ITEM_GROUP_TYPE;

public class BaseString {

    /**
     * 获取报文样式
     * 
     * @param KHString
     * @return
     */
    public static String GetForm(String xmlId, String SvcContString) {
	return "<ContractRoot><TcpCont>" + GetTcpContHead(xmlId) + "</TcpCont><SvcCont>" + SvcContString + "</SvcCont></ContractRoot>";
    }
    
    
    /**
     * 获取TcpCont开头
     * @return
     */
    public static String GetTcpContHead(String xmlId) {
	String KHHead = "<ActionCode>0</ActionCode><TransactionID>";
        //    <!--TransactionID生成规则：5000000100+YYYYMMDDHH24MISS+4位随机数字-->
	KHHead += xmlId;
	KHHead += "</TransactionID> <ServiceLevel>1</ServiceLevel> " +
			"<SrcOrgID>GD0000</SrcOrgID> " +
			"<SrcSysID>GD00000001</SrcSysID> " +
			"<SrcSysSign>1000000002</SrcSysSign> " +
			"<DstOrgID>609902</DstOrgID> " +
			"<DstSysID>6099020001</DstSysID><ReqTime>";
	//发起时间
	KHHead += GetTimeString();
	KHHead += "</ReqTime> <BusCode>BUSTJ001</BusCode> <ServiceCode>SVCTJ002</ServiceCode> <ServiceContractVer>SVCTJ00120140804</ServiceContractVer>";
	return KHHead;
    }
    
    
    /**
     * 保存客户订单
     * @param cot
     * @return
     */
    public static String SAVE_CUSTOMER_ORDER_REQ_TYPE(String soo_id,CUSTOMER_ORDER_TYPE cot) {
	String str = "<SOO type='SAVE_CUSTOMER_ORDER_REQ_TYPE'><PUB_REQ> " +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ><CUSTOMER_ORDER>";
	str += FlagString("CUST_ORDER_ID", "$-1$");
	str += FlagString("CHANNEL_ID", cot.getChannel_id());
	str += FlagString("CHANNEL_NB", cot.getChannel_nbr());
	str += FlagString("CHANNEL_NAME", cot.getChannel_name());
	str += FlagString("CUST_ID", "225009498001");
	str += FlagString("CUST_NAME", cot.getCust_name());
	str += FlagString("STAFF_ID", cot.getM_staff_id());
	str += FlagString("STAFF_NAME", cot.getStaff_name());
	str += FlagString("PRE_HANDLE_FLAG", "F");
	str += FlagString("REMARKS", cot.getRemarks());
	str += FlagString("ACCEPT_TIME", GetTimeString());
	str += FlagString("EXT_SYSTEM", "TJSJ001");
	str += FlagString("EXT_CUST_ORDER_ID", GetTimeString() + GetUUNum());
	str += FlagString("LAN_ID", cot.getM_lan_id());
	str += "</CUSTOMER_ORDER></SOO>";
	return str;
    }
    
    

    /**
     * 保存客户订单为二次业务的
     * @param cot
     * @return
     */
    public static String SAVE_CUSTOMER_ORDER_REQ_TYPE_forTrade(String soo_id,CUSTOMER_ORDER_TYPE cot) {
	String str = "<SOO type='SAVE_CUSTOMER_ORDER_REQ_TYPE'><PUB_REQ> " +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ><CUSTOMER_ORDER>";
	str += FlagString("CUST_ORDER_ID", "$-1$");
	str += FlagString("CUST_ID", "225009498001");
	str += FlagString("PRE_HANDLE_FLAG", "F");
	str += FlagString("EXT_CUST_ORDER_ID", GetTimeString() + GetUUNum());
	str += FlagString("LAN_ID", cot.getM_lan_id());
	str += FlagString("CHANNEL_ID", cot.getChannel_id());
	str += FlagString("CHANNEL_NAME", cot.getChannel_name());
	str += FlagString("STAFF_ID", cot.getM_staff_id());
	str += FlagString("STAFF_NAME", cot.getStaff_name());
	str += FlagString("EXT_SYSTEM", "TJSJ001");
	str += FlagString("REMARKS", cot.getRemarks());
	str += FlagString("ACCEPT_TIME", GetTimeString());
	str += "</CUSTOMER_ORDER></SOO>";
	return str;
    }
    
    /**
     * 订单项分组对象
     * @return
     */
    public static String ADD_ORDER_ITEM_GROUP_REQ_TYPE(String soo_id, ORDER_ITEM_GROUP_TYPE oigt) {
	String str = "<SOO type='ADD_ORDER_ITEM_GROUP_REQ_TYPE'><PUB_REQ> " +
		FlagString("SOO_ID", soo_id) + "</PUB_REQ><ORDER_ITEM_GROUP>";
	str += FlagString("ORDER_ITEM_GROUP_ID", oigt.getOrder_item_group_id());
	str += FlagString("CUST_ORDER_ID", "$-1$");
	str += FlagString("SERVICE_OFFER_ID", oigt.getService_offer_id());
	str += FlagString("SERVICE_OFFER_NAME", oigt.getService_offer_name());
	str += FlagString("ACCEPT_DATE", oigt.getAccept_time());
	str += "</ORDER_ITEM_GROUP></SOO>";
	return str;
    }
    
    

    /**
     * 获取一个四位随机码
     * 
     * @return
     */
    public static String GetUUNum() {
	return UUID.randomUUID().toString().replace("-", "").substring(0, 4);
    }
    
    /**
     * 获取一个32位随机码
     * 
     * @return
     */
    public static String GetUUID() {
	return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取时间字符串
     * 
     * @return
     */
    public static String GetTimeString() {
	return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
    
    
    /**
     * 12位唯一码
     */
    public static String Get12ID() {
	return new SimpleDateFormat("MMDDHHmm").format(new Date()) + GetUUNum();
    }

    /**
     * 属性标签
     * 
     * @return
     */
    public static String FlagString(String flagName, String flagValue) {
	return "<" + flagName + ">" + flagValue + "</" + flagName + ">";
    }

    public static String FlagString(String flagName, String flagValue, Map<String, String> valueMap) {
	String valueString = " ";
	Iterator<Entry<String, String>> iter = valueMap.entrySet().iterator();
	while (iter.hasNext()) {
	    Map.Entry entry = (Map.Entry) iter.next();
	    valueString += entry.getKey() + "='" + entry.getValue() + "' ";
	}
	return "<" + flagName + valueString + ">" + flagValue + "</" + flagName + ">";
    }
}
