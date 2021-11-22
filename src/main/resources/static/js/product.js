//接收shopping頁面的sessionStorage
// let productid =location.search;
let id = sessionStorage.getItem('productid');
// fetch(`https://localhost/productq?id=${id}`, {
fetch(`https://localhost/productd?id=${id}`, {
    method: 'GET',
}).then(response => {
    response.json().then(res => {
        $('.product-img img').attr('src', res.imagepath);
        $('.product-name h3').html(res.name);
        $('.product-content').html(res.content);
        $('.product-price').html(res.price);
        $('#amount').html(res.inventory);

        let imgsrc = res.imagepath;
        let product_name = res.name;
        let product_price = res.price;
        let product_amount = res.inventory;
    });
});



//~接收shopping頁面的sessionStorage
$('.product-img img').css({ position: 'relative', left: offsetleft = 50, });

const cart_add = $('.cart-add');
let product_amount = $('.product-dropdown button').html();
amount
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
~amount

let cartJson = localStorage.getItem('cart');
let cart = [];

if (cartJson) {
    cart = JSON.parse(cartJson);
}



cart - add
cart_add.click(() => {
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
            date: ""
        });
    } else {
        cart.push({
            type: "product",
            image: imgsrc,
            item: product_name,
            price: product_price,
            amount: product_amount,
            timeframe: "",
            date: ""
        });
    }
    localStorage.setItem('cart', JSON.stringify(cart));
});
//~cart-add
