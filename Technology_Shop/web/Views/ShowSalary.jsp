<%-- 
    Document   : ShowSalary
    Created on : Oct 19, 2022, 4:43:26 PM
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
        .content{
            margin: 100px 20px;
        }
        .table{
            width: 1100px;
            margin-left: 10px;
            text-align: center;
            margin-top: 10px;
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
        .input{
            margin: 0px 30px;
            float: left;
        }
        .btn2{
            text-decoration: none;
            color: white;
            width: 120px;
            height: 20px;
            padding: 10px 10px;
            border-radius: 10px;
            top: 80px;
            left: 900px;
            position: absolute;
            border: 1px solid black;
            background-color: black;
        }
        .btn2:hover{
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
        <div class="content">
            <form action="/Technology_Shop/admin/salary" method="POST">
                <div class="input">From: <input type="date" required="" name="from"/></div>
                <div class="input">To:  <input type="date" required="" name="to"/></div>
                <div class="input"><input type="submit" value="submit" /></div>
            </form>
            <!--<div><a href="/Technology_Shop/home">Home</a></div>-->
            <p>From: ${from}  to: ${to} </p>
            <a id="btn2" class="btn2" name="total" onclick="getTotal()" type="button">Get total</a>
            <table class="table">
                <thead>
                    <tr>
                        <th>OrderId</th>
                        <th>Username</th>
                        <th>Date</th>
                        <th>List Product</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${orderList}" var="o">
                        <tr style="border-radius: 10px;">
                            <td style="width: 100px;">${o.orderId}</td>
                            <td style="width: 100px;">${o.username}</td>
                            <td style="width: 200px;">${o.date}</td>
                            <td style="width: 300px;">
                                <c:forEach items="${orderDetail}" var="od">
                                    <c:if test="${o.orderId==od.orderId}">
                            <li>ID: ${od.productId} || Quantity: ${od.quantity} || Price: ${od.price}</li>                               
                            </c:if>
                        </c:forEach>  
                    </td>
                    <td>
                        <c:forEach items="${total}" var="t">
                            <c:if test="${t.orderId==o.orderId}">
                                <input class="total" value="${t.total}" style="width: 50px;" hidden=""/>
                                <p>${t.total} $</p>
                            </c:if>
                        </c:forEach>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <script>
            function getTotal() {
                var x = document.getElementsByClassName("total");
                var result = 0;
                for (let i = 0; i < x.length; i++) {
                    result = result + x[i].value * 1;
                }
                document.getElementById("btn2").innerHTML = "Total = " + result + " $";
            }
        </script>

    </body>
</html>
