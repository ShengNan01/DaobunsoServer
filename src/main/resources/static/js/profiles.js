const memberId = JSON.parse(localStorage.member).member_id;
mId = {
    "Member_Id": memberId,
};

let url = 'http://localhost:8080/Daobunso_Project/Personal_Info';
fetch(url, {
    method: 'POST',
    body: JSON.stringify(mId),
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
let myModal = new bootstrap.Modal(document.getElementById('myModal'))

function updateModal(title, massage) {
$('#modal-title').text(title);
$('#massage-content').text(massage);
}
    




    // reset modal when modal was hidden
    let myModalEl = document.getElementById('myModal')
    myModalEl.addEventListener('hidden.bs.modal', function (event) {
    updateModal("","");
    })
// window.onload;
