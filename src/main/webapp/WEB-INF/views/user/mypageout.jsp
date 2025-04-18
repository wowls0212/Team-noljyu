<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td, th {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="3" width="1300px" align="center">
		<caption>마이페이지</caption>
		<tr>
			<th>이미지</th>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
			<th>연락처</th>
			<th>닉네임</th>
			<th>반려동물</th>
			<th>반려동물 이름</th>
			<th>회원등급</th>
			<th>비고</th>
		</tr>
		<tr>
			<td>
				<c:choose>
					<c:when test="${not empty myinfo.photo}">
					<img src="./image/${myinfo.photo}" width="180px" height="150px">
					</c:when>
					<c:otherwise>
						<img src="./image/defalut.jpg" width="180px" height="150px">
					</c:otherwise>
				</c:choose>
			</td>
			<td>${myinfo.id}</td>
			<td>${myinfo.name}</td>
			<td>${myinfo.address}</td>
			<td>${myinfo.phone}</td>
			<td>${myinfo.nickname}</td>
			<td>${myinfo.myanimal}</td>
			<td>${myinfo.petName}</td>
			<td>${myinfo.admin}</td>
			<td>
			<a href="pwcheck?type=modify">회원정보 수정</a> &emsp; 
			<a href="pwcheck?type=delete">회원탈퇴</a>
			</td>
		</tr>
	</table>
</body>
</html>