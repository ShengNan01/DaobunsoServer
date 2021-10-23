// $("#inlineFormInputName").val(JSON.parse(localStorage.member).member_id);
// $('#inlineFormInputName').val("12345");
const memberId = JSON.parse(localStorage.member).member_id;
member = {
    "Member_Id": memberId,
};

let url = 'http://localhost:8080/Daobunso_Project/Personal_Info';
fetch(url, {
    method: 'POST',
    body: JSON.stringify(member),
    headers: { 'Content-Type': 'application/json' },
}).then(response => {
    response.json()
        .then(res => {
            console.log(res);
            $('#inlineFormInputName').val(res.Member_name);
            $('#email').val(res.Email);
            $('#account').val(res.Account);
        });
});
window.onload;
