<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>

    <h1>연락처 등록 페이지</h1>
    
    <form  method="post">
        <input type="text" name="name" placeholder="이름" />
        <br/>
        <input type="tel" name="phone" placeholder="전화번호" />
        <br/>
        <input type="email" name="email" placeholder="이메일" />
        <br/>
        <input type="submit" value="등록" />
    </form>

</body>
</html>