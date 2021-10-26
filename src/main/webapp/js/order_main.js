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