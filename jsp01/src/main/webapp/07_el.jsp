<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>

    <h1>EL(Expression Language)</h1>
    <%-- ${ 표현식(expression) } --%>
    
    <% out.println(1 + 2); %> <%-- JSP scriptlet --%>
    <br/>
    
    <%= 1 + 2 %> <%-- JSP expression --%>
    <br/>
    
    ${ 1 + 2 } <%-- EL --%>
    <br/>
    
    <%-- 
    JSP 안에서 EL은
      (1) 지시문(directive, <%@ ... %>) 에서 사용할 수 없음.
      (2) 선언문(declaration, <%! ... %>) 에서 사용할 수 없음.
      (3) 스크립트릿(scriptlet, <% ... %>) 에서 사용할 수 없음.
      (4) 식(expression, <%= ... %>) 에서 사용할 수 없음.
    그 이외의 모든 곳에서 사용 가능.
      (1) HTML element의 컨텐트로 사용 가능: <h1>${ }</h1>, <a>${ }</a>, <td>${ }</td>, ...
      (2) HTML 태그의 속성(attribute) 값으로 사용 가능: <img src="${ }" />, ...
      (3) CSS 스타일 프로퍼티 값을 설정할 때 사용 가능:
      (4) JavaScript 코드와 함께 사용 가능:
    --%>

</body>
</html>
