<%-- 
    Document   : order
    Created on : Sep 30, 2022, 8:14:54 PM
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
        .table{
            width: 1400px;
            margin-left: 10px;
            text-align: center;
            margin-top: 200px;
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
            text-decoration: none;
            color: white;
            width: 150px;
            height: 50px;
            padding: 10px 10px;
            border-radius: 10px;
            margin: 70px 30px;
            top: 70px;
            left: 190px;
            position: absolute;
            border: 1px solid black;
            background-color: black;
        }
        .btn:hover{
            box-shadow: 0px 0px 10px #0082bb;
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
            </ul>
        </div>
        <div id="table1" class="waiting-table">
            <table class="table">
                <thead>
                    <tr>
                        <th>OrderId</th>
                        <th>Customer Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Order Date</th>
                        <th>Detail</th>
                        <th>Confirm</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${order}" var="o">
                        <tr style="border-radius: 10px;">
                            <td>${o.orderId}</td>
                            <c:forEach items="${listAcc}" var="a">
                                <c:if test="${o.username==a.username}">
                                    <td>${a.fullname}</td>
                                </c:if>
                            </c:forEach>

                            <td>${o.phone}</td>
                            <td>${o.email}</td>
                            <td>${o.address}</td>
                            <td>${o.date}</td>                    
                            <td><a href="/Technology_Shop/admin/orderDetail?orderId=${o.orderId}" style="color: ${o.orderId==index ? "red":"black"};">View Detail</a></td>
                            <td>
                                <c:if test="${o.status}">
                                    confirmed
                                </c:if>
                                <c:if test="${!o.status}">
                                    <a href="order?id=${o.orderId}" class='tick' style="color: green;" >&#x2714;</a>
                                    <a href="order?id=${o.orderId}&type=1" class="x" style="color: red;" >&#x2718;</a>
                                </c:if>                           
                            </td>

                        </tr>
                    </c:forEach>              
                </tbody>
            </table>
        </div>       
    </body>
</html>


<!--<table margin"0 auto" border="0" cellpadding="1">
                                                    <tr>
                                                        <th style="text-align: center; width: 320px;" colspan="2">${p.name}</th>
                                                    </tr>
                                                    <tr>
                                                        <td style="border-left: none;">Quantity: ${od.quantity}</td>
                                                        <td>Price: ${od.price} $</td>
                                                    </tr>
                                                </table>-->
<!--
<td id="${o.orderId}" style="width: 330px;">
                        
<c:forEach items="${orderDetail}" var="od">
    <c:if test="${o.orderId==od.orderId}">
        <c:forEach items="${list}" var="p">
            <c:if test="${od.productId==p.id}">
                <input class="quantity" value="${od.quantity}" hidden=""/>
                <input class="price" value="${od.price}" hidden=""/>
                <a href="">Detail</a>
            </c:if>
        </c:forEach>
    </c:if>
</c:forEach>  

<button onclick="show(this, ${o.orderId})">Get total</button>             
</td>-->