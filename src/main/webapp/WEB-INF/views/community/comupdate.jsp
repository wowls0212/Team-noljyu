<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="comupdatesave" method="post" enctype="multipart/form-data">
<input type="hidden" name="comnum" value="${dto.postnum}">
<input type="hidden" name="comoldimg" value="${dto.postimg}">
<table border="1" width="400px" align="center" style="margin-bottom: 400px;">
	
	<tr>
		<th>제목</th>
		<td><input type="text" name="comtitle" value="${dto.posttitle}"></td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="70" name="comdetail">${dto.postdetail}</textarea> </td>
	</tr>
	
	<tr>
		<th>이미지</th>
		<td><img alt="" src="./image/${dto.postimg}" ><input type="file" name="comimg"></td>
	</tr>
	
	<tr>
		<td colspan="2" style="text-align: center;">
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</tr>
</table>
</form>
</body>
</html>