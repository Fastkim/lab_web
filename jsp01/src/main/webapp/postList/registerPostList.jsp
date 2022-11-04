<%@page import="java.time.LocalDateTime"%>
<%@page import="edu.web.jsp01.domain.Post"%>
<%@page import="java.util.ArrayList"%>
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

        <h1>JSTL &lt;c:forEach&gt;</h1>
        <h2>JSTL &amp; EL</h2>
        <h2>JSP 테이블 작성</h2>
        
        <%
        // 테이블 행(row) 데이터로 사용할 더미 데이터
        ArrayList<Post> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //list.add(e) = new Post(i, "", "", LocalDateTime.now());
        }
        
        // EL에서 ${ contacts } 사용하기 위해서.
        //pageContext.setAttribute("posts", postList);
        %>
        
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성시간</th>
                </tr>
            </thead>
            <tbody>
                <%-- for (Post p : postList) { --%>
                <tr>
                    <td><%--= p.getId() --%></td>
                    <td><%--= p.getTitle() --%></td>
                    <td><%--= p.getContent() --%></td>
                    <td><%--= p.getCreateTime() --%></td>
                </tr>
                <%-- } --%>
            </tbody>
        </table>
        
        <br>
        
        <table>
            <thead>
                <tr>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${ contacts }">
                    <tr>
                        <td>${ c.name }</td>
                        <td>${ c.phone }</td>
                        <td>${ c.email }</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>