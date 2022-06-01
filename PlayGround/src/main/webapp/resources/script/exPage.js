/**
 * 
 */

$(document).ready(function() {
	// 인증번호 발송 버튼 클릭
	$(".heart").click(function() {
		let isLogin = $("#loginInfo").val();
		if (isLogin == null || isLogin == "") {
			alert("로그인 이후 이용 가능합니다.");
			return;
		}
		let exNo = $("#exNo").val();
		let send = { exNo: exNo };
		$.ajax({
			type: 'POST',       // 요청 메서드
			url: '/exhibit/wishList',  // 요청 URI
			headers: { "content-type": "application/json; charset=utf-8" }, // 요청 헤더
			dataType: 'text', // 전송받을 데이터의 타입
			data: JSON.stringify(send),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
			success: function(result) {
				if (result == "I") {
					alert("찜 목록에 추가되었습니다.")
				} else {
					alert("찜 목록에서 삭제되었습니다.")
				}
			},
			error: function() { alert("오류가 발생하였습니다. 다시 시도해주세요.") } // 에러가 발생했을 때, 호출될 함수
		}); // $.ajax()
	});

});