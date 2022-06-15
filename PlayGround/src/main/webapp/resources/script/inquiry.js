$(function(){
	
	$("#write").click(function(){
		
		var category = $("#category").val();
		var content = $("#content").val();
		var title = $("#title").val();
		title = title.replaceAll("  ", "");
		content = content.replaceAll("   ", "");
		
		if(category==0) {
			alert("카테고리를 선택해주세요.");
			return;
		}
		if(title == "" || title == null) {
			alert("제목을 입력해 주세요.");
			return;
		}
		if(content == "" || content == null) {
			alert("내용을 입력해 주세요.");
			return;
		}
		if(confirm("해당 내용으로 문의하시겠습니까?")) {
			$("#inqFrm").submit();
		}
		
	});

	
});