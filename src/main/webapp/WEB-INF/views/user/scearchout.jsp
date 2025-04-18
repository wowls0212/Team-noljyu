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
<table border="3" width="1000px" align="center">
<caption>회원검색자료출력</caption>
<tr>
  <th>이미지</th><th>아이디</th><th>이름</th><th>주소</th><th>연락처</th><th>닉네임</th><th>반려동물</th><th>반려동물 이름</th><th>회원등급</th>
</tr>
<c:forEach items="${list}" var="my">
<tr>
    <td>
      <c:choose>
        <c:when test="${not empty my.photo}">
          <img src="./image/${my.photo}" width="100px" height="100px" />
        </c:when>
        <c:otherwise>
          <img src="./image/defalut.jpg" width="100px" height="100px" />
        </c:otherwise>
      </c:choose>
    </td>
    <td>${my.id}</td>
    <td>${my.name}</td>
    <td>${my.address}</td>
    <td>${my.phone}</td>
    <td>${my.nickname}</td>
    <td>${my.myanimal}</td>
    <td>${my.petName}</td>
    <td>${my.admin}</td>
</tr>
</c:forEach>

</table>
</body>
</html>