<%-- 
    Document   : login
    Created on : 12 thg 5, 2021, 12:26:27
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://www.google.com/recaptcha/api.js?hl=vi" async defer></script>
        <script>
            var recaptchachecked = true;
            function recaptchaCallback() {
                recaptchachecked = true;
            }

            function isreCaptchaChecked()
            {
                return recaptchachecked;
            }
        </script>

    </head>
    <body>

        <h1>Login</h1>
        <c:if test="${not empty MSG_ERROR}">

        </c:if>
        <form action="Login" method="POST" onsubmit="return isreCaptchaChecked()"> 
            Username: <input type="text" name="txtUsername" value="" required=""/><br/><br/>
            Password: <input type="password" name="txtPassword" value="" required=""/><br/>
            <br/>
            <div class="g-recaptcha" data-sitekey="6LcTUdYaAAAAANzlMdFL-Tw5aQDNOC42xfXm_fDw" name="recaptcha" data-callback="recaptchaCallback"></div>
            <br/>
            <input type="submit" value="Login"/>
            <input type="reset" value="Reset"/>
        </form> 

        <font color="red">
        ${MSG_ERROR}
        </font>

        <br/><br/><a href="search" style="text-decoration : none">Search page</a> 
        <br/><a href="register" style="text-decoration : none">Sign in</a><br/> 

    </body>
</html>
