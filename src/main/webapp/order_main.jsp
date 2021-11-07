<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>訂單總覽</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link rel="stylesheet" href="./css/shopping_cart.css" />
  <script src="./js/jquery-3.6.0.js"></script>
</head>

<body>
  <header>
  </header>
  <div id="nav_title">訂單總覽 Orders</div>
  <center>
    <h1>訂單總覽</h1>
  </center>
  <div class="container">
    <table class="cart_table table table-hover">
      <thead class="cart_table_head">
        <tr>
          <th class="col">編號</th>
          <th class="col">訂購時間</th>
          <th class="col">總價</th>
        </tr>
      </thead>
      <tbody class="cart_table_body" id="order_main">
        <!-- <tr>
                    <td>
                      <a href="">編號</a>
                    </td>
                  <td>
                    <span>訂購時間</span>
                </td>
                  <td>
                      <span>總價</span>
                  </td>
                </tr> -->
      </tbody>
    </table>
    <br />
    <hr />
    <br />
    <div class="container" id="order_detail" style="display: none">
      <center>
        <h2>訂單明細</h2>
      </center>
      <table class="cart_table table table-hover">
        <thead class="cart_table_head">
          <tr>
            <th class="col">名稱</th>
            <th class="col">起始日期</th>
            <th class="col">結束日期</th>
            <th class="col">數量</th>
          </tr>
        </thead>
        <tbody class="cart_table_body">
          <!-- <tr>
                        <td>
                          <span id="">名稱</span>
                        </td>
                        <td>
                          <span>起始日期</span>
                      </td>
                      <td>
                        <span>結束日期</span>
                    </td>
                      <td>
                          <span>數量</span>
                      </td>
                    </tr> -->
        </tbody>
      </table>
      <div class="pay_box d-flex justify-content-end">
        <div>
          <div class="right_price">
            <span>總價：</span><span id="total">0</span><span> 元</span>
          </div>
        </div>
      </div>
    </div>
  </div>
  <center>
    <img src="./image/LOGO1.png" alt="LOGO" width="150rem" style="padding-bottom: 1.5rem" />
    <br />
    <hr style="width: 90%" />
    <br />
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
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="./js/order_main.js"></script>
  <script src="./js/logincheck.js"></script>
</body>

</html>