package com.musicshop.controller;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Servlet implementation class RegisterController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/registerController" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward((request),  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() method triggered!");

		// TODO Auto-generated method stub
		//doGet(request, response);
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
	    System.out.println("First Name: " + firstName);
	    System.out.println("Last Name: " + lastName);
	    System.out.println("Email: " + email);
	    System.out.println("Password: " + password);

	    
		//name format validation
		if (!isValidName(firstName) || !isValidName(lastName)) {
			// Redirect to the registration page with an error message
            response.sendRedirect(request.getContextPath() + "/register.html?error=name");
            return;
		}
		
        
        
        
        
        // 5. Password Complexity Requirement and Matching Passwords
        //if (!isValidPassword(password, confirmPassword)) {
            // Redirect to the registration page with an error message
        	//response.sendRedirect(request.getContextPath() + "/register.html?error=password");
            //return;
        //}

        // 6. Data Duplication Identification Requirement
        /*
        if (dbController.isUsernameExists(userName) || dbController.isEmailExists(email)
                || dbController.isPhoneNumberExists(phoneNumber)) {
            // Redirect to the registration page with an error message
            response.sendRedirect(request.getContextPath() + "/register.html?error=phone");
            return;
        }
        */

	}

	private boolean isValidName(String name) {
	    return name.matches("[A-Za-z]+"); // Only letters allowed
	}

	
	
    

	private boolean isValidPassword(String password) {
	    return password.length() > 6 &&
	           password.matches(".\\d.") &&        // At least one digit
	           password.matches(".[!@#$%^&()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*") && // At least one special character
	           password.matches(".[A-Z].");    // At least one uppercase letter
	           
	
	}

}
