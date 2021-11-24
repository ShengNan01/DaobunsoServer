const loginOK = getCookieValueByName('LoginOK');
$(()=>{
    if (loginOK == null) {
        updateModal("Oops!", "請先進行登入再寄發驗證信!");
        myModal.show();
        $('.modal-footer>button').click(function () {
            location.href = './login';
        });
    }
});
const memberId = getCookieValueByName('id');
const regex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
$("#verify_email_btn").click(function () {
    if (loginOK == null) {
        updateModal("Oops!", "請先進行登入再寄發驗證信!");
        myModal.show();
        $('.modal-footer>button').click(function () {
            location.href = './login';
        });
    }else{
        if ($("#email").val() === "") {
            updateModal("Oops!", "請輸入註冊之電子信箱");
            myModal.show();
        } else if (!regex.test($("#email").val())) {
            updateModal("Oops!", "輸入電子信箱格式不正確");
            myModal.show();
        } else {
            let email = $('#email').val();
            const Email = {
                "email": email,
                "memberId": memberId,
            }
            let url = 'https://daobunso.myddns.me/verification_email';
            fetch(url, {
                method: 'POST',
                body: JSON.stringify(Email),
                headers: { 'Content-Type': 'application/json' },
            }).then(response => {
                response.text()
                    .then(text => {
                        if (text === "Success") {
                            updateModal("發送郵件成功!", "請至信箱收取驗證信件。");
                            myModal.show();
                            $('.modal-footer>button').click(function () {
                                location.href = './frontpage';
                            })
                        } else if (text === "Fail") {
                            updateModal("Oops!", "必須輸入此帳號註冊時的電子信箱");
                            myModal.show();
                        }

                    }).catch((err) => {
                        updateModal("Oops!", "發生錯誤!");
                        myModal.show();
                        return;
                    });
            });
        };
    }
});
//跳頁
function nextPage() {
    location.href = "https://daobunso.myddns.me/"
}