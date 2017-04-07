package com.takucin.aceeci.frame;

import java.sql.Connection;
import java.sql.DriverManager;

public class DefaultBuilder implements ConnectionBuilder {

	public Connection createConnection() throws Exception {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=Demo;","sa", "1");
		return conn;
	}

}