<%-- 
    Document   : update
    Created on : Sep 30, 2022, 8:12:00 PM
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
    <link rel="stylesheet" href="css/styleAdd.css"/>
        <style>
        
h3{
    font-size: 30px;
    text-align: center;
}
.form{
    width: 600px;
    height: 600px;
    box-shadow: 0px 0px 10px #084298;
    border-radius: 10px;
    padding: 10px 20px;
    margin: 50px 300px;
}
.input{
    margin: 10px 30px;
    width: 300px;
    height: 30px;
    border-radius: 5px;
}

.input:focus{
    box-shadow: 0px 0px 10px #0082bb;
}

.selection{
    margin: 10px 20px;
}
.btn{
    width: 90px;
    height: 40px;
    border-radius: 5px;
    background-color: #0082bb;
    margin: 30px 20px;
}
.btn:hover{
    box-shadow: 0px 0px 10px #0082bb;
}
    </style>
    <body>
        <form class="form" action="/Technology_Shop/admin/Update" method="post">
            <h3 class="title">Update product</h3>
            <div>ID:<input class="input" type="text" name="id" placeholder="id.." value="${product.id}" readonly=""></div>
            <div>Name Product: <input class="input" type="text" name="name" placeholder="name.." value="${product.name}"></div>
            <div>Price: <input id="price" onfocusout="myFunction()" class="input" type="number" min="1" name="price" placeholder="price.." value="${product.price}"></div>
            <input id="oldprice" type="number" name="oldPrice" value="${product.price}" hidden=""/>
            <div id="date" style="display: none;">
                Apply with product in cart from: <input id="input"  type="date" name="date"/>
            </div>
            <div>Quantity: <input class="input" type="number" min="1" name="quantity" placeholder="quantity.." value="${product.quantity}"></div>
            <div>Image: <input class="input" type="text" name="image" placeholder="image.." value="${product.image}"></div>
            <div class="selection">Choose a category:
            <select id="category" name="category">
                <c:forEach items="${category}" var="c">
                    <option value="${c.categoryId}" ${c.categoryId.equals(product.categoryId) ? "selected" : "" }>${c.categoryName}</option>
                </c:forEach>                
            </select></div>
            <div class="text-field">
                Description:<br><textarea id="" name="description" rows="4" cols="50" placeholder="description..">${product.desciption}</textarea></div>
            <button class="btn" type="submit">Update</button>
        </form>
            <script>
                function myFunction() {
                    var price = document.getElementById("price").value;
                    var oldprice = document.getElementById("oldprice").value;
                    if(price!==oldprice){
                        document.getElementById("date").style.display = 'block';
                        document.getElementById("input").setAttribute("required", "required"); 
                    }else{
                        document.getElementById("date").style.display = 'none';
                        document.getElementById("input").removeAttribute("required");
                    }
                }
            </script>
    </body>
</html>
