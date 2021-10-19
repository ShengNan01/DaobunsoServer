$(function(){
    memberData = JSON.parse(localStorage.getItem('member'));
    if(memberData.Login === 'OK'){
        $('.dropdown-toggle').text(memberData.member_name);
        $('.dropdown-item:eq(3)').text('Log out');
        $('.dropdown-item:eq(3)').attr('href','./frontpage.html');
    }
})
$('.dropdown-item:eq(3)').click(function () {
    localStorage.removeItem('member');
});

$(".card_b1").hover(function () {
        $('#card_f1').show();
    }, function () {
        $('#card_f1').hide();
    }
);
$(".card_b2").hover(function () {
    $('#card_f2').show();
}, function () {
    $('#card_f2').hide();
}
);
$(".card_b3").hover(function () {
    $('#card_f3').show();
}, function () {
    $('#card_f3').hide();
}
);
$(".card_b4").hover(function () {
    $('#card_f4').show();
}, function () {
    $('#card_f4').hide();
}
);
$(".card_b5").hover(function () {
    $('#card_f5').show();
}, function () {
    $('#card_f5').hide();
}
);