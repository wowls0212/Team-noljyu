<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="reviewreportdel">
<table border = "3" width="800px" align="center">
<tr>
	<th>신고번호</th><th>게시글번호</th><th>댓글번호</th><th>작성자</th><th>신고유형</th><th>신고자</th><th>신고사유</th>
</tr>
<c:forEach items="${list }" var="re">
<tr>
	<td>${re.reviewreportnum }</td>
	<td>${re.postnum }</td>
	<td>${re.reviewnum }</td>
	<td>${re.reviewid }</td>
	<td>${re.reportreason }</td>
	<td>${re.reportid}</td>
	<td>${re.reportdetail}</td>
	<td colspan="2">
	<button type="button" onclick="location.href='reviewreportdel?reportreviewnum=${re.reviewreportnum}&postnum=${re.postnum}&reviewnum=${re.reviewnum}'">접수</button>
	<button type="button" onclick="location.href='main'">철회</button>
	
	<!-- 
	클릭하면 신고접수내용이 사라지는 기능 추가
	한 링크에 두개는 불가능... 
	-->
	
	
	</td>
</tr>
</c:forEach>
</table>
</form>	

</body>
</html>