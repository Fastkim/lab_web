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
    
    <h1>Example 1</h1>
    
    
    <h2>GET : ex2</h2>
    <c:url var="ex2" value="/ex2"></c:url>
    <form action="${ ex2 }" method="get">
        <input type="text" name="username" placeholder="사용자 이름" />
        <input type="number" name="age" placeholder="나이" />
        <input type="submit" value="제출" />
        <!-- input은 인라인요소로 자동줄바꿈이 없다. -->
    </form>
    
    <h2>POST : ex3</h2>
    <c:url var="ex3" value="/ex3"></c:url>
    <form action="${ ex3 }" method="post">
        <input type="text" name="username" placeholder="사용자 이름" />
        <input type="number" name="age" placeholder="나이" />
        <input type="submit" value="제출" />
    </form>
    
    <h2>POST : ex4, DTO</h2>
    <c:url var="ex4" value="/ex4"></c:url>
    <form action="${ ex4 }" method="post">
        <input type="text" name="username" placeholder="사용자 이름" />
        <input type="number" name="age" placeholder="나이" />
        <input type="submit" value="제출" />
    </form>
    
    
    
    
</body>
</html>