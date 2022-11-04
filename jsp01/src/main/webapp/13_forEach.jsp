<%@page import="edu.web.jsp01.domain.Contact"%>
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
    
    <%
    // 리스트 아이템으로 사용할 더미 데이터
    String[] sites = {"YouTube", "Instagram", "Facebook", "트위터"};
    
    // EL에서는 자바의 지역 변수를 직접 접근할 수 없기 때문에,
    // pageContext, request, session, application에 속성으로 추가.
    pageContext.setAttribute("sites", sites);
    %>
    
    <h2>scriptlet</h2>
    <ul>
        <% for (String s : sites) { %>
        <li><%= s %></li>
        <% } %>
    </ul>
    
    <h2>JSTL &amp; EL</h2>
    <ul>
        <c:forEach var="site" items="${ sites }">
            <li>${ site }</li>
        </c:forEach>
    </ul>
    
    <h2>JSP 테이블 작성</h2>
    
    <%
    // 테이블 행(row) 데이터로 사용할 더미 데이터
    ArrayList<Contact> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
        Contact c = new Contact("이름" + i, "전화번호" + i, "email" + i);
        list.add(c);
    }
    
    // EL에서 ${ contacts } 사용하기 위해서.
    pageContext.setAttribute("contacts", list);
    %>
    
    <table>
        <thead>
            <tr>
                <th>이름</th>
                <th>전화번호</th>
                <th>이메일</th>
            </tr>
        </thead>
        <tbody>
            <% for (Contact c : list) { %>
            <tr>
                <td><%= c.getName() %></td>
                <td><%= c.getPhone() %></td>
                <td<%= c.getEmail() %>></td>
            </tr>
            <% } %>
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