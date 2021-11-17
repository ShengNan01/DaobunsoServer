// 多語
let lang =  sessionStorage.getItem('lang');
$('#langbtn-en').click(() => {
    sessionStorage.setItem('lang',"?");
    console.log(sessionStorage.getItem('lang'));
});
$('#langbtn-tw').click(() => {
    sessionStorage.setItem('lang',"(l='zh_TW')");
    console.log(sessionStorage.getItem('lang'));
});


$(function () {
    if ( getCookieByName("id") != null && getCookieByName("name") != null && getCookieByName("email") != null && getCookieByName("account") != null) {
        $('#login-dropdown-bottom').text('Log Out');
        $('#login-dropdown-bottom').attr('href', './frontpage');
        $('#nav-login').text(getCookieValueByName('name'));
        $('#login-dropdown-bottom').click(() => {
            deleteCookie('id');
            deleteCookie('account');
            deleteCookie('name');
            deleteCookie('email');
            deleteCookie('password');
            deleteCookie('LoginOK');
        });
    } else {
        $('.login-dropdown-bottom').text('Log In');
        $('.login-dropdown-1,.login-dropdown-2').click(function (e) {
            e.preventDefault();
            updateModal("Oops!", "請先登入會員！");
            myModal.show();
            $(".modal-footer>button").click(function () {
                location.href = "./login";
            });
        });
        $('#login-dropdown-bottom').click(function () {
            location.assign('./login');
        });
    }
});
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