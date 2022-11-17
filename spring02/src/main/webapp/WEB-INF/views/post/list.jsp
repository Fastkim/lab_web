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
        <h2>포스트 목록 페이지</h2>
    </header>
    
    <nav>
        <ul class="nav bg-light">
            <li class="nav-item">
                <c:url var="mainPage" value="/"></c:url>
                <a class="nav-link active" href="${ mainPage }">메인 페이지</a>
            </li>
            <li class="nav-item">
                <c:url var="postCreatePage" value="/post/create"></c:url>
                <a class="nav-link active" href="${ postCreatePage }">새 글 작성</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">LINK 3</a>
            </li>
        </ul>
    </nav>
    
    <main class="my-2">
        <div class="bg-light my-2 p-2">
            <c:url var="postSearchPage" value="/post/search"></c:url>
            <form action="${ postSearchPage }" method="get">
                <div class="row">
                    <div class="col-4">
                        <select class="form-control" name="type">
                            <option value="t">제목</option>
                            <option value="c">내용</option>
                            <option value="tc">제목 + 내용</option>
                            <option value="a">작성자</option>
                        </select>
                    </div>
                    <div class="col-6">
                        <input class="form-control" 
                            type="text" name="keyword" placeholder="검색어" required autofocus />
                    </div>
                    <div class="col-2">
                        <input class="form-control btn btn-outline-success" type="submit" value="검색" />
                    </div>
                </div>
            </form>
        </div>
    
        <div class="card my-2">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>수정시간</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="post" items="${ list }">
                    <tr>
                        <td>${ post.id }</td>
                        <td>
                            <c:url var="postDetailPage" value="/post/detail">
                                <c:param name="id" value="${ post.id }" />
                            </c:url>
                            <a href="${ postDetailPage }">${ post.title }</a>
                        </td>
                        <td>${ post.author }</td>
                        <td>${ post.modified_time }</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
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
