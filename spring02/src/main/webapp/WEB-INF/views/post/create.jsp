<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Spring 2</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" 
        rel="stylesheet" 
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" 
        crossorigin="anonymous" />
</head>
<body>

<div class="container-fluid">
    
    <header class="my-2 p-4 text-center text-bg-secondary">
        <h1>Spring MVC &amp; MyBatis</h1>
        <h2>포스트 작성 페이지</h2>
    </header>
    
    <nav>
        <ul class="nav bg-light">
            <li class="nav-item">
                <c:url var="mainPage" value="/"></c:url>
                <a class="nav-link active" href="${ mainPage }">메인 페이지</a>
            </li>
            <li class="nav-item">
                <c:url var="postListPage" value="/post/list"></c:url>
                <a class="nav-link active" href="${ postListPage }">목록 페이지</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">LINK 3</a>
            </li>
        </ul>
    </nav>
    
    <main>
        <div class="card my-4">
            <form class="m-4" method="post">
                <div class="my-2">
                    <label for="title" class="form-label">제목</label>
                    <input id="title" class="form-control"
                        type="text" name="title" required autofocus />
                </div>
                <div class="my-2">
                    <label for="content" class="form-label">내용</label>
                    <textarea id="content" class="form-control" 
                        name="content" required></textarea>
                </div>
                <div class="my-2">
                    <label for="author" class="form-label">작성자</label>
                    <input id="author" class="form-control" 
                        type="text" name="author" required />
                </div>
                <div class="my-2">
                    <input class="form-control btn btn-success" type="submit" value="작성 완료" />
                </div>
            </form>
        </div>
    </main>
    
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" 
    crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" 
    integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" 
    crossorigin="anonymous"></script>
</body>
</html>
