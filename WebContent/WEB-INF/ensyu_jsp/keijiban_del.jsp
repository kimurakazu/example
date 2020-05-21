<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認</title>
<style>
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
<h1>削除確認</h1>

<p>以下の投稿を削除します。よろしいですか？</p>
<table>
<tr>
<th>${Res.number }</th>
<th>${Res.name }</th>
<th>${Res.time }</th>
</tr>
<tr>
<td colspan="3"><pre>${Res.main }</pre></td>
</tr>
</table>
<form action="keijiban_del" method="post">
<input type="hidden" name="number" value="${Res.number }">
<input type="submit" value="削除">
</form>
<form action="keijiban_home" method="get">
<input type="submit" value="戻る">
</form>
</body>
</html>