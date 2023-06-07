<%-- 
    Document   : AccountSetting
    Created on : Oct 16, 2022, 4:19:41 PM
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
        .info{
            padding: 20px 50px;
            width: 340px;
            height: 400px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px #0082bb;
            margin: 100px 300px;
        }
        .form-change{  
            float: left;
            border-radius: 10px;
            box-shadow: 0px 0px 10px #0082bb;
            padding: 10px 40px;
            width: 370px;
            height: 300px;
        }
        .btnSave{
            margin-top: 50px;
            background-color: black;
            color: white;
            width: 50px;
            border-radius: 5px;
        }
        .btnHome{
            margin-top: 50px;
            background-color: black;
            width: 100px;
            height: 20px;
            text-align: center;
            padding: 10px;
            border-radius: 5px;
        }
        .btnChange{
            /*margin-top: 20px;*/
            position: absolute;
            top: 440px;
            left: 470px;
            background-color: black;
            color: white;
            width: 140px;
            height: 20px;
            text-align: center;
            padding: 10px;
            border-radius: 5px;
        }
        .btnChange:hover{
            box-shadow: 0px 0px 10px #0082bb;
        }
        .btnSave:hover{
            box-shadow: 0px 0px 10px #0082bb;
        }
        
        .btnHome:hover{
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
        
        <div class="info">
            <h1 style="text-align: center;">Account Setting</h1>
            <h3>Username: <input value="${account.username}" readonly=""/></h3>
            <h3>Password: <input type="password" value="${account.password}" readonly=""/></h3>
            
            <form action="/Technology_Shop/UpdateAccount" method="POST">
                <input name="username" value="${account.username}" hidden/>
                <h3>Email: <input name="email" value="${account.email}" /></h3>
                <h3>Phone: <input name="phone" value="${account.phone}" /></h3>
                <div>City:
                    <select id="city" name="city" style="width: 170px;">
                        <c:forEach items="${city}" var="c">
                            <option value="${c.cityId}" ${c.cityId==account.cityId ? "selected" : ""}>${c.cityName}</option>
                        </c:forEach>                
                    </select>
                </div>
                <button class="btnSave" type="submit">Save</button>
            </form>
                <div class="btnChange"><a style="text-decoration: none;color: white;" href="/Technology_Shop/ChangePassword?username=${account.username}" type="button">Change Password</a></div>
                <!--<div class="btnHome"><a style="text-decoration: none;color: white;" href="home" type="button">Return to home</a></div>-->
                <c:if test="${account.isAdmin}">
<!--                    <form action="/Technology_Shop/admin/CreateControl" method="POST">
                        <div class="create">
                            <input type="submit" value="Create New Admin"/>
                        </div>
                    </form>-->
                </c:if>    
        </div>               
    </body>
</html>
