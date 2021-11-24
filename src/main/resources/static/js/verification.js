$(function () {
  $("#open-popup-btn").css("display", "none");
  document.getElementsByClassName("popup")[0].classList.add("active");
});

$("#dismiss-popup-btn").click(function () {
  $("#open-popup-btn").css("display", "block");
  document.getElementsByClassName("popup")[0].classList.remove("active");
  location.href = "https://daobunso.myddns.me/";
});

let timeoutID = setTimeout(IndexPage, 5000);
function IndexPage() {
  location.href = "https://daobunso.myddns.me/";
}
