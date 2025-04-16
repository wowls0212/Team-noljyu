<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="800px" align="center">
	<tr>
		<th>댓글</th>
		<td>${dto.comreview}</td>
	</tr>
</table>

<form action="comreresave">
<input type="hidden" value="${dto.comnum}" name="comnum">
<input type="hidden" value="${dto.id}" name="id">
<input type="hidden" value="${dto.comgroups}" name="comgroups">
<input type="hidden" value="${dto.comstep}" name="comstep">
<input type="hidden" value="${dto.comindent}" name="comindent">
<table border="1" align="center" width="800px">
	<tr>
		<th><textarea rows="10" cols="70" name="comreview"></textarea></th>
		<td><input type="submit" value="전송"></td>
	</tr>
</table>
</form>

</body>
</html>