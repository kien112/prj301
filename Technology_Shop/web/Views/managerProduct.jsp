<%-- 
    Document   : managerProduct
    Created on : Sep 27, 2022, 3:03:57 PM
    Author     : 84877
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <link rel="stylesheet" href="css/stylehome.css">
    <link rel="stylesheet" href="css/styleManager.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <style>
        #fixNav{
            width: 100%;
            height: 45px;
            background-color: #0082bb;
            display: block;
            box-shadow: 0px 2px 2px rgba(0,0,0,0.5); /*Đổ bóng cho menu*/
            position: fixed; /*Cho menu cố định 1 vị trí với top và left*/
            top: 0; /*Nằm trên cùng*/
            left: 0; /*Nằm sát bên trái*/
            z-index: 100000; /*Hiển thị lớp trên cùng*/
        }
        #fixNav ul{
            margin: 0 50px;
            padding: 0;
        }
        #fixNav ul li{
            list-style:none inside;
            width: auto;
            float: left;
            line-height: 45px; /*Cho text canh giữa menu*/
            color: #fff;
            padding: 0;
            margin-right:10px;
            position: relative;
        }
        #fixNav ul li a{
            text-transform: uppercase;
            white-space: nowrap; /*Cho chữ trong menu không bị wrap*/
            padding: 0 10px;
            color: #fff;
            display: block;
            font-size: 0.8em;
            text-decoration: none;
        }
        /*CSS Style cho Submenu*/
        #fixNav ul li ul {
            position: absolute;
            width: auto;
            display: none;
            background-color: #252525;
            border-bottom: 3px solid #0082bb;
            padding-left: 5px;
        }

        #fixNav ul li ul li{
            display: block;
            padding:0;
            margin: 0;
            float: none; /*Bỏ float cho li cấp thứ 2*/
        }
        /* Hover cho submenu */
        #fixNav ul li:hover {
            /* Hover thì li sẽ đổi màu*/
            background-color: #252525;
        }
        #fixNav ul li:hover ul{
            /*Display ra submenu*/
            display: block;
        }

        .page{
            position: absolute;
            top: 100px;
            left: 300px;
        }

        .table{
            width: 1000px;
            margin-left: 200px;
            text-align: center;
            margin-top: 150px;
            border-collapse: collapse;
            border-radius: 5px;
            border: 10px solid #efefef;
        }
        .table th{
            height: 50px;
            color: black;
            background-color: #efefef;
        }

        .table tr{
            top: 10px;
            margin: 100px 5px;
            border: 4px solid #efefef;
            border-radius: 10px;
        }
        .table tr td{
            border-left: 10px solid #efefef;
            border-radius: 5px;
        }
        .table input{
            font-weight: bold;
            background-color: #0082bb;
            border-radius: 10px;
            color: white;
        }
        .table a{
            text-decoration: none;
            margin-left: 20px;
        }
        .btn{
            width: 100px;
        }
        .hide-delete{
            position: absolute;
            margin-top: 0px;
            margin-left: 28px;
            background-color: black;
            color: white;
            border-radius: 5px;
            font-size: 14px;
            display: none;
        }
        .hide-edit{
            position: absolute;
            margin-top: 0px;
            margin-left: 98px;
            background-color: black;
            color: white;
            border-radius: 5px;
            font-size: 14px;
            display: none;
        }

        .delete:hover + .hide-delete {
            display: block;
        }

        .edit:hover + .hide-edit {
            display: block;
        }
        .btnIndex{
            border-radius: 5px;
            background-color: black;
            color: white;
        }
        .btnIndex:hover{
            box-shadow: 0px 0px 5px #0082bb;
        }
        .check{
            position: absolute;
            top: 100px;
            left: 600px;
            width: 400px;
            height: 50px;
            padding: 10px 15px;
            margin: -10px 0px;
            color: blue;
            border-radius: 20px;
            box-shadow: 0px 0px 10px #aaa;
        }
        .btnCheck{
            background-color: black;
            color: white;
            border-radius: 5px;
        }
        .btnCheck:hover{
            box-shadow: 0px 0px 5px #0082bb;
        }
    </style>
    <body>
        <div id="fixNav">
            <ul>
                <li><a href="/Technology_Shop/home">Home</a></li>
                <li><a href="#">Contact</a></li>
                    <c:if test="${acc.isAdmin}">               
                    <li><a href="/Technology_Shop/admin/Manager">Manager</a></li>
                    <li><a href="/Technology_Shop/admin/order">Order</a></li>
                    <li><a href="/Technology_Shop/Views/ShowSalary.jsp">Salary</a></li>
                    </c:if>              
                    <c:if test="${acc==null}">                   
                    <li><a href="Views/login.jsp">Login</a></li>
                    </c:if>
                    <c:if test="${acc!=null}">
                    <li><a style="color: yellow;" href="/Technology_Shop/UpdateAccount?username=${acc.username}">${acc.fullname}</a></li>
                    <li><a href="/Technology_Shop/logout">Logout</a></li>
                    </c:if>    
                <li>
                    <a href="#">Category</a>
                    <ul class="sub-menu">
                        <c:forEach items="${category}" var="c">                            
                            <li><a href="/Technology_Shop/search?categoryId=${c.categoryId}">${c.categoryName}</a></li>
                            </c:forEach>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="page">
            <form action="Manager" method="POST">
                <c:if test="${config.pageIndex!=null}">
                    <c:if test="${config.pageIndex-2>1}">
                        <button class="btnIndex" type="submit" name="page" value="1">Home</button>
                    </c:if>  

                    <c:forEach begin="${config.pageStart}" end="${config.pageEnd}" var="i">
                        <button class="btnIndex" type="submit" name="page" style="background-color: ${i==config.pageIndex ? "blue" : ""}" value="${i}">${i}</button>
                    </c:forEach> 
                    <c:if test="${config.pageIndex-2<1}">
                        <button class="btnIndex" type="submit" name="page" value="${config.totalPage}">End</button>
                    </c:if> 
                </c:if> 
            </form>
        </div>     
        <div class="check">
            <form action="Manager" method="post">
                Check Quantity Under: <input style="width: 100px;" type="number" name="qty" value="${quantity}"/>
                <input class="btnCheck" type="submit" value="Check"/>
            </form>
        </div>
        <c:if test="${productList.size()==0}">
            <p style="position: absolute; top: 180px; left: 630px; color: red; font-size: 20px;">Not found products have quantity under ${quantity}</p>
        </c:if>
        <c:if test="${productList.size()!=0}">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Image</th>
                        <th>Description</th>
                        <th class="btn"><a href="/Technology_Shop/Views/add.jsp" class="add"><input type="button" value="+ Add new"/></a></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${productList}" var="p">
                        <tr style="border-radius: 10px;">
                            <td>${p.id}</td>
                            <td>${p.name}</td>
                            <td style="width:100px;">${p.price} $</td>
                            <td style="width:100px;">${p.quantity}</td>
                            <td><img src="${p.image}" width="100px" height="90px"/></td>
                            <td>${p.desciption}</td>
                            <td><a href="#" onclick="showMess(${p.id})"  class='far delete' >&#xf2ed;</a><p class="hide-delete">delete</p>
                                <a href="/Technology_Shop/admin/Update?pid=${p.id}" class="fas edit" >&#xf044;</a><p class="hide-edit">edit</p></td>
                        </tr>
                    </c:forEach>                
                </tbody>
            </table>
        </c:if> 
        <script>
            function showMess(id) {
                var option = confirm('do you want to delete');
                if (option === true) {
                    window.location.href = '/Technology_Shop/admin/delete?pid=' + id;
                }
            }
        </script>
    </body>
</html>
