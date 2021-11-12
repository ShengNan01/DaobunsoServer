const memberId = getCookieValueByName('id');
mId = {
        "memberId": memberId
};

let url = 'https://localhost/profiles';
fetch(url, {
    method: 'POST',
    body: JSON.stringify(mId),
    headers: { 'Content-Type': 'application/json' },
}).then(response => {
    response.json()
        .then(res => {
            console.log(res);
            $('#inlineFormInputName').val(res.member_name);
            $('#email').val(res.email);
            $('#account').val(res.account);
        });
});
// let myModal = new bootstrap.Modal(document.getElementById('myModal'))

// function updateModal(title, massage) {
// $('#modal-title').text(title);
// $('#massage-content').text(massage);
// }
//     // reset modal when modal was hidden
//     let myModalEl = document.getElementById('myModal')
//     myModalEl.addEventListener('hidden.bs.modal', function (event) {
//     updateModal("","");
//     })
// window.onload;
