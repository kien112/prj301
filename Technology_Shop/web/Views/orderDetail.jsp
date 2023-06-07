

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <style>
        body {
            letter-spacing: 0.8px;
            background: linear-gradient(0deg , #fff , 50% , #74a0ff);
            background-repeat: no-repeat;
        }

        .container-fluid {
            margin-top: 80px !important;
            margin-bottom: 80px !important;
        }

        p {
            font-size: 14px;
            margin-bottom: 7px;
        }

        .cursor-pointer {
            cursor: pointer;
        }

        a{
            text-decoration: none !important;
            color: #651FFF !important;
        }

        .bold{
            font-weight: 600;
        }

        .small{
            font-size: 12px !important;
            letter-spacing: 0.5px !important;
        }

        .Today{
            color: rgb(83, 83, 83);
        }

        .btn-outline-primary{
            background-color: #fff !important;
            color:#4bb8a9 !important;
            border:1.3px solid #4bb8a9;
            font-size: 12px;
            border-radius: 0.4em !important;
        }

        .btn-outline-primary:hover{
            background-color:#4bb8a9  !important;
            color:#fff !important;
            border:1.3px solid #4bb8a9;
        }

        .btn-outline-primary:focus,
        .btn-outline-primary:active {
            outline: none !important;
            box-shadow: none !important;
            border-color: #42A5F5 !important;
        }

        #progressbar {
            margin-bottom: 30px;
            overflow: hidden;
            color: #455A64;
            padding-left: 0px;
            margin-top: 30px
        }

        #progressbar li {
            list-style-type: none;
            font-size: 13px;
            width: 33.33%;
            float: left;
            position: relative;
            font-weight: 400;
            color: #455A64 !important;

        }

        #progressbar #step1:before {
            content: "1";
            color: #fff;
            width: 29px;
            margin-left: 15px !important;
            padding-left: 11px !important;
        }


        #progressbar #step2:before {
            content: "2";
            color: #fff;
            width: 29px;

        }

        #progressbar #step3:before {
            content: "3";
            color: #fff;
            width: 29px;
            margin-right: 15px !important;
            padding-right: 11px !important;
        }

        #progressbar li:before {
            line-height: 29px;
            display: block;
            font-size: 12px;
            background: #455A64 ;
            border-radius: 50%;
            margin: auto;
        }

        #progressbar li:after {
            content: '';
            width: 121%;
            height: 2px;
            background: #455A64;
            position: absolute;
            left: 0%;
            right: 0%;
            top: 15px;
            z-index: -1;
        }

        #progressbar li:nth-child(2):after {
            left: 50%;
        }

        #progressbar li:nth-child(1):after {
            left: 25%;
            width: 121%;
        }
        #progressbar li:nth-child(3):after {
            left: 25% !important;
            width: 50% !important;
        }

        #progressbar li.active:before,
        #progressbar li.active:after {
            background: #4bb8a9;
        }

        .card {
            background-color: #fff ;
            box-shadow: 2px 4px 15px 0px rgb(0, 108, 170);
            z-index: 0;
        }

        small{
            font-size: 12px !important;
        }

        .a {
            justify-content: space-between !important;
        }

        .border-line {
            border-right: 1px solid rgb(226, 206, 226)
        }

        .card-footer img{
            opacity: 0.3;
        }

        .card-footer h5{
            font-size: 1.1em;
            color: #8C9EFF;
            cursor: pointer;
        }
        
    </style>
    <body>       
        <div class="container-fluid my-5 d-sm-flex justify-content-center">          
            <div class="card px-2">
                <div class="card-header bg-white">
                    <div class="row justify-content-between">
                        <div class="col">                     
                            <p class="text-muted"> Order ID  <span class="font-weight-bold text-dark">${order.orderId}</span></p> 
                            <p class="text-muted"> Order date <span class="font-weight-bold text-dark">${order.date}</span> </p></div>
                        <div class="flex-col my-auto">
                            <h6 class="ml-auto mr-3">
                                <a>View Details</a>
                            </h6>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <ol>
                        <c:forEach items="${orderDetail}" var="od">
                            <c:forEach items="${list}" var="p">
                                <c:if test="${od.productId==p.id}">
                                    <li><div class="media flex-column flex-sm-row">
                                    <div class="media-body ">
                                        <h5 class="bold">${p.name}</h5>
                                        <p class="text-muted"> Quantity: ${od.quantity}</p>
                                        <h4 class="mt-3 mb-4 bold"> <span class="mt-5">$</span> ${od.price} <span class="small text-muted"></span></h4> 
                                        <input class="price" value="${od.price}" hidden=""/>
                                        <input class="quantity" value="${od.quantity}" hidden=""/>
                                    </div><img class="align-self-center img-fluid" src="${p.image}" width="100" height="100">
                                </div></li>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </ol>
                </div>
                        <div style="position: relative; width: 100%; height: 100px;">
                    <form action="/Technology_Shop/admin/order" method="post">
                        <input name="index" value="${order.orderId}" hidden=""/>
                        <button type="submit" style="width: 150px; height: 50px; position: absolute; top: 10px; left: 50px;" class="btn-outline-primary">Return to Order</button>
                    </form>
                    <button onclick="show(this)" style="width: 150px; height: 50px; position: absolute; top: 10px; left: 300px;" class="btn-outline-primary">Get Total</button>
                </div>
            </div>
        </div>
        <script>
            function show(t){
                var price = document.getElementsByClassName("price");
                var quantity = document.getElementsByClassName("quantity");
                var total = 0;
                for (var i = 0; i < price.length; i++) {
                    total += price[i].value * quantity[i].value;
                }
                t.innerHTML = "Total = $" + total;
            }
        </script>
    </body>
</html>
