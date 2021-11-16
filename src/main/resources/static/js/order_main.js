$(function () {
  $('#order_detail').hide();

  let DBSuserid = getCookieValueByName('id');
  console.log(DBSuserid)
  let urlOrderList = `https://localhost/orders/${DBSuserid}`;
  $(function () {
    maintbody = $('#order_main');
    fetch(urlOrderList, {
      method: "GET",
    }).then(response => {
      response.json().then(text => {
        console.log(text);

        for (let i = 0; i < text.length; i++) {
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

  $('#order_main').on('click', '.details', function () {
    detailtbody = $('#item_details');
    // console.log("HAHAHA");
    $('#order_detail').show();
    let oid = $(this).text();
    // console.log(oid);
    let urlOrderDetail = `https://localhost/orders/${DBSuserid}/${oid}`;
    detailtbody.empty();
    fetch(urlOrderDetail, {
      method: "GET",
    })
      .then(response => {
        response.json().then(text => {
          // console.log(text);

          for (let i = 0; i < text.length; i++) {
            let itemTr = document.createElement('tr');

            let nameTd = document.createElement('td');
            let nameSpan = document.createElement('span');
            nameSpan.innerText = text[i][1];
            nameTd.appendChild(nameSpan);
            itemTr.appendChild(nameTd);

            let stDayTd = document.createElement('td');
            let stDaySpan = document.createElement('span');
            stDaySpan.innerText = text[i][2];
            stDayTd.appendChild(stDaySpan);
            itemTr.appendChild(stDayTd);

            let eDayTd = document.createElement('td');
            let eDaySpan = document.createElement('span');
            eDaySpan.innerText = text[i][3];
            eDayTd.appendChild(eDaySpan);
            itemTr.appendChild(eDayTd);

            let countTd = document.createElement('td');
            let countSpan = document.createElement('span');
            countSpan.innerText = text[i][0];
            countTd.appendChild(countSpan);
            itemTr.appendChild(countTd);

            detailtbody.append(itemTr);
          }
        });
      })
  })
  // $(".dropdown-item:eq(0),.dropdown-item:eq(1)").click(function (e) {
  //   if (memberData.Login !== "OK") {
  //     e.preventDefault();
  //     // alert("請先登入會員")
  //     updateModal("Oops!", "請先登入會員！");
  //     myModal.show();
  //     $(".modal-footer>button").click(function () {
  //       location.href = "./login.html";
  //     });
  //   }
  // });
  // } else {
  //   $(".dropdown-item:eq(0),.dropdown-item:eq(1)").click(function (e) {
  //     e.preventDefault();
  //     // alert("請先登入會員")
  //     updateModal("Oops!", "請先登入會員！");
  //     myModal.show();
  //     $(".modal-footer>button").click(function () {
  //       location.href = "./login.html";
  //     });
  //   });
});
// reset modal when modal was hidden
// let myModalEl = document.getElementById("myModal");
// myModalEl.addEventListener("hidden.bs.modal", function (event) {
//   updateModal("", "");
// });

