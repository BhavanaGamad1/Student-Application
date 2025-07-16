<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body><div align = "center">
    <form action="login" method="POST" >
        <h1>Pentagon space</h1>
        <h3>Login</h3>
        <%String success=(String)request.getAttribute("success"); %>
		<%if(success!=null) {%>
	 <h3> <%=success %> </h3>
		<%} %>
		
		 <%String error=(String)request.getAttribute("error"); %>
         <%if(error!=null){ %>
        <h3 class="errormsg"> <%=error %></h3>
         <%} %>


        Enter your Email ID:
        <input type="mail" name="mail" required><br><br>
        Enter your password:
        <input type="password" name="password" required><br><br>

        <input type="submit" value="login">
        <p>Don't have account? <a href="signup.jsp">Sign up </a> </p>
        <a href="password.html"> forgot password</a>

    </form>
    
    </div>
</body>
</html>