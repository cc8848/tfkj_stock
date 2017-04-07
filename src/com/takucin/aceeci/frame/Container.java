package com.takucin.aceeci.frame;

import java.sql.Connection;

import com.hrbank.business.employee.Employee;

public class Container {
	
	private Connection connection;
	private Employee userInfo;
	
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Employee getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(Employee userInfo) {
		this.userInfo = userInfo;
	}
}
