<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

</style>
</head>
<body>
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
</body>
</html>