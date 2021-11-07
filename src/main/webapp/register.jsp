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
        <!-- Bootstrap CSS  -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <style>

    </style>
    
    </head>
    <body class="text-center">
        <div class="container">
            <div class="row justify-content-center mt-5">
                <aside class="col-sm-4">
                    <div class="card align-center">
                        <article class="card-body">
                            <h4 class="card-title text-center mb-4 mt-1">Sign up</h4>
                            <hr>
                            <form action="Register" method="POST" required>
                                <div class="form-group">
                                    <c:if test="${not empty ERROR}">
                                        <div class="form-group">
                                            <p class="justify-content-center" style="color: red;">${ERROR}</p>
                                        </div>
                                    </c:if> 
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"> <i class="fa fa-user"></i></span>
                                        </div>
                                        <input class="form-control" type="text" name="fullName" placeholder="Full name" pattern="^[A-Za-z0-9 ]+$" title="Oly use english and not special character" required>
                                    </div> 
                                </div> 
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"> <i class="fa fa-user"></i></span>
                                        </div>
                                        <input class="form-control" placeholder="Username" type="text" name="username" pattern="^[A-Za-z0-9 ]+$" title="Oly use english and not special character" required>
                                    </div> 
                                </div> 
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"> <i class="fa fa-lock"></i></span>
                                        </div>
                                        <input class="form-control" placeholder="Password" type="password" name="password" required>
                                    </div> 
                                </div> 
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"> <i class="fa fa-lock"></i></span>
                                        </div>
                                        <input class="form-control" placeholder="Confirm Password" type="password" name="confirmPassword" required>
                                    </div>
                                </div> 
                                <div class="form-group">
                                    <input type="submit" class="btn btn-primary btn-block" value="Register">
                                </div> 
                                <div class="form-group">
                                    <input type="reset" class="btn btn-primary btn-block" value="Reset">
                                </div> 
                            </form>
                            <a class="text-center" href="login">Login</a>
                        </article>
                    </div>
                </aside>
            </div>
        </div> 
    </body>
</html>
