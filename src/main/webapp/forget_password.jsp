<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>忘記密碼</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/forget_password.css">
    <script src="./js/jquery-3.6.0.js"></script>
</head>
<body>
  <header>
  </header>
    <div id="nav_title">忘記密碼</div>
    <center><h2>請填寫以下資訊</h2></center>
    <center><h2>我們將寄送更改密碼信件給您</h2></center>
    <div class="container">
        <table class="cart_table table table-hover">
           
            <tbody class="cart_table_body" id="order_main">
             
              <form>
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">ACCOUNT 請輸入您的帳號*</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Email 請輸入您的信箱*</label>
                  <input type="email" class="form-control" id="exampleInputPassword1">
                  <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
            </tbody>
        </table>        
    </div>
    <center>
      <img src="./image/LOGO1.png" alt="LOGO" width="150rem" style="padding-bottom: 1.5rem;"> <br>
      <hr style="width:90%;"> <br>
  </center>
  <div id="sec_area_8">
      <a href="<c:url value='/about_us.jsp' />">關於我們</a>
      <a href="<c:url value='/service_intro.jsp' />">服務介紹</a>
      <a href="<c:url value='/User terms.jsp' />">使用須知</a>
      <a href="<c:url value='/problem.jsp' />">常見問題</a>
      <a href="<c:url value='/feedback.jsp' />">使用回饋</a>
      <a href="<c:url value='/service.jsp' />">購買服務</a>
      <a href="<c:url value='/shopping.jsp' />">購物商城</a>
  </div>

<footer>
</footer>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modal-title"></h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" id="massage-content">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="./js/forget_password.js"></script>

</body>
</html>