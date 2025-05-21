package com.musicshop.controller;

import java.io.IOException;

import com.musicshop.model.UserModel;
import com.musicshop.service.LoginService;
import com.musicshop.util.cookies;
import com.musicshop.util.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/loginController", "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final LoginService loginService;

	/**
	 * Constructor initializes the LoginService.
	 */
	public LoginController() {
		this.loginService = new LoginService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DEBUG: LoginController doGet called");
		// Check if user is already logged in
		if (session.getAttribute(request, "username") != null) {
			System.out.println("DEBUG: User already logged in, redirecting to home");
			response.sendRedirect(request.getContextPath() + "/home");
			return;
		}
		System.out.println("DEBUG: Showing login page");
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DEBUG: LoginController doPost called");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("DEBUG: Attempting login for username: " + username);

		UserModel userModel = new UserModel(username, password);
		UserModel loggedInUser = loginService.loginUser(userModel);

		System.out.println("DEBUG: Login result: " + (loggedInUser != null ? "success" : "failed"));

		if (loggedInUser != null) {
			System.out.println("DEBUG: Setting session attributes");
			// Store user information in session
			session.setAttribute(request, "username", username);
			session.setAttribute(request, "userId", loggedInUser.getId());
			session.setAttribute(request, "userRole", loggedInUser.getRole());
			session.setAttribute(request, "firstName", loggedInUser.getFirstName());

			// Set appropriate cookies
			if (loggedInUser.getRole() != null && loggedInUser.getRole().equals("admin")) {
				System.out.println("DEBUG: Admin user, redirecting to dashboard");
				cookies.addCookie(response, "role", "admin", 5 * 30);
				response.sendRedirect(request.getContextPath() + "/dashboard");
			} else {
				System.out.println("DEBUG: Regular user, redirecting to home");
				cookies.addCookie(response, "role", "user", 5 * 30);
				
				// Set welcome message before redirect
				session.setAttribute(request, "welcomeMessage", "Welcome back, " + loggedInUser.getFirstName() + "!");
				String redirectUrl = request.getContextPath() + "/home";
				System.out.println("DEBUG: Redirecting to: " + redirectUrl);
				response.sendRedirect(redirectUrl);
			}
		} else {
			System.out.println("DEBUG: Login failed, showing error message");
			handleLoginFailure(request, response, false);
		}
	}

	private void handleLoginFailure(HttpServletRequest request, HttpServletResponse response, Boolean loginStatus)
			throws ServletException, IOException {
		String errorMessage;
		if (loginStatus == null) {
			errorMessage = "Our server is under maintenance. Please try again later!";
		} else {
			errorMessage = "Invalid username or password. Please try again!";
		}
		request.setAttribute("error", errorMessage);
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}
}
