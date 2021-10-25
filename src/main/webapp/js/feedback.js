//定義頁面
const starimg = "./image/service_intro picture/holo/noel.png";

let uimgsrc = "./image/service_intro picture/holo/pekora.png";
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
//展開按鈕
$('.btn-ex').click(function(){

    $(this).toggleClass('tog');
    if($('.btn-ex').hasClass('tog')){
        $('.feedback').show();
        $('.btn-ex').text("收起");
    }else{
        $('.feedback').hide()
        $('.btn-ex').text("填寫意見");
    }
});
//~展開按鈕

//編輯意見按鈕
$('.btn-edit').click(()=>{
// GET
    fetch(`http://localhost:8080/grading?uaccount=${uaccount}`,{
                method: 'GET',
    }).then((response) =>{
        response.json()
        .then(res =>{
            console.log(res)
        });
    });
})
//~編輯意見按鈕

//意見送出按鈕
$('.btn-feedback').click(()=>{
    ucomment = $('#feedback-comment').val();
    // sessionStorage.setItem('grading',JSON.stringify(grading));
    // alert("感謝你寶貴的意見!\n"+ sessionStorage.getItem('grading'));
    fetch(`http://localhost:8080/grading`,{
                method: 'POST',
                body: JSON.stringify({
                    objectid    :   oid,
                    user_account:   uaccount,
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