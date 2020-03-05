package com.george.expenses.db;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class MyConnection {
	private Connection conn = null;
	private static MyConnection myConnInstance = new MyConnection();
	
	private MyConnection() {
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setServerName("localhost");
			ods.setServiceName("orcl");
			ods.setDriverType("thin");
			ods.setPortNumber(1521);
			ods.setUser("reimbursement_admin");
			ods.setPassword("admin");
			
			conn = ods.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	// get the only instance available
	public static MyConnection getMyConnInstance() {
		return myConnInstance;
	}

	
	
	
}
