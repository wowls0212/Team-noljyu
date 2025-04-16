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
<form action="fleasave" method="post" enctype="multipart/form-data">
<input type="hidden" name="flea" value="flea">
<table border="1" width="400px" align="center">
	<caption>플리마켓 글 등록</caption>
	
	<tr>
	<c:choose>
		<c:when test="${loginstate==true }">
		<th>아이디</th>
		<td><input type="hidden" name="id" value="${id }"><font>${id}</font></td>
	</c:when>
	</c:choose>
	</tr>
	
	<tr>
		<th>제목</th>
		<td><input type="text" name="fleatitle"></td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="70" name="fleadetail"></textarea> </td>
	</tr>
	
	<tr>
		<th>이미지</th>
		<td><input type="file" name="fleaimg"></td>
	</tr>
	
	<tr>
		<td colspan="2" style="text-align: center;">
		<input type="submit" value="전송">
		<input type="reset" value="취소">
	</tr>
</table>
</form>
</body>
</html>