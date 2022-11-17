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
        
            <h1>유저 목록 페이지</h1>

        <nav> <!-- 웹 서버 내에서 이동 메뉴 -->
            <ul>
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${ mainPage }">메인 페이지</a>
                </li>
                <li>
                    <c:url var="usersCreatePage" value="/users/create"></c:url>
                    <a href="${ usersCreatePage }">회원 가입</a>
                </li>
                
                
            </ul>
        </nav>
        
        <main>
            <table>
                <thead>
                    <tr>
                        <th>등록번호</th>
                        <th>아이디</th>
                        <th>비밀번호</th>
                        <th>이메일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="u" items="${ users }">
                    <tr>
                        <td>${ u.id }</td>
                        <td>
                            <c:url var="usersDetailPage" value="/users/detail">
                                <c:param name="id" value="${ u.id }"></c:param>
                            </c:url>
                            <a href="${ usersDetailPage }">${ u.userName }</a>
                        </td>
                        <td>${ u.passWord }</td>
                        <td>${ u.email }</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>
        
    </div>
</body>
</html>