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
        <title>JSP Page</title>
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
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="home">Book Store</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item ">  
                            <a class="nav-link" href="home">Home</a>
                        </li>
                    <c:if test = "${!user.role.id.equals('admin')}">
                        <li class="nav-item active">
                            <a class="nav-link" href="listBookToBuy">Book</a>
                        </li>
                    </c:if>
                    <li class="nav-item ">
                        <a class="nav-link" href="listDeal">Deal</a>
                    </li>
                    <li class="nav-item">
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
            <div class="row border">
                <div class="col border" style="min-width: 110px;">Name</div>
                <div class="col border" style="min-width: 110px;">Image</div>
                <div class="col border" style="min-width: 110px;">Title</div>
                <div class="col border" style="min-width: 110px;">Author</div>
                <div class="col border" style="min-width: 110px;">Import Date</div>
                <div class="col border" style="min-width: 110px;">Quantity</div>
                <div class="col border" style="min-width: 110px;">Category</div>    
                <div class="col border" style="min-width: 110px;">Price</div>          
                <div class="col border" style="min-width: 110px;">Description</div>
                <div class="col border" style="min-width: 110px;"></div>

                <div class=""></div>

            </div>
            <c:forEach var="books" items="${books}">
                <form action="addToCart" method="POST">
                    <div class="row border">
                        <div class="col border" style="min-width: 110px;">${books.name}</div>
                        <div class="col border" style="min-width: 110px; padding: 0px">
                            <img src="${books.image}" style="width: 100px; height: 100px; padding: 10px">
                        </div>
                        <div class="col border" style="min-width: 110px;">${books.title}</div>
                        <div class="col border" style="min-width: 110px;">${books.author}</div>
                        <div class="col border" style="min-width: 110px;">${books.importDate}</div>
                        <div class="col border" style="min-width: 110px;">${books.quantity}</div>
                        <div class="col border" style="min-width: 110px;">${books.category}</div>
                        <div class="col border" style="min-width: 110px;">${books.price}$</div>  
                        <div class="col border" style="min-width: 110px;">${books.description}</div>
                        <div class="col border" style="min-width: 110px;">
                            <button type="submit" class="btn btn-primary" style="width: 80px; margin: auto" data-toggle="modal" data-target="#model${books.id}">
                                Add To Cart
                            </button>
                        </div>
                        <div class="col-md-8 invisible" style="height: 0px">
                            <div class="form-group">
                                <input type="text" name="bookId" value="${books.id}" class="form-control" title="Only use english and not special character">
                            </div>
                        </div>
                        <div class="col-md-8 invisible" style="height: 0px">
                            <div class="form-group">
                                <input type="text" name="bookName" value="${books.name}" class="form-control" title="Only use english and not special character">
                            </div>
                        </div>
                        <div class="col-md-8 invisible" style="height: 0px">
                            <div class="form-group">
                                <input type="text" name="price" value="${books.price}" class="form-control" title="Only use english and not special character">
                            </div>
                        </div>
                    </div>
                </form>

            </c:forEach>


            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="listBookToBuy?page=${page == 0 ? page : page - 1}&bookName=${bookName}&categoryName=${categoryName}&minPrice=${minPrice}&maxPrice=${maxPrice}">Previous</a></li>
                        <c:forEach begin="0" end="${paging}" step="1" varStatus="loop">
                        <li class="page-item ${page == (loop.count -1 )? "active" : ""}"><a class="page-link" href="listBookToBuy?page=${loop.count - 1}&bookName=${bookName}&categoryName=${categoryName}&minPrice=${minPrice}&maxPrice=${maxPrice}">${loop.count}</a></li>
                        </c:forEach>

                    <li class="page-item"><a class="page-link" href="listBookToBuy?page=${page == paging ? page : page + 1}&bookName=${bookName}&categoryName=${categoryName}&minPrice=${minPrice}&maxPrice=${maxPrice}">Next</a></li>

                </ul>


            </nav>

        </div>

    </body>
</html>
