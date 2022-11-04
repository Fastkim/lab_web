<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>

    <h1>연락처 등록 결과 페이지</h1>
    <div>
        <label>이름</label>
        <input type="text" value="${ contact.name }" readonly />
    </div>
    <div>
        <label>전화번호</label>
        <input type="tel" value="${ contact.phone }" readonly />
    </div>
    <div>
        <label>이메일</label>
        <input type="email" value="${ contact.email }" readonly />
    </div>

</body>
</html>