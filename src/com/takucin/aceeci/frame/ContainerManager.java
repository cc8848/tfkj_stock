package com.takucin.aceeci.frame;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.hrbank.business.employee.Employee;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.takucin.aceeci.common.Constant;

/**
 * ���ݿ����ӹ�����.���ڴ�������ú͹ر�����.
 */
public class ContainerManager {
	
	// �̳߳�����.
	private static ThreadLocal<Container> containerManager = new ThreadLocal<Container>();
	
	private static ComboPooledDataSource combolPool = null;

	/**
	 * ������ȡ��һ�����ݿ�����.
	 * 
	 * @return ����һ����������.
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	private static Connection getConnection() throws Exception {

		if (combolPool == null) {
			combolPool = new ComboPooledDataSource();
			parseDBXML();
		}
	
		Connection conn = combolPool.getConnection();
		return conn;
	}
	/**
	 * �������ݿ������ļ�.
	 * 
	 * @return �޷���ֵ.
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	private static void parseDBXML() {
		SAXReader reader = new SAXReader();
		try {
			InputStream resourceAsStream = ContainerManager.class.getClassLoader().getResourceAsStream("dbconfig.xml");
			Document document = reader.read(resourceAsStream);
			
			Node datasourceNode = document.selectSingleNode("//datasource");
			String user = datasourceNode.selectSingleNode("//user").getText();
			String driver = datasourceNode.selectSingleNode("//driver").getText();
			String url = datasourceNode.selectSingleNode("//url").getText();
			String password = datasourceNode.selectSingleNode("//password").getText();
			combolPool.setUser(user);
			combolPool.setJdbcUrl(url);
			combolPool.setPassword(password);
			combolPool.setInitialPoolSize(5);
			combolPool.setMaxPoolSize(500);//���ӳ��б��������������
			combolPool.setMinPoolSize(5);   
			combolPool.setAcquireIncrement(5);//�����ӳ��е����Ӻľ���ʱ��c3p0һ��ͬʱ��ȡ����������Default: 3   
			combolPool.setMaxIdleTime(180); //������ʱ��,180����δʹ�������ӱ���������Ϊ0������������Default: 0
			combolPool.setMaxStatementsPerConnection(50); 
			combolPool.setMaxStatements(30); 
			combolPool.setIdleConnectionTestPeriod(30); //ÿ30�����������ӳ��еĿ������ӡ�Default: 0
			/*�Զ����Ե�table����,c3p0����һ����ΪC3P0TestTable�Ŀձ���ʹ�����Դ��Ĳ�ѯ�����в��ԡ�
			      ������������������ô����preferredTestQuery�������ԡ��㲻��������Test���Ͻ����κβ���������ֻ��c3p0����ʹ�á�Default: null 
			 */
			combolPool.setAutomaticTestTable("C3P0TestTable");
			combolPool.setTestConnectionOnCheckin(true);//�����Ϊtrue��ô��ȡ�����ӵ�ͬʱ��У�����ӵ���Ч�ԡ�Default: false
			/*��ȡ����ʧ�ܽ����������еȴ����ӳ�����ȡ���ӵ��߳��׳��쳣����������Դ����Ч   
	                              �����������´ε���getConnection()��ʱ��������Ի�ȡ���ӡ������Ϊtrue����ô�ڳ���   
	                              ��ȡ����ʧ�ܺ������Դ�������ѶϿ������ùرա�Default: false  
	        */ 
			combolPool.setBreakAfterAcquireFailure(true);
			/*c3p0���첽�����ģ�������JDBC����ͨ������������ɡ���չ��Щ����������Ч����������   
	                              ͨ�����߳�ʵ�ֶ������ͬʱ��ִ�С�Default: 3
	         */
			combolPool.setNumHelperThreads(10);
			try {
				combolPool.setDriverClass(driver);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ȡ��һ�����ݿ�����.
	 * ���ӻ��ڵ�ǰ�̳߳�ȡ�ã�����Ҳ����򴴽�һ���µ����ӣ��������̳߳����׵���.
	 * 
	 * @return һ�����ݿ����Ӷ���.
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	public static Connection currentConnection() throws Exception {
		Container container = containerManager.get();
		if(container == null){
			container = new Container();
			containerManager.set(container);
		}
		Connection connection = container.getConnection();
		if (connection == null) {
			connection = getConnection();
			container.setConnection(connection);
			containerManager.set(container);
		}
		return connection;
	}

	/**
	 * �رղ��ͷ��̳߳������е�����.
	 * 
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	public static void closeConnection() throws Exception {
		Container container = containerManager.get();
		Connection connection = container.getConnection();
		if (connection != null) {
			connection.close();
		}
		container.setConnection(null);
		containerManager.set(container);
		
	}
	
	private static Employee getUserInfo(HttpServletRequest request){
		return(Employee)request.getSession().getAttribute(Constant.LOGIN_USER);
	}
	
	public static Employee currentUser(HttpServletRequest request){
		Container container = containerManager.get();
		if(container == null){
			container = new Container();
			containerManager.set(container);
		}
		Employee userInfo = container.getUserInfo();
		if (userInfo == null) {
			userInfo = getUserInfo(request);
			container.setUserInfo(userInfo);
			containerManager.set(container);
		}
		return userInfo;
	}
	
	public static void destroyUser(){
		Container container = containerManager.get();
		container.setUserInfo(null);
		containerManager.set(container);
	}
}
