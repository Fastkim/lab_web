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
        <h1>회원정보 수정 페이지</h1>
        
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
                    <c:url var="usersModifyPage" value="/users/detail">
                        <c:param name="id" value="${ users.id }"></c:param>
                    </c:url>
                    <a href="${ usersModifyPage }">회원정보 상세</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <form id="usersForm"> 
            <!-- action: 제출(submit) 주소. 기본값은 현재 페이지 주소.
            method: 제출(submit) 방식. 기본값은 'get' -->
                <div>
                    <label for="id">번호</label>
                    <input id="id" type="text" name="id" value="${ users.id }" readonly />
                </div>
                <div>
                    <label for="userName">아이디</label>
                    <input id="userName" type="text" name="userName" value="${ users.userName }" required autofocus />
                </div>
                <div>
                    <label for="passWord">비밀번호</label>
                    <input id="passWord" type="text" name="passWord" value="${ users.passWord }" required/>
                </div>
                <div>
                    <label for="email">이메일</label>
                    <input id="email" type="text" name="email" value="${ users.email }" required />
                </div>
                <div>
                    <button id="btnDelete">삭제</button>
                    <button id="btnUpdate">수정완료</button>
                    <!-- form 안에서 작성된 버튼들은 form의 action 주소로 method 방식의 요청을 보냄. -->
                </div>
            </form>
        </main>
    </div>
    
    <c:url var="usersDeletePage" value="/users/delete"></c:url>
    <c:url var="usersUpdatePage" value="/users/modify"></c:url>
    
    <script>
    // id="postForm" 인 HTML 요소를 찾음.
    const form = document.querySelector('#usersForm');
    
    // id="btnDelete" 인 버튼을 찾음.
    const btnDelete = document.querySelector('#btnDelete');
    
    // 버튼 클릭 이벤트 리스너를 등록.
    btnDelete.addEventListener('click', function(event) {
    	event.preventDefault();
    	// 이벤트 기본 처리방식을 막음(실행되지 않도록 함).
    	//-> 폼 양식이 서버로 제출(submit)되지 않도록 함.
    	
    	// 사용자에게 삭제 확인
    	const check = confirm('정말 삭제?');
    	if (check) { // 사용자 "확인"을 선택했을 때
    		form.action = '${ usersDeletePage }'; // 제출 요청 주소
    		form.method = 'post'; // 제출 요청 방식
    		form.submit(); // 서버로 제출(데이터 전송)
    	}
    });
    
    // id="btnUpdate" 인 버튼을 찾음.
    const btnUpdate = document.querySelector('#btnUpdate'); // #은 ID를 의미, 클래스는 .
    // 버튼의 'click' 이벤트 리스너를 등록.
    btnUpdate.addEventListener('click', function(event) {
    	event.preventDefault();
    	// 이벤트 기본 처리방식을 막음(실행되지 않도록 함).
    	//-> 폼 양식이 서버로 제출(submit)되지 않도록 함.
    	
    	// <input> userName에 입력된 값
    	const userName = document.querySelector('#userName').value;
    	// <input> passWord에 입력된 값 
    	const passWord = document.querySelector('#passWord').value;
    	// <input> email에 입력된 값 
        const email = document.querySelector('#email').value;
    	if (userName == '' || passWord == '' || email == '' ) {
    		alert('아이디, 패스워드, 이메일은 반드시 입력해야 합니다.');
    		return; // 이벤트 리스너 종료
    	}
    	
    	// 사용자에게 수정 확인
    	const check = confirm('정말 변경하시겠습니까?');
    	if (check) { // 사용자 "확인"을 선택했을 때
    		   form.action = '${ usersUpdatePage }'; // 제출 요청 주소
    		   form.method = 'post'; // 제출 요청 방식
    		   form.submit(); // 서버로 제출(데이터 전송)
    	}
    });
    </script>
</body>
</html>
