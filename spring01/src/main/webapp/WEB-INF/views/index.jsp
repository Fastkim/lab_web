<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring 1</title>
</head>
<body>

    <h1>메인 페이지</h1>
    
    <ul>
        <li>
            <c:url var="ex1" value="/ex1"></c:url>
            <a href="${ ex1 }">example 1</a>
        </li>
        <li>
            <c:url var="exForward" value="/ex-forward"></c:url>
            <a href="${ exForward }">포워드 테스트</a>
        </li>
        <li>
            <c:url var="exRedirect" value="/ex-redirect"></c:url>
            <a href="${ exRedirect }">리다이렉트 테스트</a>
        </li>
    </ul>
    
</body>
</html>
