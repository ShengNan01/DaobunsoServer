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

let p1imgsrc = "./image/trashbag1.jpg"; 
let p2imgsrc = "./image/trashbag2.jpg"; 
let p3imgsrc = "./image/trashbag3.jpg";
let p1name ="一般垃圾袋";
let p2name ="廚餘垃圾袋";
let p3name ="回收垃圾袋";
let p1content ="1組/6入";
let p2content ="1組/6入";
let p3content ="1組/6入";
let p1price = 60;
let p2price = 80;
let p3price = 100;
let plink = "product.html";
const p1btn = $('.product1 a');
const p2btn = $('.product2 a');
const p3btn = $('.product3 a');

$('.product1 img').attr('src',p1imgsrc);
$('.product2 img').attr('src',p2imgsrc);
$('.product3 img').attr('src',p3imgsrc);
$('.product1 .card-title').text(p1name);
$('.product2 .card-title').text(p2name);
$('.product3 .card-title').text(p3name);
$('.product1 .card-content').text(p1content);
$('.product2 .card-content').text(p2content);
$('.product3 .card-content').text(p3content);
$('.product1 .price').text(p1price+"元");
$('.product2 .price').text(p2price+"元");
$('.product3 .price').text(p3price+"元");
$('.spl').attr('href',plink);


p1btn.click(()=>{
    let splink=[];

    splink.push({
        p_imgsrc  :   p1imgsrc,
        p_name    :   p1name,
        p_content :   p1content,
        p_price   :   p1price,
    });
    sessionStorage.setItem('splink',JSON.stringify(splink));
});
p2btn.click(()=>{
    let splink=[];

    splink.push({
        p_imgsrc  :   p2imgsrc,
        p_name    :   p2name,
        p_content :   p2content,
        p_price   :   p2price,
    });
    sessionStorage.setItem('splink',JSON.stringify(splink));
});
p3btn.click(()=>{
    let splink=[];

    splink.push({
        p_imgsrc  :   p3imgsrc,
        p_name    :   p3name,
        p_content :   p3content,
        p_price   :   p3price,
    });
    sessionStorage.setItem('splink',JSON.stringify(splink));
});
