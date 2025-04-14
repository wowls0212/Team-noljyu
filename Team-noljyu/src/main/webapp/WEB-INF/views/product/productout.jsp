<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
<head>
<style>
table
{
	margin-top: 50px;
	margin-bottom: 350px;
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
<a href="dogproduct"><img alt="" src="./image/2-modified.png" width="200px" height="160px"></a>
<a href="catproduct"><img alt="" src="./image/cat-modified.png" width="200px" height="160px"></a>
<a href="birdproduct"><img alt="" src="./image/bird2-modified.png" width="200px" height="160px"></a>
<a href="fishproduct"><img alt="" src="./image/goldfish-modified.png" width="200px" height="160px"></a>
<a href="creepingproduct"><img alt="" src="./image/reptile2-modified.png" width="200px" height="160px"></a>



<table border="3" width="1000px" align="center">
<caption></caption>
	<tr>
		<th>상품번호</th><th>아이디</th><th>동물구분</th>
		<th>상품목록</th><th>상품명</th><th>가격</th><th>상품이미지</th>
		<th>조회수</th><th>구입날짜</th><th>비고</th>		
	</tr>
	<c:forEach items="${list}" var="pro">
	<tr>
		<td>${pro.productnum} </td>
		<td>${pro.id} </td>
		<td>${pro.animal} </td>
		<td>${pro.productlist} </td>
		<td>${pro.productname} </td>
		<td>
		<fmt:formatNumber value="${pro.price}" pattern="#,##0"/>
		</td>
		<td>
			<a href="productdetail?num=${pro.productnum}">	
			<img alt="" src="./image/${pro.productimg}" width="80px" height="100px"></a>			
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