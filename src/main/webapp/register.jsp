<%-- 
    Document   : signUp
    Created on : 20 thg 5, 2021, 20:00:19
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in</title>
    </head>
    <body>
        <h1>Sign In</h1>


        <form action="Register" method="POST">

            Full Name <input type="text" name="fullName" required="true" pattern="^[A-Za-z0-9 ]+$" title="Oly use english and not special character" required/><br/>
            <br>
            username <input type="text" name="username" required="true" pattern="^[A-Za-z0-9 ]+$" title="Oly use english and not special character" required/><br/>
            <br>
            Password <input type="password" name="password" required="true"/><br/>
            <br>
            Confirm Password <input type="password" name="confirmPassword" required="true"/><br/>
            <br>
            <p style="color: red">${ERROR}</p>
            <input type="submit" value="Register" />
            <input type="reset" value="Reset" />
        </form>

        <br/><a href="login">Back</a>

    </body>
</html>
