<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Smilegate | Rank Serivce</title>
</head>
<body>

<#-- 랭킹 -->
<div align="center">
    <button type="button" onclick="history.back()">뒤로가기</button>
    <table>
    </table>
    <h2>
    <#if list?? && list?size != 0>
        랭킹:ID:점수<hr>
        <#list list as l>
        ${l.rank}:${l.user.userId}:#{l.user.score} <br>
        </#list>
    <#-- 친구 리스트 -->
    <#elseif friendList?? && friendList?size != 0>
        ID:점수<hr>
        <#list friendList as l>
        ${l.userId}:${l.score} <br>
        </#list>
    </#if>
    </h2>
</div>
</body>
</html>