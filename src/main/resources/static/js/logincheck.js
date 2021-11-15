
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
			location.assign('./login');
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