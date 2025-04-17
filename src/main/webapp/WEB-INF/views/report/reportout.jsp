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
	

<table border = "3" width="800px" align="center">
<tr>
	<th>신고번호</th><th>게시글번호</th><th>작성자</th><th>신고유형</th><th>신고자</th><th>신고사유</th>
</tr>
<c:forEach items="${list }" var="rep">
<tr>
	<td>${rep.postreportnum }</td>
	<td>${rep.postnum}</td>
	<td>${rep.postid }</td>
	<td>${rep.reportreason }</td>
	<td>${rep.reportid}</td>
	<td>${rep.reportdetail}</td>
	<td colspan="2">
	<input type="hidden" name="reportnum" value="${rep.postreportnum }">
	<div id = sub>
	<button type="button" id=postsubmit onclick="location.href='postreportdel?num=${rep.postnum}'">접수</button>
	<button type="button" onclick="location.href='main'">철회</button>
	</div>
	</td>
</tr>
</c:forEach>
</table>

</body>
</html>