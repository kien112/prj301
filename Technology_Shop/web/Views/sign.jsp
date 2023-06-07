<%-- 
    Document   : sign
    Created on : Nov 8, 2022, 8:43:50 PM
    Author     : 84877
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
        <!--        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
        <!------ Include the above in your HEAD tag ---------->
    </head>
    <style>
        .register{
            background: -webkit-linear-gradient(left, #3931af, #00c6ff);
            margin-top: 3%;
            padding: 3%;
        }
        .register-left{
            text-align: center;
            color: #fff;
            margin-top: 4%;
        }
        .register-left input{
            border: none;
            border-radius: 1.5rem;
            padding: 2%;
            width: 60%;
            background: #f8f9fa;
            font-weight: bold;
            color: #383d41;
            margin-top: 30%;
            margin-bottom: 3%;
            cursor: pointer;
        }
        .register-right{
            background: #f8f9fa;
            border-top-left-radius: 10% 50%;
            border-bottom-left-radius: 10% 50%;
        }
        .register-left img{
            margin-top: 15%;
            margin-bottom: 5%;
            width: 25%;
            -webkit-animation: mover 2s infinite  alternate;
            animation: mover 1s infinite  alternate;
        }
        @-webkit-keyframes mover {
            0% {
                transform: translateY(0);
            }
            100% {
                transform: translateY(-20px);
            }
        }
        @keyframes mover {
            0% {
                transform: translateY(0);
            }
            100% {
                transform: translateY(-20px);
            }
        }
        .register-left p{
            font-weight: lighter;
            padding: 12%;
            margin-top: -9%;
        }
        .register .register-form{
            padding: 10%;
            margin-top: 10%;
        }
        .btnRegister{
            float: right;
            margin-top: 10%;
            border: none;
            border-radius: 1.5rem;
            padding: 2%;
            background: #0062cc;
            color: #fff;
            font-weight: 600;
            width: 50%;
            cursor: pointer;
        }
        .register .nav-tabs{
            margin-top: 3%;
            border: none;
            background: #0062cc;
            border-radius: 1.5rem;
            width: 28%;
            float: right;
        }
        .register .nav-tabs .nav-link{
            padding: 2%;
            height: 34px;
            font-weight: 600;
            color: #fff;
            border-top-right-radius: 1.5rem;
            border-bottom-right-radius: 1.5rem;
        }
        .register .nav-tabs .nav-link:hover{
            border: none;
        }
        .register .nav-tabs .nav-link.active{
            width: 100px;
            color: #0062cc;
            border: 2px solid #0062cc;
            border-top-left-radius: 1.5rem;
            border-bottom-left-radius: 1.5rem;
        }
        .register-heading{
            text-align: center;
            margin-top: 8%;
            margin-bottom: -15%;
            color: #495057;
        }
    </style>
    <body>
        <form action="/Technology_Shop/signUp" method="post">
            <div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <h3>Welcome</h3>
                        <p>Hurry up to be able to buy good products at a favorable price</p>
                        <a href="/Technology_Shop/Views/login.jsp"><input type="button" name="" value="Login"/></a> <br/>
                    </div>

                    <div class="col-md-9 register-right">
                        <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Sign Up</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">New</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Sign Up</h3>
                                <div class="row register-form">

                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="fullname" placeholder="Full Name *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" required="" name="username" placeholder="UserName *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" required="" name="password" placeholder="Password *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" name="RePassword"  placeholder="Confirm Password *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <select class="form-control" name="city">
                                                <option class="hidden"  selected disabled>Please select your city</option>
                                                <c:forEach items="${city}" var="c">
                                                    <option value="${c.cityId}">${c.cityName}</option>
                                                </c:forEach> 
                                            </select>
                                            <p style="color: red;">${mess}</p>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="email" class="form-control" name="email" placeholder="Your Email *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" minlength="10" maxlength="10" name="phone" class="form-control" placeholder="Your Phone *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <select class="form-control" name="question">
                                                <option class="hidden"  selected disabled>Please select your Sequrity Question</option>
                                                <c:forEach items="${question}" var="q">
                                                    <option value="${q.questionId}">${q.content}</option>
                                                </c:forEach>   
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="answer" placeholder="Enter Your Answer *" value="" />
                                        </div>
                                        <input type="submit" class="btnRegister"  value="Sign Up"/>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>

            </div>
        </form>
    </body>

</html>
