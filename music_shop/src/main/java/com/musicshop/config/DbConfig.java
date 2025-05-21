package com.musicshop.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
	private static final String DB_NAME = "music_shop";
	private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	
	public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Test the connection before returning
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			if (connection == null) {
				throw new SQLException("Failed to establish database connection");
			}
			
			// Test if connection is valid
			if (!connection.isValid(5)) { // 5 seconds timeout
				throw new SQLException("Database connection is invalid");
			}
			
			return connection;
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: MySQL JDBC Driver not found");
			throw e;
		} catch (SQLException e) {
			System.err.println("ERROR: Database connection failed");
			System.err.println("ERROR: " + e.getMessage());
			System.err.println("ERROR: Connection URL: " + URL);
			throw e;
		}
	}
}
