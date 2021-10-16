//接收shopping頁面的sessionStorage
let spcatch = JSON.parse(sessionStorage.getItem('splink'))[0];
let imgsrc  = spcatch.p_imgsrc;
let product_name    = spcatch.p_name;
let product_price   = spcatch.p_price;
//~接收shopping頁面的sessionStorage

$('.product-img img').attr('src',imgsrc);
$('.product-img img').height(600);
$('.product-img img').width(400);


// document.getElementById('.product-img img').style.left=800;
// document.getElementById('.product-img img').style.top=200; 
$('.product-img img').css({position: 'relative',left:offsetleft =50,});  

$('.product-name h3').html(product_name);
$('.product-content').html(spcatch.p_content);
$('.product-price').html(product_price);


const cart_add = $('.cart-add');

let product_amount  = $('.product-dropdown button').html();

//amount
{
$('.product-dropdown .dropdown-item1').click(()=>{
    //button 換字
    $('.product-dropdown button').html("1");
    //~button 換字
    product_amount = 1;
});
$('.product-dropdown .dropdown-item2').click(()=>{
    $('.product-dropdown button').html("2");
    product_amount = 2;
});
$('.product-dropdown .dropdown-item3').click(()=>{
    $('.product-dropdown button').html("3");
    product_amount = 3;
});
$('.product-dropdown .dropdown-item4').click(()=>{
    $('.product-dropdown button').html("4");
    product_amount = 4;
});
}
//~amount

 let cartJson = localStorage.getItem('cart');
 let cart = [];

 if (cartJson) {
    cart = JSON.parse(cartJson);
}
//cart-add
cart_add.click( () => {
    alert("已加入購物車");
   
    cart.push({
        type    :   "product",
        image   :   imgsrc,
        item    :   product_name,
        price   :   product_price,
        amount  :   product_amount,
        timeframe : "",
        date:"",
    });
    localStorage.setItem('cart',JSON.stringify(cart));
});
//~cart-add

