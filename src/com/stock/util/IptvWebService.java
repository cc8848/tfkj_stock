package com.stock.util;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.stock.weihu.IptvlogEidtForm;
import com.takucin.aceeci.frame.ContainerManager;
import com.takucin.aceeci.frame.model.ParameterModel;

import javax.xml.soap.*;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能描述：模拟客户端A-即服务调用者，通过该类模拟客户端发送SOAP报文给IPTV，
 * 同时把IPTV的响应报文打印出来
 * @author tfkj-lhh
 *
 */
public class IptvWebService {
	//	public static String getServerIp() {
////		return "http://10.104.0.6:8500/";
//		return "http://10.103.0.6:8500/";
//	}
	private static CommonDao dao = new CommonDao();
	/**
	 * 停机
	 * @return
	 */
	public static String tingJi(String userId,String serverip,String isweb){
		IptvlogEidtForm log=new IptvlogEidtForm();
		log.setTingjizhanghao(userId);
		log.setInterfaceType("停机");
		log.setTingjishijian(new Date().toString());
		log.setServerip(serverip);
		log.setIsweb(isweb);
		try{
			// 创建连接
			// ==================================================
			SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = soapConnFactory.createConnection();

			//创建消息对象
			// ===========================================
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();
			buildHead(message);

			createBody(message,userId,"2");

			return excute(connection,message,log,serverip);
		}catch (Exception e){
			e.printStackTrace();
			log.setShifouchenggong("失败");
			log.setShibaixinxi(e.getMessage());
			log(log);
			return "FAIL";
		}
	}

	/**
	 * 复机
	 * @return
	 */
	public static String fuJi(String userId,String serverip,String startDate,String isweb){
		IptvlogEidtForm log=new IptvlogEidtForm();
		log.setTingjizhanghao(userId);
		log.setInterfaceType("复机");
		log.setTingjishijian(startDate);
		log.setServerip(serverip);
		log.setIsweb(isweb);
		try{
			// 创建连接
			// ==================================================
			SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = soapConnFactory.createConnection();

			//创建消息对象
			// ===========================================
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();
			buildHead(message);
			createBody(message,userId,"1");


			return  excute(connection,message,log,serverip);
		}catch (Exception e){
			e.printStackTrace();
			log.setShifouchenggong("失败");
			log.setShibaixinxi(e.getMessage());
			log(log);
			return "FAIL";

		}

	}


