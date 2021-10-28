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
            <h1  class="row justify-content-center" style="margin-top: 50px">Books</h1>
            <form action="book" method="GET">
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
            <%--<c:if test = "${user.roleID.equals('manager')}">--%>
            <button type="button" class="btn btn-primary center" data-toggle="modal" data-target="#myModal">
                Add Book
            </button>       
            <%--</c:if>--%>
            <!-- The Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="book" enctype="multipart/form-data" method="post">  
                            <!-- Modal body -->
                            <div class="modal-body">

                                <div id="logout">
                                    <div class="container">
                                        <div class="row justify-content-center align-items-center">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    Category :
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <select name="categoryId" class="form-control" id="exampleFormControlSelect1">
                                                        <c:forEach items="${categories}" var="categories">
                                                            <option value="${categories.id}">${categories.categoryName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="row justify-content-center align-items-center">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    Name :
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <input type="text" name="bookName" class="form-control" title="Oly use english and not special character" required>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="row justify-content-center align-items-center">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    Image :
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <input type="file" name="image" class="form-control" title="Oly use english and not special character" required>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="row justify-content-center align-items-center">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    Title :
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <input type="text" name="title" class="form-control" title="Oly use english and not special character" required>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="row justify-content-center align-items-center">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    Import Date :
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <input type="date" name="importDate" class="form-control" required>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="row justify-content-center align-items-center">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    Quantity :
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <input type="number" name="quantity" class="form-control" min="0" required>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="row justify-content-center align-items-center">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    price :
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <input type="number" step="0.01" name="price" min="0" class="form-control" required>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row justify-content-center align-items-center">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    Author :
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <input type="text" name="author" class="form-control" title="Only use english and not special character">
                                                </div>
                                            </div>

                                        </div>

                                        <div class="row justify-content-center align-items-center">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    Description :
                                                </div>
                                            </div>
                                            <div class="col-md-8">
                                                <div class="form-group">
                                                    <input type="text" name="description" class="form-control" title="Only use english and not special character">
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
            <!-- The Modal -->


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
                        <button type="button" class="btn btn-primary" style="width: 80px; margin: auto" data-toggle="modal" data-target="#model${books.id}">
                            Update
                        </button>
                        <br/>
                        <br/>
                        <button type="button" class="btn btn-danger"  style="width: 80px; margin: auto" data-toggle="modal" data-target="#modelD${books.id}">
                            Delete
                        </button>

                    </div>
                    <div class=""></div>
                </div>

                <script>
                    $('#model${books.id}').on('shown.bs.modal');
                    $('#modelD${books.id}').on('shown.bs.modal');

                </script>

                <div class="modal" id="modelD${books.id}">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <form action="deleteBook" method="POST">
                                <div class="modal-header">
                                    <h5 class="modal-title">Delete</h5>
                                </div>
                                <div class="container">
                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <h3> Do you want delete '${books.name}'? </h3>
                                            </div>                                 
                                        </div>
                                    </div>

                                </div>
                                <div class="col-md-8 invisible" style="height: 0px">
                                    <div class="form-group">
                                        <input type="text" name="bookId" value="${books.id}" class="form-control" title="Only use english and not special character">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary">Save</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>

                <div class="modal" id="model${books.id}">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <form action="updateBook" method="POST">


                                <div class="modal-header">
                                    <h5 class="modal-title">Update</h5>
                                </div>

                                <div class="container">
                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                Category :
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <select name="categoryId" class="form-control" id="exampleFormControlSelect1">
                                                    <c:forEach items="${categories}" var="categories">
                                                        <option value="${categories.id}" ${categories.id.equals(books.categoryId)? "selected" : ""}>${categories.categoryName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                Name :
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="text" name="bookName" value="${books.name}" class="form-control" title="Oly use english and not special character" required>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="row justify-content-center align-items-center">

                                    </div>
                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                Title :
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="text" name="title" value="${books.title}"  class="form-control" title="Oly use english and not special character" required>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                Import Date :
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="date" name="importDate" value="${books.importDate}" class="form-control" required>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                Quantity :
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="number" name="quantity" value="${books.quantity}" min="0" class="form-control" required>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                price :
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="number" step="0.01" name="price" value="${books.price}" min="0" class="form-control" required>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                Author :
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="text" name="author" value="${books.author}" class="form-control" title="Only use english and not special character">
                                            </div>
                                        </div>

                                    </div>

                                    <div class="row justify-content-center align-items-center">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                Description :
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <input type="text" name="description" class="form-control" value="${books.description}" title="Only use english and not special character">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-8 invisible" style="height: 0px">
                                        <div class="form-group">
                                            <input type="text" name="bookId" value="${books.id}" class="form-control" title="Only use english and not special character">
                                        </div>
                                    </div>
                                </div>

                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary">Save</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </c:forEach>


            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="book?page=${page == 0 ? page : page - 1}&bookName=${bookName}&categoryName=${categoryName}&minPrice=${minPrice}&maxPrice=${maxPrice}">Previous</a></li>
                        <c:forEach begin="0" end="${paging}" step="1" varStatus="loop">
                        <li class="page-item ${page == (loop.count -1 )? "active" : ""}"><a class="page-link" href="book?page=${loop.count - 1}&bookName=${bookName}&categoryName=${categoryName}&minPrice=${minPrice}&maxPrice=${maxPrice}">${loop.count}</a></li>
                        </c:forEach>

                    <li class="page-item"><a class="page-link" href="book?page=${page == paging ? page : page + 1}&bookName=${bookName}&categoryName=${categoryName}&minPrice=${minPrice}&maxPrice=${maxPrice}">Next</a></li>

                </ul>


            </nav>

        </div>

    </body>
</html>
