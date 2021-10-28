<%-- 
    Document   : listDeal
    Created on : Jun 20, 2021, 3:06:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="ISO-8859-1">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
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
        </div>
        <c:if test = "${!user.roleID.equals('admin')}">

            <table border="1" class="table" style="margin-top: 100px;">
                <thead>
                <meta charset="utf-8">
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="carts" items="${carts}" varStatus="Counter">
                    <tr>
                        <td>${carts.bookName}</td>
                        <td>${carts.price}</td>
                <form action="updateCart" method="POST">
                    <td><input type="number" name="quantity" value="${carts.quantity}"/> </td>
                    <input type="hidden" name="id" value="${carts.bookId}"/>
                    <td><input type="submit" value="Update"/></td>
                </form>
                <form action="deleteCart" method="POST">
                    <input type="hidden" name="id" value="${carts.bookId}"/>
                    <td><input type="submit" value="Delete"/></td>
                </form>
            </tr>
        </c:forEach>
    </tbody>
</table>
<br/>
<form action="addDiscount" method="POST">
    <div class="main">
        <div class="input-group" style="width: 20%">
            <input name="discountCode" type="text" class="form-control" placeholder="Discount Code" value="${discount.code}">
            <div class="input-group-append">
                <button type="submit" class="btn btn-secondary" type="button">
                    Add Discount
                </button>
            </div>
        </div>
    </div>
</form>
<h3 style="color: red">${param.message}</h3>
<br>
<c:set var="total" value="${0}"/>
<c:forEach var="carts" items="${carts}">
    <c:set var="total" value="${total + carts.price}" />
</c:forEach>
<h4>Price: ${total}</h4>
<h4>Discount Price: ${(total*discount.percent)/100}</h4>
<h4>Total Price: ${total - (total*discount.percent)/100}</h4>
<br/>
<button type="button" class="btn btn-primary center" data-toggle="modal" style="width: 100px" data-target="#myModal">
    Buy
</button>
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal body -->
            <div class="modal-body">
                <div class="modal-header">
                    <h5 class="modal-title">Submit To Buy</h5>
                </div>
                <div id="logout" style="margin-top: 10px">
                    <div class="container">
                        <table border="1" class="table">
                            <tr>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="carts" items="${carts}" varStatus="Counter">
                                    <tr>
                                        <td>${carts.bookName}</td>
                                        <td>${carts.price}</td>
                                        <td>${carts.quantity}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <h4>Price: ${total}</h4>
            <h4>Discount Price: ${(total*discount.percent)/100}</h4>
            <h4>Total Price: ${total - (total*discount.percent)/100}</h4>
            <!-- Modal footer -->
            <div class="modal-footer">
                <div class="form-group">
                    <c:if test = "${carts != null}">
                        <form action="confirmDeal" method="POST">
                            <input type="submit" value="Confirm" class="btn btn-info btn-md"/>    
                        </form>
                    </c:if>
                </div>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</c:if>
<div style="margin-top: 100px"></div>
<h1  class="row justify-content-center" style="margin-top: 50px">Deal History</h1>
<div style="margin-top: 50px"></div>
<div class="container">

    <form action="listDeal" method="GET">
        <div class="main">
            <div class="input-group">
                <input name="bookName" type="text" class="form-control" placeholder="book name">
                <input name="createDate" type="date" class="form-control">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-secondary" type="button">
                        <i class="fa fa-search"></i>
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
<c:forEach var="dealHistory" items="${dealHistory}">
    <div class="container">
        <h4>${dealHistory.fullName} - ${dealHistory.creatDate}</h4>
        <div class="row justify-content-center">
            <div class="card" style="width:100%">
                <table border="1" class="table">
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="carts" items="${dealHistory.dealList}" varStatus="Counter">
                            <tr>
                                <td>${carts.bookName}</td>
                                <td>${carts.price}$</td>
                                <td>${carts.quantity}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <h5>Price: ${dealHistory.totalPrice + dealHistory.discountPrice}</h5>
                <h5>Discount Price: ${dealHistory.discountPrice}</h5>
                <h5>Total Price: ${dealHistory.totalPrice}</h5>

            </div>
        </div>                      
    </div>
    <br>
</c:forEach>
</body>
</html>
