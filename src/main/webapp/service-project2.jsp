<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>月租方案</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/service-project2.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
</head>
<body>
    <header>
        <div id="header_media">
            <a href="#"><img id="header_media_fb" src="./image/FB.png" alt="fb sign" width="30rem"></a>
            <a href="#"><img id="header_media_IG" src="./image/IG.png" alt="IG sign" width="30rem"></a>
            <a href="#"><img id="header_media_Line" src="./image/Line.png" alt="IG sign" width="30rem"></a>
            <a href="#"><img id="header_media_twitter" src="./image/Twitter.png" alt="IG sign" width="30rem"></a>
        </div>
       
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <a class="navbar-brand" href="<c:url value='/frontpage.jsp' />"><img src="./image/LOGO1.png" alt="LOGO" width="120rem"></a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/frontpage.jsp' />">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/about_us.jsp' />">About</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/shopping.jsp' />">Shopping</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/service.jsp' />">Service</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/shopping_cart.jsp' />">Shopping Cart</a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Log In</a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="<c:url value='/profiles.jsp' />">個人資訊</a></li>
                      <li><a class="dropdown-item" href="<c:url value='/order_main.jsp' />">訂單管理</a></li>
                      <li><a class="dropdown-item" href="<c:url value='/shopping_cart.jsp' />">購物車</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="<c:url value='/login.jsp' />">Log In</a></li>
                    </ul>
                  </li>
                </ul>
                <form class="d-flex">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
              </div>
            </div>
          </nav>
    </header>
    <nav>
        <div id="nav_title">服務方案 Service Project</div>
    </nav>
<!-- ---------------------------大框----------------------------------- -->

    <div class="card mb-3" style="max-width: 100%;">
        <div class="row g-0">
<!-- ---------------------------大框----------------------------------- -->


<!-- 圖片內 -->
    <div class="box1">
            <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                  <button  type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                  <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                  <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                  <div class="carousel-item active" data-bs-interval="10000">
                    <img src="./image/pexels-cottonbro-4604668.jpg" class="d-block" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text1">可靠的服務只是一個開始</h5>
                      <p class="text1">使命必達是我們對您的信念,給您最好的服務是我們願望</p>
                    </div>
                  </div>
                  <div class="carousel-item" data-bs-interval="2000">
                    <img src="./image/pexels-anna-shvets-3683199.jpg" class="d-block" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text1">一次一袋減少負擔</h5>
                      <p class="text1">若您的垃圾量過多,可以再幫您進行加購的服務</p>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <img src="./image/proj1-4.jpg" class="d-block" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                      <h5 class="text1">確實做好分類跟回收</h5>
                      <p class="text1">我們的垃圾袋有配合者不同的項目來搭配使用,請確實作好分類回收</p>
                    </div>
                  </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Next</span>
                </button>
              </div>
            </div>
<!-- ---------------------------圖片內----------------------------------- -->

<!-- 旁邊文字 -->
          <div class="col-md-8">
            <div class="card-body">
              <h3 class="fw-bold">月租方案：一周可以選擇3個時段(一個月以30天為主)</h3>
              <p class="card-text">適合對象：3-4人  小家庭/ 外宿族群/</p>
              <p class="card-text"><small class="text-muted">每周收取 3 次</small></p>
              <ul class="list-group list-group-flush">
                <li class="list-group-item">>  方案提供12個一般垃圾袋/ 6個回收袋/ 12個防臭廚餘袋</li>
                <li class="list-group-item">>  每次最多收取量為：一般垃圾、回收、廚餘 最多 2 袋</li>
                <li class="list-group-item">>  若您的垃圾量較多，使用超過方案提供的袋子量，可以加購</li>
                <li class="list-group-item">>  回收袋收取項目：寶特瓶、鐵鋁罐、玻璃瓶、紙類。較大型的紙箱或紙板，請您拆平後獨立  於回收袋外收取，單次最多收取 2 片。</li>
                <li class="list-group-item">>  結帳前請先確認您的地址是否在服務範圍內 </li>
                <li class="list-group-item">>  請先確認您選取正確的收取方式與時間 </li><br>
              </ul>

      <!-- -------------------------------旁邊文字------------------------------- -->

             <br><h4 class="fw-bold">方案時間</h4>
             <ul class="list-group list-group-flush">
             <li class="list-group-item">.  一個月（4 週）One Month(Four Weeks) </li>
             <li class="list-group-item">.  四個月（16 週）Four Month(Sixteen Weeks) </li>
             <li class="list-group-item">.  六個月（24 週）Six Month(Twenty-Four Weeks) </li>
            </ul><br>
           <hr class="lineproject" width="575px" size="5"><br>
    
 <!-- -------------------------------旁邊文字------------------------------- -->

