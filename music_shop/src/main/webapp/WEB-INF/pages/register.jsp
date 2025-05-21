<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register a User</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/register.css" />
</head>
<body>
	<div class="container">
    <div class="signup-box">
      <h1>Sign Up</h1>
      
      <!-- Display error message if any -->
      <% if(request.getAttribute("error") != null) { %>
          <div class="error-message">
              <%= request.getAttribute("error") %>
          </div>
      <% } %>
      
      <form action="${pageContext.request.contextPath}/registerController" method="post" enctype="multipart/form-data">
        <input type="text" name="firstName" placeholder="First Name" 
               value="${firstName}" required />
        <input type="text" name="lastName" placeholder="Last Name" 
               value="${lastName}" required />
        <input type="text" name="username" placeholder="Username" 
               value="${username}" required />
        <input type="email" name="email" placeholder="Email" 
               value="${email}" required />
        <input type="password" name="password" placeholder="Password" required />
        
        <div class="file-input">
            <label for="image">Profile Image:</label>
            <input type="file" name="image" id="image" accept="image/*" required />
        </div>
        
        <button type="submit">Sign Up</button>
      </form>
      <div class="signin-link">
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Sign In</a></p>
      </div>
    </div>
  </div> 
</body>
</html>