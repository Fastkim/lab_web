<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
// request의 객체의 인코딩 설정 -> 한글 처리
request.setCharacterEncoding("UTF-8");

String username = request.getParameter("username");
String color = request.getParameter("color");
String colorValue = ""; // 실제 색깔 이름
if (color.equals("r")) {
    colorValue = "red";
} else if (color.equals("g")) {
    colorValue = "green";
} else if (color.equals("b")) {
    colorValue = "blue";
}

%>

<%-- JSTL <c:if>를 사용한 Java의 if 문 대체 --%>
<c:set var="colorValue2" value="black"></c:set>
<c:if test="${ param.color == 'r' }">
    <c:set var="colorValue2" value="indianred"></c:set>
</c:if>
<c:if test="${ param.color == 'g' }">
    <c:set var="colorValue2" value="mediumgreen"></c:set>
</c:if>
<c:if test="${ param.color == 'b' }">
    <c:set var="colorValue2" value="dodgerblue"></c:set>
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL</title>
    
    <style>
        span {
            color: ${ colorValue2 };    /* <%= colorValue %>; */
            font-weight: bold;
        }
    </style>
</head>
<body>
  
    <h1>Form 제출 결과 페이지</h1>
    <h2>JSP Expression: <span><%= username %></span></h2>
    <h2>EL: <span>${ param.username }</span></h2>

</body>
</html>