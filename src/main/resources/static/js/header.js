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