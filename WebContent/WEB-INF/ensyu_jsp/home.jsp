<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板ホーム</title>
<style>
#error {
	color: red;
}
th{
	background-color: #bbbbbb;

}
td{
	background-color: #dddddd;
}

th,td{
	padding: 0.2em 2em;
}

tr {
	margin-bottom: 3em;
}
</style>
</head>
<body>
<h1>ホーム</h1>
<c:if test="${empty list}">
<p>投稿がありません。</p>
</c:if>
<table>
<c:forEach var="Res" items="${list}">
<tr>
<th>${Res.number }</th>
<th>${Res.name }</th>
<th>${Res.time }</th>
<td><a href="keijiban_del?number=${Res.number }">削除</a></td>
</tr>
<tr>
<td colspan="4"><pre>${Res.main }</pre></td>
</tr>
</c:forEach>
</table>

<h2>投稿フォーム</h2>
<p id="error">${msg }</p>
<form action="keijiban_insert" method="post">
名前：<input type="text" name="name" ><br>
本文：<textarea name="main" ></textarea><br>
<input type="submit" value="書き込み">
</form>

</body>
</html>