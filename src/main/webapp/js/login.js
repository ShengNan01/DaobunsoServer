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
        alert('兩次輸入的密碼不相符，請重新輸入！');
    } else if($('#username').val() === "" || $('#email').val() === "" 
    || $('#accountNew').val() === "" || $('#pswdNew').val() ===""){
    alert('有欄位未填寫，請檢查！');
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
        alert(text);
        location.reload();
      } else {
        $(this).width('5rem');
        $(this).text("註冊");
        alert(text)}
        })
        })
    };
});

let urlLogin = 'http://localhost:8080/Daobunso_Project/login.do';
$('#login_btn').click(function(e){
    e.preventDefault();
    if($('#account').val() === "" || $('#pswd').val() === "" ){
         alert('有欄位未填寫，請檢查！');
    } 
    else {
            login = {
                "account":$('#account').val(),
                "password":$('#pswd').val(),               
            };

            // console.log(JSON.stringify(login));
           
    fetch(urlLogin, {
                method: 'POST',
                body: JSON.stringify(login),  //將JavaScript物件轉為JSON物件
                headers: { 'Content-Type': 'application/json' },
        })
        .then(response => { response.json()
        .then(res => { console.log(res)
            if( res.Login === "NO"){
            alert('帳號或密碼不正確');
            location.reload();
            } else {
                   alert("登入成功");
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

$('.dropdown-item:eq(3)').click(function () { 
    localStorage.removeItem('member');
});