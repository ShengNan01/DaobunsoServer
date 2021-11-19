//Feedback定義變數
let oid = 0;
let uaccount = getCookieValueByName("account");
let getstar = 0;
let ucomment = "";
// let wdate = Date();

//定義頁面
let uimgsrc = "./image/service_intro/holo/pekora.png";
let uname = getCookieValueByName("name");

//頁面初始化
$('.feedback').hide();
$('.user-img img').attr('src', uimgsrc);
$('.user-name h2').text(uname);
//觀看意見領域
fetch(`https://localhost/gradings`, {
    method: 'GET',
}).then((response) => {
    response.json().then(res => {
        console.log(res);

        const width = $(window).width();
        console.log(width);
        let result = null;

        // display dispatcher
        if (width >= 1183) {
            result = res.slice(0, 3)
        }

        else if (width > 768 && width < 1183) {
            result = res.slice(0, 2)
        }
        else {
            result = [res[0]];
        }
        // ~display dispatcher

        let marqueev = new Vue({
            el: '#marquee',
            data: {
                res: result,
            },
        });
        $('#marquee').show();
    });
});
//~觀看意見領域
//~頁面初始化

//意見填寫展開按鈕tog
$('#btn-ex').click(function () {
    // 數值init
    oid = 0;
    getstar = 0;
    ucomment = "";
    $('#feedback-comment').val("");
    $('#feedback-id').hide();
    // ~數值init
    $(this).toggleClass('tog');
    if ($(this).hasClass('tog')) {
        $('.feedback').show();
        $('#btn-ex').text("收起");
    } else {
        $('.feedback').hide();
        $('#btn-ex').text("填寫意見");
    }
});
//~意見填寫展開按鈕tog

//編輯意見按鈕
$('#btn-list').click(function () {
    // 數值init
    oid = 0;
    ucomment = "";
    $('#feedback-comment').val("");
    $('#feedback-id').hide();
    // ~數值init
    $('.feedback').hide();
    $('#btn-ex').removeClass("tog");
    $('#btn-ex').text("填寫意見");
    $(this).toggleClass('tog');
    if ($('#btn-list').hasClass('tog')) {
        $('#feedback-list').show();
        $('#btn-list').text("收起意見列表");
        // GET
        fetch(`https://localhost/grading?uaccount=${uaccount}`, {
            method: 'GET',
        }).then((response) => {
            response.json().then(res => {
                $('#btn-ex').hide();
                $('#feedback-list').show();
                console.log(res);

                let editv = new Vue({
                    el: '#feedback-list',
                    data: {
                        res,
                    },
                    methods: {
                        edit: (key) => {
                            oid = res[key].objectid;
                            ucomment = res[key].comment;
                            getstar = res[key].star;
                            $('.feedback').show();
                            $('#feedback-comment').val(ucomment);
                            $('#feedback-id h2').text(oid);
                            $('#feedback-id').show();

                            for (let temp = getstar; temp >= 1; temp--) {
                                $('#star' + temp).addClass('star-cl');
                            }


                        },
                        del: (key) => {
                            // console.log(key);
                            console.log(res[key].objectid);
                            fetch(`https://localhost/grading?objectid=${res[key].objectid}&account=${getCookieByName('account')}&email=${getCookieByName('email')}`, {
                                method: 'DELETE',
                            }).then(response => {
                                alert("刪除意見成功");
                                location.reload();
                            });
                        }
                    },
                });
            });
        });
        // ~GET
    } else {
        // $('#btn-list').text("修改/刪除意見");
        // $('#btn-list').removeClass('tog')
        // $('#feedback-list').hide();
        location.reload();
    }
});
//~編輯意見按鈕

