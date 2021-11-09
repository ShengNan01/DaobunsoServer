let myModal = new bootstrap.Modal(document.getElementById('myModal'))

function updateModal(title, massage) {
$('#modal-title').text(title);
$('#massage-content').text(massage);
}
  // reset modal when modal was hidden
  let myModalEl = document.getElementById("myModal");
  myModalEl.addEventListener("hidden.bs.modal", function (event) {
    updateModal("", "");
  });

$(".card_b1").hover(function () {
        $('#card_f1').show();
    }, function () {
        $('#card_f1').hide();
    }
);
$(".card_b2").hover(function () {
    $('#card_f2').show();
}, function () {
    $('#card_f2').hide();
}
);
$(".card_b3").hover(function () {
    $('#card_f3').show();
}, function () {
    $('#card_f3').hide();
}
);
$(".card_b4").hover(function () {
    $('#card_f4').show();
}, function () {
    $('#card_f4').hide();
}
);
$(".card_b5").hover(function () {
    $('#card_f5').show();
}, function () {
    $('#card_f5').hide();
}
);