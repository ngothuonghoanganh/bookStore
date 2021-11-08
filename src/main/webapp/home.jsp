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
        <title>Home Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        
        <!-- CSS only -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
                
    </head>
    <body>
        <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="Home">Book Store</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">  
                        <a class="nav-link" href="Home">Home</a>
                    </li>
                <c:if test = "${!user.role.roleName.equals('admin')}">
                    <li class="nav-item ">
                        <a class="nav-link" href="ListBookToBuy">Book</a>
                    </li>
                </c:if>
                <li class="nav-item ">
                    <a class="nav-link" href="ListDeal">Deal</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Discount">Discount</a>
                </li>
                <c:if test = "${user.role.roleName.equals('admin')}">
                    <li class="nav-item ">
                        <a class="nav-link" href="Category">Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Book">Book</a>
                    </li>
                </c:if>
            </ul>
            <span class="nav-item my-2">
                <a class="nav-link my-2" href="Logout"><button class="btn btn-primary">Logout</button></a>
            </span>
        </div>
    </nav>
        <c:if test="${not empty user}"> 
            <h1 style="margin-top: 100px">${user.fullName} (${user.role.roleName})</h1>
        </c:if>
        <c:if test="${empty user}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
    </div>
    </body>
</html>
