<%-- 
    Document   : cart
    Created on : Nov 4, 2022, 8:51:35 AM
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
<!--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>-->
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <body>
        <form action="SubmitOrder" method="post">
        <div style="height: 1000px;" class="h-100 bg-gray-300">
            <div class="py-12">
                <div class="max-w-md mx-auto bg-gray-100 shadow-lg rounded-lg  md:max-w-5xl">
                    <div class="md:flex ">
                        <div class="w-full p-4 px-5 py-5">
                            <div class="md:grid md:grid-cols-3 gap-2 ">
                                <div class="col-span-2 p-5">
                                    <h1 class="text-xl font-medium ">
                                        Shopping Cart
                                        <c:if test="${tempOrder.size()==0}">
                                            <c:if test="${mess==null}">
                                                <span style="margin-left: 100px; color: red;">Your cart is empty</span>
                                            </c:if>                                           
                                        </c:if>
                                            <span style="margin-left: 100px; color: red;">${mess}</span>
                                    </h1>
                                    <c:forEach items="${tempOrder}" var="t">  
                                        <input name="productId" class="productId" value="${t.productId}" hidden=""/>
                                        <input name="username" value="${t.username}" hidden=""/> 
                                        <c:forEach items="${listP}" var="p">
                                            <c:if test="${t.productId==p.id}">
                                                <c:if test="${p.price!=t.price}">
                                                    <c:forEach items="${newPrice}" var="n">
                                                        <c:if test="${n.productId==t.productId}">
                                                            <div class="flex justify-between items-center mt-6 pt-6">
                                                                <div class="flex  items-center">
                                                                    <input style="margin-right: 10px;" type="checkbox" class="check" name="isSelect" value="${t.productId}"/>
                                                                    <img src="${p.image}" width="60" class="rounded-full ">
                                                                    <div class="flex flex-col ml-3">
                                                                        <span class="md:text-md font-medium">${p.name}</span>
                                                                        <span class="text-xs font-light text-gray-400">#${p.id}: time update: ${n.date}</span>
                                                                    </div>
                                                                </div>
                                                                <div class="flex justify-center items-center">
                                                                    <div class="pr-8 flex ">
                                                                        <!--<span class="font-semibold">-</span>-->
                                                                        <input type="number" name="quantity" class="focus:outline-none bg-gray-100 border h-6 w-13 rounded text-sm px-2 mx-2 quantity" value="${t.quantity}" min="1" max="${p.quantity}">
                                                                        <!--<span class="font-semibold">+</span>-->
                                                                    </div>
                                                                    <div class="pr-8 ">
                                                                        <input name="price" class="price" value="${t.price}" style="width: 50px;" hidden="">
                                                                        <span class="text-xs font-medium">$${t.price}</span>
                                                                    </div>
                                                                    <div>
                                                                        <a href="Delete?productId=${t.productId}&username=${t.username}"><i class="fa fa-close text-xs font-medium"></i></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:if>                                                       
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${p.price==t.price}">
                                                    <div class="flex justify-between items-center mt-6 pt-6">
                                                        <div class="flex  items-center">
                                                            <input style="margin-right: 10px;" type="checkbox" class="check" name="isSelect" value="${t.productId}"/>
                                                            <img src="${p.image}" width="60" class="rounded-full ">
                                                            <div class="flex flex-col ml-3">
                                                                <span class="md:text-md font-medium">${p.name}</span>
                                                                <span class="text-xs font-light text-gray-400">#${p.id}</span>
                                                            </div>
                                                        </div>
                                                        <div class="flex justify-center items-center">
                                                            <div class="pr-8 flex ">
                                                                <!--<span class="font-semibold">-</span>-->
                                                                <input type="number" name="quantity" class="focus:outline-none bg-gray-100 border h-6 w-13 rounded text-sm px-2 mx-2 quantity" value="${t.quantity}" min="1" max="${p.quantity}">
                                                                <!--<span class="font-semibold">+</span>-->
                                                            </div>
                                                            <div class="pr-8 ">
                                                                <input name="price" class="price" value="${t.price}" style="width: 50px;" hidden="">
                                                                <span class="text-xs font-medium">$${t.price}</span>
                                                            </div>
                                                            <div>
                                                                <a href="Delete?productId=${t.productId}&username=${t.username}"><i class="fa fa-close text-xs font-medium"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                    <div class="flex justify-between items-center mt-6 pt-6 border-t"> 
                                        <div class="flex items-center">
                                            <a href="home"><i class="fa fa-arrow-left text-sm pr-2"></i>
                                                <span class="text-md  font-medium text-blue-500">Continue Shopping</span></a>
                                        </div>
                                        <c:if test="${tempOrder.size()!=0}">
                                            <div class="flex justify-center items-end">
                                                <a id="btn2" class="btn2" name="total" onclick="myFunction()" type="button">
                                                    <span class="text-sm font-medium text-gray-400 mr-1">Get Total:</span>
                                                </a> 
                                                <span id="btn2" class="text-lg font-bold text-gray-800 "></span>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                                <c:if test="${tempOrder.size()!=0}">
                                    <div style="height: 500px;" class=" p-5 bg-gray-800 rounded overflow-visible">
                                        <span class="text-xl font-medium text-gray-100 block pb-3">Customer Info</span>

                                        <div class="flex justify-center flex-col pt-3">
                                            <label class="text-xs text-gray-400 ">Email</label>
                                            <input type="email" name="email" required="" value="${sessionScope.acc.email}" class="focus:outline-none w-full h-6 bg-gray-800 text-white placeholder-gray-300 text-sm border-b border-gray-600 py-4" placeholder="email..">
                                        </div>
                                        <div class="flex justify-center flex-col pt-3">
                                            <label class="text-xs text-gray-400 ">Phone Number</label>
                                            <input type="text" name="phone" required="" value="${sessionScope.acc.phone}" class="focus:outline-none w-full h-6 bg-gray-800 text-white placeholder-gray-300 text-sm border-b border-gray-600 py-4" placeholder="phone..">
                                        </div>
                                        <div class="flex justify-center flex-col pt-3">
                                            <label class="text-xs text-gray-400 ">Address</label>
                                            <input type="text" name="address" required="" value="${city}" class="focus:outline-none w-full h-6 bg-gray-800 text-white placeholder-gray-300 text-sm border-b border-gray-600 py-4" placeholder="address..">
                                        </div>

                                        <button style="margin-top: 50px;" onclick="check()" class="h-12 w-full bg-blue-500 rounded focus:outline-none text-white hover:bg-blue-600">Submit</button>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        <script>
            function myFunction() {
                var x = document.getElementsByClassName("price");
                var y = document.getElementsByClassName("quantity");
                var result = 0;
                for (let i = 0; i < x.length; i++) {
                    result+=x[i].value*y[i].value;
                }
                document.getElementById("btn2").innerHTML = "Total = $"+result;
                document.getElementById("btn2").value = result;
            }
            
            function check(){
                var x = document.getElementsByClassName("check");
                var check = false;
                for (var i = 0; i < x.length; i++) {
                    if(x[i].checked){
                        check = true;
                    }
                }
                if(!check){
                    x[0].setAttribute("required", "required"); 
//                    document.getElementById("mess").innerHTML = "you must be select at least 1 product to submit";
                }else{
                    x[0].removeAttribute("required"); 
//                    document.getElementById("mess").innerHTML = "";
                }
            }
        </script>
    </body>
</html>

