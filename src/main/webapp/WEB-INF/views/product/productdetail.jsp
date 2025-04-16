<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
caption
{
	text-align:center;
}
th,td
{
	text-align:center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<table border="3" width="500px" align="center">
<caption>상품상세설명</caption>
	<tr>		
		<th>상품목록</th>
		<td>${dto.productlist} </td>	
	</tr>
	<tr>		
		<th>가격</th>
		<td>${dto.price} </td>	
	</tr>
	<tr>		
		<th>상품이미지</th>
		<td>
			<img alt="" src="./image/${dto.productimg}" width="300px" height="200px"> 
		</td>
	</tr>
	<tr>		
		<th>조회수</th>
		<td>${dto.productcnt} </td>
	</tr>		
</table>
<div id="aa">
<a href="productout">뒤로가기</a>
</div>
</body>
</html>