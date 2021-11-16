$(function () {
  $("#open-popup-btn").css("display", "none");
  document.getElementsByClassName("popup")[0].classList.add("active");
});

$("#dismiss-popup-btn").click(function(){
$("#open-popup-btn").css("display", "block");
document.getElementsByClassName("popup")[0].classList.remove("active");
location.href = "https://localhost/verification_email";
});

let timeoutID = setTimeout(verification_emailPage, 5000);
function verification_emailPage(){
  location.href = "https://localhost/verification_email";
}