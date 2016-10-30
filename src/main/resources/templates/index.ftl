<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Smilegate | Rank Serivce</title>
</head>
<body>
<div align="center">
    <h2>
        <form name="inputForm" action="javascript:;">
            스코어 입력<button type="button" id="addInputBox">입력란 추가</button>
            <br>
            <div id="inputFormList">
                <input type="text" name="inputScore" placeholder="ID:스코어"><br>
            </div>
            <button type="button" id="inputScore">확인</button>
            <br>
            <hr>
            친구 등록<br>
            <input type="text" name="addFriend" placeholder="ID:ID">
            <button type="button" id="addFriend">확인</button>
            <br>
            <hr>
            친구 삭제<br>
            <input type="text" name="deleteFriend" placeholder="ID:ID">
            <button type="button" id="deleteFriend">확인</button>
            <br>
        </form>

        <hr>
    <#-- 전체 랭킹 -->
        <form action="/rank/all">
            전체 랭킹<br>
            <button type="submit">확인하기</button>

        </form>
        <hr>
    <#-- 나의 랭킹 -->
        <form action="/rank/my" method="get">
            나의 랭킹 <br>
            <input type="text" name="myId" placeholder="나의 USER_ID 입력">
            <button type="submit" id="myRank">확인</button>
        </form>
        <hr>
    <#-- 친구 랭킹 -->
        <form action="/rank/friend" method="get">
            친구 랭킹 <br>
            <input type="text" name="myId" placeholder="나의 USER_ID 입력">
            <button type="submit" id="rankFriend">확인</button>
        </form>
        <hr>
    <#-- 친구 리스트 -->
        <form action="/friend/list" name="friendList" method="get">
            친구리스트 <br>
            <input type="text" name="myId" placeholder="나의 USER_ID 입력">
            <button type="submit" id="friendList">확인</button>
        </form>
    </h2>
</div>
</body>
<script src="js/jQuery-2.1.4.min.js"></script>
<script>
    $("#inputScore").click(function () {
        // 체크박스 배열 Loop
        var data = [];

        $("input[name=inputScore]").each(function(idx){
            data.push($(this).val());
        });

        $.ajax({
            url: "rank/inputScore",
            type: "post",
            data: {
                ptop : data
            },
            success: function (result) {
                if(result){
                    alert("스코어가 등록되었습니다");
                }else{
                    alert("실패하였습니다.");
                }
                location.reload();
            },
            error: function () {
                alert("[error]");
            }
        });

    });

    $("#addFriend").click(function(){
        var data = $("input[name=addFriend]").val();
        $.ajax({
            url: "friend/add",
            type: "post",
            dataType: "text",
            data:{
                ptop : data
            },
            success: function(result){
                if(result){
                    alert("친구가 추가되었습니다");
                }else{
                    alert("실패하였습니다");
                }
                location.reload();
            },
            error: function(){
                alert("[error]");
            }
        })
    });

    $("#addInputBox").click(function(){
        $("#inputFormList").append("<input type='text' name='inputScore' placeholder='ID:스코어'><br>");
    });

    $("#deleteFriend").click(function(){
        var data = $("input[name=deleteFriend]").val();
        $.ajax({
            url: "friend/delete",
            type: "post",
            dataType: "text",
            data:{
                ptop : data
            },
            success: function(result){
                if(result){
                    alert("친구가 삭제되었습니다");
                }else{
                    alert("실패하였습니다");
                }
                location.reload();
            },
            error: function(){
                alert("[error]");
            }
        })
    })
</script>
</html>