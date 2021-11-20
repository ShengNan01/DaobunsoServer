
let url = 'https://localhost/payPayment'

jsonData = JSON.parse(localStorage.getItem('User'));
console.log(jsonData);

fetch('payPayment', {
    method: 'POST',
    body: JSON.stringify(jsonData),
    headers: { 'Content-Type': 'application/json' },

}).then(response => {
    response.text()
        .then(ecpayPageReturn => {
            console.log(ecpayPageReturn);
            // alert(ecpayPageReturn);
            //  $('#ecpay').append(ecpayPageReturn);
            $('#ecpay').html(ecpayPageReturn);
        })
       
    }   
);
