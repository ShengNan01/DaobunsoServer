//Feedback定義變數
let oid ="";
let uaccount ="bcioooher1";
let getstar;
let ucomment = "";
let wdate = Date();

//定義頁面
const starimg = "./image/service_intro/holo/noel.png";

let uimgsrc = "./image/service_intro/holo/pekora.png";
let uname = uaccount;
let sstarimg = "./image/service_intro/holo/Saintquartz.png";

//頁面初始化
$('.feedback').hide();
$('.user-img img').attr('src',uimgsrc);
$('.star img').attr('src',starimg);
$('.user-name h2').text(uname);

//觀看意見領域
fetch(`https://localhost:8443/gradings`,{
    method: 'GET',
}).then((response) =>{
    response.json()
    .then(res =>{
        console.log(res);
        $('#sushi-0').ready(()=>{
            $('#sushi-0 .sushi-uimg').attr('src',uimgsrc);
            $('#sushi-0 .sushi-star').attr('src',sstarimg);
            $('#sushi-0 .card-title').html(res[0].account);
            $('#sushi-0 .card-text').html(res[0].comment);
        });
        $('#sushi-1').ready(()=>{
            $('#sushi-1 .sushi-uimg').attr('src',uimgsrc);
            $('#sushi-1 .sushi-star').attr('src',sstarimg);
            $('#sushi-1 .card-title').html(res[1].account);
            $('#sushi-1 .card-text').html(res[1].comment);
        });
        $('#sushi-2').ready(()=>{
            $('#sushi-2 .sushi-uimg').attr('src',uimgsrc);
            $('#sushi-2 .sushi-star').attr('src',sstarimg);
            $('#sushi-2 .card-title').html(res[2].account);
            $('#sushi-2 .card-text').html(res[2].comment);
        });
        $('#sushi-3').ready(()=>{
            $('#sushi-3 .sushi-uimg').attr('src',uimgsrc);
            $('#sushi-3 .sushi-star').attr('src',sstarimg);
            $('#sushi-3 .card-title').html(res[3].account);
            $('#sushi-3 .card-text').html(res[3].comment);
        });
        
    });
});
$('#marquee').marquee({
        yScroll: "top"              // the position of the marquee initially scroll (can
                                    // be either "top" or "bottom")
      , showSpeed: 10000              // the speed of to animate the initial dropdown of
                                    // the messages
      , scrollSpeed: 5             // the speed of the scrolling (keep number low)
      , pauseSpeed: 10000            // the time to wait before showing the next message
                                    // or scrolling current message
      , pauseOnHover: true          // determine if we should pause on mouse hover
      , loop: -1                    // determine how many times to loop through the
                                    // marquees (#'s < 0 = infinite)
      , fxEasingShow: "swing"       // the animition easing to use when showing a new
                                    // marquee
      , fxEasingScroll: "linear"    // the animition easing to use when showing a new
                                    // marquee
  
      // define the class statements
      , cssShowing: "marquee-showing"
  
      // event handlers
      , init: null                // callback that occurs when a marquee is initialized
      , beforeshow: null          // callback that occurs before message starts
                                  // scrolling on screen
      , show: null                // callback that occurs when a new marquee message is
                                  // displayed
      , aftershow: null           // callback that occurs after the message has scrolled
});
//~觀看意見領域
//~頁面初始化

//展開按鈕
$('#btn-ex').click(function(){

    $(this).toggleClass('tog');
    if($('#btn-ex').hasClass('tog')){
        $('.feedback').show();
        // $('#btn-ex').text("收起");・
    }else{
        $('.feedback').hide()
        $('#btn-ex').text("填寫意見");
    }
});
//~展開按鈕

//編輯意見按鈕
$('#btn-edit').click(()=>{
// GET
    fetch(`https://localhost:8443/grading?uaccount=${uaccount}`,{
        method: 'GET',
    }).then((response) =>{
        response.json()
        .then(res =>{
            console.log(res);
        });
    });
})
//~編輯意見按鈕

//意見送出按鈕
$('#btn-feedback').click(()=>{
    ucomment = $('#feedback-comment').val();
    fetch(`https://localhost:8443/grading`,{
        method: 'POST',
        body: JSON.stringify({
            objectid    :   oid,
            account     :   uaccount,
            star        :   getstar,
            date        :   wdate,
            comment     :   ucomment,
            }),
        headers: { 'Content-Type': 'application/json'},
    }).then((response) =>{
        response.json()
        .then(res =>{
            console.log(res)
        });
    });
    alert("成功送出!!");
});
//~意見送出按鈕
//star
{
    $('.star1').hover(()=>{
        $('.star1').addClass('star-act')
    },()=>{
        $('.star1').removeClass('star-act')
    });
    $('.star1').click(()=>{
        $('.star1').addClass('star-cl');
        $('.star2').removeClass('star-cl');
        $('.star3').removeClass('star-cl');
        $('.star4').removeClass('star-cl');
        $('.star5').removeClass('star-cl');
        getstar = 1;
    });

    $('.star2').hover(()=>{
        $('.star1').addClass('star-act');
        $('.star2').addClass('star-act');
    },
    ()=>{
        $('.star1').removeClass('star-act');
        $('.star2').removeClass('star-act');
    });
    $('.star2').click(()=>{
        $('.star1').addClass('star-cl');
        $('.star2').addClass('star-cl');
        $('.star3').removeClass('star-cl');
        $('.star4').removeClass('star-cl');
        $('.star5').removeClass('star-cl');
        getstar = 2;
    });

    $('.star3').hover(()=>{
        $('.star1').addClass('star-act');
        $('.star2').addClass('star-act');
        $('.star3').addClass('star-act');
    },
    ()=>{
        $('.star1').removeClass('star-act');
        $('.star2').removeClass('star-act');
        $('.star3').removeClass('star-act');
    });
    $('.star3').click(()=>{
        $('.star1').addClass('star-cl');
        $('.star2').addClass('star-cl');
        $('.star3').addClass('star-cl');
        $('.star4').removeClass('star-cl');
        $('.star5').removeClass('star-cl');
        getstar = 3;
    });

    $('.star4').hover(()=>{
        $('.star1').addClass('star-act');
        $('.star2').addClass('star-act');
        $('.star3').addClass('star-act');
        $('.star4').addClass('star-act');
    },
    ()=>{
        $('.star1').removeClass('star-act');
        $('.star2').removeClass('star-act');
        $('.star3').removeClass('star-act');
        $('.star4').removeClass('star-act');
    });
    $('.star4').click(()=>{
        $('.star1').addClass('star-cl');
        $('.star2').addClass('star-cl');
        $('.star3').addClass('star-cl');
        $('.star4').addClass('star-cl');
        $('.star5').removeClass('star-cl');
        getstar = 4;
    });

    $('.star5').hover(()=>{
        $('.star1').addClass('star-act');
        $('.star2').addClass('star-act');
        $('.star3').addClass('star-act');
        $('.star4').addClass('star-act');
        $('.star5').addClass('star-act');
    },
    ()=>{
        $('.star1').removeClass('star-act');
        $('.star2').removeClass('star-act');
        $('.star3').removeClass('star-act');
        $('.star4').removeClass('star-act');
        $('.star5').removeClass('star-act');
    });
    $('.star5').click(()=>{
        $('.star1').addClass('star-cl');
        $('.star2').addClass('star-cl');
        $('.star3').addClass('star-cl');
        $('.star4').addClass('star-cl');
        $('.star5').addClass('star-cl');
        getstar = 5;
    });
}
//~star
let vue = new Vue({
    
});