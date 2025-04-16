<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
td,th{
text-align: center; 
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty sessionScope.msg}">
    <script>
        alert("${sessionScope.msg}");
    </script>
    <c:remove var="msg" scope="session" />
</c:if>

<table border="3" width="1300px" align="center">
<caption>회원정보출력</caption>
<tr>
<th>아이디</th><th>비밀번호</th><th>이름</th><th>주소</th><th>연락처</th><th>닉네임</th><th>나의 반려동물</th><th>회원등급</th><th>비고</th>
</tr>
<c:forEach items="${list}" var="my">
<tr>
    <td>${my.id}</td>
    <td>******</td>
    <td>${my.name}</td>
    <td>${my.address}</td>
    <td>${my.phone}</td>
    <td>${my.nickname}</td>
    <td>${my.myanimal}</td>
    <td>${my.admin}</td>
    <td>
        <form action="admindelete" method="post" onsubmit="return confirm('정말 삭제하시겠습니까?');">
            <input type="hidden" name="id" value="${my.id}" />
            <input type="submit" value="회원삭제">
        </form>
    </td>
</tr>
</c:forEach>
</table>
</body>
