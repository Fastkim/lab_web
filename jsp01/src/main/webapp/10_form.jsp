<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL</title>
</head>
<body>
    <h1>Form 제출 페이지</h1>
    
    
    <%-- action="12_result.jsp" --%>
    <form action="12_result.jsp" method="get">
        <div>
            <input type="text" name="username" placeholder="사용자 이름" autofocus/>
        </div>
        <div>
            <select name="color">
                <option value="r">빨강</option>
                <option value="g">초록</option>
                <option value="b">파랑</option>
            </select>
        </div>
        <div>
            <input type="submit" value="전송" />
        </div>
    </form>
    
</body>
</html>