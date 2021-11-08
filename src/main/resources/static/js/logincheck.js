// header產生
$('header').html(`<div id="header_media">
<a href="#"><img id="header_media_fb" src="./image/FB.png" alt="fb sign" width="30rem"></a>
<a href="#"><img id="header_media_IG" src="./image/IG.png" alt="IG sign" width="30rem"></a>
<a href="#"><img id="header_media_Line" src="./image/Line.png" alt="IG sign" width="30rem"></a>
<a href="#"><img id="header_media_twitter" src="./image/Twitter.png" alt="IG sign" width="30rem"></a>     
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="container-fluid">
  <a class="navbar-brand" href="./frontpage"><img src="./image/LOGO1.png" alt="LOGO" width="120rem"></a>
  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
      <li class="nav-item">
        <a class="nav-link" href="./frontpage">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./about_us">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./shopping">Shopping</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./service">Service</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./shopping_cart">Shopping Cart</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Log In</a>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="./profiles">個人資訊</a></li>
          <li><a class="dropdown-item" href="./order_main">訂單管理</a></li>
          <li><a class="dropdown-item" href="./shopping_cart">購物車</a></li>
          <li><hr class="dropdown-divider"></li>
          <li><a id ="logintoggle"class="dropdown-item togin" href="./login">Log In</a></li>
        </ul>
      </li>
    </ul>
    <form class="d-flex">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</div>
</nav>`);
// ~header產生
// header.javascript

$(function () {
	if (getCookieByName("id") != null && getCookieByName("name") != null && getCookieByName("email") != null && getCookieByName("account") != null) {
		$('#logintoggle').text('Log Out');

		$('.dropdown-item:eq(3)').attr('href', './frontpage');
		$('.dropdown-toggle:not(.btn)').text(getCookieValueByName('name'));
		$('.dropdown-item:eq(3)').click(() => {

			deleteCookie('id');
			deleteCookie('account');
			deleteCookie('name');
			deleteCookie('email');
			deleteCookie('password');
			deleteCookie('LoginOK');
			$('.dropdown-item:eq(3)').text('Log In');

		});
	} else {
		$('#logintoggle').text('Log In');

		$('.dropdown-item:eq(0),.dropdown-item:eq(1)').click(function (e) {
			e.preventDefault();
			updateModal("Oops!", "請先登入會員！");
			myModal.show();
			$(".modal-footer>button").click(function () {
				location.href = "./login";
			  });
		});
		$('.dropdown-item:eq(3)').click(function () {
			location.assign('./login.html');
		});
	}
});
// ~header.javascript

//  控制Cookie方法
{
	function getCookieByName(name) {
		let arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
		if (arr != null) return unescape(arr[2]);
		return null;
	}
	function deleteCookie(name) {
		var exp = new Date();
		exp.setTime(exp.getTime() - 1);
		var cval = getCookieByName(name);
		if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
	}
	function parseCookie() {
		var cookieObj = {};
		var cookieAry = document.cookie.split(';');
		var cookie;
		for (var i = 0, l = cookieAry.length; i < l; ++i) {
			cookie = jQuery.trim(cookieAry[i]);
			cookie = cookie.split('=');
			cookieObj[cookie[0]] = cookie[1];
		}
		return cookieObj;
	}
	function getCookieValueByName(name) {
		var value = parseCookie()[name];
		if (value) {
			value = decodeURIComponent(value);
		}
		return value;
	}
}
//  ~控制Cookie方法 

// footer產生
$('footer').html(`<img id="footer_logo" src="./image/LOGO2.png" alt="footer_logo" width="200rem">
<a href="#"><img id="footer_media_fb" src="./image/iconmonstr-facebook-3-240.png" alt="fb sign" width="30rem"></a>
<a href="#"><img id="footer_media_IG" src="./image/iconmonstr-instagram-11-240.png" alt="IG sign" width="30rem"></a>
<a href="#"><img id="footer_media_Line" src="./image/iconmonstr-line-3-240.png" alt="Line sign" width="30rem"></a>
<a href="#"><img id="footer_media_Twitter" src="./image/iconmonstr-twitter-3-240.png" alt="Twitter sign" width="30rem"></a>

<p>DAOBUNSO &copy; 2021 Garbage Connections. All Rights Reserved.<br>
僅為北科大 Java 017 班專題展示使用 <br>
如有任何問題請聯絡：XXXXX@gmail.com</p>`);
// ~footer產生
