<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
</head>
<body>

	<div class="container">
		<div class="sidebar">
			<ul class="nav">
				<li><a href="#"><span class="icon">🏠</span> Dashboard</a></li>
				<li><a href="#"><span class="icon">📊</span> Order List</a></li>
			</ul>
			<div class="upgrade">Upgrade to Pro</div>
		</div>

		<div class="content">
			<div class="header">
				<div class="info-box">
					<h3>Total customers</h3>
					<p>300</p>
				</div>			
			</div>

			<div class="card">
				<div>
					<h2>Welcome, Admins!</h2>
					<p> Management Dashboard</p>
					<br /> <br />
					<p>We're excited to have you onboard. Manage your company's data
						efficiently and effortlessly with our user-friendly interface.
						Everything you need is just a few clicks away.</p>
				</div>
				<img src="${pageContext.request.contextPath}/resources/images/system/logo.png"
					alt="college">
			</div>

			

			<div class="table-container">
				<h3>Customer Information</h3>
				<table>
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Module</th>
							<th>Email</th>
							<th>Number</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!-- Using JSTL forEach loop to display student data -->
						<c:forEach var="student" items="${studentList}">
							<tr>
								<td>${student.id}</td>
								<td>${student.firstName} ${student.lastName}</td>
								<td>${student.program.name}</td>
								<td>${student.email}</td>
								<td>${student.number}</td>
								<td>
									<form action="${contextPath}/dashboard" method="post"
										style="display: inline;">
										<input type="hidden" name="studentId" value="${student.id}">
										<input type="hidden" name="action" value="edit">
										<button class="action-btn" type="submit">
											<img src="${pageContext.request.contextPath}/resources/images/system/edit.png"
												alt="Edit" title="Edit" />
										</button>
									</form>
									<form action="${contextPath}/dashboard" method="post"
										style="display: inline;">
										<input type="hidden" name="studentId" value="${student.id}">
										<input type="hidden" name="action" value="delete">
										<button class="action-btn" type="submit">
											<img src="${pageContext.request.contextPath}/resources/images/system/delete.png"
												alt="Delete" title="Delete" />
										</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
