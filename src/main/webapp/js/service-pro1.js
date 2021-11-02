let myModal = new bootstrap.Modal(document.getElementById('myModal'))

function updateModal(title, massage) {
$('#modal-title').text(title);
$('#massage-content').text(massage);
}

$(function() {
    $( "#mydate" ).datepicker({ minDate: 0, maxDate: "+3M", dateFormat: 'yy-mm-dd' });
});
const btn = document.getElementById('save_cart_btn');
const timeframe = document.getElementById('inputGroupSelect01')
const date = document.getElementById('mydate');
const price = document.getElementById('singleSelect');

let cartJson = localStorage.getItem('cart');
let cart = [];

if (cartJson) {
    cart = JSON.parse(cartJson);
}

btn.onclick = function () {
    // alert("已加入購物車");
    updateModal("Thanks!", "已加入購物車囉！");
    myModal.show();
           
    cart.push({
        type: "service",
        image: "",
        item: "單次方案",
        date: date.value,
        timeframe: timeframe.value,
        price: price.value
    });

    localStorage.setItem('cart', JSON.stringify(cart))
};

// reset modal when modal was hidden
let myModalEl = document.getElementById('myModal')
myModalEl.addEventListener('hidden.bs.modal', function (event) {
    updateModal("","");
})

$(function(){
    if(localStorage.getItem('member') != null){
        memberData = JSON.parse(localStorage.getItem('member'));
        if(memberData.Login === 'OK'){
        $('.dropdown-toggle:not(.btn)').text(memberData.member_name);
        $('.dropdown-item:eq(3)').text('Log out');
        $('.dropdown-item:eq(3)').attr('href','./frontpage.html');

        $('.dropdown-item:eq(3)').click(function () {
            localStorage.clear();
        });

        }
        
        $('.dropdown-item:eq(0),.dropdown-item:eq(1)').click(function (e) {
            if(memberData.Login !== 'OK'){
                e.preventDefault();
                // alert("請先登入會員")
                updateModal("Oops!", "請先登入會員！");
                myModal.show();
                $('.modal-footer>button').click(function(){
                    location.href='./login.html';
                })
            }
        });
    } else {
        $('.dropdown-item:eq(0),.dropdown-item:eq(1)').click(function (e){
            e.preventDefault();
            // alert("請先登入會員")
            updateModal("Oops!", "請先登入會員！");
            myModal.show();
            $('.modal-footer>button').click(function(){
                location.href='./login.html';
            })
        })
    }   
})