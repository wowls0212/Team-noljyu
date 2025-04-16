<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
>>>>>>> 8546762916583da98135734a1f7933dd5da22e86
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title><t:insertAttribute name="title"/></title>
<style type="text/css">

header
{
   text-align: center;
   width: 100%;
}
nav
{
      
}
#top
{
   
}
#body
{
   text-align: center;
   width: 100%;
}
#footer
{
   position: fixed;
   bottom: 0px;
   width: 100%;
   text-align: center;
   font-size: 15px;
   line-height: 30px;
   background-color: #000000;
   color: #ffffff; 
}
<<<<<<< HEAD
</style>
</head>
<body>
   <div id="container">
      <div id="top">
         <t:insertAttribute name="top"/>
      </div>
      <div id="body">
         <t:insertAttribute name="body"/>
      </div>
      <div id="footer">
         <t:insertAttribute name="footer"/>
      </div>
   </div>
=======

</style>
</head>
 <!-- 공통 알림 메시지 (회원가입/수정/삭제 등 완료 후 alert 창 띄움) -->
  <c:if test="${not empty sessionScope.msg}">
    <script>
      alert("${sessionScope.msg}");
    </script>
    <c:remove var="msg" scope="session" /> <!--  메시지 한 번 출력 후 제거 -->
  </c:if>


  <div id="top">
    <c:choose>
      <c:when test="${sessionScope.admin eq 'admin'}">

        <jsp:include page="/WEB-INF/views/top.jsp" />
      </c:when>
      <c:otherwise>

        <jsp:include page="/WEB-INF/views/top_user.jsp" />
      </c:otherwise>
    </c:choose>
  </div>

  <div id="body">
    <t:insertAttribute name="body"/>
  </div>

  <div id="footer">
    <t:insertAttribute name="footer"/>
  </div>
>>>>>>> 8546762916583da98135734a1f7933dd5da22e86
</body>
</html>