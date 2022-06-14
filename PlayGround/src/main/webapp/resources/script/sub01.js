$(document).ready(function(){
//$("a.next").click(function(){
//  $(".popup_background").show();
//})
//$("a.main").click(function(){
//  $(".popup_background").hide();
//})


$("#items1").on('change', function(){

  var price = $("#ticketPrice").val();
  price = parseInt(price);
  var cnt = $("#items1").val();
  cnt = parseInt(cnt);
  
  var price2 = $("#ticketPrice2").val();
  price2 = parseInt(price2);
  var cnt2 = $("#items3").val();
  cnt2 = parseInt(cnt2);
  
  var totalPrice = 0;
  if(isNaN(price2) && isNaN(cnt2)) {
	  totalPrice = price*cnt;
  } else {
	  totalPrice = price*cnt + price2*cnt2;	  
  }

  
  var uPoint = $("#usePoint").val();
  uPoint = parseInt(uPoint.replace(",",""));

  if(totalPrice < uPoint) {
    uPoint = 0;
    $("#usePoint").val(uPoint); 
  }

  var coupon = $("#items2 option:checked").text();
  coupon = parseInt(coupon.replace("%",""))/100;

  var allMoney = totalPrice - uPoint;
  coupon = totalPrice*coupon;
  if((allMoney - coupon)>0 && allMoney>0){
    allMoney = allMoney - coupon;
  };
  $("#allMoney").val(allMoney);
  $("#totalPrice").text(allMoney.toLocaleString());
  
  totalPrice = totalPrice.toLocaleString();
  $("#totTicketPrice").text(totalPrice);
  

});



$("#items3").on('change', function(){

  var price = $("#ticketPrice").val();
  price = parseInt(price);
  var cnt = $("#items1").val();
  cnt = parseInt(cnt);
  
  var price2 = $("#ticketPrice2").val();
  price2 = parseInt(price2);
  var cnt2 = $("#items3").val();
  cnt2 = parseInt(cnt2);

  var totalPrice = price*cnt + price2*cnt2;

  
  var uPoint = $("#usePoint").val();
  uPoint = parseInt(uPoint.replace(",",""));

  if(totalPrice < uPoint) {
    uPoint = 0;
    $("#usePoint").val(uPoint); 
  }

  var coupon = $("#items2 option:checked").text();
  coupon = parseInt(coupon.replace("%",""))/100;

  var allMoney = totalPrice - uPoint;
  coupon = totalPrice*coupon;
  if((allMoney - coupon)>0 && allMoney>0){
    allMoney = allMoney - coupon;
  };
  $("#allMoney").val(allMoney);
  $("#totalPrice").text(allMoney.toLocaleString());
  
  totalPrice = totalPrice.toLocaleString();
  $("#totTicketPrice").text(totalPrice);
  

});



$("#items2").on('change', function(){

  var price = $("#ticketPrice").val();
  price = parseInt(price);
  var cnt = $("#items1").val();
  cnt = parseInt(cnt);

  var totalPrice = price*cnt;

  var uPoint = $("#usePoint").val();
  uPoint = parseInt(uPoint.replace(",",""));

  if(uPoint > 0) {
    alert("쿠폰이 변경되었습니다. 포인트를 다시 선택해 주세요.");
    var uPoint = $("#usePoint").val("0");
  }

  var coupon = $("#items2 option:checked").text();
  coupon = parseInt(coupon.replace("%",""))/100;

  
  var allMoney = totalPrice;
  coupon = totalPrice*coupon;
  if((allMoney - coupon)>=0 && allMoney>0){
    allMoney = allMoney - coupon;
  };


  if(totalPrice==0) {
    alert("매수를 선택해 주세요");
    $("#items2").val("0").prop("selected", true);
    return;
  }

  $("#allMoney").val(allMoney);
  $("#totalPrice").text(allMoney.toLocaleString());
  
  totalPrice = totalPrice.toLocaleString();
  $("#totTicketPrice").text(totalPrice);
  
});


$("#plus").click(function(){



  var point = $("#totPoint").val();
  point = parseInt(point);
  if(point>=10000) {
    var uPoint = $("#usePoint").val();
    uPoint = parseInt(uPoint.replace(",",""));
    uPoint = uPoint + 10000;

    var chkMoney = $("#totalPrice").text();
    chkMoney = parseInt(chkMoney.replace(",",""));
    if(uPoint>point || chkMoney==0) {
      return;
    } else if(chkMoney<10000) {
      alert("결제금액이 10,000원 이하일 경우 포인트의 추가 사용이 불가능합니다.");
      return;
    }


    var ticket = $("#totTicketPrice").text();
    ticket = parseInt(ticket.replace(",",""));

    var coupon = $("#items2 option:checked").text();
    coupon = parseInt(coupon.replace("%",""))/100;
    if(isNaN(coupon)){
    	coupon = 0;
    } else {
    	coupon = ticket*coupon;
    }

    if(uPoint<=point && uPoint<=ticket) {
      var allMoney = ticket - coupon - uPoint;

      if(allMoney == 0) {
        $("#items2").val("0").prop("selected", true);
      }

      $("#allMoney").val(allMoney);
      $("#totalPrice").text(allMoney.toLocaleString());

      $("#frmPoint").val(uPoint);
      uPoint = uPoint.toLocaleString();
      $("#usePoint").val(uPoint);
    }
  }

});

$("#minus").click(function(){

  var uPoint = $("#usePoint").val();
  uPoint = parseInt(uPoint.replace(",",""));
  if(uPoint>0) {
    uPoint = uPoint - 10000;
    
    var ticket = $("#totTicketPrice").text();
    ticket = parseInt(ticket.replace(",",""));

    var coupon = $("#items2 option:checked").text();
    coupon = parseInt(coupon.replace("%",""))/100;
    if(isNaN(coupon)){
    	coupon = 0;
    } else {
    	coupon = ticket*coupon;
    }

    var allMoney = ticket - uPoint - coupon;
    $("#allMoney").val(allMoney);
    $("#totalPrice").text(allMoney.toLocaleString());

    $("#frmPoint").val(uPoint);
    uPoint = uPoint.toLocaleString();
    $("#usePoint").val(uPoint);
  }

});


$("#cancel").click(function(){
	
	if(confirm("예약을 취소하시겠습니까?")) {
		location.href="/";
	}
	
});

$("#reserve").click(function(){
	
	var adCnt = $("#items1").val();
	adCnt = parseInt(adCnt);
	var chCnt = $("#items3").val();
	chCnt = parseInt(chCnt);
	
	var date = new Date();
	var year = date.getFullYear();
	var month = ("0" + (1 + date.getMonth())).slice(-2);
	var day = ("0" + date.getDate()).slice(-2);
	
	var payDate = year+ month+day;
	
	$("#payDate").val(payDate);
	
	if(isNaN(chCnt)) {
		if(adCnt != 0) {
			if(confirm("해당 내용으로 예매하시겠습니까?")) {
				$("#payFrm").submit();
			} 
		} else {
			alert("예약 매수를 선택해 주세요.");
		}			
	} else {
		if(adCnt != 0 && chCnt != 0) {
			if(confirm("해당 내용으로 예매하시겠습니까?")) {
				return;
			}		
		} else {
			alert("예약 매수를 선택해 주세요.");
		}	
	}

	
});



});