const indicator = document.querySelector(".indicator");
const input = document.querySelector("#pswdNew");
const weak = document.querySelector(".weak");
const medium = document.querySelector(".medium");
const strong = document.querySelector(".strong");
const text = document.querySelector(".text");
let regExpWeak = /[a-z]/;
let regExpMedium = /\d+/;
let regExpStrong = /.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/;

$(".register").on('click', function () {
	$("#form_in").hide();
	$("#form_reg").show();
})
// $('#form_reg').submit(function () { 
//   if($('#pswdNew').val() != $('#repswd').val()){
//     alert('兩次輸入的密碼不相符，請重新輸入！');
//     return false;
//   } else if($('#username').val() === "" || $('#email').val() === "" 
//             || $('#accountNew').val() === "" || $('#pswdNew').val() ===""){
//     alert('有欄位未填寫，請檢查！');
//     return false;
//     }  else {
//     return true;
//   }
// });
let urlReg = 'https://localhost/reg';
const regex_password = new RegExp(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,16}$/);
const regex_account = new RegExp(/^([a-zA-Z]+\d+|\d+[a-zA-Z]+)[a-zA-Z0-9]*$/);
const regex_email = new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/);

$('#signup_btn').click(function (e) {
	e.preventDefault();
	if ($('#pswdNew').val() !== $('#repswd').val()) {
		// alert('兩次輸入的密碼不相符，請重新輸入！');
		updateModal("Oops!", "兩次輸入的密碼不相符，請重新輸入！");
		myModal.show();
		return;
	} else if ($('#username').val() === "" || $('#email').val() === ""
		|| $('#accountNew').val() === "" || $('#pswdNew').val() === "") {
		// alert('有欄位未填寫，請檢查！');
		updateModal("Oops!", "有欄位未填寫，請檢查！！");
		myModal.show();
		return;
	} else if ($('#accountNew').val().match(regex_account) === null) {
		updateModal("輸入的帳號格式不符!", "帳號請包含英文及數字");
		myModal.show();
		return;
	} else if ($('#email').val().match(regex_email) === null) {
		updateModal("輸入的信箱格式不符!", "請重新填寫一個信箱");
		myModal.show();
		return;
	} else if ($('#pswdNew').val().match(regex_password) === null) {
		updateModal("輸入的密碼格式不符!", "至少一個小寫字母、一個大寫字母、一個數字，且密碼長度須符合8-16個字元");
		myModal.show();
		return;
	} else {
		member = {
			"member_name": $('#username').val(),
			"email": $('#email').val(),
			"account": $('#accountNew').val(),
			"password": $('#pswdNew').val()
		};
		$(this).width('5.5rem');
		$(this).text("傳送中");

		//   console.log(JSON.stringify(member));
		fetch(urlReg, {
			method: 'POST',
			body: JSON.stringify(member),
			headers: { 'Content-Type': 'application/json' },
		}).then(response => {
			response.text().then(text => {
				// console.log(text)
				if (text === "註冊成功，請重新登入") {
					// alert(text);
					updateModal("Congratulations!", text);
					myModal.show();
					$('.modal-footer>button').click(function () {
						location.reload();
					})
				} else {
					$(this).width('5rem');
					$(this).text("註冊");
					// alert(text)
					updateModal("Oops!", text);
					myModal.show();
					return;
				}
			})
		}).catch((err) => {
			$(this).width('5rem');
			$(this).text("註冊");
			updateModal("Oops!", "發生錯誤!");
			myModal.show();
			return;
		});

	};
});
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


// Login

$(document).ready(function () {
	if (getCookieValueByName('account') != undefined && getCookieValueByName('name') != undefined && getCookieValueByName('email') != undefined && getCookieValueByName('password') != undefined) {
		$("#account").val(getCookieValueByName('account'));
		$("#pswd").val(getCookieValueByName('password') + "==");
	} else {
		$("#account").val(null);
		$("#pswd").val(null);
	}
});
// ~Login

// 判斷#rememberMe有沒有勾
let rememberMe = false;
$("#rememberMe").click(function () {
	$(this).toggleClass('tog');
	if ($('#rememberMe').hasClass('tog')) {
		rememberMe = true;
	} else {
		rememberMe = false;
	}
});
// ~判斷#rememberMe有沒有勾

// 登入按鈕
$('#login_btn').click(function (e) {
	e.preventDefault();

	if ($('#account').val() === "" || $('#pswd').val() === "") {
		updateModal("Oops!", "有欄位未填寫，請檢查！！");
		myModal.show();
		return;
	}
	else {
		let account = $('#account').val();
		let password = $('#pswd').val();

		fetch(`https://localhost/logincheck?rememberMe=${rememberMe}`, {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			// 將JavaScript物件轉為JSON物件
			body: JSON.stringify({
				"account": account,
				"password": password,
			}),
		}).then(response => {
			// 將Server回覆的boolean值轉為文字存入res
			response.text().then(res => {
				if (res == "true") {
					alert("登入成功! res狀態:" + res);
					location.assign('./frontpage');
				} else {
					alert("登入失敗! res狀態:" + res + "\n請重新登入");
					$("#account").val(null);
					$("#pswd").val(null);
				}
			});
		}).catch((err) => {
			updateModal("Oops!", "發生錯誤!");
			myModal.show();
			return;
		});
	};
});