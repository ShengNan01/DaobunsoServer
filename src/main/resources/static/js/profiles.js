let myModal = new bootstrap.Modal(document.getElementById('myModal'))
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
function updateModal(title, massage) {
    $('#modal-title').text(title);
    $('#massage-content').text(massage);
}
// reset modal when modal was hidden
let myModalEl = document.getElementById('myModal')
myModalEl.addEventListener('hidden.bs.modal', function (event) {
    updateModal("", "");
})
// window.onload;
