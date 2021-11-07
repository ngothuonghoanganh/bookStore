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
        
        <!-- Bootstrap CSS  -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
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
    <body class="text-center">
        <div class="container">
            <div class="row justify-content-center mt-5">
                <aside class="col-sm-4">
                    <div class="card align-center">
                        <article class="card-body">
                            <h4 class="card-title text-center mb-4 mt-1">Login</h4>
                            <hr>
                            <c:if test="${not empty MSG_ERROR}">
                                <div class="alert alert-danger" role="alert">
                                    ${MSG_ERROR}
                                </div>
                                <hr>
                            </c:if>
                            <form action="Login" method="POST" onsubmit="return isreCaptchaChecked()">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                                        </div>
                                        <input class="form-control" placeholder="Username" type="text" name="txtUsername" required="" value="" type="submit">
                                    </div> 
                                </div> 
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                                        </div>
                                        <input class="form-control" placeholder="Password" type="password" name="txtPassword" value="" type="password" required="">
                                    </div> 
                                </div> 
                                <div class="form-group">
                                    <input type="submit" class="btn btn-primary btn-block" value="Login">
                                </div> 
                            </form>
                            <hr>
                            <button type="button" class="btn btn-primary btn-block" type="reset" value="Reset">
                                Reset
                            </button>
                            <hr>
                            <a href="register.jsp" class="text-center">Sign up</a>
                            <hr>
                            <a class="text-center">Search page</a>
                        </article>
                    </div>
                </aside>
            </div>
        </div>
    </body>
</html>
