<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
</head>
<body>
	<c:if test="${not empty msg}">
		<div style="color: red; text-align: center;">${msg}</div>
	</c:if>
	<form action="pwcheckdo" method="post">
		<input type="hidden" name="type" value="${param.type}">
		<table border="1" align="center">
			<caption>비밀번호 확인</caption>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick="location.href='main'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
