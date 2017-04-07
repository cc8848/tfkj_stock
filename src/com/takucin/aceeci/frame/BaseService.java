package com.takucin.aceeci.frame;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.employee.Employee;

/**
 * �����Ļ��࣬���ڿ������񣬺�ҵ���߼��ķ�װ.
 */
public abstract class BaseService {

	private Log log = LogFactory.getLog(this.getClass());
	
	public static final int SC_SUCCESS = 200;
	public static final int SC_ERROR = 400;

	/**
	 * ��һ������.
	 * 
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	protected void openTransaction() throws Exception {
		try {
			Connection conn = ContainerManager.currentConnection();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}

	}

	/**
	 * �ύһ������.
	 * 
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	protected void commit() throws Exception {
		try {
			Connection conn = ContainerManager.currentConnection();
			if (conn != null) {
				conn.commit();
			}
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	/**
	 * �ع�һ������.
	 * 
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	protected void rollback() throws Exception {
		try {
			Connection conn = ContainerManager.currentConnection();
			if (conn != null) {
				conn.rollback();
			}
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	
	protected Employee getUserInfo(){
		return ContainerManager.currentUser(null);
	}
	
	protected Employee getUserInfo(HttpServletRequest request){
		return ContainerManager.currentUser(request);
	}
	/**
	 * ת��ʱ���ʽ
	 * @return
	 */
	protected String get_time(String s){
		String a = "20";
		String a1 = s.substring(0, 2);
		String a2 = s.substring(2, 4);
		String a3 = s.substring(4, 6);
		return a+a1+"/"+a2+"/"+a3;
	}
	/**
	 * ��ȡ�ַ��� �������ʱ�� ��ʽΪ  yyMMdd
	 * @param time
	 * @return
	 */
	protected String get_time_235689(String time){
		String s = "";
		s+=time.substring(2, 4);
		s+=time.substring(5, 7);
		s+=time.substring(8, 10);
		return s;
	}
}
