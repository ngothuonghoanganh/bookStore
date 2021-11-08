<%-- 
    Document   : category
    Created on : May 25, 2021, 10:40:12 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="Home">Book Store</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item ">  
                            <a class="nav-link" href="Home">Home</a>
                        </li>
                    <c:if test = "${!user.role.id.equals('admin')}">
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
                    <c:if test = "${user.role.id.equals('admin')}">
                        <li class="nav-item active">
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
            <h1  class="row justify-content-center" style="margin-top: 50px">Categories</h1>

            <button type="button" class="btn btn-primary center" data-toggle="modal" data-target="#myModal">
                Add Category
            </button>
            <!-- The Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="Category" method="post">  
                            <!-- Modal body -->
                            <div class="modal-body">

                                <div id="logout">
                                    <div class="container">
                                        <div class="row justify-content-center align-items-center">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    Category Name:
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <input type="text" name="categoryName" class="form-control" pattern="^[A-Za-z0-9 ]+$" title="Oly use english and not special character" required>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <div class="form-group">
                                    <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                                </div>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div style="height: 10px"></div>

            <c:forEach var="categories" items="${categories}">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="card" style="width:100%">
                            <div class="card-body">
                                <p class="card-text">${categories.categoryName}</p>
                            </div>
                        </div>
                    </div>                      
                </div>
                <br>
            </c:forEach>
        </div>


    </body>
</html>
