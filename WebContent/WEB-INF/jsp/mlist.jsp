<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバー一覧</title>
<style>
th,td {
	border: 1px solid black;
	padding: 0.2em 0.5em;
}
table {
	border-collapse: collapse;
	margin-top: 2em;
}
</style>
</head>
<body>
<h1>メンバー一覧</h1>
<h2>メンバー追加</h2>
<form action="mlist" method="post">
氏名：<input type="text" name="name" ><br>
住所：<input type="text" name="adr" ><br>
<input type="submit" value="追加">
</form>
<table>
<tr>
<th>メンバーID</th><th>氏名</th><th>住所</th>
</tr>
<c:forEach var="member" items="${list}">
<tr>
<td>${member.mid }</td>
<td>${member.name }</td>
<td>${member.adr }</td>
<td><a href="mupdate?mid=${member.mid }">変更</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>