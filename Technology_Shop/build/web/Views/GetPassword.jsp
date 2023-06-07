<%-- 
    Document   : GetPassword
    Created on : Oct 19, 2022, 2:43:57 PM
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
        .form{
            width: 500px;
            height: 560px;
            box-shadow: 0px 0px 5px #0082bb;
            border-radius: 10px;
            margin: 100px 400px;
            padding: 10px 10px;
        }    
        .form-field{
            /*border: 1px solid black;*/
            margin: 20px 40px;
        }
        .btn{
            background-color: black;
            color: white;
            border-radius: 5px;
            width: 60px;
            height: 30px;
            margin: 5px 30px;
        }
        .btn:hover{
            box-shadow: 0px 0px 5px #0082bb;
        }
        .form-input:focus{
            box-shadow: 0px 0px 5px #0082bb;
        }
        a{
            position: absolute;
            left: 670px;
            top: 610px;
        }
    </style>
    <body>
        <div class="form">
            <h1 style="text-align: center;">Forget Password</h1>
            <form action="/Technology_Shop/GetPassword" method="post">
                <div class="form-field">
                    <h3>UserName:<h3>
                    <input type="text" class="form-input" name="username" required="" value="user" placeholder="username"/>
                </div>
                <div class="form-field">Question:
                <select id="question" name="question" style="width: 300px;">
                    <c:forEach items="${question}" var="q">
                            <option value="${q.questionId}">${q.content}</option>                        
                    </c:forEach>                
                </select>
                </div>
                <div class="form-field">
                    <h3>Answer:</h3>
                    <input class="form-input" required="" name="answer" type="password" value="" placeholder="answer.."/>
                </div>
                <div class="form-field">
                    <h3>New Password:</h3>
                    <input type="password" class="form-input" name="newpassword" minlength="6" maxlength="31" required="" placeholder="password"/>
                </div>
                <div class="form-field">
                    <h3>Re-NewPassword:</h3>
                    <input type="password" class="form-input" name="renewpassword" value="" placeholder="re-password"/>
                </div>
                <p style="color: red; margin: 0px 50px;">${mess}</p>
                <button class="btn" type="submit">Submit</button> 
            </form>
            <a href="Views/login.jsp" type="submit" value="Login">Login</a>
            </div>
    </body>
</html>
