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
        <title>List Deal Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

        <style>
            .margin-top-100{
                margin-top: 100px;;
            }
            .center-screen {
                display: flex;
                justify-content: center;
                align-items: center;
                text-align: center;
            }
        </style>
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
                <li class="nav-item active">
                    <a class="nav-link" href="ListDeal">Deal</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Discount">Discount</a>
                </li>
                <c:if test = "${user.role.id.equals('admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="Category">Category</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="Book">Book</a>
                    </li>
                </c:if>
            </ul>
            <span class="nav-item my-2">
                <a class="nav-link my-2" href="Logout"><button class="btn btn-primary">Logout</button></a>
            </span>
        </div>
    </nav>
        <c:set var="total" value="${0}"/>
<c:forEach var="carts" items="${carts}">
    <c:set var="total" value="${total + carts.price}" />
</c:forEach>
        <c:if test = "${!user.role.id.equals('admin')}">
            <c:if test="${not empty carts}">
            <table class="table margin-top-100">
                <thead>
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
                <form action="UpdateCart" method="POST">
                    <td><input type="number" name="quantity" value="${carts.quantity}"/> </td>
                    <input type="hidden" name="id" value="${carts.bookId}"/>
                    <td><input class="btn btn-primary" type="submit" value="Update"/></td>
                </form>
                <form action="DeleteCart" method="POST">
                    <input type="hidden" name="id" value="${carts.bookId}"/>
                    <td><input class="btn btn-primary" type="submit" value="Delete"/></td>
                </form>
            </tr>
            <tr>
                <th scope="row" colspan="4">
                    Price
                </th>
                <td colspan="1">
                    ${total}
                </td>
            </tr>
            <tr>
                <th scope="row" colspan="4">
                    Discount Price
                </th>
                <td colspan="1">
                    ${(total*discount.percent)/100}
                </td>
            </tr>
            <tr>
                <th scope="row" colspan="4">
                    Total Price
                </th>
                <td colspan="1">
                    ${total - (total*discount.percent)/100}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
            
            
<br/>
<form action="AddDiscount" method="POST">
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
<button type="button" class="btn btn-primary center" data-toggle="modal" style="width: 100px" data-target="#myModal">
    Buy
</button>
</c:if>
<c:if test="${empty carts}">
    <h4 class="center-screen margin-top-100">Empty Cart</h4>
</c:if>
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
                        <form action="ConfirmDeal" method="POST">
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

    <form action="ListDeal" method="GET">
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

</body>
</html>
