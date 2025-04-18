<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>비밀번호 재설정</title>
  <style> td, th { text-align: center; } </style>
</head>
<body>
  <c:if test="${not empty msg}">
    <div style="color:red; text-align:center;">${msg}</div>
  </c:if>

  <form action="passwordresetProcess" method="post">
    <input type="hidden" name="id" value="${id}">
    <table border="3" width="400px" align="center">
      <caption>새 비밀번호 입력</caption>
      <tr>
        <th>새 비밀번호</th>
        <td><input type="password" name="newPassword" required></td>
      </tr>
      <tr style="text-align:center;">
        <td colspan="2">
          <input type="submit" value="변경">
          <input type="button" value="취소" onclick="location.href='main'">
        </td>
      </tr>
    </table>
  </form>
</body>
</html>
