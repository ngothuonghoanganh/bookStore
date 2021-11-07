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
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="home">Book Store</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">  
                            <a class="nav-link" href="home">Home</a>
                        </li>
                    <c:if test = "${!user.role.id.equals('admin')}">
                        <li class="nav-item">
                            <a class="nav-link" href="listBookToBuy">Book</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="listDeal">Deal</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="discount">Discount</a>
                    </li>
                    <c:if test = "${user.role.id.equals('admin')}">
                        <li class="nav-item">
                            <a class="nav-link" href="category">Category</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="book">Book</a>
                        </li>
                    </c:if>
                </ul>
                <span class="nav-item my-2">
                    <a class="nav-link my-2" href="logout"><button class="btn btn-primary">Logout</button></a>
                </span>
            </div>
        </nav>
            <h1  class="row justify-content-center" style="margin-top: 50px">Discounts</h1>
            <c:if test = "${user.roleID.equals('admin')}"> 

                <button type="button" class="btn btn-primary center" data-toggle="modal" data-target="#myModal">
                    Add Discount
                </button>
                <!-- The Modal -->
                <div class="modal" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="discount" method="post">  
                                <!-- Modal body -->
                                <div class="modal-body">

                                    <div id="logout">
                                        <div class="container">
                                            <div class="row justify-content-center align-items-center">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        Discount Code:
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <input type="text" name="discountCode" class="form-control" pattern="^[A-Za-z1-9]+$" title="only input englist and not special characters" required>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row justify-content-center align-items-center">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        Start Date :
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <input type="date" id="startDate" name="startDate" class="form-control" onclick="setStartDate()" required>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="row justify-content-center align-items-center">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        End Date :
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="col-md-12">

                                                        <div class="form-group">
                                                            <input type="date" id="endDate" name="endDate" class="form-control" onclick="setEndDate()" required>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                            <script>
                                                function setStartDate() {
                                                    return document.getElementById('startDate').max = new Date(document.getElementById("endDate").value).toJSON().split('T')[0];
                                                    ;
                                                }
                                                function setEndDate() {
                                                    console.log(new Date(document.getElementById("startDate").value))
                                                    return  document.getElementById('endDate').min = new Date(document.getElementById("startDate").value).toJSON().split('T')[0];
                                                    ;
                                                }

                                            </script>

                                            <div class="row justify-content-center align-items-center">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        Discount Percent:
                                                    </div>
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="col-md-12">
                                                        <div class="form-group">
                                                            <input type="number" name="discountPercent" class="form-control" max="100" min="0" required>
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
                <h3 style="color: red">${param.message}</h3>
                <div style="height: 10px"></div>
            </c:if>
            <c:forEach var="discounts" items="${discounts}">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="card" style="width:100%">
                            <div class="card-body">
                                <p class="card-text">Code: ${discounts.code}</p>
                                <p class="card-text">Active Time: ${discounts.startDate} --> ${discounts.endDate}</p>
                                <p class="card-text">Discount Percent: ${discounts.percent}%</p>
                            </div>
                        </div>
                    </div>                      
                </div>
                <br>
            </c:forEach>
        </div>


    </body>
</html>
