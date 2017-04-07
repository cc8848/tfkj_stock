package com.stock.util;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

import com.stock.weihu.IptvlogEidtForm;
import com.stock.weihu.WeihuService;
import com.takucin.aceeci.util.Common;

/**
 * 功能描述：模拟客户端A-即服务调用者，通过该类模拟客户端发送SOAP报文给IPTV，
 * 同时把IPTV的响应报文打印出来
 * @author tfkj-lhh
 *
 */
public class SoapClient{
	
	/**
	 * 修改用户状态
	 * @param userId  用户ID
	 * @param status  状态
	 * @throws Exception
	 */
	public static IptvlogEidtForm updateUserStatus(String userId, String status, String invaliDate, String serverip,String isweb) throws Exception{
		WeihuService iptvlogService = new WeihuService();
		/*
		 * 发送日志记录
		 */
		IptvlogEidtForm f1 =  new IptvlogEidtForm();
		f1.setTingjishijian(invaliDate);
		f1.setTingjizhanghao(userId);
		f1.setShifouchenggong("发送成功");
		f1.setShibaibianhao("");
		f1.setShibaixinxi("");
		f1.setCreatedt(Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		f1.setServerip(serverip);
		f1.setInterfaceType(status.equals("1")?"复机":"停机");
		f1.setIsweb(isweb);
		iptvlogService.insertIptvlog(f1);
		//创建返回对象
		IptvlogEidtForm f =  new IptvlogEidtForm();
		// 创建连接
		// ==================================================
		SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection connection = soapConnFactory.createConnection();

		//创建消息对象
		// ===========================================
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage message = messageFactory.createMessage();
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
		
		SOAPElement bodyElement = body.addChildElement("sam:mes-ChangeStatus");
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
		
		/*
		 * 实际的消息是使用 call()方法发送的，该方法接收消息本身和目的地作为参数，并返回第二个 SOAPMessage 作为响应。
		 * call方法的message对象为发送的soap报文，url为iptv服务器端口地址。
		 */
		URL url = new URL(serverip);//新服务器
		// 响应消息
		// ===========================================================================
		SOAPMessage reply=null;
//		SOAPMessage reply = connection.call(message, url);
		connection.close();
		/*
		 * 模拟客户端A，异常处理测试
		 */
		SOAPBody ycBody = reply.getSOAPBody();
		String ErrorCode = ycBody.getElementsByTagName("ErrorCode").item(0).getTextContent();
		String ErrorMsg = ycBody.getElementsByTagName("ErrorMsg").item(0).getTextContent();
		if("0".equals(ErrorCode)){
			f.setShifouchenggong("成功");//执行成功
		}
		else{
			f.setShifouchenggong("失败");//执行失败
		}
		f.setShibaibianhao(ErrorCode);//失败编号
		f.setShibaixinxi(ErrorMsg);//失败信息
		return f;
	}
	
	/**
	 * 创建用户
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception{
		// 创建连接
		// ==================================================
		SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection connection = soapConnFactory.createConnection();

		//创建消息对象
		// ===========================================
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage message = messageFactory.createMessage();
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
		
		
		
//-----------------------------------IPTV测试（创建用户）------------------------------------
		SOAPElement bodyElement = body.addChildElement("sam:mes-ChangeStatus");
		SOAPElement stClientInfo = bodyElement.addChildElement("stClientInfo");
		stClientInfo.setAttribute("xsi:type", "sam:ClientInfo");
		SOAPElement ClientID = stClientInfo.addChildElement("ClientID");
		ClientID.setAttribute("xsi:type", "xsd:string");
		ClientID.addTextNode("auto");
		SOAPElement ClientPassword = stClientInfo.addChildElement("ClientPassword");
		ClientPassword.setAttribute("xsi:type", "xsd:string");
		ClientPassword.addTextNode("Tfkj-6543210");
		SOAPElement IPAddress = stClientInfo.addChildElement("IPAddress");
		IPAddress.setAttribute("xsi:type", "xsd:string");
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
		UserID.addTextNode("99999999");
		SOAPElement Status = bodyElement.addChildElement("Status");
		Status.setAttribute("xsi:type", "xsd:string");
		Status.addTextNode("1");
//		SOAPElement stUserInfo = bodyElement.addChildElement("stUserInfo");
//		stUserInfo.setAttribute("xsi:type", "sam:mes-UserInfo");
//		//用户编号
//		SOAPElement UserID = stUserInfo.addChildElement("UserID");
//		UserID.setAttribute("xsi:type", "xsd:string");
//		UserID.addTextNode("999996");
//		
//		SOAPElement SubCategory = stUserInfo.addChildElement("SubCategory");
//		SubCategory.setAttribute("xsi:type", "xsd:int");
//		SubCategory.addTextNode("1");
//		
//		SOAPElement ChargeMode = stUserInfo.addChildElement("ChargeMode");
//		ChargeMode.setAttribute("xsi:type", "xsd:int");
//		ChargeMode.addTextNode("2");
//		
//		SOAPElement Password = stUserInfo.addChildElement("Password");
//		Password.setAttribute("xsi:type", "xsd:string");
//		Password.addTextNode("111111");
//		/*产品包代码
//		1:package1
//        2:HDpackages
//        3:SDpackages
//        4:Test*/
//		SOAPElement PackageOrderCode = stUserInfo.addChildElement("PackageOrderCode");
//		PackageOrderCode.setAttribute("xsi:type", "xsd:string");
//		PackageOrderCode.addTextNode("2");
//		
//-------------------------------------IPTV测试 END------------------------------------
		
		message.saveChanges();
		// 打印客户端发出的soap报文，做验证测试
		System.out.println(" REQUEST: ");
		message.writeTo(System.out);
		System.out.println(" ");
		/*
		 * 实际的消息是使用 call()方法发送的，该方法接收消息本身和目的地作为参数，并返回第二个 SOAPMessage 作为响应。
		 * call方法的message对象为发送的soap报文，url为iptv服务器端口地址。
		 */
		URL url = new URL("http://10.104.0.6:8500/");//新服务器
//		URL url = new URL("http://10.103.0.6:8500/");//老服务器
		// 响应消息
		// ===========================================================================
		SOAPMessage reply = connection.call(message, url);
		//reply.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "gb2312");
		// 打印服务端返回的soap报文供测试
		System.out.println("RESPONSE:");
		// ==================创建soap消息转换对象
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		//======================提取消息内容
		Source sourceContent = reply.getSOAPPart().getContent();
		// Set the output for the transformation
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);
		//关闭连接 ==============
		System.out.println("");
		connection.close();
		/*
		 * 模拟客户端A，异常处理测试
		 */
		SOAPBody ycBody = reply.getSOAPBody();
		
//		SOAPElement bodyElement1 = ycBody.addChildElement("sam:mes-ChangeStatus");
//		SOAPElement stClientInfo1 = bodyElement1.addChildElement("stClientInfo");
//		stClientInfo1.setAttribute("xsi:type", "sam:ClientInfo");
//		SOAPElement ClientID1 = stClientInfo1.addChildElement("ClientID");
//		ClientID1.setAttribute("xsi:type", "xsd:string");
//		ClientID1.addTextNode("auto");
		System.out.print("啊啊啊额达到的饿:"+ycBody.getElementsByTagName("ErrorCode").item(0).getTextContent());
		System.out.print("啊啊啊额达到的饿:"+ycBody.getElementsByTagName("ErrorMsg").item(0).getTextContent());
		Node ycResp = ycBody.getFirstChild();
		System.out.print("   returnValue:"+ycResp.getTextContent());
	}
}