	public static String excute(SOAPConnection connection,SOAPMessage message,IptvlogEidtForm log,String serverip) throws Exception {
		/*
		 * 实际的消息是使用 call()方法发送的，该方法接收消息本身和目的地作为参数，并返回第二个 SOAPMessage 作为响应。
		 * call方法的message对象为发送的soap报文，url为iptv服务器端口地址。
		 */
		//先打印发送成功的log
		log.setShifouchenggong("发送成功");

		log(log);
		URL url = new URL(serverip);//新服务器
		// 响应消息
		// ===========================================================================
//		SOAPMessage reply = connection.call(message, url);
		connection.close();
		/*
		 * 模拟客户端A，异常处理测试
		 */
//		SOAPBody ycBody = reply.getSOAPBody();
//		String ErrorCode = ycBody.getElementsByTagName("ErrorCode").item(0).getTextContent();
//		String ErrorMsg = ycBody.getElementsByTagName("ErrorMsg").item(0).getTextContent();
		String ErrorCode = "0";
		String ErrorMsg = "0";
		if("0".equals(ErrorCode)){
			log.setShifouchenggong("成功");//执行成功
		}
		else{
			log.setShifouchenggong("失败");//执行失败
		}

		log.setShibaibianhao(ErrorCode);//失败编号
		log.setShibaixinxi(ErrorMsg);//失败信息

		log(log);
		return "0".equals(ErrorCode)?"SUCCESS":"FAIL";
	}
	public static void buildHead(SOAPMessage message) throws Exception {
		//用于消息编码格式（已注释）
		//message.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "gb2312");

		// 创建soap消息主体==========================================
		SOAPPart soapPart = message.getSOAPPart();
		// 创建soap部分
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.setAttribute("xmlns:SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
		envelope.setAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
		envelope.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		envelope.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
		envelope.setAttribute("xmlns:sam", "http://www.utstar.com/web_service/SAM.wsdl");
		SOAPBody body = envelope.getBody();
		body.setAttribute("encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");
		//  根据接口文档根据要传给IPTV的参数，创建消息body内容。具体参数的配置参考IPTV播控平台用户管理接口规范V1.1
		// =====================================

	}
	public static void createBody(SOAPMessage message,String userId,String status) throws Exception {
		SOAPElement bodyElement = message.getSOAPPart().getEnvelope().getBody().addChildElement("sam:mes-ChangeStatus");
		SOAPElement stClientInfo = bodyElement.addChildElement("stClientInfo");
		stClientInfo.setAttribute("xsi:type", "sam:ClientInfo");
		//客户端登录ID
		SOAPElement ClientID = stClientInfo.addChildElement("ClientID");
		ClientID.setAttribute("xsi:type", "xsd:string");
		ClientID.addTextNode("auto");
		//客户端登录密码
		SOAPElement ClientPassword = stClientInfo.addChildElement("ClientPassword");
		ClientPassword.setAttribute("xsi:type", "xsd:string");
		ClientPassword.addTextNode("Tfkj-6543210");
		//客户端登录IP
		SOAPElement IPAddress = stClientInfo.addChildElement("IPAddress");
		IPAddress.setAttribute("xsi:type", "xsd:string");
		//客户端登录版本
		SOAPElement InterfaceVersion = stClientInfo.addChildElement("InterfaceVersion");
		InterfaceVersion.setAttribute("xsi:type", "xsd:int");
		InterfaceVersion.addTextNode("1");

		SOAPElement stTransactionInfo = bodyElement.addChildElement("stTransactionInfo");
		stTransactionInfo.setAttribute("xsi:type", "sam:TransactionInfo");
		SOAPElement StaffNo = stTransactionInfo.addChildElement("StaffNo");
		StaffNo.setAttribute("xsi:type", "xsd:string");
		SOAPElement SubsidiaryName = stTransactionInfo.addChildElement("SubsidiaryName");
		SubsidiaryName.setAttribute("xsi:type", "xsd:string");
		SOAPElement Sequence = stTransactionInfo.addChildElement("Sequence");
		Sequence.setAttribute("xsi:type", "xsd:int");
		SOAPElement TransactionID = stTransactionInfo.addChildElement("TransactionID");
		TransactionID.setAttribute("xsi:type", "xsd:string");
		//事务类型（-1表示普通请求，处理成功时它将执行）
		SOAPElement TransactionFlag = stTransactionInfo.addChildElement("TransactionFlag");
		TransactionFlag.setAttribute("xsi:type", "xsd:int");
		TransactionFlag.addTextNode("-1");
		//用户编号
		SOAPElement UserID = bodyElement.addChildElement("UserID");
		UserID.setAttribute("xsi:type", "xsd:string");
		UserID.addTextNode(userId);
		/*状态
		0 –待激活（缺省值）
		1 –使用中
		2 –欠费停机
		3 –用户申请停机
		4 –已注销
		5 –欠费半停机（不能购买）
		6 –用户申请半停机（不能购买）
		9 –用户停机和欠费（预留）
		10 –预拆机
		*/
		SOAPElement Status = bodyElement.addChildElement("Status");
		Status.setAttribute("xsi:type", "xsd:string");
		Status.addTextNode(status);

		message.saveChanges();
	}


	/**
	 * @param f
	 * @return
	 * @author billy by 20140919
	 */
	public static CommonMessage log(IptvlogEidtForm f) {
		try {
			ParameterModel model = new ParameterModel();
			model.put("tingjishijian", f.getTingjishijian());
			model.put("tingjizhanghao", 	f.getTingjizhanghao());
			model.put("shifouchenggong", 	f.getShifouchenggong());
			model.put("shibaibianhao", 	f.getShibaibianhao());
			model.put("shibaixinxi", 	f.getShibaixinxi());
			model.put("createdt", 	new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			model.put("serverip", 	f.getServerip());
			model.put("interfaceType", 	f.getInterfaceType());
			model.put("isweb",f.getIsweb());
			dao.insert("iptvlog", model);
			Connection conn = ContainerManager.currentConnection();
			if (conn != null) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加失败！");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "添加成功！");
	}

	public static void main(String[] args) {
//		System.out.println(IptvWebService.fuJi("1110005","http://10.104.0.6:8500/","2016-06-15"));
	}
}

