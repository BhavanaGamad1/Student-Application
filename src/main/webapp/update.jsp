<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update data</title>
</head>
<body>
	<div align = "center">
		<div>
			<h1>Pentagon Space</h1>
		</div>
		<div>
			<h3>Update Your Account</h3>
		</div>
		<%String error = (String)request.getAttribute("error"); %>
		<%if(error != null){ %>
			<h3><%=error %></h3>
		<%} %>
		<div>
		<!-- calling student object -->
		<%Student s = (Student)session.getAttribute("student"); %>
			<form action="update" method="post">
				<table>
					<tr>
						<td>Enter Your Name:</td>
						<td><input type="text" name="name" value="<%= s.getName() %>"></td>
					</tr>
					<tr><td><br></td></tr>
					<tr>
						<td>Enter The Phone Number:</td>
						<td><input type="text" name="phone" value="<%= s.getPhone() %>"></td>
					</tr>
					<tr><td><br></td></tr>
					<tr>
						<td>Enter The Mail ID:</td>
						<td><input type="email" name="mail" value="<%= s.getMail() %>"></td>
					</tr>
					<tr><td><br></td></tr>
					<tr>
						<td>Enter The Branch:</td>
						<td><input type="text" name="branch" value="<%= s.getBranch() %>"></td>
					</tr>
					<tr><td><br></td></tr>
					<tr>
						<td>Enter The Location:</td>
						<td><input type="text" name="location" value="<%= s.getLocation() %>"></td>
					</tr>
					<tr><td><br></td></tr>
					<tr>
						<td><input type = "submit" value = "Update Account"></td>
						<td><button><a href = "Dashboard.jsp">Back</a></button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>