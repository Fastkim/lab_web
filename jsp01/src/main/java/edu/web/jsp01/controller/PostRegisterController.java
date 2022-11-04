package edu.web.jsp01.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp01.domain.Contact;
import edu.web.jsp01.domain.Post;

/**
 * Servlet implementation class PostRegisterController
 */
@WebServlet(name = "PostRegisterController", urlPatterns = { "/post/registerPost" })
public class PostRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostRegisterController() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    System.out.println("PostRegisterController.doGet() 호출");
	    
	    // View(JSP 페이지)로 "forward" 이동
        request.getRequestDispatcher("/WEB-INF/post/registerPost.jsp")
            .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    System.out.println("PostRegisterController.doPost() 호출");
	    
	    // request 객체의 인코딩 타입 설정 -> 한글 처리
        request.setCharacterEncoding("UTF-8");
        
        // 요청 파라미터(request parameter) 분석
        Integer id = Integer.valueOf(request.getParameter("id"));           
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        LocalDateTime createTime = LocalDateTime.parse(request.getParameter("createdTime"));
        
        // Post 타입 객체 생성
        Post post = new Post(id, title, content, createTime);
        System.out.println(post);
        
        // Post 객체를 request의 속성 값으로 추가 -> View에 전달
        request.setAttribute("post", post);
        
        // View(JSP)로 이동(forward)
        request.getRequestDispatcher("/WEB-INF/post/registerPost-result.jsp")
            .forward(request, response);
	}

}
