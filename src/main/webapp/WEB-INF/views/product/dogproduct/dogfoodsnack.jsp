<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="3" width="1000px" align="center">
<caption></caption>
	<tr>
		<th>상품이미지</th><th>비고</th>		
	</tr>
	<c:forEach items="${list}" var="pro">
	<tr>
		<td>
			<a href="productdetail?num=${pro.productnum}">	
			<img alt="" src="./image/${pro.productimg}" width="80px" height="100px"></a>			
		</td>
		<td>${pro.productnum} </td>
		<td>${pro.id} </td>
		<td>${pro.animal} </td>
		<td>${pro.productlist} </td>
		<td>
		<fmt:formatNumber value="${pro.price}" pattern="#,##0"/>
		</td>
		
		<td>${pro.productcnt} </td>	
		<td>${pro.productdate} </td>
		<td>
			<a href="pmodify1?num=${pro.productnum}">수정</a>
			<a href="pdelete1?num=${pro.productnum}">삭제</a>
		</td>	
	</tr>	
	</c:forEach>		
</table>
</body>
</html>