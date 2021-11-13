let myModal = new bootstrap.Modal(document.getElementById('myModal'));
const memberId = getCookieValueByName('id');
const regex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
$("#verify_email_btn").click(function () {
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
        let url = 'https://localhost/verifyEmail';
        fetch(url, {
            method: 'POST',
            body: JSON.stringify(Email),
            headers: { 'Content-Type': 'application/json' },
        }).then(response => {
            response.text()
                .then(text => {
                    if (text === "Success") {
                        updateModal("發送郵件成功!", "請至信箱收取信件修改密碼。");
                        myModal.show();
                        $('.modal-footer>button').click(function(){
                            location.href='./frontpage';
                        })
                    } else if (text === "Fail") {
                        updateModal("Oops!", "必須輸入此帳號註冊時的電子信箱");
                        myModal.show();
                    }

                });
        });
    };
});
//Modal Function
function updateModal(title, massage) {
    $('#modal-title').text(title);
    $('#massage-content').text(massage);
    }
// reset modal when modal was hidden
let myModalEl = document.getElementById('myModal')
myModalEl.addEventListener('hidden.bs.modal', function() {
    updateModal("","");
})
//跳頁
function nextPage(){
    location.href = "https://localhost/"
}