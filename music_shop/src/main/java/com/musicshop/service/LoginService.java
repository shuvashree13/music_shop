package com.musicshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.musicshop.config.DbConfig;
import com.musicshop.model.UserModel;
import com.musicshop.util.PasswordUtil;

public class LoginService {
	
	private Connection dbConn;
	private boolean isConnectionError = false;

	/**
	 * Constructor initializes the database connection. Sets the connection error
	 * flag if the connection fails.
	 */
	public LoginService() {
		try {
			System.out.println("DEBUG: Initializing LoginService");
			dbConn = DbConfig.getDbConnection();
			System.out.println("DEBUG: Database connection successful in LoginService");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("DEBUG: Database connection failed in LoginService: " + ex.getMessage());
			ex.printStackTrace();
			isConnectionError = true;
		}
	}

	/**
	 * Validates the user credentials against the database records.
	 *
	 * @param studentModel the StudentModel object containing user credentials
	 * @return true if the user credentials are valid, false otherwise; null if a
	 *         connection error occurs
	 */
	public UserModel loginUser(UserModel userModel) {
		if (isConnectionError) {
			System.out.println("DEBUG: Connection error in loginUser");
			return null;
		}

		String query = "SELECT * FROM user WHERE username = ?";
		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			System.out.println("DEBUG: Executing login query for username: " + userModel.getUserName());
			stmt.setString(1, userModel.getUserName());
			ResultSet result = stmt.executeQuery();

			if (result.next() && validatePassword(result, userModel)) {
				System.out.println("DEBUG: User found and password validated");
				UserModel loggedInUser = new UserModel(
					result.getInt("id"),
					result.getString("first_name"),
					result.getString("last_name"),
					result.getString("username"),
					result.getString("email"),
					result.getString("password"),
					result.getString("image_path")
				);
				
				// Set the role from database, default to "user" if not found
				String role = result.getString("role");
				loggedInUser.setRole(role != null ? role : "user");
				
				System.out.println("DEBUG: User role set to: " + loggedInUser.getRole());
				return loggedInUser;
			} else {
				System.out.println("DEBUG: Invalid username or password");
			}
		} catch (SQLException e) {
			System.out.println("DEBUG: SQL error in loginUser: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

		return null;
	}

	/**
	 * Validates the password retrieved from the database.
	 *
	 * @param result       the ResultSet containing the username and password from
	 *                     the database
	 * @param studentModel the StudentModel object containing user credentials
	 * @return true if the passwords match, false otherwise
	 * @throws SQLException if a database access error occurs
	 */
	private boolean validatePassword(ResultSet result, UserModel userModel) throws SQLException {
		String dbUsername = result.getString("username");
		String dbPassword = result.getString("password");
		
		boolean isValid = dbUsername.equals(userModel.getUserName()) &&
						 PasswordUtil.decrypt(dbPassword, dbUsername).equals(userModel.getPassword());
		
		System.out.println("DEBUG: Password validation result: " + isValid);
		return isValid;
	}
}
