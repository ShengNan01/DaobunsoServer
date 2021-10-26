let myModal = new bootstrap.Modal(document.getElementById('myModal'))

function updateModal(title, massage) {
$('#modal-title').text(title);
$('#massage-content').text(massage);
}

$(function () {
    if (localStorage.getItem("member") != null) {
      memberData = JSON.parse(localStorage.getItem("member"));
      if (memberData.Login === "OK") {
        $(".dropdown-toggle:not(.btn)").text(memberData.member_name);
        $(".dropdown-item:eq(3)").text("Log out");
        $(".dropdown-item:eq(3)").attr("href", "./frontpage.html");
      }
      $(".dropdown-item:eq(3)").click(function () {
        localStorage.removeItem("member");
      });
      $(".dropdown-item:eq(0),.dropdown-item:eq(1)").click(function (e) {
        if (memberData.Login !== "OK") {
          e.preventDefault();
          // alert("請先登入會員")
          updateModal("Oops!", "請先登入會員！");
          myModal.show();
          $(".modal-footer>button").click(function () {
            location.href = "./login.html";
          });
        }
      });
    } else {
      $(".dropdown-item:eq(0),.dropdown-item:eq(1)").click(function (e) {
        e.preventDefault();
        // alert("請先登入會員")
        updateModal("Oops!", "請先登入會員！");
        myModal.show();
        $(".modal-footer>button").click(function () {
          location.href = "./login.html";
        });
      });
    }
  });

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