<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login to your account</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css" />

</head>
<body>
	<div class="login-box">
      <h1>Sign In</h1>
      
      <!-- Display error message if any -->
      <% if(request.getAttribute("error") != null) { %>
          <div class="error-message">
              <%= request.getAttribute("error") %>
          </div>
      <% } %>
      
      <form action="${pageContext.request.contextPath}/loginController" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Sign In</button>
      </form>
      <div class="signup-link">
        <p>Don't have an account Yet? <a href="${pageContext.request.contextPath}/registerController">Sign Up</a></p>
      </div>
    </div>
</body>
</html> 