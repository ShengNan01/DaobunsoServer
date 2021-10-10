<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <title>Daobunso</title>
  </head>
  <body>
    <div class="product">
      <div class="container">
        <div class="row">

          <div class="col">
            <div class="product-img">
              <img src="">
            </div>
          </div>


          <div class="col my-auto">

            <div class="product-name">
              <h3 style="color: aqua;"><!--商品名稱--></h3>
            </div>

            <div class="product-content"><!--商品介紹--></div>

            <div class="row">
              <div class="product-price col-2 my-auto" style="color: red;font-size: 2rem;"><!--商品價格--></div><h4 class="col-1 my-auto">元</h4>
            </div>
            

            <!-- btn-group -->
            <div class="product-dropdown btn-group ms-1 my-auto">
              <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">數量</button>
              <ul class="dropdown-menu">
                <li class="dropdown-item1 btn-outline-primary">1</li>
                <li class="dropdown-item2 btn-outline-primary">2</li>
                <li class="dropdown-item3 btn-outline-primary">3</li>
                <li class="dropdown-item4 btn-outline-primary">4</li>
                <!-- <li class="dropdown-itemelse btn-outline-primary">else</li> -->
              </ul>
            </div>
            <!-- /btn-group -->
            <button type="button"class="cart-add btn btn-outline-primary my">加入購物車</button>


          </div>
        </div>
      </div>
    </div>
    <script src="js\jquery-3.6.0.js"></script>
    <script src="js\product.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  </body>
</html>