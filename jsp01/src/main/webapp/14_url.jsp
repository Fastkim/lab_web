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

    <h1>JSTL &lt;c:url&gt;</h1>

    <ul>
        <li>
            <a href="12_result.jsp?color=r&username=ad&min">클릭</a> <%-- 하드 코딩 이용 --%>
        <li>
            <c:url var="url1" value="12_result.jsp"> <%-- 요청 URL --%>
                <%-- 요청 파라미터 --%>
                <c:param name="color" value="r"></c:param>
                <c:param name="username" value="ad&min"></c:param>
            </c:url>
            <a href="${ url1 }">클릭 2</a>
        </li>
    </ul>

</body>
</html>