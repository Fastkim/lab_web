<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
    <h1>JSTL</h1>
    <h2>JSP(Java Server Page) Standard Tag Library</h2>
    <%--
    JSTL 사용하기:
        1. POM.xml에 의존성 추가(jstl:jstl:1.2)
        2. JSP에 사용할 태그 라이브러 종류를 taglib 지시문(directive)으로 설정.
     --%>
    
    <c:set var="username" value="admin" ></c:set>
    <%-- pageContext.setAttribute("username", "admin") --%>
    
    <h3><%= pageContext.getAttribute("username") %></h3>
    <h3><c:out value="${ username }"></c:out></h3>
    <h3>${ username }</h3> <%-- %{ pageScope.username } --%>
    
</body>
</html>