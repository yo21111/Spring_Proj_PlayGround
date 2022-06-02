$(function(){
	
	$(".1W").click(function(){
		// 7일뒤 날짜 계산
		var last = new Date();
		
		var lastDay = new Date(last.setDate(last.getDate() + 7));
		
		lastDay = lastDay.toISOString().slice(0,10);

		var start = document.getElementById("start");
		var start2 = document.getElementById("start2");
		var end = document.getElementById("end");
		var end2 = document.getElementById("end2");
		
		start.value = lastDay;
		start2.value = lastDay;
		end.value = lastDay;
		end2.value = lastDay;
	});
	
	$(".1M").click(function(){
		// 1달뒤 날짜 계산
		var last = new Date();
		
		var lastDay = new Date(last.setMonth(last.getMonth() + 1));
		
		lastDay = lastDay.toISOString().slice(0,10);

		var start = document.getElementById("start");
		var start2 = document.getElementById("start2");
		var end = document.getElementById("end");
		var end2 = document.getElementById("end2");
		
		start.value = lastDay;
		start2.value = lastDay;
		end.value = lastDay;
		end2.value = lastDay;
	});
	
	$(".3M").click(function(){
		// 3달뒤 날짜 계산
		var last = new Date();
		
		var lastDay = new Date(last.setMonth(last.getMonth() + 3));
		
		lastDay = lastDay.toISOString().slice(0,10);

		var start = document.getElementById("start");
		var start2 = document.getElementById("start2");
		var end = document.getElementById("end");
		var end2 = document.getElementById("end2");
		
		start.value = lastDay;
		start2.value = lastDay;
		end.value = lastDay;
		end2.value = lastDay;
	});
	
	$(".6M").click(function(){
		// 6달뒤 날짜 계산
		var last = new Date();
		
		var lastDay = new Date(last.setMonth(last.getMonth() + 6));
		
		lastDay = lastDay.toISOString().slice(0,10);

		var start = document.getElementById("start");
		var start2 = document.getElementById("start2");
		var end = document.getElementById("end");
		var end2 = document.getElementById("end2");
		
		start.value = lastDay;
		start2.value = lastDay;
		end.value = lastDay;
		end2.value = lastDay;
	});
	
	$(".score1").click(function(){
		$(".score").val(1);
		$(".score1").attr("src", "/resources/image/full.png");
		$(".score2").attr("src", "/resources/image/empty.png");
		$(".score3").attr("src", "/resources/image/empty.png");
		$(".score4").attr("src", "/resources/image/empty.png");
		$(".score5").attr("src", "/resources/image/empty.png");
	});
	
	$(".score2").click(function(){
		$(".score").val(2);
		$(".score1").attr("src", "/resources/image/full.png");
		$(".score2").attr("src", "/resources/image/full.png");
		$(".score3").attr("src", "/resources/image/empty.png");
		$(".score4").attr("src", "/resources/image/empty.png");
		$(".score5").attr("src", "/resources/image/empty.png");
	});
	
	$(".score3").click(function(){
		$(".score").val(3);
		$(".score1").attr("src", "/resources/image/full.png");
		$(".score2").attr("src", "/resources/image/full.png");
		$(".score3").attr("src", "/resources/image/full.png");
		$(".score4").attr("src", "/resources/image/empty.png");
		$(".score5").attr("src", "/resources/image/empty.png");
	});
	
	$(".score4").click(function(){
		$(".score").val(4);
		$(".score1").attr("src", "/resources/image/full.png");
		$(".score2").attr("src", "/resources/image/full.png");
		$(".score3").attr("src", "/resources/image/full.png");
		$(".score4").attr("src", "/resources/image/full.png");
		$(".score5").attr("src", "/resources/image/empty.png");
	});
	
	$(".score5").click(function(){
		$(".score").val(5);
		$(".score1").attr("src", "/resources/image/full.png");
		$(".score2").attr("src", "/resources/image/full.png");
		$(".score3").attr("src", "/resources/image/full.png");
		$(".score4").attr("src", "/resources/image/full.png");
		$(".score5").attr("src", "/resources/image/full.png");
	});
	
	$(".revIns").click(function(){
				
		var src = $(".score1").attr("src");
		var empty = "/resources/image/empty.png";
		if(src == empty) {
			alert("평점을 선택해주세요");
			return;
		}
		
		var title = $(this).parent().parent().prev().children().next().next().children().eq(1).val();
		if(title.trim() == "" ) {
			alert("제목을 입력해주세요");
			$(".revTitle").focus();
			return;
		}
		$(".insTitle").val(title);
		
		var content = $(this).parent().parent().prev().children().next().next().children().eq(2).val();
		if(content.trim() == "") {
			alert("내용을 입력해주세요");
			$("#review_letter").focus();
			return;
		}
		$(".insContent").val(content);
		
		var reDate = $(this).parent().parent().prev().children().children().next().children().val();
		$(".reDate").val(reDate);
		
		var exNo = $(this).parent().parent().prev().children().next().next().children().eq(5).val();
		$(".exNo").val(exNo);
	
		
		$(".review").submit();
		
	});
	
	$(".viewBtn").click(function(){
		var exNo = $(this).next().val();
		alert(exNo);
		location.href = "/exhibit/listView?exNo=" + exNo;
	});
	

	
});