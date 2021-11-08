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
        <meta charset="ISO-8859-1">
        <title>List buy book Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

        <style>
            .main {
                width: 70%;
                margin: 50px auto;
            }

            /* Bootstrap 4 text input with search icon */

            .has-search .form-control {
                padding-left: 2.375rem;
            }

            .has-search .form-control-feedback {
                position: absolute;
                z-index: 2;
                display: block;
                width: 2.375rem;
                height: 2.375rem;
                line-height: 2.375rem;
                text-align: center;
                pointer-events: none;
                color: #aaa;
            }

            .max-width-30px{
                max-width: 30px;
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
        <div class="container">
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
                <c:if test = "${!useruser.role.roleName.equals('admin')}">
                    <li class="nav-item active">
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
            <h1  class="row justify-content-center" style="margin-top: 50px">Books</h1>
            <form action="listBookToBuy" method="GET">
                <div class="main">
                    <div class="input-group">
                        <input name="bookName" type="text" class="form-control" placeholder="book name">
                        <input name="categoryName" type="text" class="form-control" placeholder="category name">
                        <input name="minPrice" id="minPrice" type="number" class="form-control" placeholder="min pirce" onclick="setMin()">
                        <input name="maxPrice" id="maxPrice" type="number" class="form-control" placeholder="max pirce" onclick="setMax()">
                        <script>
                            function setMin() {
                                return document.getElementById('minPrice').max = document.getElementById("maxPrice").value;
                                
                            }
                            function setMax() {
                               
                                return  document.getElementById('maxPrice').min = document.getElementById("minPrice").value;
                                
                            }

                        </script>
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-secondary" type="button">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </form>

            <div style="height: 10px"></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th  scope="col" class="max-width-30px" >No</th>
                <th  scope="col">Name</th>
                <th  scope="col" >Title</th>
                <th  scope="col" >Author</th>
                <th  scope="col" >Quantity</th>
                <th  scope="col" >Category</th>    
                <th  scope="col" >Price</th>          
                <th  scope="col" >Description</th>
                <th  scope="col" ></th>

                <div class=""></div>
                </tr>
                <thead>
                    <tbody>    
            <c:forEach var="books" items="${books}" varStatus="status">
                <tr>
                <form action="AddToCart" method="POST">
                    <div class="row ">
                        <td class="max-width-30px" >${status.index + 1}</td>
                        <td  >${books.name}</td>
                        <td >${books.title}</td>
                        <td  >${books.author}</td>
                        <td >${books.quantity}</td>
                        <td >${books.categoryName}</td>
                        <td >${books.price}$</td>  
                        <td >${books.description}</td>
                        <td >
                            <button type="submit" class="btn btn-primary" style="width: 80px; margin: auto" data-toggle="modal" data-target="#model${books.id}">
                                Add To Cart
                            </button>
                            <div class="form-group">
                                <input type="hidden" name="bookId" value="${books.id}" class="form-control" title="Only use english and not special character">
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="bookName" value="${books.name}" class="form-control" title="Only use english and not special character">
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="price" value="${books.price}" class="form-control" title="Only use english and not special character">
                            </div>
                        </td>
                    </div>
                </form>
            </tr>
            </c:forEach>
            </tbody>
        </table>

            <nav aria-label="Page navigation example" class="center-screen">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="ListBookToBuy?page=${page == 0 ? page : page - 1}&bookName=${bookName}&categoryName=${categoryName}&minPrice=${minPrice}&maxPrice=${maxPrice}">Previous</a></li>
                        <c:forEach begin="0" end="${paging}" step="1" varStatus="loop">
                        <li class="page-item ${page == (loop.count -1 )? "active" : ""}"><a class="page-link" href="ListBookToBuy?page=${loop.count - 1}&bookName=${bookName}&categoryName=${categoryName}&minPrice=${minPrice}&maxPrice=${maxPrice}">${loop.count}</a></li>
                        </c:forEach>

                    <li class="page-item"><a class="page-link" href="ListBookToBuy?page=${page == paging ? page : page + 1}&bookName=${bookName}&categoryName=${categoryName}&minPrice=${minPrice}&maxPrice=${maxPrice}">Next</a></li>

                </ul>


            </nav>

        </div>
    </div>
    </body>
</html>
