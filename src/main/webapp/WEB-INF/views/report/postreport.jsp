<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑 같이 놀쥬 :: 게시물신고창</title>
</head>
<body>
	
	<form action="postreportsave">
	<input type="hidden" name="postnum" value="${dto.postnum }">
		<table border="3" width="400px" align="center">
			<tr>
				<th>신고대상</th>
				<td><input type="text" value="${dto.id }" name="postid" readonly="readonly"></td>
			</tr>
			<tr>
				<th>신고사유</th>
				<td>
				<select name="reportreason" id="category" required="required">
					<option value="정보통신망법에 의거한 청소년 유해 컨텐츠">정보통신망법에 의거한 청소년 유해 컨텐츠</option>
					<option value="정보통신망법에 의거한 명예훼손, 모욕, 비방">정보통신망법에 의거한 명예훼손, 모욕, 비방</option>
					<option value="정보통신망법에 의거한 불법촬영물">정보통신망법에 의거한 불법촬영물</option>
					<option value="정보통신망법에 의거한 광고성 게시글(스팸, 바이럴)">정보통신망법에 의거한 광고성 게시글(스팸, 바이럴)</option>
					<option value="개인정보보호법에 의거한 개인정보 노출게시물">개인정보보호법에 의거한 개인정보 노출게시물</option>
					<option value="불법행위,불법링크 등 불법정보 포함게시글">불법행위,불법링크 등 불법정보 포함게시글</option>
					<option value="그 외(아래 '문의 내용'에 게재)">그 외(아래 '문의 내용'에 게재)</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>신고내용</th>
				<td><textarea rows="10" cols="20" name="reportdetail"></textarea>
			</tr>
			<tr>
			<c:choose>
				<c:when test="${loginstate==true }">
				<th>신고자</th>
				<td><input type="text" name="reportid" value="${id }"></td>
				</c:when>
			</c:choose>
			</tr>
			<tr>
			<td colspan="2">
			<button type="submit">신고하기</button>
			<button type="button" onclick="window.close();">취소하기</button>
			</td>
			</tr>
		</table>
	</form> 
</body>
</html>