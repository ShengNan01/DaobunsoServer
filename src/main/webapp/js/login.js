let myModal = new bootstrap.Modal(document.getElementById('myModal'))
const indicator = document.querySelector(".indicator");
const input = document.querySelector("#pswdNew");
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

$(function(){
    if(localStorage.getItem('member') != null){
        memberData = JSON.parse(localStorage.getItem('member'));
        if(memberData.Login === 'OK'){
        $('.dropdown-toggle:not(.btn)').text(memberData.member_name);
        $('.dropdown-item:eq(3)').text('Log out');
        $('.dropdown-item:eq(3)').attr('href','./frontpage.html');
        }
        $('.dropdown-item:eq(3)').click(function () {
            localStorage.clear();
        });
        $('.dropdown-item:eq(0),.dropdown-item:eq(1)').click(function (e) {
            if(memberData.Login !== 'OK'){
                e.preventDefault();
                // alert("請先登入會員")
                updateModal("Oops!", "請先登入會員！");
                myModal.show();
                $('.modal-footer>button').click(function(){
                    location.href='./login.html';
                })
            }
        });
    } else {
        $('.dropdown-item:eq(0),.dropdown-item:eq(1)').click(function (e){
            e.preventDefault();
            // alert("請先登入會員")
            updateModal("Oops!", "請先登入會員！");
            myModal.show();
            $('.modal-footer>button').click(function(){
                location.href='./login.html';
            })
        })
    }   
})

$(".register").on('click',function(){
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
let urlReg = 'http://localhost:8080/Daobunso_Project/register.do';
const regex_password = new RegExp(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,16}$/);
const regex_account = new RegExp(/^([a-zA-Z]+\d+|\d+[a-zA-Z]+)[a-zA-Z0-9]*$/);
const regex_email = new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/);

$('#signup_btn').click(function(e){
    e.preventDefault();
    if($('#pswdNew').val() !== $('#repswd').val()){
        // alert('兩次輸入的密碼不相符，請重新輸入！');
        updateModal("Oops!", "兩次輸入的密碼不相符，請重新輸入！");
        myModal.show();
        return;
    } else if($('#username').val() === "" || $('#email').val() === "" 
    || $('#accountNew').val() === "" || $('#pswdNew').val() ===""){
    // alert('有欄位未填寫，請檢查！');
        updateModal("Oops!", "有欄位未填寫，請檢查！！");
        myModal.show();
        return;
	}else if($('#accountNew').val().match(regex_account) === null){
		 updateModal("輸入的帳號格式不符!", "帳號請包含英文及數字");
       	 myModal.show();
         return;	
	} else if($('#email').val().match(regex_email) === null){
		 updateModal("輸入的信箱格式不符!", "請重新填寫一個信箱");
       	 myModal.show();
         return;
	}else if($('#pswdNew').val().match(regex_password) === null){
		 updateModal("輸入的密碼格式不符!", "至少一個小寫字母、一個大寫字母、一個數字，且密碼長度須符合8-16個字元");
       	 myModal.show();
         return;
    } else {
        member = {
            "Member_name":$('#username').val(),
            "Email":$('#email').val(),
            "Account":$('#accountNew').val(),
            "Password":$('#pswdNew').val()
        };
        $(this).width('5.5rem');
        $(this).text("傳送中");

//   console.log(JSON.stringify(member));
    fetch(urlReg, {
        method: 'POST',
        body: JSON.stringify(member),
        headers: { 'Content-Type': 'application/json' },
    })
    .then(response => { response.text()
    .then(text => {
      if( text === "註冊成功，請重新登入"){
        // alert(text);
        updateModal("Congratulations!", text);
        myModal.show();
        $('.modal-footer>button').click(function(){
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
        })
    };
});




let urlLogin = 'http://localhost:8080/Daobunso_Project/login.do';

$(document).ready(function(){
    if (getCookieByName('account') != "" && getCookieByName('daobunsopppp') != "") {
            $("#account").val(getCookieByName('account'));
            $("#pswd").val(getCookieByName('daobunsopppp')); 
    }
})

var checkis;
var remember;
    var isClick = false;
    //先判斷有沒有被點擊過，有被點過 => isClick = true;，再判斷是否是勾起的狀態
    $("#rememberMe").click(function(){
        isClick = true;
        checkis = $(this).is(":checked");
        if (checkis) {
            remember = "rememberOk";
        } else {
            remember = "rememberNo";
        }
    
    });
    //如果rememberMe連點都沒被點過 => isClick就會是false
    if(!isClick){
        remember = "rememberNo";
    }

$('#login_btn').click(function(e){
    e.preventDefault();
    
    if($('#account').val() === "" || $('#pswd').val() === "" ){
        //  alert('有欄位未填寫，請檢查！');
        updateModal("Oops!", "有欄位未填寫，請檢查！！");
        myModal.show();
        return;
    } 
    else {
            login = {
                "account":$('#account').val(),
                "password":$('#pswd').val(),
                "rememberMe":remember,               
            };

            console.log(JSON.stringify(login));
           
    fetch(urlLogin, {
                method: 'POST',
                body: JSON.stringify(login),  //將JavaScript物件轉為JSON物件
                headers: { 'Content-Type': 'application/json' },
        })
        .then(response => { response.json()
        .then(res => { console.log(res)
            if( res.Login === "NO"){
            // alert('帳號或密碼不正確');
            updateModal("Oops!", "帳號或密碼不正確！！");
            myModal.show();
            localStorage.setItem('member',JSON.stringify(res));
            // location.reload();
            } else {
                //    alert("登入成功");
                   updateModal("Welcome!", "登入成功");
                   myModal.show();
                   $('.modal-footer>button').click(function(){
                    $('.dropdown-toggle').text(res.member_name);
                   $('.dropdown-item:eq(3)').text('Log out');
                   $('.dropdown-item:eq(3)').attr('href','./frontpage.html');
                   localStorage.setItem('member',JSON.stringify(res));
                   history.go(-1);
                    })

                //    location.assign('http://localhost:8080/Daobunso_Project/frontpage.html');
            }
        })
        })
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


function parseCookie() {
    var cookieObj = {};
    var cookieAry = document.cookie.split(';');
    var cookie;
    
    for (var i=0, l=cookieAry.length; i<l; ++i) {
        cookie = jQuery.trim(cookieAry[i]);
        cookie = cookie.split('=');
        cookieObj[cookie[0]] = cookie[1];
    }
    
    return cookieObj;
}


function getCookieByName(name) {
    var value = parseCookie()[name];
    if (value) {
        value = decodeURIComponent(value);
    }
    return value;
}

$('.dropdown-item:eq(3)').click(function () { 
    localStorage.removeItem('member');
});

// reset modal when modal was hidden
let myModalEl = document.getElementById('myModal')
myModalEl.addEventListener('hidden.bs.modal', function (event) {
    updateModal("","");
})
