<%-- 
    Document   : home
    Created on : May 25, 2021, 10:34:07 AM
    Author     : Admin
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar fixed-top navbar-light bg-light">
            <a class="navbar-brand" href="home">Home</a>
            <c:if test = "${!user.roleID.equals('admin')}">
                <a class="navbar-brand" href="listBookToBuy">Book</a>
            </c:if>

            <a class="navbar-brand" href="listDeal">Deal</a>
            <a class="navbar-brand" href="discount">Discount</a>

            <c:if test = "${user.roleID.equals('admin')}">
                <a class="navbar-brand" href="category">Category</a>
                <a class="navbar-brand" href="book">Book</a>
            </c:if>
            <a class="navbar-brand" href="logout">Logout</a>

        </nav>
        <%--<c:forEach var="user" items="${user}">--%> 
        <h1 style="margin-top: 100px">${user.fullName} (${user.roleID})</h1>
        <%--</c:forEach>--%>

    </body>
</html>
