storage = localStorage;
$(function(){
    tbody = $('tbody');
    jsonData = JSON.parse(storage.getItem('cart'));
    
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
    storage.setItem('cart', JSON.stringify(jsonData));
    tbody.remove($(this).parent().parent());
    location.reload(); 
}