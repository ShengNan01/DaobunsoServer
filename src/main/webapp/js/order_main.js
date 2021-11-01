$(function () {
    $('#order_detail').hide();
    if (localStorage.getItem("member") != null) {
      memberData = JSON.parse(localStorage.getItem("member"));
      if (memberData.Login === "OK") {
        $(".dropdown-toggle:not(.btn)").text(memberData.member_name);
        $(".dropdown-item:eq(3)").text("Log out");
        $(".dropdown-item:eq(3)").attr("href", "./frontpage.html");
      }
      $(".dropdown-item:eq(3)").click(function () {
        localStorage.clear();
      });
      $(".dropdown-item:eq(0),.dropdown-item:eq(1)").click(function (e) {
        if (memberData.Login !== "OK") {
          e.preventDefault();
          // alert("請先登入會員")
          updateModal("Oops!", "請先登入會員！");
          myModal.show();
          $(".modal-footer>button").click(function () {
            location.href = "./login.html";
          });
        }
      });
    } else {
      $(".dropdown-item:eq(0),.dropdown-item:eq(1)").click(function (e) {
        e.preventDefault();
        // alert("請先登入會員")
        updateModal("Oops!", "請先登入會員！");
        myModal.show();
        $(".modal-footer>button").click(function () {
          location.href = "./login.html";
        });
      });
    }
  });

  // reset modal when modal was hidden
  // let myModalEl = document.getElementById("myModal");
  // myModalEl.addEventListener("hidden.bs.modal", function (event) {
  //   updateModal("", "");
  // });
  maintbody = $('#order_main');
  let urlOrderList = "http://localhost:8080/Daobunso_Project/orderList.do";
  $('.dropdown-item:eq(1)').click(function (e) { 
    e.preventDefault();
    fetch(urlOrderList, {
      method: "POST",
      body: JSON.stringify(memberData.member_id), //將JavaScript物件轉為JSON物件
      headers: { "Content-Type": "application/json" },
    }).then(response => {
      response.json().then(text => {
        console.log(text);
        
        for(let i = 0; i < text.length; i++){
            let itemTr = document.createElement('tr');
            
            let numTd = document.createElement('td');
            let numSpan = document.createElement('span');
            numSpan.innerText = text[i][0];
            numSpan.className = 'details';
            numSpan.style.textDecoration = 'underline';
            numTd.appendChild(numSpan);
            itemTr.appendChild(numTd);
            
            let timeTd = document.createElement('td');
            let timeSpan = document.createElement('span');
            timeSpan.innerText = text[i][1];
            timeTd.appendChild(timeSpan);
            itemTr.appendChild(timeTd);
            
            let totalTd = document.createElement('td');
            let totalSpan = document.createElement('span');
            totalSpan.innerText = text[i][2];
            totalTd.appendChild(totalSpan);
            itemTr.appendChild(totalTd);

            maintbody.append(itemTr);
        }
      })
    })
  })

  let urlOrderDetail = "http://localhost:8080/Daobunso_Project/orderDetail.do";

  $('#order_main').on('click','.details',function() { 
    // console.log("HAHAHA");
    $('#order_detail').show();
    let oid = $(this).text();
    // console.log(oid);
    fetch(urlOrderDetail, {
      method: "POST",
      body: JSON.stringify(oid), //將JavaScript物件轉為JSON物件
      headers: { "Content-Type": "application/json" },
    
    // .then(response => {
    //   response.json().then(text => {
    //     console.log(text);
        
        // for(let i = 0; i < text.length; i++){
        //     let itemTr = document.createElement('tr');
            
        //     let numTd = document.createElement('td');
        //     let numSpan = document.createElement('span');
        //     numSpan.innerText = text[i][0];
        //     numSpan.className = 'details';
        //     numSpan.style.textDecoration = 'underline';
        //     numTd.appendChild(numSpan);
        //     itemTr.appendChild(numTd);
            
        //     let timeTd = document.createElement('td');
        //     let timeSpan = document.createElement('span');
        //     timeSpan.innerText = text[i][1];
        //     timeTd.appendChild(timeSpan);
        //     itemTr.appendChild(timeTd);
            
        //     let totalTd = document.createElement('td');
        //     let totalSpan = document.createElement('span');
        //     totalSpan.innerText = text[i][2];
        //     totalTd.appendChild(totalSpan);
        //     itemTr.appendChild(totalTd);

        //     maintbody.append(itemTr);
        // }
      
    })
  });
