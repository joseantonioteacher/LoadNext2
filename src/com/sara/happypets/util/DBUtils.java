package com.sara.happypets.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sara.happypets.service.DataException;

public class DBUtils {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://10.53.124.206:3306/happypets?serverTimezone=UTC&useSSL=false";

	// Database credentials
	static final String USER = "HappypetDVA";
	static final String PASS = "promesa93";

	static {
		try {
			// Register JDBC driver	
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			//			System.exit(1);
		}
	}

	public static final Connection getConnection()
			throws DataException {	
		try {
			// Open a connection
			return DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			throw new DataException(e);
		}
	}
}
