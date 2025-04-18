<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>비밀번호 찾기</title>
  <style> td, th { text-align: center; } </style>
</head>
<body>
  <c:if test="${not empty msg}">
    <div style="color:red; text-align:center;">${msg}</div>
  </c:if>

  <form action="passwordfindProcess" method="post">
    <table border="3" width="400px" align="center">
      <caption>ID / 반려동물 이름 확인</caption>
      <tr>
        <th>ID</th>
        <td><input type="text"   name="id"      required></td>
      </tr>
      <tr>
        <th>반려동물 이름</th>
        <td><input type="text"   name="petName" required></td>
      </tr>
      <tr style="text-align:center;">
        <td colspan="2">
          <input type="submit" value="확인">
          <input type="button" value="취소" onclick="location.href='main'">
        </td>
      </tr>
    </table>
  </form>
</body>
</html>
