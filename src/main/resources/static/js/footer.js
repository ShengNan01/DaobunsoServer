// 進入頁面的語言初始化
let langsearch;
if (sessionStorage.getItem('lang') == null) {
    sessionStorage.setItem('lang', "?l=zh_TW");
} else {
    langsearch = sessionStorage.getItem('lang');
    langinit();
}
// ~進入頁面的語言初始化

function langinit() {
    // footerherf
    $('#footer-about_us').attr('href', "./about_us" + langsearch);
    $('#footer-service_intro').attr('href', "./service_intro" + langsearch);
    $('#footer-Userterms').attr('href', "./Userterms" + langsearch);
    $('#footer-problem').attr('href', "./problem" + langsearch);
    $('#footer-feedback').attr('href', "./feedback" + langsearch);
    $('#footer-service').attr('href', "./service" + langsearch);
    $('#footer-shopping').attr('href', "./shopping" + langsearch);
    // ~footerherf


}
// ~連結初始化