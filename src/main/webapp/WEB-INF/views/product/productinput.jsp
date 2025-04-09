<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="productsave" method="post" enctype="multipart/form-data">
<Table border="3" width="600px" align="center">
<caption>상품자료 입력</caption>
	<tr>
		<th>아이디</th>
		<td><input type="text" name="id"> </td>		
	</tr>
	<tr>
		<th>종류</th>
		<td><input type="text" name="animal"> </td>	
		</td>		
	</tr>
	<tr>
		<th>상품목록</th>
		<td><input type="text" name="productlist"> </td>		
	</tr>
	<tr>	
		<th>가격</th>
		<td><input type="number" name="price"> </td>
	</tr>
	<tr>
		<th>상품이미지</th>
		<td><input type="file" name="productimg"> </td>
	</tr>
	<tr>
		<th>구입날짜</th>
		<td><input type="date" name="productdate"> </td>		
	</tr>
	<tr>		
		<td colspan="2">					
				<input style="background-color: lightgray" type="submit" value="구매내역 전송"> &emsp;		
				<input style="background-color: lightgray" type="reset" value="취소" onclick="location.href='./'">				
		</td>	
	</tr>
</Table>
</form>
</body>
</html>