// 多語化
{
    // 進入頁面的初始化
    let langsearch;
    if (sessionStorage.getItem('lang') == null) {
        sessionStorage.setItem('lang', "?l=zh_TW");
    } else {
        langsearch = sessionStorage.getItem('lang');
        langinit();
    }
    // ~進入頁面的初始化
    // 語言按鈕
    $('#langbtn-en').click(() => {
        sessionStorage.setItem('lang', "?l=en_US");
        langsearch = sessionStorage.getItem('lang');
        langinit();
        window.location.href = window.location.protocol + window.location.pathname + langsearch;
    });
    $('#langbtn-tw').click(() => {
        sessionStorage.setItem('lang', "?l=zh_TW");
        langsearch = sessionStorage.getItem('lang');
        langinit();
        window.location.href = window.location.protocol + window.location.pathname + langsearch;
    });
    // ~語言按鈕
    // 連結初始化
    function langinit() {
        // headerherf
        $('#hreffrontpage').attr('href', "./" + langsearch);
        $('#dropdown-profiles').attr('href', "./profiles" + langsearch);
        $('#dropdown-orders').attr('href', "./orders" + langsearch);
        $('#dropdown-shopping_cart').attr('href', "./shopping_cart" + langsearch);
        $('#dropdown-login').attr('href', "./login" + langsearch);
        $('#nav-frontpage').attr('href', "./frontpage" + langsearch);
        $('#nav-about_us').attr('href', "./about_us" + langsearch);
        $('#nav-shopping').attr('href', "./shopping" + langsearch);
        $('#nav-service').attr('href', "./service" + langsearch);
        $('#nav-shopping_cart').attr('href', "./shopping_cart" + langsearch);
        // ~headerherf
    }
    // ~連結初始化
}
// ~多語化

// 登入dropdown
$(function () {
    if (getCookieByName("id") != null && getCookieByName("name") != null && getCookieByName("email") != null && getCookieByName("account") != null) {
        $('#dropdown-login').text('Log Out');
        $('#dropdown-login').attr('href', './frontpage');
        $('#nav-login').text(getCookieValueByName('name'));
        $('#dropdown-login').click(() => {
            deleteCookie('id');
            deleteCookie('account');
            deleteCookie('name');
            deleteCookie('email');
            deleteCookie('password');
            deleteCookie('LoginOK');
        });
    } else {
        $('.dropdown-login').text('Log In');
        $('#dropdown-profiles,#dropdown-orders,#footer-feedback').click(function (e) {
            e.preventDefault();
            updateModal("Oops!", "請先登入會員！");
            myModal.show();
            $(".modal-footer>button").click(function () {
                location.href = "./login";
            });
        });
        $('#dropdown-login').click(function () {
            location.assign('./login');
        });
    }
});
// ~登入dropdown
// 控制Cookie方法
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
// ~控制Cookie方法

// modal方法
let myModal = new bootstrap.Modal(document.getElementById('myModal'))
function updateModal(title, massage) {
    $('#modal-title').text(title);
    $('#massage-content').text(massage);
}
// reset modal when modal was hidden
let myModalEl = document.getElementById("myModal");
myModalEl.addEventListener("hidden.bs.modal", function (event) {
    updateModal("", "");
});
// ~modal方法