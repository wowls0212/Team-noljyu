<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="800px" align="center">
	<tr>
		<th>글번호</th><th>ID</th><th>제목</th><th>조회수</th>
	</tr>
	
	<c:forEach items="${list}" var="h">
	<tr>
		<td>${h.hownum}</td>
		<td>${h.id}</td>
		<td><a href="howdetail?hownum=${h.hownum }">${h.howtitle}</a></td>
		<td>${h.howcnt}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>