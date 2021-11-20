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



// 日期選取
$(function () {
    $("#mydate").datepicker({
       minDate: 0,
       maxDate: "+3M", dateFormat: 'yy-mm-dd',
 
       onSelect: function (selected) {
          $("#enddate").datepicker("option", "minDate", selected);
          var date = $(this).datepicker('getDate');
          var tempStartDate = new Date(date);
          var default_end = new Date(tempStartDate.getFullYear(), tempStartDate.getMonth(), tempStartDate.getDate() + 30);
          $('#enddate').datepicker('setDate', default_end);
       }
    });
    $("#enddate").datepicker({
       minDate: 0, maxDate: "+3M", dateFormat: 'yy-mm-dd',
 
       onSelect: function (selected) {
          $("#mydate").datepicker("option", "maxDate", selected);
       }
    });
 });
 // 日期選取