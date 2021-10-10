const starimg = "./image/service_intro picture/holo/noel.png";

let oid ="";
let uimgsrc = "./image/service_intro picture/holo/pekora.png";
let uname = "pekora";
let uid ="";
let getstar = 0;
let ucontent = "";
let wdate = Date();

$('.feedback').hide();
$('.user-img img').attr('src',uimgsrc);
$('.star img').attr('src',starimg);
$('.user-name h2').text(uname);

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

$('.btn-feedback').click(()=>{
    ucontent = $('.form-control').val();
    let feedback = [];
    
    feedback.push({
        type        :   "feedback",
        objectid    :   oid,
        userid      :   uid,
        star        :   getstar,
        date        :   wdate,
        content     :   ucontent,
    });

    console.log(JSON.stringify(feedback));
    localStorage.setItem('feedback',JSON.stringify(feedback));

    alert("感謝你寶貴的意見!\n"+ localStorage.getItem('feedback'));
});
// star
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
// star