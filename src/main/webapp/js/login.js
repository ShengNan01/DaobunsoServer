$(".register").on('click',function(){
    $("#form_in").hide();
    $("#form_reg").show();
})
$('#form_reg').submit(function () { 
  if($('#pswdNew').val() != $('#repswd').val()){
    alert('兩次輸入的密碼不相符，請重新輸入！');
    return false;
  } else {
    return true;
  }
});
let urlReg = 'http://localhost:8080/Daobunso_Project/register.do';

$('#signup_btn').click(function(e){
  $(this).width('5.5rem');
  $(this).text("傳送中");
  e.preventDefault();
  member = {
  "Member_name":$('#username').val(),
  "Email":$('#email').val(),
  "Account":$('#accountNew').val(),
  "Password":$('#pswdNew').val()
};
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
    });
  });