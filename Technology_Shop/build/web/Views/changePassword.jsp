<%-- 
    Document   : changePassword
    Created on : Oct 24, 2022, 8:50:11 AM
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
        .form-change{ 
            border-radius: 10px;
            box-shadow: 0px 0px 10px #0082bb;
            padding: 10px 40px;
            width: 370px;
            height: 300px;
            margin: 100px 400px;
        }
        .btnChange{
            /*margin-top: 20px;*/
            position: absolute;
            top: 360px;
            left: 610px;
            background-color: black;
            color: white;
            width: 110px;
            height: 30px;
            text-align: center;
            padding: 10px;
            border-radius: 5px;
        }
        .btnChange:hover{
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
        
        <div id="form" class="form-change">
            <h2>Change Password</h2>
            <form action="/Technology_Shop/ChangePassword" method="POST">
                <input name="username" value="${username}" hidden/>
                Old Password: <input type="password" name="password" required value="e"/><br><br> 
                New Password: <input type="password" name="newpassword" required value=""/><br><br> 
                Re-New Password: <input type="password" name="renewpassword" value=""/><br> 
                <div>Question:
                    <select id="question" name="question" style="width: 300px;">
                        <c:forEach items="${question}" var="q">
                            <option value="${q.questionId}">${q.content}</option>
                        </c:forEach>                
                    </select>
                </div><br>
                Answer: <input name="answer" type="password"/><br>
                <button class="btnChange" type="submit">Change</button><br>
                <c:if test="${mess!=null}">
                    <p style="color: red;margin-left: 160px; margin-top: -10px;">${mess}</p>
                </c:if>
            </form>
            <a href="/Technology_Shop/UpdateAccount?username=${username}">Account Setting</a>
        </div>
    </body>
</html>
