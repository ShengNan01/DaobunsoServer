

// reset modal when modal was hidden
let myModalEl = document.getElementById('myModal')
myModalEl.addEventListener('hidden.bs.modal', function (event) {
    updateModal("","");
})

$(function(){
    tbody = $('tbody');
    jsonData = JSON.parse(localStorage.getItem('cart'));

    // console.log(jsonData.length);
    total = 0;
    for(let i = 0; i < jsonData.length; i++){
        createCartList(i);
        if(jsonData[i].type == "service"){
            itemPrice = parseInt(jsonData[i].price);
        } else {
            itemPrice = parseInt(jsonData[i].price) * parseInt(jsonData[i].amount);
        }
        total += itemPrice;
    }
    $('#total').text(total);
})
function createCartList(i){
    let itemTr = document.createElement('tr');
    tbody.append(itemTr);

    let imgTd = document.createElement('td');
    let image = document.createElement('img');
    image.src = jsonData[i].image;
    imgTd.appendChild(image);
    itemTr.appendChild(imgTd);

    let nameTd = document.createElement('td');
    let nameSpan = document.createElement('span');
    nameSpan.id = i;
    nameSpan.innerText = jsonData[i].item;
    nameTd.appendChild(nameSpan);
    itemTr.appendChild(nameTd);

    let dateTd = document.createElement('td');
    let dateSpan = document.createElement('span');
    dateSpan.innerText = jsonData[i].date;
    dateTd.appendChild(dateSpan);
    itemTr.appendChild(dateTd);

    let timeTd = document.createElement('td');
    let timeSpan = document.createElement('span');
    timeSpan.innerText = jsonData[i].timeframe;
    timeTd.appendChild(timeSpan);
    itemTr.appendChild(timeTd);

    let numTd = document.createElement('td');
    if(jsonData[i].type == "service"){
        numTd.innerText = 1;
    } else {
        let numInput = document.createElement('input');
        numInput.type = 'number';
        numInput.value = jsonData[i].amount;
        numInput.min = 1;
        numInput.addEventListener('input',changItemCount);
        numTd.appendChild(numInput);
    }
    itemTr.appendChild(numTd);

    let priceTd = document.createElement('td');
    let priceSpan = document.createElement('span');
    if(jsonData[i].type == "service"){
        priceSpan.innerText = jsonData[i].price;
    } else {
        priceSpan.innerText = jsonData[i].price * jsonData[i].amount;
    }
    priceTd.appendChild(priceSpan);
    itemTr.appendChild(priceTd);

    let delTd = document.createElement('td');
    let delBtn = document.createElement('button');
    delBtn.className = 'btn btn-primary btn-sm text-light btn_delete';
    delBtn.innerText = '刪除';
    delBtn.addEventListener('click',deleteItem);
    delTd.appendChild(delBtn);
    itemTr.appendChild(delTd);
}
function changItemCount() {
    let itemOldPrice = $(this).parent().next().first().text();
    // console.log(itemOldPrice);
    let newNum = $(this).val();
    // console.log(newNum);
    let index = this.parentNode.previousSibling.previousSibling.previousSibling.firstChild.id;
    // let index = $(this).parent().prev().prev().prev().first().attr('id');
    // console.log(index);
    let itemPrice = parseInt(jsonData[index].price);
    // console.log(itemPrice);
    jsonData[index].amount = newNum;
    // console.log(jsonData[index].amount);
    localStorage.setItem('cart', JSON.stringify(jsonData));

    let subtotal = newNum * itemPrice;
    // console.log(subtotal);
    $(this).parent().next().first().text(subtotal);
    total = total - itemOldPrice + subtotal;
    // console.log(total);
    $('#total').text(total);
}
function deleteItem(){
    let index = this.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.firstChild.id;
    // console.log(index);
    let delCount =  $(this).parent().prev().first().text();
    // console.log(delCount);
    total -= delCount;
    $('#total').text(total);
    jsonData.splice(index, 1);
    // console.log(jsonData);
    localStorage.setItem('cart', JSON.stringify(jsonData));
    tbody.remove($(this).parent().parent());
    location.reload();
}


// ----------------抓LOCALSTORAGE資料----------
localStorage.getItem('cart')

// AJAX傳向後端------------------------------------------------

alert( "準備要結帳了喔" );

$(function () {


    $('#submiter').click(function (e) {
        alert( "您的結帳已經寄出" );
        e.preventDefault();


        let maincontactname = $('#maincontactname').val();
        let maincontactphone =  $('#maincontactphone').val();
        let maincontactaddress =  $('#maincontactaddress').val();
        let paymentmoney = $('.form-select').val();
        let maincompany = $('#maincompany').val();
        let companyinvoicenumber = $('#companyinvoicenumber').val();
        let confirm = $('#lastconfirm').val();
        let totalPrice = $('#total').text();

        // -------------把LOCALSTORAGE用成一個變數
        let paymenttype = JSON.parse(localStorage.getItem('cart'))





        // -------------------localstorage的各項值每次訂單的定義

        let userDetail = [];

        for (i=0;i<paymenttype.length;i++){

            var  localDate=  paymenttype[i].date;
            let date=localDate.split(" ~ ")
            var startday= date[0];
            var endday= date[1];

            let detail={
                "garbageStartDate" : startday,
                "garbageEndDate" :endday,
                "image" :paymenttype[i].image,
                "itemType" :paymenttype[i].item,
                "quantity" : paymenttype[i].type=='service'?1:paymenttype[i].amount


            }
            userDetail.push(detail);

        }

        let user = {};
        for (i=0;i<paymenttype.length;i++){
            user['contact'] = maincontactname;
            user['phone'] = maincontactphone;
            user['address'] = maincontactaddress;
            user['payType'] = paymentmoney;
            user['sum'] = totalPrice;
            user['company_title'] = maincompany;
            user['taxIDnumber'] = companyinvoicenumber;
            user['timeForGarbage'] = paymenttype[i].timeframe;
            user['scheduleGarbage'] = confirm;
            user['userDetails']= userDetail;
        }



        // $.ajax({
        //     url: `https://localhost:8443/placeOrder2`,
        //     type: 'POST',
        //     async: false,
        //     contentType: 'application/json;charset=utf-8',
        //     data: JSON.stringify(user),
        //     success: function (response) {
        //         $('#message').text('您的結帳已送出成功~');
        //     }
        // });


            fetch(`https://localhost:8443/placeOrder2`,{
            method: 'POST',
            body:JSON.stringify(user),
            headers: { 'Content-Type': 'application/json'},
        }).then(
            console.log("ok")
            );

    });
});








