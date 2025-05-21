package com.musicshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.musicshop.config.DbConfig;
import com.musicshop.model.UserModel;

public class RegisterService {
	
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		System.out.println("DEBUG: Attempting to establish database connection...");
		return DbConfig.getDbConnection();
	}
	
	public Boolean addUser(UserModel userModel) {
		if (userModel == null) {
			System.err.println("DEBUG: User model is null");
			return false;
		}

		try {
			System.out.println("DEBUG: Starting user registration for username: " + userModel.getUserName());
			System.out.println("DEBUG: User details:");
			System.out.println("DEBUG: First Name: " + userModel.getFirstName());
			System.out.println("DEBUG: Last Name: " + userModel.getLastName());
			System.out.println("DEBUG: Email: " + userModel.getEmail());
			System.out.println("DEBUG: Image URL: " + userModel.getImageUrl());
			
			String insertQuery = "INSERT INTO user (first_name, last_name, username, email, password, image_path) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";

			try (Connection conn = getConnection();
				 PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
				
				// Insert user details
				insertStmt.setString(1, userModel.getFirstName());
				insertStmt.setString(2, userModel.getLastName());
				insertStmt.setString(3, userModel.getUserName());
				insertStmt.setString(4, userModel.getEmail());
				insertStmt.setString(5, userModel.getPassword());
				insertStmt.setString(6, userModel.getImageUrl());

				System.out.println("DEBUG: Executing user registration query");
				
				int result = insertStmt.executeUpdate();
				System.out.println("DEBUG: Registration successful. Rows affected: " + result);

				return result > 0;
				
			} catch (SQLException e) {
				System.err.println("DEBUG: SQL Error during registration:");
				System.err.println("DEBUG: Error message: " + e.getMessage());
				System.err.println("DEBUG: SQL State: " + e.getSQLState());
				System.err.println("DEBUG: Error code: " + e.getErrorCode());
				e.printStackTrace();
				return false;
			} catch (ClassNotFoundException e) {
				System.err.println("DEBUG: Database driver not found:");
				System.err.println("DEBUG: Error message: " + e.getMessage());
				e.printStackTrace();
				return false;
			}
		} catch (Exception e) {
			System.err.println("DEBUG: Unexpected error during registration:");
			System.err.println("DEBUG: Error message: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
