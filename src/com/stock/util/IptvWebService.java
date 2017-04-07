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
 * ����������ģ��ͻ���A-����������ߣ�ͨ������ģ��ͻ��˷���SOAP���ĸ�IPTV��
 * ͬʱ��IPTV����Ӧ���Ĵ�ӡ����
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
	 * ͣ��
	 * @return
	 */
	public static String tingJi(String userId,String serverip,String isweb){
		IptvlogEidtForm log=new IptvlogEidtForm();
		log.setTingjizhanghao(userId);
		log.setInterfaceType("ͣ��");
		log.setTingjishijian(new Date().toString());
		log.setServerip(serverip);
		log.setIsweb(isweb);
		try{
			// ��������
			// ==================================================
			SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = soapConnFactory.createConnection();

			//������Ϣ����
			// ===========================================
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();
			buildHead(message);

			createBody(message,userId,"2");

			return excute(connection,message,log,serverip);
		}catch (Exception e){
			e.printStackTrace();
			log.setShifouchenggong("ʧ��");
			log.setShibaixinxi(e.getMessage());
			log(log);
			return "FAIL";
		}
	}

	/**
	 * ����
	 * @return
	 */
	public static String fuJi(String userId,String serverip,String startDate,String isweb){
		IptvlogEidtForm log=new IptvlogEidtForm();
		log.setTingjizhanghao(userId);
		log.setInterfaceType("����");
		log.setTingjishijian(startDate);
		log.setServerip(serverip);
		log.setIsweb(isweb);
		try{
			// ��������
			// ==================================================
			SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = soapConnFactory.createConnection();

			//������Ϣ����
			// ===========================================
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();
			buildHead(message);
			createBody(message,userId,"1");


			return  excute(connection,message,log,serverip);
		}catch (Exception e){
			e.printStackTrace();
			log.setShifouchenggong("ʧ��");
			log.setShibaixinxi(e.getMessage());
			log(log);
			return "FAIL";

		}

	}


	public static String excute(SOAPConnection connection,SOAPMessage message,IptvlogEidtForm log,String serverip) throws Exception {
		/*
		 * ʵ�ʵ���Ϣ��ʹ�� call()�������͵ģ��÷���������Ϣ�����Ŀ�ĵ���Ϊ�����������صڶ��� SOAPMessage ��Ϊ��Ӧ��
		 * call������message����Ϊ���͵�soap���ģ�urlΪiptv�������˿ڵ�ַ��
		 */
		//�ȴ�ӡ���ͳɹ���log
		log.setShifouchenggong("���ͳɹ�");

		log(log);
		URL url = new URL(serverip);//�·�����
		// ��Ӧ��Ϣ
		// ===========================================================================
//		SOAPMessage reply = connection.call(message, url);
		connection.close();
		/*
		 * ģ��ͻ���A���쳣�������
		 */
//		SOAPBody ycBody = reply.getSOAPBody();
//		String ErrorCode = ycBody.getElementsByTagName("ErrorCode").item(0).getTextContent();
//		String ErrorMsg = ycBody.getElementsByTagName("ErrorMsg").item(0).getTextContent();
		String ErrorCode = "0";
		String ErrorMsg = "0";
		if("0".equals(ErrorCode)){
			log.setShifouchenggong("�ɹ�");//ִ�гɹ�
		}
		else{
			log.setShifouchenggong("ʧ��");//ִ��ʧ��
		}

		log.setShibaibianhao(ErrorCode);//ʧ�ܱ��
		log.setShibaixinxi(ErrorMsg);//ʧ����Ϣ

		log(log);
		return "0".equals(ErrorCode)?"SUCCESS":"FAIL";
	}
	public static void buildHead(SOAPMessage message) throws Exception {
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

	}
	public static void createBody(SOAPMessage message,String userId,String status) throws Exception {
		SOAPElement bodyElement = message.getSOAPPart().getEnvelope().getBody().addChildElement("sam:mes-ChangeStatus");
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
			return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "���ʧ�ܣ�");
		}
		return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0, "��ӳɹ���");
	}

	public static void main(String[] args) {
//		System.out.println(IptvWebService.fuJi("1110005","http://10.104.0.6:8500/","2016-06-15"));
	}
}

