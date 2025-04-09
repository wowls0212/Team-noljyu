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
		<th>아이디</th>
		<td>${dto.id}</td>
	</tr>
	
	<tr>
		<th>제목</th>
		<td>${dto.howtitle}</td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td>${dto.howdetail}</td>
	</tr>
	
	<tr>
		<th>이미지</th>
		<td><img alt="" src="./image/${dto.howimg}"></td>
	</tr>
	
	<tr>
		<td colspan="2" style="text-align: center;">
		<button onclick="location.href='howreview?hownum=${dto.hownum}'"></button>
	</tr>
</table>

<form action="howreviewsave">
<input type="hidden" value="${dto.hownum}" name="hownum">
<input type="hidden" value="${dto.id}" name="id">
<table border="1" align="center" width="800px">
	<tr>
		<th><textarea rows="10" cols="70" name="review"></textarea></th>
		<td><input type="submit" value="전송"></td>
	</tr>
</table>
</form>


<table border="1" align="center" width="800px" style="margin-bottom: 100px">
<c:forEach items="${list}" var="rr">
	<tr>
		<th>
		<c:forEach var="i" begin="0" end="${rr.indent}">
			&emsp;
		</c:forEach>
		${rr.review}</th>
		<td>
		<button onclick="location.href='howrere?reviewnum=${rr.reviewnum}'">댓글달기</button>
	</tr>
</c:forEach>	
</table>

</body>
</html>