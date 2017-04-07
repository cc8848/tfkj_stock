package com.takucin.aceeci.frame;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.employee.Employee;

/**
 * 服务层的基类，用于控制事务，和业务逻辑的封装.
 */
public abstract class BaseService {

	private Log log = LogFactory.getLog(this.getClass());
	
	public static final int SC_SUCCESS = 200;
	public static final int SC_ERROR = 400;

	/**
	 * 打开一个事务.
	 * 
	 * @throws Exception 如果发生任何错误抛出此异常.
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
	 * 提交一个事务.
	 * 
	 * @throws Exception 如果发生任何错误抛出此异常.
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
	 * 回滚一个事务.
	 * 
	 * @throws Exception 如果发生任何错误抛出此异常.
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
	 * 转换时间格式
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
	 * 截取字符串 用于输出时间 格式为  yyMMdd
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
