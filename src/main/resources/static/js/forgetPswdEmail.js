let myModal = new bootstrap.Modal(document.getElementById('myModal'));

function updateModal(title, massage) {
$('#modal-title').text(title);
$('#massage-content').text(massage);
}

const regexEmail =  new RegExp(/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/);
const regexAccount = new RegExp(/^([a-zA-Z]+\d+|\d+[a-zA-Z]+)[a-zA-Z0-9]*$/ );
$("#submit").click(function (e) {
    e.preventDefault();
    if ($("#forgetPasswordAccount").val() === "" && $("#forgetPasswordEmail").val() === ""){
        updateModal("Oops!", "請填寫完整欄位資訊");
        myModal.show();
        return;
    } else if ($("#forgetPasswordAccount").val() === "") {
        updateModal("Oops!", "請輸入註冊之帳號");
        myModal.show();
    } else if (!regexAccount.test($("#forgetPasswordAccount").val())) {
        updateModal("Oops!", "輸入帳號格式錯誤");
        myModal.show();
        return;
	} else if ($("#forgetPasswordEmail").val() === "") {
        updateModal("Oops!", "請輸入註冊之電子信箱");
        myModal.show();
        return;
    } else if (!regexEmail.test($("#forgetPasswordEmail").val())) {
        updateModal("Oops!", "輸入電子信箱格式不正確");
        myModal.show();
        return;
    } else {
		console.log("123");
		let account = $('#forgetPasswordAccount').val();
        let email = $('#forgetPasswordEmail').val();
        const forget_pswd = {
            email: email,
			account:account,
        }
        let url = 'https://localhost/forgetPswdEmail';
        fetch(url, {
            method: 'POST',
            body: JSON.stringify(forget_pswd),
            headers: { 'Content-Type': 'application/json' },
		  }).then(response =>{response.json()
					
				.then(res=>{ console.log(res)
					if (res.checkmemberinfo === "notok"){
						 updateModal("Oops!", "輸入的帳號或信箱不存在，請重新輸入！！");
				         myModal.show();
//				         localStorage.setItem('res_notok',JSON.stringify(res));
					}else {
//						 updateModal("great!", "輸入的帳號及信箱正確！！");
//				         myModal.show();這邊會被下面的updateModal蓋掉
						 localStorage.setItem('res_ok',JSON.stringify(res));
//						 sessionStorage.setItem('res_ok',JSON.stringify(res));不能用因為信箱頁面導入回去就不見了
						  	if(res.sending === "Success"){
								updateModal("發送郵件成功!", "請至信箱收取信件修改密碼。");
			                    myModal.show();
			                    $('.modal-footer>button').click(function(){
			                        location.href='./frontpage';
			                    })
						//好像不會執行到下面
							}else if (res.sending === "Fail") {
		                        updateModal("Oops!", "必須輸入此帳號註冊時的電子信箱");
		                        myModal.show();
							 }
						 }
							 
					})
				})	
			}
        });
//跳頁
function nextPage(){
    location.href = "https://localhost/"
}






