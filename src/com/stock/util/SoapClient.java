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
 * ����������ģ��ͻ���A-����������ߣ�ͨ������ģ��ͻ��˷���SOAP���ĸ�IPTV��
 * ͬʱ��IPTV����Ӧ���Ĵ�ӡ����
 * @author tfkj-lhh
 *
 */
public class SoapClient{
	
	/**
	 * �޸��û�״̬
	 * @param userId  �û�ID
	 * @param status  ״̬
	 * @throws Exception
	 */
	public static IptvlogEidtForm updateUserStatus(String userId, String status, String invaliDate, String serverip,String isweb) throws Exception{
		WeihuService iptvlogService = new WeihuService();
		/*
		 * ������־��¼
		 */
		IptvlogEidtForm f1 =  new IptvlogEidtForm();
		f1.setTingjishijian(invaliDate);
		f1.setTingjizhanghao(userId);
		f1.setShifouchenggong("���ͳɹ�");
		f1.setShibaibianhao("");
		f1.setShibaixinxi("");
		f1.setCreatedt(Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		f1.setServerip(serverip);
		f1.setInterfaceType(status.equals("1")?"����":"ͣ��");
		f1.setIsweb(isweb);
		iptvlogService.insertIptvlog(f1);
		//�������ض���
		IptvlogEidtForm f =  new IptvlogEidtForm();
		// ��������
		// ==================================================
		SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection connection = soapConnFactory.createConnection();

		//������Ϣ����
		// ===========================================
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage message = messageFactory.createMessage();
		//������Ϣ�����ʽ����ע�ͣ�
		//message.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "gb2312");

		// ����soap��Ϣ����==========================================
		SOAPPart soapPart = message.getSOAPPart();
		// ����soap����
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.setAttribute("xmlns:SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
		envelope.setAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
		envelope.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		envelope.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
		envelope.setAttribute("xmlns:sam", "http://www.utstar.com/web_service/SAM.wsdl");
		SOAPBody body = envelope.getBody();
		body.setAttribute("encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");
		//  ���ݽӿ��ĵ�����Ҫ����IPTV�Ĳ�����������Ϣbody���ݡ�������������òο�IPTV����ƽ̨�û�����ӿڹ淶V1.1
		// =====================================
		
		SOAPElement bodyElement = body.addChildElement("sam:mes-ChangeStatus");
		SOAPElement stClientInfo = bodyElement.addChildElement("stClientInfo");
		stClientInfo.setAttribute("xsi:type", "sam:ClientInfo");
		//�ͻ��˵�¼ID
		SOAPElement ClientID = stClientInfo.addChildElement("ClientID");
		ClientID.setAttribute("xsi:type", "xsd:string");
		ClientID.addTextNode("auto");
		//�ͻ��˵�¼����
		SOAPElement ClientPassword = stClientInfo.addChildElement("ClientPassword");
		ClientPassword.setAttribute("xsi:type", "xsd:string");
		ClientPassword.addTextNode("Tfkj-6543210");
		//�ͻ��˵�¼IP
		SOAPElement IPAddress = stClientInfo.addChildElement("IPAddress");
		IPAddress.setAttribute("xsi:type", "xsd:string");
		//�ͻ��˵�¼�汾
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
		//�������ͣ�-1��ʾ��ͨ���󣬴���ɹ�ʱ����ִ�У�
		SOAPElement TransactionFlag = stTransactionInfo.addChildElement("TransactionFlag");
		TransactionFlag.setAttribute("xsi:type", "xsd:int");
		TransactionFlag.addTextNode("-1");
		//�û����
		SOAPElement UserID = bodyElement.addChildElement("UserID");
		UserID.setAttribute("xsi:type", "xsd:string");
		UserID.addTextNode(userId);
		/*״̬
		0 �C�����ȱʡֵ��
		1 �Cʹ����
		2 �CǷ��ͣ��
		3 �C�û�����ͣ��
		4 �C��ע��
		5 �CǷ�Ѱ�ͣ�������ܹ���
		6 �C�û������ͣ�������ܹ���
		9 �C�û�ͣ����Ƿ�ѣ�Ԥ����
		10 �CԤ���
		*/
		SOAPElement Status = bodyElement.addChildElement("Status");
		Status.setAttribute("xsi:type", "xsd:string");
		Status.addTextNode(status);
		
		message.saveChanges();
		
		/*
		 * ʵ�ʵ���Ϣ��ʹ�� call()�������͵ģ��÷���������Ϣ�����Ŀ�ĵ���Ϊ�����������صڶ��� SOAPMessage ��Ϊ��Ӧ��
		 * call������message����Ϊ���͵�soap���ģ�urlΪiptv�������˿ڵ�ַ��
		 */
		URL url = new URL(serverip);//�·�����
		// ��Ӧ��Ϣ
		// ===========================================================================
		SOAPMessage reply=null;
//		SOAPMessage reply = connection.call(message, url);
		connection.close();
		/*
		 * ģ��ͻ���A���쳣�������
		 */
		SOAPBody ycBody = reply.getSOAPBody();
		String ErrorCode = ycBody.getElementsByTagName("ErrorCode").item(0).getTextContent();
		String ErrorMsg = ycBody.getElementsByTagName("ErrorMsg").item(0).getTextContent();
		if("0".equals(ErrorCode)){
			f.setShifouchenggong("�ɹ�");//ִ�гɹ�
		}
		else{
			f.setShifouchenggong("ʧ��");//ִ��ʧ��
		}
		f.setShibaibianhao(ErrorCode);//ʧ�ܱ��
		f.setShibaixinxi(ErrorMsg);//ʧ����Ϣ
		return f;
	}
	
	/**
	 * �����û�
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception{
		// ��������
		// ==================================================
		SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection connection = soapConnFactory.createConnection();

		//������Ϣ����
		// ===========================================
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage message = messageFactory.createMessage();
		//������Ϣ�����ʽ����ע�ͣ�
		//message.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "gb2312");

		// ����soap��Ϣ����==========================================
		SOAPPart soapPart = message.getSOAPPart();
		// ����soap����
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.setAttribute("xmlns:SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
		envelope.setAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
		envelope.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		envelope.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
		envelope.setAttribute("xmlns:sam", "http://www.utstar.com/web_service/SAM.wsdl");
		SOAPBody body = envelope.getBody();
		body.setAttribute("encodingStyle", "http://schemas.xmlsoap.org/soap/encoding/");
		//  ���ݽӿ��ĵ�����Ҫ����IPTV�Ĳ�����������Ϣbody���ݡ�������������òο�IPTV����ƽ̨�û�����ӿڹ淶V1.1
		// =====================================
		
		
		
//-----------------------------------IPTV���ԣ������û���------------------------------------
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
		//�������ͣ�-1��ʾ��ͨ���󣬴���ɹ�ʱ����ִ�У�
		SOAPElement TransactionFlag = stTransactionInfo.addChildElement("TransactionFlag");
		TransactionFlag.setAttribute("xsi:type", "xsd:int");
		TransactionFlag.addTextNode("-1");
		//�û����
		SOAPElement UserID = bodyElement.addChildElement("UserID");
		UserID.setAttribute("xsi:type", "xsd:string");
		UserID.addTextNode("99999999");
		SOAPElement Status = bodyElement.addChildElement("Status");
		Status.setAttribute("xsi:type", "xsd:string");
		Status.addTextNode("1");
//		SOAPElement stUserInfo = bodyElement.addChildElement("stUserInfo");
//		stUserInfo.setAttribute("xsi:type", "sam:mes-UserInfo");
//		//�û����
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
//		/*��Ʒ������
//		1:package1
//        2:HDpackages
//        3:SDpackages
//        4:Test*/
//		SOAPElement PackageOrderCode = stUserInfo.addChildElement("PackageOrderCode");
//		PackageOrderCode.setAttribute("xsi:type", "xsd:string");
//		PackageOrderCode.addTextNode("2");
//		
//-------------------------------------IPTV���� END------------------------------------
		
		message.saveChanges();
		// ��ӡ�ͻ��˷�����soap���ģ�����֤����
		System.out.println(" REQUEST: ");
		message.writeTo(System.out);
		System.out.println(" ");
		/*
		 * ʵ�ʵ���Ϣ��ʹ�� call()�������͵ģ��÷���������Ϣ�����Ŀ�ĵ���Ϊ�����������صڶ��� SOAPMessage ��Ϊ��Ӧ��
		 * call������message����Ϊ���͵�soap���ģ�urlΪiptv�������˿ڵ�ַ��
		 */
		URL url = new URL("http://10.104.0.6:8500/");//�·�����
//		URL url = new URL("http://10.103.0.6:8500/");//�Ϸ�����
		// ��Ӧ��Ϣ
		// ===========================================================================
		SOAPMessage reply = connection.call(message, url);
		//reply.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "gb2312");
		// ��ӡ����˷��ص�soap���Ĺ�����
		System.out.println("RESPONSE:");
		// ==================����soap��Ϣת������
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		//======================��ȡ��Ϣ����
		Source sourceContent = reply.getSOAPPart().getContent();
		// Set the output for the transformation
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);
		//�ر����� ==============
		System.out.println("");
		connection.close();
		/*
		 * ģ��ͻ���A���쳣�������
		 */
		SOAPBody ycBody = reply.getSOAPBody();
		
//		SOAPElement bodyElement1 = ycBody.addChildElement("sam:mes-ChangeStatus");
//		SOAPElement stClientInfo1 = bodyElement1.addChildElement("stClientInfo");
//		stClientInfo1.setAttribute("xsi:type", "sam:ClientInfo");
//		SOAPElement ClientID1 = stClientInfo1.addChildElement("ClientID");
//		ClientID1.setAttribute("xsi:type", "xsd:string");
//		ClientID1.addTextNode("auto");
		System.out.print("��������ﵽ�Ķ�:"+ycBody.getElementsByTagName("ErrorCode").item(0).getTextContent());
		System.out.print("��������ﵽ�Ķ�:"+ycBody.getElementsByTagName("ErrorMsg").item(0).getTextContent());
		Node ycResp = ycBody.getFirstChild();
		System.out.print("   returnValue:"+ycResp.getTextContent());
	}
}

