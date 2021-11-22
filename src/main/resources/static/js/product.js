//接收shopping頁面的sessionStorage
// let productid =location.search;
let id = sessionStorage.getItem('productid');
// fetch(`https://localhost/productq?id=${id}`, {
fetch(`https://localhost/productd?id=${id}`, {
    method: 'GET',
}).then(response => {
    console.log(response.text());
});



//~接收shopping頁面的sessionStorage

// $('.product-img img').attr('src', imgsrc);
// $('.product-img img').height(600);
// $('.product-img img').width(400);

// $('.product-img img').css({ position: 'relative', left: offsetleft = 50, });
// $('.product-name h3').html(product_name);
// $('.product-content').html(spcatch.p_content);
// $('.product-price').html(product_price);


// const cart_add = $('.cart-add');
// let product_amount = $('.product-dropdown button').html();
//amount
// {
//     $('.product-dropdown .dropdown-item1').click(() => {
//         //button 換字
//         $('.product-dropdown button').html("1");
//         //~button 換字
//         product_amount = 1;
//     });
//     $('.product-dropdown .dropdown-item2').click(() => {
//         $('.product-dropdown button').html("2");
//         product_amount = 2;
//     });
//     $('.product-dropdown .dropdown-item3').click(() => {
//         $('.product-dropdown button').html("3");
//         product_amount = 3;
//     });
//     $('.product-dropdown .dropdown-item4').click(() => {
//         $('.product-dropdown button').html("4");
//         product_amount = 4;
//     });
// }
//~amount

// let cartJson = localStorage.getItem('cart');
// let cart = [];

// if (cartJson) {
//     cart = JSON.parse(cartJson);
// }



//cart-add
// cart_add.click(() => {
//     // alert("已加入購物車");
//     updateModal("Thanks!", "已加入購物車囉！");
//     myModal.show();
//     $('.modal-footer>button').click(function () {
//         location.href = './shopping_cart';
//     })

//     cart.push({
//         type: "product",
//         image: imgsrc,
//         item: product_name,
//         price: product_price,
//         amount: product_amount,
//         timeframe: "",
//         date: "",
//     });
//     localStorage.setItem('cart', JSON.stringify(cart));
// });
//~cart-add
