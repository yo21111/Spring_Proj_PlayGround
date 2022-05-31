$(document).ready(function() {

    //전시목록 탭
    //tab_menu
    $("li.tab_menu").click(function() {
        $(this).addClass("on");
        $(this).siblings().removeClass("on");
        let idx = $(this).index();
        console.log(idx);
        $(this).parent().parent().siblings().removeClass("view");
        $(this).parent().parent().siblings().eq(idx).addClass("view");

    });

    //아이디 비밀번호 찾기 탭
    $(".sel_form .select").click(function() {
        $(this).addClass("on");
        $(this).siblings().removeClass("on");
        let idx1 = $(this).index();
        console.log(idx1);
        $(this).parent().siblings().removeClass("view");
        $(this).parent().siblings().eq(idx1).addClass("view");
    });
    //아이디 비밀번호 찾기 탭
    $(".sel_form .select_1").click(function() {
        $(this).addClass("on");
        $(this).siblings().removeClass("on");
        let idx2 = $(this).index();
        console.log(idx2);
        $(this).parent().siblings().removeClass("view");
        $(this).parent().siblings().eq(idx2).addClass("view");
    });

    //회원가입 약관 팝업
    $("#popup_1").click(function() {
        $("#bglayer").show();
    });
    $("#popup_2").click(function() {
        $("#bglayer2").show();
    });
    $("#popup_3").click(function() {
        $("#bglayer3").show();
    });
    $(".close").click(function() {
        $(".bg").hide();
    });
    $("#close2").click(function() {
        $("#bglayer").hide();
    });
    $("#close3").click(function() {
        $("#bglayer2").hide();
    });

    $("#close4").click(function() {
        $("#bglayer3").hide();
    });

    //마이페이지 회원탈퇴 팝업창 (오류)
    $("#pop_up").click(function() {
        $("#pop_bg").show();
    });
    $("#back").click(function() {
        $("#pop_bg").hide();
    });
}); //.ready() end