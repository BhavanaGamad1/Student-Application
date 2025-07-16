<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <form action="password" method="post">
        <h1>Pentagon Space</h1>
        <h3>Reset your password here</h3>
        
        <%String error=(String)request.getAttribute("error"); %>
         <%if(error!=null){ %>
        <h3 class="msg"> <%=error %></h3>
         <%} %>

        

        Enter the phone number:
        <input type="phone" name="phone"><br><br>
        Enter the mail id:
        <input type="email" name="mail"><br><br>
        Enter the password:
        <input type="password" name="password"><br><br>
        Conform the password:
        <input type="password" name="conform"><br><br>
        <input type="submit" value="Reset Password">
       <a href="login.jsp">Back</a>

    </form>
    
</body>
</html>