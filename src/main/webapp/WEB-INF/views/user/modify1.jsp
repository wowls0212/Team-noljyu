<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td,th{
text-align: center; 

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modifysave" method="post">
		<table border="3" width="400px" align="center">
			<caption>회원정보 수정</caption>
			
			<tr>
			<th>아이디</th>
			<td><input type="text" name="id" value="${dto.id}" readonly style="background-color: #f0f0f0;">
            </td>
            </tr>

			<tr>
				<th>새 비밀번호</th>
				<td><input type="password" name="pw" placeholder="변경 시에만 입력"></td>
			</tr>

			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${dto.name}" required="required"></td>
			</tr>

			<tr>
				<th>주소</th>
				<td><input type="text" name="address" value="${dto.address}" required="required"></td>
			</tr>

			<tr>
				<th>연락처</th>
				<td><input type="text" name="phone" value="${dto.phone}" required="required"></td>
			</tr>

			<tr>
				<th>닉네임</th>
				<td><input type="text" name="nickname" value="${dto.nickname}" required="required"></td>
			</tr>

			<tr>
				<th>나의 반려동물</th>
				<td><input type="text" name="myanimal" value="${dto.myanimal}" required="required"></td>
			</tr>
			

			<tr style="text-align: center;">
				<td colspan="2">
				<input type="submit" value="수정"> 
				<input type="button" value="취소" onclick="location.href='main'"></td>
			</tr>


		</table>
	</form>
</body>
</html>