//意見送出按鈕
$('#btn-feedback').click(() => {
    ucomment = $('#feedback-comment').val();
    if (oid == 0) {

        if (getstar != 0 && ucomment != '') {
            fetch(`https://localhost/grading?email=${getCookieByName('email')}`, {
                method: 'POST',
                body: JSON.stringify({
                    account: uaccount,
                    star: getstar,
                    comment: ucomment,
                }),
                headers: { 'Content-Type': 'application/json' },
            }).then((response) => {
                alert("成功送出意見!!");
                location.reload();
            });

        } else {
            alert("項目不完整!");
        }
    } else {
        ucomment = $('#feedback-comment').val();
        if (getstar != 0 && ucomment != '') {
            fetch(`https://localhost/grading?email=${getCookieByName('email')}`, {
                method: 'PUT',
                body: JSON.stringify({
                    objectid: oid,
                    account: uaccount,
                    star: getstar,
                    comment: ucomment,
                }),
                headers: { 'Content-Type': 'application/json' },
            }).then(response => {
                alert("重新編輯完成!!");
                location.reload();

            });

        } else {
            alert("項目不完整!!");
        }

    }
});
//~意見送出按鈕

//star
$('#stars').hover(() => {
    // listenstar(()=>{

    $('#star1').hover(() => {
        $('#star1').addClass('star-act');
    }, () => {
        $('#star1').removeClass('star-act');
    });
    $('#star1').click(() => {
        $('#star1').addClass('star-cl');
        $('#star2').removeClass('star-cl');
        $('#star3').removeClass('star-cl');
        $('#star4').removeClass('star-cl');
        $('#star5').removeClass('star-cl');
        getstar = 1;
    });
    $('#star2').hover(() => {
        $('#star1').addClass('star-act');
        $('#star2').addClass('star-act');
    }, () => {
        $('#star1').removeClass('star-act');
        $('#star2').removeClass('star-act');
    });
    $('#star2').click(() => {
        $('#star1').addClass('star-cl');
        $('#star2').addClass('star-cl');
        $('#star3').removeClass('star-cl');
        $('#star4').removeClass('star-cl');
        $('#star5').removeClass('star-cl');
        getstar = 2;
    });
    $('#star3').hover(() => {
        $('#star1').addClass('star-act');
        $('#star2').addClass('star-act');
        $('#star3').addClass('star-act');
    }, () => {
        $('#star1').removeClass('star-act');
        $('#star2').removeClass('star-act');
        $('#star3').removeClass('star-act');
    });
    $('#star3').click(() => {
        $('#star1').addClass('star-cl');
        $('#star2').addClass('star-cl');
        $('#star3').addClass('star-cl');
        $('#star4').removeClass('star-cl');
        $('#star5').removeClass('star-cl');

        getstar = 3;
    });
    $('#star4').hover(() => {
        $('#star1').addClass('star-act');
        $('#star2').addClass('star-act');
        $('#star3').addClass('star-act');
        $('#star4').addClass('star-act');

    }, () => {
        $('#star1').removeClass('star-act');
        $('#star2').removeClass('star-act');
        $('#star3').removeClass('star-act');
        $('#star4').removeClass('star-act');
    });
    $('#star4').click(() => {
        $('#star1').addClass('star-cl');
        $('#star2').addClass('star-cl');
        $('#star3').addClass('star-cl');
        $('#star4').addClass('star-cl');
        $('#star5').removeClass('star-cl');
        getstar = 4;
    });
    $('#star5').hover(() => {
        $('#star1').addClass('star-act');
        $('#star2').addClass('star-act');
        $('#star3').addClass('star-act');
        $('#star4').addClass('star-act');
        $('#star5').addClass('star-act');

    }, () => {
        $('#star1').removeClass('star-act');
        $('#star2').removeClass('star-act');
        $('#star3').removeClass('star-act');
        $('#star4').removeClass('star-act');
        $('#star5').removeClass('star-act');
    });
    $('#star5').click(() => {
        $('#star1').addClass('star-cl');
        $('#star2').addClass('star-cl');
        $('#star3').addClass('star-cl');
        $('#star4').addClass('star-cl');
        $('#star5').addClass('star-cl');
        getstar = 5;
    });
})
//~star
