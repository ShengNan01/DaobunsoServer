//接收shopping頁面的sessionStorage
// let productid =location.search;
let imgsrc;
let product_name;
let product_price;
let id = sessionStorage.getItem('productid');
// fetch(`https://daobunso.myddns.me/productq?id=${id}`, {
fetch(`https://daobunso.myddns.me/productd?id=${id}`, {
    method: 'GET',
}).then(response => {
    response.json().then(res => {
        $('.product-img img').attr('src', res.imagepath);
        $('.product-name h3').html(res.name);
        $('.product-content').html(res.content);
        $('.product-price').html(res.price);

        imgsrc = res.imagepath;
        product_name = res.name;
        product_price = res.price;
    });
});



//~接收shopping頁面的sessionStorage
$('.product-img img').css({ position: 'relative', left: offsetleft = 50, });

let product_amount = $('.product-dropdown button').html();
{
    $('.product-dropdown .dropdown-item1').click(() => {
        //button 換字
        $('.product-dropdown button').html("1");
        //~button 換字
        product_amount = 1;
    });
    $('.product-dropdown .dropdown-item2').click(() => {
        $('.product-dropdown button').html("2");
        product_amount = 2;
    });
    $('.product-dropdown .dropdown-item3').click(() => {
        $('.product-dropdown button').html("3");
        product_amount = 3;
    });
    $('.product-dropdown .dropdown-item4').click(() => {
        $('.product-dropdown button').html("4");
        product_amount = 4;
    });
}


let cartJson = localStorage.getItem('cart');
let cart = [];
if (cartJson) {
    cart = JSON.parse(cartJson);
}
$('.cart-add').click(() => {
    // alert("已加入購物車");
    updateModal("Thanks!", "已加入購物車囉！");
    myModal.show();
    $('.modal-footer>button').click(function () {
        location.href = './shopping_cart';
    })
    if (product_amount === '數量') {
        let product_amount = 1;

        cart.push({
            type: "product",
            image: imgsrc,
            item: product_name,
            price: product_price,
            amount: product_amount,
            timeframe: "",
            date: "",
        });
    }else{
        cart.push({
            type: "product",
            image: imgsrc,
            item: product_name,
            price: product_price,
            amount: product_amount,
            timeframe: "",
            date: "",
        });
    }
    localStorage.setItem('cart', JSON.stringify(cart));
});
//~cart-add
