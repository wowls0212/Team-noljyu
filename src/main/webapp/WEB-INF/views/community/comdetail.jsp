<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
//게시글 삭제
$(document).ready(function() {
    $("#compostdelete").click(function() {
        var postnum = $("#postnum").val();
        var value = confirm("정말로 삭제하시겠습니까?");
        if (value == true) {
            $.ajax({
                type: "POST",
                url: "compostdelete",
                data: { "postnum": postnum },
                async: true,
                success: function(bigo) {
                    if (bigo == "success") { 
                        alert("삭제가 완료되었습니다");
                        let url = 'comdetail?postnum=${dto.postnum}';
                        location.replace(url);
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

// 댓글 수정(DB 저장)
function comreviewRealUpdate(sindex){
    var reviewnum = $('#reviewnum'+sindex).val();
    var review = $("#comreveiwUpdate-content"+sindex).val();

    $.ajax({
        url : "comreviewupdate",
        data : {'reviewnum' : reviewnum, 'review' : review},
        dataType :'text', 
        success : function(data){
            if(data == "1") {
                alert("댓글이 수정되었습니다");
                let url = 'comdetail?postnum=${dto.postnum}';
                location.replace(url);
            }
        }
    });
}

// 댓글 수정(댓글 입력 창으로 화면 바뀌기)
function comreupdate(sindex){
    $('#comreview2'+sindex).hide();
    $('#comreview3'+sindex).show();
    $('#comreupdate-btn'+sindex).hide();
}

//댓글 삭제
function comreviewdelete(sindex) {
    var reviewnum = $('#reviewnum'+sindex).val();
    var value = confirm("정말로 삭제하시겠습니까?");
    if (value == true) {
	    $.ajax({
	        type: "POST",
	        url: "comreviewdelete",
	        data: { "reviewnum": reviewnum },
	        async: true,
	        success: function(bigo) {
	            if (bigo == "success") { 
	                alert("삭제가 완료되었습니다");
	                let url = 'comdetail?postnum=${dto.postnum}';
	                location.replace(url);
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
}

//대댓글 입력(대댓글 입력창 생성)
function comrere(sindex){
    $('#comrere2'+sindex).show();
    $('#comrere-btn'+sindex).hide();
}

//대댓글 저장(DB)
function comrereRealUpdate(sindex){
    var reviewnum = $('#reviewnum'+sindex).val();
    var review = $("#comrere-content"+sindex).val();
    $.ajax({
        url : "comreresave",
        data : {'reviewnum' : reviewnum, 'review' : review},
        dataType :'text', 
        success : function(data){
            if(data == "1") {
                alert("댓글이 입력되었습니다");
                let url = 'comdetail?postnum=${dto.postnum}';
                location.replace(url);
            }
        }
    });
}

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 게시글 상세페이지 출력 -->
<input type="hidden" name="postnum" value="${dto.postnum}" id="postnum">
<table border="1" width="800px" align="center">
	<tr>
		<th>아이디</th>
		<td>${dto.id}</td>
	</tr>
	
	<tr>
		<th>제목</th>
		<td>${dto.posttitle}</td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td>${dto.postdetail}</td>
	</tr>
	
	<tr>
		<th>이미지</th>
		<td><img alt="" src="./image/${dto.postimg}"></td>
	</tr>
	
	<tr>
		<td colspan="2" style="text-align: center;">
		<button onclick="location.href='comupdate?comnum=${dto.postnum}'">수정</button>
		<button id="howdelete">삭제</button>
		<button onclick="window.open('postreport1?postnum=${dto.postnum}&id=${dto.id }','_blank','width=600px height=500px resizable=no scrollbar=no location=no toolbars=no')">신고</button>
	</tr>
</table>

<!-- 댓글 입력창 -->
<form action="comreviewsave">
<input type="hidden" value="${dto.postnum}" name="comnum">
<c:choose>
	<c:when test="${loginstate==true }">
		<input type="hidden" value="${id }" name="id">
	</c:when>
</c:choose>
<input type="hidden" value="${dto.posttype }" name="posttype">
<table border="1" align="center" width="800px">
	<tr>
		<th><textarea rows="10" cols="70" name="review"></textarea></th>
		<td><input type="submit" value="전송"></td>
	</tr>
</table>
</form>

<!-- 댓글 출력 -->
<table border="1" align="center" width="800px" style="margin-bottom: 100px">
<c:forEach items="${list}" var="rr" varStatus="status">

	<!-- 작성자, 수정/삭제/댓글 표시 -->
	<tr style="border-bottom: none;">
		<th style="border-right: none;">
		<c:forEach var="i" begin="0" end="${rr.postindent}">
			<c:choose>
				<c:when test="${i<rr.postindent}">
					&emsp;
				</c:when>
				<c:when test="${i==rr.postindent}">
					<img alt="" src="./image/reviewicon.png" height="30px">
				</c:when>
			</c:choose>
		</c:forEach>${rr.id} 
		<input type="hidden" value="${rr.postreviewnum}" id="reviewnum${status.index}"></th>
		<td style="border-left: none; text-align: right;">
		<a href="#" id="comreupdate-btn${status.index}" onclick="comreupdate(${status.index}); return false;">수정</a>
		<a href="#" id="comreviewdelete${status.index}" onclick="comreviewdelete(${status.index})">삭제</a>
		<a href="#" id="comrere-btn${status.index}" onclick="comrere(${status.index}); return false;">댓글</a>
		<a href="#" onclick = "window.open('reviewreport?reviewnum=${rr.postreviewnum}&postnum=${rr.postnum }','_blank','width=600px height=500px resizable=no scrollbar=no location=no toolbars=no')">신고</a>
		<!-- <a href="howrere?reviewnum=${rr.postreviewnum}">댓글</a> -->
		</td>
	</tr>
	
	<!-- 댓글 보기창 -->
	<tr id="comreview2${status.index}">
		<td colspan="2" style="text-align: left;">
		<c:forEach var="i" begin="0" end="${rr.postindent}">
			<c:choose>
				<c:when test="${i<rr.postindent}">
					&emsp;
				</c:when>
				<c:when test="${i==rr.postindent}">
					<img alt="" src="./image/reviewicon.png" height="30px">
				</c:when>
			</c:choose>
		</c:forEach>
		${rr.postreview}
		</td>
	</tr>
	
	<!-- 댓글 수정창 -->
	<tr id="comreview3${status.index}" style="display: none;">		
    	<td colspan="2" style="text-align: left;">
    	<c:forEach var="i" begin="0" end="${rr.postindent}">
			<c:choose>
				<c:when test="${i<rr.postindent}">
					&emsp;
				</c:when>
				<c:when test="${i==rr.postindent}">
					<img alt="" src="./image/reviewicon.png" height="30px">
				</c:when>
			</c:choose>
		</c:forEach>
    	<textarea mexlength="300" id="comreveiwUpdate-content${status.index}" class="form-control" rows="2" cols="100" placeholder="댓글을 입력해 주세요">${rr.postreview}</textarea>
        <a href="" onclick="comreviewRealUpdate(${status.index}); return false;" >등록</a>
   		</td>
	</tr>
	
	<!-- 대댓글 입력 -->
	<tr id="comrere2${status.index}" style="display: none;">		
    	<td style="text-align: left;">
    	<c:forEach var="i" begin="0" end="${rr.postindent}">
			<c:choose>
				<c:when test="${i<rr.postindent}">
					&emsp;
				</c:when>
				<c:when test="${i==rr.postindent}">
					<img alt="" src="./image/reviewicon.png" height="30px">
				</c:when>
			</c:choose>
		</c:forEach>
    	<textarea mexlength="300" id="comrere-content${status.index}" class="form-control" rows="2" cols="100" placeholder="댓글을 입력해 주세요"></textarea>
        </td>
        <td>
        	<a href="" onclick="comrereRealUpdate(${status.index}); return false;">등록</a>
   		</td>
	</tr>
	
</c:forEach>

	<!-- 댓글 페이징 처리 -->
	<tr style="border-left: none;border-right: none;border-bottom: none">
		<td colspan="8" style="text-align: center;">
		<c:if test="${paging.startPage!=1 }">
		   <a href="comdetail?postnum=${dto.postnum}&nowPage=${paging.startPage-1}&cntPerPage=${paging.cntPerPage}"></a>
		</c:if>   
		
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p"> 
		   <c:choose>
		      <c:when test="${p == paging.nowPage }">
		         <b><span style="color: red;">${p}</span></b>
		      </c:when>   
		      <c:when test="${p != paging.nowPage}">
		         <a href="comdetail?postnum=${dto.postnum}&nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a>
		      </c:when>   
		   </c:choose>
		</c:forEach>      
		
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="cometail?postnum=${dto.postnum}&nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage }">  </a>
		</c:if>   
	   </td>
	</tr>
</table>
</body>
</html>