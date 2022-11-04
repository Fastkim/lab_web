<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>
    <h1>사용자 이름 전송</h1>
    <form action="03_result.jsp" method="post">
        <input type="text" name="username" placeholder="username" required />
        <input type="submit" value="전송" />
    </form>
</body>
</html>
