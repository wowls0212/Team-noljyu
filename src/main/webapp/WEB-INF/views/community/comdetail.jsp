<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("#comdelete").click(function() {
        var comnum = $("#comnum").val();
        var value = confirm("정말로 삭제하시겠습니까?");
        if (value == true) {
            $.ajax({
                type: "POST",
                url: "comdelete",
                data: { "comnum": comnum },
                async: true,
                success: function(bigo) {
                    if (bigo == "success") { 
                        alert("삭제가 완료되었습니다");
                        location.href="./";
                    } else {
                        alert("정상적으로 처리되지 않았습니다");
                        location.href="main";
                    }
                },
                error: function() {
                    alert("에러가 발생했습니다. 다시 시도해주세요");
                }
            });
        }
    });
});
</script>

<style type="text/css">

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="comnum" value="${dto.comnum}" id="comnum">
<table border="3" width="800px" align="center" style="margin-bottom: 50px;">
<tr>
	<th>${dto.id }</th>
</tr>
<tr>
	<th>${dto.comtitle }</th>
</tr>
<tr>
	<th><img src = "${dto.comimg }" width="600px" height="500px"></th>
</tr>
<tr>
	<th>${dto.comdetail }</th>
</tr>
<tr>
	<th><button type="button" value="${dto.comcnt }">♡</button></th>
</tr>
<tr>
	<td colspan="2" style="text-align: center;">
	<button onclick="location.href='comupdate?comnum=${dto.comnum}'">수정</button>
	<button id="comdelete">삭제</button>
</tr>
</table>

<form action="comreviewsave">
<input type="hidden" value="${dto.comnum }" name="comnum">
<input type="hidden" value="${dto.id }" name="id">
<table border="3" width="800px" align="center" style="margin-bottom: 50px;">
<tr>
	<th><textarea rows="10" cols="70" name="comreview"></textarea></th>
	<td><input type="submit" value="전송"></td>
</tr>
</table>
</form>

<table border="3" align="center" width="800px" style="margin-bottom: 150px;">
<c:forEach items="${list2 }" var="cr">
	<tr>
		<th>
		<c:forEach var="i" begin="0" end="${cr.comindent }">
			<c:choose>
				<c:when test="${i<cr.comindent}">
					&emsp;
				</c:when>
				<c:when test="${i==cr.comindent}">
					<img alt="" src="./image/reviewicon.png" height="30px">
				</c:when>
			</c:choose>
		</c:forEach>
		${cr.comreview }
		</th>
		<td>
		<button onclick="location.href='comrere?comreviewnum=${cr.comreviewnum}'">댓글달기</button>
	</tr>

</c:forEach>
</table>

</body>
</html>