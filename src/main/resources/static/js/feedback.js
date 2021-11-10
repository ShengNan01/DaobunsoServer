//Feedback定義變數
let oid;
let uaccount = getCookieValueByName("account");
let getstar;
let ucomment = "";
// let wdate = Date();

//定義頁面
const starimg = "./image/service_intro/holo/noel.png";

let uimgsrc = "./image/service_intro/holo/pekora.png";
let uname = getCookieValueByName("name");
let sstarimg = "./image/service_intro/holo/Saintquartz.png";

//頁面初始化
$('.feedback').hide();
$('.user-img img').attr('src',uimgsrc);
$('.star img').attr('src',starimg);
$('.user-name h2').text(uname);

//觀看意見領域


fetch(`https://localhost/gradings`,{
    method: 'GET',
}).then((response) =>{
    response.json()
    .then(res =>{
        console.log(res);
        let marqueev = new Vue({
            el:'#marquee',
            data:{
                res,
            },
        });
        $('#marquee').show();

    });
});

//~觀看意見領域
//~頁面初始化

//展開按鈕
$('#btn-ex').click(function(){
    $(this).toggleClass('tog');
    $('.editli').hide();
    if($('#btn-ex').hasClass('tog')){
        $('.feedback').show();
        $('#btn-ex').text("收起");
    }else{
        $('.feedback').hide();
        $('#btn-ex').text("填寫意見");
    }
});
//~展開按鈕

//編輯意見按鈕
$('#btn-edit').click(()=>{
// GET
    fetch(`https://localhost/grading?uaccount=${uaccount}`,{
        method: 'GET',
    }).then((response) =>{
        response.json()
        .then(res =>{
            console.log(res);

            let editv = new Vue({
                el:'#feedback-edit',
                data:{
                    res,
                },
            });
            $('.editli').show();

        });
    });
// ~GET
    $('#btn-ex').removeClass('tog');
    $('.feedback').hide();
    $('#btn-ex').text("填寫意見");

})
//~編輯意見按鈕

//意見送出按鈕
$('#btn-feedback').click(()=>{
    ucomment = $('#feedback-comment').val();
    fetch(`https://localhost/grading`,{
        method: 'POST',
        body: JSON.stringify({
            objectid    :   oid,
            account     :   uaccount,
            star        :   getstar,
            date        :   null,
            comment     :   ucomment,
            }),
        headers: { 'Content-Type': 'application/json'},
    }).then((response) =>{
        response.json()
        .then(res =>{
            console.log(res);
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
