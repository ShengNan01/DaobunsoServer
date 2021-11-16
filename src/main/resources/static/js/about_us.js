let myModal = new bootstrap.Modal(document.getElementById('myModal'))

function updateModal(title, massage) {
    $('#modal-title').text(title);
    $('#massage-content').text(massage);
}
// reset modal when modal was hidden
let myModalEl = document.getElementById('myModal')
myModalEl.addEventListener('hidden.bs.modal', function (event) {
    updateModal("", "");
})