// 進入頁面的語言初始化
if (sessionStorage.getItem('lang') == null) {
    sessionStorage.setItem('lang', "?l=zh_TW");
} else {
    langsearch = sessionStorage.getItem('lang');
    langinit();
}
// ~進入頁面的語言初始化

function langinit() {
    // serviceherf
    $('#card-service-project1').attr('href', "./service-project1" + langsearch);
    $('#card-service-project2').attr('href', "./service-project2" + langsearch);
    $('#card-service-project3').attr('href', "./service-project3" + langsearch);

}
