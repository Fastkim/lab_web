<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP 2</title>
</head>
<body>
    <div>
        <h1>회원정보 상세 페이지</h1>
        
        <nav>
            <ul>
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${ mainPage }">메인 페이지</a>
                </li>
                <li>
                    <c:url var="usersListPage" value="/users"></c:url>
                    <a href="${ usersListPage }">회원정보 목록</a>
                </li>
                <li>
                    <c:url var="usersModifyPage" value="/users/modify">
                        <c:param name="id" value="${ users.id }"></c:param>
                    </c:url>
                    <a href="${ usersModifyPage }">회원정보 수정</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <form>
                <div>
                    <label for="id">번호</label>
                    <input id="id" type="text" value="${ users.id }" readonly />
                </div>
                <div>
                    <label for="userName">아이디</label>
                    <input id="userName" type="text" value="${ users.userName }" readonly />
                </div>
                <div>
                    <label for="passWord">비밀번호</label>
                    <input id="passWord" type="text" value="${ users.passWord }" readonly/>
                </div>
                <div>
                    <label for="email">이메일</label>
                    <input id="email" type="text" value="${ users.email }" readonly />
                </div>
            </form>
        </main>
    </div>
</body>
</html>