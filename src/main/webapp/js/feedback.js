//定義頁面
const starimg = "./image/service_intro/holo/noel.png";

let uimgsrc = "./image/service_intro/holo/pekora.png";
let uname = "pekora";

//Feedback定義變數
let oid ="";
let uaccount ="bcioooher1";
let getstar;
let ucomment = "";
let wdate = Date();

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
        $('#surf-0').html(JSON.stringify(res[0]));
        $('#surf-1').html(JSON.stringify(res[1]));
        $('#surf-2').html(JSON.stringify(res[2]));
    });
});
$(".marquee").marquee({ 
    yScroll: "bottom", 
    showSpeed: 850,  // 初始下拉速度   , 
    scrollSpeed: 12,  // 滾動速度   , 
    pauseSpeed: 500,  // 滾動完到下一條的間隔時間   , 
    pauseOnHover: true, // 滑鼠滑向文字時是否停止滾動   , 
    loop: -1 ,    // 設定迴圈滾動次數 （-1為無限迴圈）   , 
    fxEasingShow: "swing" , // 緩衝效果   , 
    fxEasingScroll: "linear", // 緩衝效果   , 
    cssShowing: "marquee-showing" //定義class 
    });
//~觀看意見領域
//~頁面初始化

//展開按鈕
$('#btn-ex').click(function(){

    $(this).toggleClass('tog');
    if($('#btn-ex').hasClass('tog')){
        $('.feedback').show();
        $('#btn-ex').text("收起");
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