<!-- 旁邊選單 -->
           
    <form class="formtest" id="formid" action="">
      <form class="d-flex" id="Datatext" for="mydate">選取開始日期
        <input id="mydate" class="form-control me-2" name="Data" type="data" placeholder="請選擇日期" aria-label="Data"><br>
    
        <form class="d-flex" id="Datatext" for="enddate">選取結束日期
          <input id="enddate" class="form-control me-2" name="Data" type="data" placeholder="結束日期" aria-label="Data"><br>

          <h5 >選擇每周來收取日子(請選擇三日)</h5>
          <form onsubmit="return check()" for="selectday" > 
            <div id="selectday"  name="Selectday">
          <div class="form-check form-check-inline" >
              <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="禮拜一 " onclick="return count(this)">
              <label class="form-check-label" for="inlineCheckbox1">禮拜一 Monday</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="禮拜二" onclick="return count(this)">
              <label class="form-check-label" for="inlineCheckbox2">禮拜二 Tuesday</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="禮拜三" onclick="return count(this)">
              <label class="form-check-label" for="inlineCheckbox3">禮拜三 Wednesday </label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="禮拜四" onclick="return count(this)">
              <label class="form-check-label" for="inlineCheckbox1">禮拜四 Thursday</label>
            </div><br>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="禮拜五 " onclick="return count(this)">
              <label class="form-check-label" for="inlineCheckbox2">禮拜五   Friday</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="禮拜六" onclick="return count(this)">
              <label class="form-check-label" for="inlineCheckbox3">禮拜六 Saturday </label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3" onclick="return count(this)">
              <label class="form-check-label" for="inlineCheckbox3">禮拜日 Sunday </label>
            </div>
          </div>
          </form> 

            <br>
           
            <div id="myMoney" class="input-group mb-3" name="Time">
                <label class="input-group-text" name="Time" for="inputGroupSelect01">時間選取 Time Selection</label>
                <select class="form-select" id="inputGroupSelect01" name="Time">
                    <option value="8:00am - 9:00am">8:00am - 9:00am</option>
                    <option value="9:00am - 10:00am">9:00am - 10:00am</option>
                    <option value="10:00am - 11:00am">10:00am - 11:00am</option>
                    <option value="11:00am - 12:00pm">11:00am - 12:00pm</option>
                    <option value="12:00pm - 13:00pm">12:00pm - 13:00pm</option>
                    <option value="13:00pm - 14:00pm">13:00pm - 14:00pm</option>
                    <option value="14:00pm - 15:00pm">14:00pm - 15:00pm</option>
                    <option value="15:00pm - 16:00pm">15:00pm - 16:00pm</option>
                    <option value="16:00pm - 17:00pm">16:00pm - 17:00pm</option>
                   
                </select>
            </div>

            <div id="myMoney" class="input-group mb-3" name="Money">
                <label class="input-group-text" for="singleSelect" name="Money">價格選取 Price Selection</label>
                <select class="form-select" id="singleSelect" name="Money">
                    <option value="600">600元</option>
                </select>
            </div>

            <button class="btn btn-outline-success" id="save_cart_btn" type="button"> 提交
            </button>
            </div>
        </form>
    </form>

          </div> 
        </div>
      </div>

<!-- 旁邊選單 -->

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
    <img id="footer_logo" src="./image/LOGO2.png" alt="footer_logo" width="200rem">
    <a href="#"><img id="footer_media_fb" src="./image/iconmonstr-facebook-3-240.png" alt="fb sign" width="30rem"></a>
    <a href="#"><img id="footer_media_IG" src="./image/iconmonstr-instagram-11-240.png" alt="IG sign" width="30rem"></a>
    <a href="#"><img id="footer_media_Line" src="./image/iconmonstr-line-3-240.png" alt="Line sign" width="30rem"></a>
    <a href="#"><img id="footer_media_Twitter" src="./image/iconmonstr-twitter-3-240.png" alt="Twitter sign" width="30rem"></a>
  
    <p>DAOBUNSO &copy; 2021 Garbage Connections. All Rights Reserved.<br>
    僅為北科大 Java 017 班專題展示使用 <br>
    如有任何問題請聯絡：XXXXX@gmail.com</p>
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
    <script src="./js/service-pro2.js"></script>
</body>
</html>
