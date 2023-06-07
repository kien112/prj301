<%-- 
    Document   : login
    Created on : Sep 26, 2022, 7:28:50 AM
    Author     : 84877
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <!--<link rel="stylesheet" href="css/logins.css">-->
    <style>
        .login{
    width: 350px;
    height: 500px;
    background-color: white;
    box-shadow: 0px 0px 10px #0082bb;
    border-radius: 10px;
    padding: 50px;
    margin: 0 auto;
    margin-top: 50px;  
    color: black;
}

.logo img{
    width: 70px;
    height: 70px;
    margin-left: 120px;
    margin-top: -10px;
}

.form-input{
    padding: 20px;
    border: 1px solid blue;
    margin: 10px 20px;
    border-radius: 20px;
    width: 300px;
    height: 50px;
    padding: 0 20px;
}

.form-input:focus{
    border-color: #0082bb;
    box-shadow: 0px 0px 5px #0082bb;
}

.form-field{
    position: relative;
    
}
.btn{
    width: 100px;
    height: 40px;
    border-radius: 20px;
    margin: 20px 120px;
    background-color: #0082bb;
    color: white;
}
.signup{
    margin-left: 80px;
    margin-top: 20px;
}
.forget{
    text-align: center;
    margin: 10px 110px;
}
    </style>
    <body>
        <div class="login">
            <h1 style="text-align: center;">Login</h1>

            <form action="/Technology_Shop/login" method="post">
                <div class="form-field">
                    <h3>UserName:<h3>
                    <input type="text" class="form-input" name="username" placeholder="username"/>
                </div>
                <div class="form-field">
                    <h3>Password:</h3>
                    <input type="password" class="form-input" name="password" placeholder="password"/>
                </div>
                <p style="color: red;">${error}</p>
                <button class="btn" type="submit">Login</button> 
            </form>
                <a class="forget" href="/Technology_Shop/GetPassword">Forget password?</a>
            <div class="signup">
                Do you have an account? <a href="/Technology_Shop/signUp">Sign up</a>
            </div>
        </div>
        
    </body>
</html>
