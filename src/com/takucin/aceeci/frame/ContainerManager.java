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
 * 数据库连接管理类.用于创建，获得和关闭连接.
 */
public class ContainerManager {
	
	// 线程池容器.
	private static ThreadLocal<Container> containerManager = new ThreadLocal<Container>();
	
	private static ComboPooledDataSource combolPool = null;

	/**
	 * 创建或取得一个数据库连接.
	 * 
	 * @return 返回一个数据连接.
	 * @throws Exception 如果发生任何错误抛出此异常.
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
	 * 解析数据库配置文件.
	 * 
	 * @return 无返回值.
	 * @throws Exception 如果发生任何错误抛出此异常.
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
			combolPool.setMaxPoolSize(500);//连接池中保留的最大连接数
			combolPool.setMinPoolSize(5);   
			combolPool.setAcquireIncrement(5);//当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。Default: 3   
			combolPool.setMaxIdleTime(180); //最大空闲时间,180秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0
			combolPool.setMaxStatementsPerConnection(50); 
			combolPool.setMaxStatements(30); 
			combolPool.setIdleConnectionTestPeriod(30); //每30秒检查所有连接池中的空闲连接。Default: 0
			/*自动测试的table名称,c3p0将建一张名为C3P0TestTable的空表，并使用其自带的查询语句进行测试。
			      如果定义了这个参数那么属性preferredTestQuery将被忽略。你不能在这张Test表上进行任何操作，它将只供c3p0测试使用。Default: null 
			 */
			combolPool.setAutomaticTestTable("C3P0TestTable");
			combolPool.setTestConnectionOnCheckin(true);//如果设为true那么在取得连接的同时将校验连接的有效性。Default: false
			/*获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常。但是数据源仍有效   
	                              保留，并在下次调用getConnection()的时候继续尝试获取连接。如果设为true，那么在尝试   
	                              获取连接失败后该数据源将申明已断开并永久关闭。Default: false  
	        */ 
			combolPool.setBreakAfterAcquireFailure(true);
			/*c3p0是异步操作的，缓慢的JDBC操作通过帮助进程完成。扩展这些操作可以有效的提升性能   
	                              通过多线程实现多个操作同时被执行。Default: 3
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
	 * 取得一个数据库连接.
	 * 连接会在当前线程池取得，如果找不到则创建一个新的连接，并放在线程池容易当中.
	 * 
	 * @return 一个数据库连接对象.
	 * @throws Exception 如果发生任何错误抛出此异常.
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
	 * 关闭并释放线程池容器中的连接.
	 * 
	 * @throws Exception 如果发生任何错误抛出此异常.
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
