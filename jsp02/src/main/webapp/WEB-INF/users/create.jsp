<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP 2</title>
</head>
<body>
    <div>
        <h1>회원정보 작성 페이지</h1>
        
        <nav>
            <ul>
                <li>
                    <a href="/jsp02">메인 페이지</a>
                </li>
                <li>
                    <a href="/jsp02/users">회원목록 페이지</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <!-- form의 action 속성: 요청을 보내는 주소. 
            생략된 경우에는 현재 페이지로 요청을 보냄.
            
            폼안에 버튼은 이벤트 리스너가 등록되어있는것이다.
            -->
            <form method="post"> <!-- 전송방식 선택 post/get -->
                <div>
                    <input type="text" name="userName" placeholder="아이디" required autofocus />
                </div>
                <div>
                    <input type="text" name="passWord" placeholder="비밀번호" required />
                </div>
                <div>
                    <input type="email" name="email" placeholder="이메일" required />
                </div>
                <div>
                    <input type="submit" value="작성 완료" />
                </div>
            </form>
        </main>
    </div>
</body>
</html>