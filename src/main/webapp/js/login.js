let myModal = new bootstrap.Modal(document.getElementById('myModal'))

function updateModal(title, massage) {
$('#modal-title').text(title);
$('#massage-content').text(massage);
}

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
        location.reload();
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
    $("#rememberMe").click(function(){
        checkis = $(this).is(":checked");
        console.log(checkis);
    });

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
                "RememberMe":checkis,               
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
            location.reload();
            } else {
                //    alert("登入成功");
                   updateModal("Welcome!", "登入成功");
                   myModal.show();
                   $('.dropdown-toggle').text(res.member_name);
                   $('.dropdown-item:eq(3)').text('Log out');
                   $('.dropdown-item:eq(3)').attr('href','./frontpage.html');
                   localStorage.setItem('member',JSON.stringify(res));
                   history.go(-1);

                //    location.assign('http://localhost:8080/Daobunso_Project/frontpage.html');
            }
        })
        })
    };      
});

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