let myModal = new bootstrap.Modal(document.getElementById('myModal'))

function updateModal(title, massage) {
$('#modal-title').text(title);
$('#massage-content').text(massage);
}

$(function(){
    if(localStorage.getItem('member') != null){
        memberData = JSON.parse(localStorage.getItem('member'));
        if(memberData.Login === 'OK'){
        $('.dropdown-toggle:not(.btn)').text(memberData.member_name);
        $('.dropdown-item:eq(3)').text('Log out');
        $('.dropdown-item:eq(3)').attr('href','./frontpage.html');
        }
        $('.dropdown-item:eq(3)').click(function () {
            localStorage.removeItem('member');
        });
        $('.dropdown-item:eq(0),.dropdown-item:eq(1)').click(function (e) {
            if(memberData.Login !== 'OK'){
                e.preventDefault();
                updateModal("Oops!", "請先登入會員！");
                myModal.show();
                $('.modal-footer>button').click(function(){
                    location.href='./login.html';
                })
            }
        });
    } else {
        $('.dropdown-item:eq(0),.dropdown-item:eq(1)').click(function (e){
            e.preventDefault();
            updateModal("Oops!", "請先登入會員！");
            myModal.show();
            $('.modal-footer>button').click(function(){
                location.href='./login.html';
            })
        })
    }   
})
let urlReg = 'http://localhost:8080/Daobunso_Project/Change_pswd';

$('#change_btn').click(function(e){
    e.preventDefault();
    if($('#pswdnew').val() !== $('#confpswd').val()){
        updateModal("Oops!", "兩次輸入的新密碼不相符，請重新輸入！");
        myModal.show();
        return;
    } else if($('#ogpswd').val() === "" || $('#pswdnew').val() === "" 
    || $('#confpswd').val() === "" ){
        updateModal("Oops!", "有欄位未填寫，請檢查！！");
        myModal.show();
        return;
    } else {
	
	const memberId = JSON.parse(localStorage.member).member_id;
        changepswd = {
			"Member_Id": memberId,
			"Password":$('#ogpswd').val(),
        };
    fetch('Change_pswd',{
//    fetch(urlReg,{
        method:'POST',
        body:JSON.stringify(changepswd),
        headers:{ 'Content-Type' :'application/type'},
    })
    .then(response => { response.text()

			const memberId = JSON.parse(localStorage.member).member_id;
		        changepswd = {
					"Member_Id": memberId,
					"Password":$('#pswdnew').val()
		        };
		    fetch('Change_pswd',{
		//    fetch(urlReg,{
		        method:'POST',
		        body:JSON.stringify(changepswd),
		        headers:{ 'Content-Type' :'application/type'},
		    })
    .then(text =>{
        if(text === "修改密碼成功，請重新登入！"){
            updateModal("修改密碼成功，請重新登入")
                Modal.show();
                $('.modal-footer>button').click(function(){
                    location.href='./frontpage.html';
                })
            
        } else {
            updateModal("修改密碼失敗，請重新輸入！",text);
            myModal.show();
            return;
             }
        }
    )
    })
    }
}); 


$('.dropdown-item:eq(3)').click(function () { 
    localStorage.removeItem('member');
});
// reset modal when modal was hidden
let myModalEl = document.getElementById('myModal')
myModalEl.addEventListener('hidden.bs.modal', function (event) {
    updateModal("","");
})