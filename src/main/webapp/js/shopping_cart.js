let myModal = new bootstrap.Modal(document.getElementById('myModal'))
let paymentModal = new bootstrap.Modal(document.getElementById('paymentModal'))

function updateModal(title, massage) {
$('.modal-title').text(title);
$('.modal-body').text(massage);
}

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
        $('#payment_btn').click(function () {
            if(memberData.Login === 'OK') {
                updateModal("Final Check!", "確定要結帳了嗎？");
                paymentModal.show();
                $("#paymentOK").click(function () { 
                    location.href='./payment.html'; 
                });
            } else {
                // alert("請先登入會員")
                updateModal("Oops!", "請先登入會員！");
                myModal.show();
                $('.modal-footer>button').click(function(){
                    location.href='./login.html';
                }) 
            }
        });
    } else {
        $('#payment_btn').click(function (){
            // alert("請先登入會員")
            updateModal("Oops!", "請先登入會員！");
            myModal.show();
            $('.modal-footer>button').click(function(){
                location.href='./login.html';
            })
        })
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