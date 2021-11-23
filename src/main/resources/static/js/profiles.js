const memberId = getCookieValueByName('id');
const Name = getCookieValueByName('name');
const email = getCookieValueByName('email');
const account = getCookieValueByName('account');
const verification = getCookieValueByName('verification');
$('#inlineFormInputName').val(Name);
$('#email').val(email);
$('#account').val(account);
mId = {
    "memberId": memberId
};
if (verification == 0) {
    updateModal("提醒", "若要使用網站功能請進行信箱驗證")
    myModal.show();
    $("#buttonVerification").show();
} else if (verification == 1) {
    $("#buttonVerification").hide();
}
// window.onload;



//// 進入頁面的語言初始化
////let langsearch;
//if (sessionStorage.getItem('lang') == null) {
//    sessionStorage.setItem('lang', "?l=zh_TW");
//} else {
//    langsearch = sessionStorage.getItem('lang');
//    langinit();
//}
//// ~進入頁面的語言初始化
//
//function langinit() {
//    // profilesherf
//    $('.btn btn-lg active text-center mt-2 me-5').attr('href', "./verify_email" + langsearch);
//	$('.btn  btn-lg active mt-2').attr('href', "./verification_email" + langsearch);
//
//}