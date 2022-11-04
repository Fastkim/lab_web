<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>
    
    <h1>JSP 내장 객체 vs EL 내장 객체</h1>
    <%-- 
    상태 정보 유지: 속성 (값) 추가, 저장된 속성 값 읽음.
    JSP에서 상태 정보들을 유지하기 위해서 사용하는 객체들:
      * pageContext: JSP 페이지가 유지되는 동안 사용.
      * request: 요청 객체가 유지되는 동안 사용.
      * session: 세션이 유지되는 동안 사용.
      * application: 웹 애플리케이션이 동작 중에 사용.
      pageContext < request < session < application
    EL에서 상태 정보들을 유지하기 위해서 사용하는 객체들:
      * pageScope
      * requestScope
      * sessionScope
      * applicationScope
      
    EL ${ 속성이름 }의 동작 원리:
      ${ pageScope.attr } => ${ requestScope.attr } => ${ sessionScope.attr } => ${ applicationScope.attr }
    --%>
    
    <h2>JSP</h2>
    <%
    pageContext.setAttribute("number1", 1);
    request.setAttribute("number2", 2);
    session.setAttribute("number3", 3);
    application.setAttribute("number4", 4);
    %>
    
    pageContext 속성: <%= pageContext.getAttribute("number1") %>
    <br/>
    request 속성: <%= request.getAttribute("number2") %>
    <br/>
    session 속성: <%= session.getAttribute("number3") %>
    <br/>
    application 속성: <%= application.getAttribute("number4") %>
    <br/>

    <h2>EL</h2>
    pageScope 속성: ${ number1 } <br/> 
    <%-- ${ pageScope.number1 } --%>
    requestScope 속성: ${ number2 } <br/>
    <%-- ${ pageScope.number2 } 속성 값을 찾을 수 없음 => ${ requestScope.number2 } --%>
    sessionScope 속성: ${ number3 } <br/>
    applicationScope 속성: ${ number4 } <br/>

</body>
</html>
