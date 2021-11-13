let myModal = new bootstrap.Modal(document.getElementById('myModal'))
const indicator = document.querySelector(".indicator");
const input = document.querySelector("#pswdnew");
const weak = document.querySelector(".weak");
const medium = document.querySelector(".medium");
const strong = document.querySelector(".strong");
const text = document.querySelector(".text");
let regExpWeak = /[a-z]/;
let regExpMedium = /\d+/;
let regExpStrong = /.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/;

function updateModal(title, massage) {
    $('#modal-title').text(title);
    $('#massage-content').text(massage);
}
let urlReg = 'https://localhost/forgetPswd';
const regex = new RegExp(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,16}$/);
$('#change_btn').click(function (e) {
    e.preventDefault();
    if ($('#pswdnew').val() !== $('#confpswd').val()) {
        updateModal("密碼輸入不相符!", "兩次輸入的新密碼不相符，請重新輸入！");
        myModal.show();
        return;
    } else if ( $('#pswdnew').val() === ""|| $('#confpswd').val() === "") {
        updateModal("Oops!", "有欄位未填寫，請檢查！！");
        myModal.show();
        return;
	
	}else if($('#pswdnew').val().match(regex) === null){
		 updateModal("輸入的密碼格式不符!", "至少一個小寫字母、一個大寫字母、一個數字，且密碼長度須符合8-16個字元");
       	 myModal.show();
         return;
    } else {

        const memberAccount = JSON.parse(localStorage.res_ok).memberAccount;
		const memberEmail = JSON.parse(localStorage.res_ok).memberEmail;
        forget_change_pswd = {
            "account":memberAccount,
			"email":memberEmail,	
            "newPassword": $('#pswdnew').val(),
        };
        fetch('forgetPswd', {
            //    fetch(urlReg,{
            method: 'POST',
            body: JSON.stringify(forget_change_pswd),
//            headers: { 'Content-Type': 'application/type' },
            headers: { 'Content-Type': 'application/json' },
        }).then(response => {
            response.text()
            .then(text=>{
                if (text === "Success") {
                    updateModal("成功!","密碼修改完成，請重新登入!")
                    myModal.show();
                    $('.modal-footer>button').click(function () {
                        location.href = './frontpage';
                    })
    
                } else if(text === "Fail") {
                    updateModal("失敗!", "請重新輸入");
                    myModal.show();
                    return;
                }
            });
            localStorage.clear()
        }
        )
    }
});


$('.dropdown-item:eq(3)').click(function () {
    localStorage.removeItem('member');
});
// reset modal when modal was hidden
let myModalEl = document.getElementById('myModal')
myModalEl.addEventListener('hidden.bs.modal', function (event) {
    updateModal("", "");
})

//密碼強度
function trigger() {
    if (input.value != "") {
        indicator.style.display = "block";
        indicator.style.display = "flex";
        if (input.value.length <= 3 && (input.value.match(regExpWeak) || input.value.match(regExpMedium) || input.value.match(regExpStrong))) no = 1;
        if (input.value.length >= 6 && ((input.value.match(regExpWeak) && input.value.match(regExpMedium)) || (input.value.match(regExpMedium) && input.value.match(regExpStrong)) || (input.value.match(regExpWeak) && input.value.match(regExpStrong)))) no = 2;
        if (input.value.length >= 6 && input.value.match(regExpWeak) && input.value.match(regExpMedium) && input.value.match(regExpStrong)) no = 3;
        if (no == 1) {
            weak.classList.add("active");
            text.style.display = "block";
            text.textContent = "密碼強度：弱";
            text.classList.add("weak");
        }
        if (no == 2) {
            medium.classList.add("active");
            text.textContent = "密碼強度：中等";
            text.classList.add("medium");
        } else {
            medium.classList.remove("active");
            text.classList.remove("medium");
        }
        if (no == 3) {
            weak.classList.add("active");
            medium.classList.add("active");
            strong.classList.add("active");
            text.textContent = "密碼強度：強";
            text.classList.add("strong");
        } else {
            strong.classList.remove("active");
            text.classList.remove("strong");
        }
    } else {
        indicator.style.display = "none";
        text.style.display = "none";
    }
}