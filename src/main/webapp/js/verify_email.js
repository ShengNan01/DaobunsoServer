const regex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
$("#verify_email_btn").click(function () { 
    if($("#email").val() === ""){
        alert('請填入信箱');
    }else if(!regex.test($("#email").val())){   
        alert('輸入的信箱格式不正確');
    }else{
         let email = $('#email').val();
         const Email = {Email:email}
         
         let url = 'http://localhost:8080/Daobunso_Project/Verifyemail';
         fetch(url, {
            method: 'POST',
            body: JSON.stringify(Email),
            headers: { 'Content-Type': 'application/json' },
        }).then(response =>{
            response.text()
            .then(text =>{
                alert(text);
            });
        });
    };
});