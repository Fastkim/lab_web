<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

    <h1>포스트 등록 페이지</h1>

    <form method="post">
        <div>
            <input type="number" name="id" placeholder="번호" required autofocus />
        </div>
        <div>
            <input type="text" name="title" placeholder="제목" required />
        </div>
        <div>
            <textarea row="5" cols="80" name="content" placeholder="내용" required ></textarea>
        </div>
        <div>
            <input type= "datetime-local" name="createdTime" required >
        </div>
        <div>
            <input type="submit" value="작성 완료" />
        </div>
        
    </form>
</body>
</html>