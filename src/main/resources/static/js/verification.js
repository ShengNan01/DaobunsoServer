$(function () {
  $("#open-popup-btn").css("display", "none");
  document.getElementsByClassName("popup")[0].classList.add("active");
});

$("#dismiss-popup-btn").click(function(){
$("#open-popup-btn").css("display", "block");
document.getElementsByClassName("popup")[0].classList.remove("active");
location.href = "https://localhost/";
});