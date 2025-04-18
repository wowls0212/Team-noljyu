<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원정보 수정</title>
    <style>
  td, th {
    text-align: center;
}
    </style>
</head>
<body>
    <form action="modifysave" method="post" enctype="multipart/form-data">
        <table border="1">
            <caption><h2>회원정보 수정</h2></caption>
            <tr>
                <th>아이디</th>
                <td><input type="text" name="id" value="${dto.id}" readonly /></td>
            </tr>
            <tr>
                <th>새 비밀번호</th>
                <td><input type="password" name="pw" placeholder="변경 시 입력, 미입력 시 유지"></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="name" value="${dto.name}" required></td>
            </tr>
            <tr>
                <th>주소</th>
                <td><input type="text" name="address" value="${dto.address}" required></td>
            </tr>
            <tr>
                <th>연락처</th>
                <td><input type="text" name="phone" value="${dto.phone}" required></td>
            </tr>
            <tr>
                <th>닉네임</th>
                <td><input type="text" name="nickname" value="${dto.nickname}" required></td>
            </tr>
            <tr>
                <th>반려동물 종류</th>
                <td><input type="text" name="myanimal" value="${dto.myanimal}" required></td>
            </tr>
            <tr>
                <th>반려동물 이름</th>
                <td><input type="text" name="petName" value="${dto.petName}" required></td>
            </tr>
            <tr>
                <th>현재 프로필 사진</th>
                <td>
                  <img src="${pageContext.request.contextPath}/image/${dto.photo}" 
                                 alt="프로필 사진" width="100" height="100">
                </td>
            </tr>
            <tr>
                <th>프로필 사진 변경</th>
                <td><input type="file" name="uploadfile"></td>
            </tr>
			<tr style="text-align: center;">
				<td colspan="2">
				<input type="submit" value="수정">&emsp;
				<input type="button" value="취소" onclick="location.href='main'">
			</tr>
    </form>
</body>
</html>
