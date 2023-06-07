<%-- 
    Document   : CreateAdmin
    Created on : Oct 19, 2022, 3:51:11 PM
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
    <body>
        <table class="table">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Change to Admin</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${accountList}" var="acc">
                <c:if test="${!acc.isAdmin}">
                    <form action="/Technology_Shop/admin/CreateControl" method="POST">
                        <tr style="border-radius: 10px;">
                            <input name="username" value="${acc.username}" hidden=""/>
                            <td style="width: 300px; text-align: center;">${acc.username}</td>
                            <td style="text-align: center;"><input type="submit" value="+"/></td>
                        </tr>
                    </form>                   
                </c:if>              
            </c:forEach>               
            </tbody>
        </table>
        <p>${mess}</p>
        <a href="/Technology_Shop/home">Home</a>
    </body>
</html>
