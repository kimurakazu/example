<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモリスト</title>
</head>
<body>
<h1>Memo</h1>
<ul>
<c:forEach var="memo" items="${list}">
<li><a href="memo?mid=${memo.mid}">${memo.title}</a></li>
</c:forEach>
</ul>
</body>
</html>