<%-- 
    Document   : productDetail
    Created on : Oct 3, 2022, 3:24:30 PM
    Author     : 84877
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <style>
        .product{
            width: 700px;
            height: 500px;
            box-shadow: 0px 0px 10px #aaa;
            border-radius: 10px;
            margin: 100px 100px;
            display: flex;
        }
        .product-image{
            float: left;
            width: 350px;
            height: 350px;
            /*border: 1px solid black;*/
        }
        .product-image img{
            /*border-radius: 10px;*/
            margin: 10px 20px;
            width: 300px;
            height: 300px;
        }
        h3{
            font-size: 28px;
        }
        .product-info h3, p{
            text-align: center;
        }
        .description{
            margin-left: 10px;
            margin-top: 30px;
            width: 300px;
        }
        .btnHome{
            color: white;
            width: 150px;
            height: 50px;
            padding: 10px 10px;
            border-radius: 10px;
            margin: 70px 30px;
            top: 400px;
            left: 500px;
            position: absolute;
            border: 1px solid black;
            background-color: black;
        }
        .btnHome:hover{
            box-shadow: 0px 0px 10px #0082bb;
        }
        .comment{
            top: 100px;
            left: 900px;
            position: absolute;
            width: 300px;
            /*border: 1px solid black;*/
        }
        ul{
            margin: 20px -40px;
        }
        ul li{
            list-style-type: none;
        }
    </style>
    <body>
        <div class="product">
            <div class="product-image"><img src="${product.image}"/></div>
            <div class="product-info">
                <h3>${product.name}</h3>
                <p>Price: <span style="color:red;font-size: 20px;">${product.price} $</span></p>
                <p class="description"><img src="https://cdn-icons-png.flaticon.com/512/3176/3176218.png" width="30px" height="30px"/>
                    ${product.desciption}</p>
                <a class="btnHome" href="home" style="text-decoration: none; text-align: center;">Return to home</a>
            </div>

        </div>  
        <div class="comment">
            <h2>Comment</h2>
            <form action="/Technology_Shop/addComment" method="POST">
                <input name="username" value="${account.username}" hidden=""/>
                <input name="productId" value="${product.id}" hidden=""/>
                <c:if test="${account.username!=null}">
                    <input type="text" id="inputComment" name="comment" required="" placeholder="comment.."/>
                    <button type="submit">Send</button>
                </c:if>
            </form>
            <ul>
                <c:forEach items="${comment}" var="c">
                    <li>
                        <c:if test="${c.reply==0}">
                            <img src="https://w7.pngwing.com/pngs/754/2/png-transparent-samsung-galaxy-a8-a8-user-login-telephone-avatar-pawn-blue-angle-sphere-thumbnail.png" width="30" height="30" class="img-circle"/>                       
                            <c:if test="${account.username==c.username}">
                                <span style="color: red;">you</span>
                            </c:if>
                            <c:if test="${account.username!=c.username}">
                                <c:forEach items="${accList}" var="a">
                                    <c:if test="${c.username==a.username}">
                                        <span style="color: blue;">${a.fullname}</span>
                                    </c:if>
                                </c:forEach>                            
                            </c:if> | ${c.date}

                            <p style="text-align: left; margin-top: 0px; margin-left: 30px; font-size: 20px;">${c.content}</p>
                            <p onclick="show(${c.id})" style="margin-left: -220px; margin-top: -10px; color: grey;">reply</p>
                            <div style="display: none;" id="${c.id}">
                                <ul>
                                    <c:forEach items="${comment}" var="r">
                                        <c:if test="${r.reply!=0}">
                                            <c:if test="${r.reply==c.id}">
                                                <li style="margin-left: 30px;">
                                                    <img src="https://w7.pngwing.com/pngs/754/2/png-transparent-samsung-galaxy-a8-a8-user-login-telephone-avatar-pawn-blue-angle-sphere-thumbnail.png" width="30" height="30" class="img-circle"/>                       
                                                    <c:if test="${account.username==r.username}">
                                                        <span style="color: red;">you</span>
                                                    </c:if>
                                                    <c:if test="${account.username!=r.username}">
                                                        <c:forEach items="${accList}" var="a">
                                                            <c:if test="${r.username==a.username}">
                                                                <span style="color: blue;">${a.fullname}</span>
                                                            </c:if>
                                                        </c:forEach>                            
                                                    </c:if> | ${r.date}
                                                    <p style="text-align: left; margin-top: 0px; margin-left: 30px; font-size: 20px;">${r.content}</p>
                                                </li>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                                <form action="/Technology_Shop/addComment" method="post">
                                    <input name="productId" value="${product.id}" hidden=""/>
                                    <input name="cid" value="${c.id}" hidden=""/>
                                    <input style="margin-left: 60px;" type="text" name="reply" required="" placeholder="reply.."/>
                                    <input type="submit" value="send"/>
                                </form>
                            </div>
                        </c:if>                       
                    </li>
                </c:forEach>
            </ul>

        </div>
        <script>

            function show(t) {
                if (document.getElementById(t).style.display === "none") {
                    document.getElementById(t).style.display = "block";
                } else {
                    document.getElementById(t).style.display = "none";
                }
            }
        </script>
    </body>
</html>


