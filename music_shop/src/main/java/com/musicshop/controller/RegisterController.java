package com.musicshop.controller;

import com.musicshop.model.UserModel;
import com.musicshop.service.RegisterService;
import com.musicshop.util.ImageUtil;
import com.musicshop.util.PasswordUtil;
import com.musicshop.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.io.File;
import java.io.IOException;

 



/**
 * Servlet implementation class RegisterController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/registerController" })

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	private final ImageUtil imageUtil = new ImageUtil();
	private final RegisterService registerService = new RegisterService();
       
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
		System.out.println("DEBUG: Starting registration process...");
		try {
			String validationMessage = validateRegistrationForm(request);
			if (validationMessage != null) {
				System.out.println("DEBUG: Validation failed: " + validationMessage);
				handleError(request, response, validationMessage);
				return;
			}
			System.out.println("DEBUG: Form validation passed");

			UserModel userModel = extractUserModel(request);
			System.out.println("DEBUG: User model created successfully");
			System.out.println("DEBUG: Attempting to add user to database...");
			
			Boolean isAdded = registerService.addUser(userModel);
			System.out.println("DEBUG: Database addition result: " + isAdded);

			if (isAdded == null || !isAdded) {
				System.out.println("DEBUG: User registration failed");
				handleError(request, response, "Registration failed. The username or email might already be in use.");
			} else {
				System.out.println("DEBUG: User added successfully, attempting to upload image");
				try {
					if (uploadImage(request)) {
						System.out.println("DEBUG: Image upload successful");
						// Store user information in session
						request.getSession().setAttribute("user", userModel);
						handleSuccess(request, response, "Your account is successfully created!", "/WEB-INF/pages/home.jsp");
					} else {
						System.out.println("DEBUG: Image upload failed");
						handleError(request, response, "Could not upload the image. Please try again later!");
					}
				} catch (IOException | ServletException e) {
					System.out.println("DEBUG: Image upload exception: " + e.getMessage());
					handleError(request, response, "An error occurred while uploading the image. Please try again later!");
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("DEBUG: Unexpected error in registration: " + e.getMessage());
			handleError(request, response, "An unexpected error occurred. Please try again later!");
			e.printStackTrace();
		}
	}

	private String validateRegistrationForm(HttpServletRequest request) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Check for null or empty fields first
		if (ValidationUtil.isNullOrEmpty(firstName))
			return "First name is required.";
		if (ValidationUtil.isNullOrEmpty(lastName))
			return "Last name is required.";
		if (ValidationUtil.isNullOrEmpty(username))
			return "Username is required.";
		if (ValidationUtil.isNullOrEmpty(email))
			return "Email is required.";
		if (ValidationUtil.isNullOrEmpty(password))
			return "Password is required.";

		

		// Validate fields
		if (!ValidationUtil.isAlphanumericStartingWithLetter(username))
			return "Username must start with a letter and contain only letters and numbers.";
		if (!ValidationUtil.isValidEmail(email))
			return "Invalid email format.";
		if (!ValidationUtil.isValidPassword(password))
			return "Password must be at least 8 characters long, with 1 uppercase letter, 1 number, and 1 symbol.";

		try {
			Part image = request.getPart("image");
			if (!ValidationUtil.isValidImageExtension(image))
				return "Invalid image format. Only jpg, jpeg, png, and gif are allowed.";
		} catch (IOException | ServletException e) {
			return "Error handling image file. Please ensure the file is valid.";
		}

		return null; // All validations passed
	}

	private UserModel extractUserModel(HttpServletRequest request) throws Exception {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		

		// Assuming password validation is already done in validateRegistrationForm
		password = PasswordUtil.encrypt(username, password);
		
		

		Part image = request.getPart("image");
		String imageUrl = imageUtil.getImageNameFromPart(image);

	    
		return new UserModel(firstName, lastName, username, email, password,imageUrl);
	}

	private boolean uploadImage(HttpServletRequest request) throws IOException, ServletException {
		try {
			Part image = request.getPart("image");
			if (image == null) {
				System.err.println("ERROR: No image part found in request");
				return false;
			}
			
			// Print image details
			System.out.println("DEBUG: Image details:");
			System.out.println("DEBUG: Content type: " + image.getContentType());
			System.out.println("DEBUG: Size: " + image.getSize() + " bytes");
			System.out.println("DEBUG: Submitted filename: " + image.getSubmittedFileName());
			
			// Get the real path of the web application
			String realPath = request.getServletContext().getRealPath("/");
			System.out.println("DEBUG: Web application real path: " + realPath);
			
			// Extract the workspace path by going up to the workspace directory
			File webappDir = new File(realPath);
			// Go up 5 levels: webapp -> main -> src -> music_shop -> workspace
			File workspaceDir = webappDir;
			for (int i = 0; i < 5 && workspaceDir != null; i++) {
				workspaceDir = workspaceDir.getParentFile();
			}
			
			if (workspaceDir == null) {
				System.err.println("ERROR: Could not determine workspace directory");
				return false;
			}
			
			String workspacePath = workspaceDir.getAbsolutePath();
			System.out.println("DEBUG: Determined workspace path: " + workspacePath);
			
			// Call ImageUtil with the correct workspace path
			return imageUtil.uploadImage(image, workspacePath, null);
			
		} catch (Exception e) {
			System.err.println("ERROR: Failed to process image upload: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	private void handleSuccess(HttpServletRequest request, HttpServletResponse response, String message, String redirectPage)
			throws ServletException, IOException {
		request.setAttribute("success", message);
		// Set a welcome message
		request.setAttribute("welcomeMessage", "Welcome, " + request.getParameter("firstName") + "!");
		request.getRequestDispatcher(redirectPage).forward(request, response);
	}

	private void handleError(HttpServletRequest request, HttpServletResponse response, String message)
			throws ServletException, IOException {
		request.setAttribute("error", message);
		request.setAttribute("firstName", request.getParameter("firstName"));
		request.setAttribute("lastName", request.getParameter("lastName"));
		request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("email", request.getParameter("email"));
		request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
	}

}
