<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
    </style>
    <title>Document</title>
</head>
<body>
    <form action="signup" method="POST" align = "center">
        <div>
        <h1>Pentagon Space</h1>
        <h2 >Application Form</h2>
                  <%String error=(String)request.getAttribute("error"); %>
         <%if(error!=null){ %>
        <h3 class="msg"> <%=error %></h3>
         <%} %>

        

        
        Enter your name:
        <input type="text"  name="name" required><br><br>

        Enter your Phone number:
        <input type="number"   name="phone" required><br><br>

        Enter your mail:
        <input type="mail"  name="mail" required><br><br>

        Enter your branch:
        <input type="text" name="branch" required><br><br>

        Enter your location:
        <input type="text" name="location" required><br><br>

        Enter your password:
        <input type="password" name="password" required><br><br>

        Enter conform password:
        <input type="password" name="conform" required><br><br>

        <input type="submit" value="Create account">
        <p>Already have account <a href="login.jsp">Login here</a></p>
        </div>
    </form>
    
    
</body>
</html>