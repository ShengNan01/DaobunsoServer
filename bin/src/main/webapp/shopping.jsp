<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Daobunso</title>

    <style type="text/css">
        .main{
            width: 90%;
            height: 40vh;
            margin: auto;
        }
        .main .container{
            background-image: url(./image/service_intro\ picture/log-cabin-1886620_1920.jpg);
            background-size:cover;
        }
        .main .text{
            text-align:center;
            color: aliceblue;
            background-color: cadetblue;
            background: hsla(178,70%,60%,0.4);
            margin-top: -13%;
            margin-left: -10vh;
        }
        .nav_title{
            margin-top: 0.5rem;
            background-color: #2D3E4D;
            width: 100vw;
            height: 3rem;
            font-size: 1.5rem;
            color: #FFF;
            text-align: center;
            line-height: 3rem;
        }
        .card_b1:hover,.card_b2:hover,.card_b3:hover,.card_b4:hover,.card_b5:hover{
            cursor: pointer;
        }
        .res_area{
            width: 90%;
            height: 50vh;
        }
    </style>
</head>
<body>
    <div class="main">
        <div class="container w-100 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-10">
                    <div class="text w-50">
                        <h1>Shopping</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="nav_title">商城 Shopping</div>
    <div class="shopping">
        <div class="container">
            <div class="row">
                <div class="col-3 m-auto">
                    <div class="card product1" style="width: 20rem;height: 20rem;">
                        <img src="" class="card-img-top" >
                        <div class="card-body">
                            <h5 class="card-title"></h5>
                            <p class="card-content"></p>
                            
                            <div class="col">
                                <div class="price" style="color: red"></div>
                            </div>
                            
                            <div class="col"style="margin-left: 12rem;">
                                <a class="spl btn btn-primary">前往商品</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-3 m-auto">
                    <div class="card product2" style="width: 20rem;height: 20rem;">
                        <img src="" class="card-img-top" >
                        <div class="card-body">
                            <h5 class="card-title"></h5>
                            <p class="card-content"></p>
                            
                            <div class="col">
                                <div class="price" style="color: red"></div>
                            </div>

                            <div class="col"style="margin-left: 12rem;">
                                <a class="spl btn btn-primary">前往商品</a>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-3 m-auto">
                    <div class="card product3" style="width: 20rem;height: 20rem;">
                        <img src="" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title"></h5>
                            <p class="card-content"></p>
                            
                            <div class="col">
                                <div class="price" style="color: red;"></div>
                            </div>
                            
                            <div class="col" style="margin-left: 12rem;">
                                <a class="spl btn btn-primary ">前往商品</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script src="js\jquery-3.6.0.js"></script>
    <script src="js\shopping.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>