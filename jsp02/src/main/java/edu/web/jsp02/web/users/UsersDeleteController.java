package edu.web.jsp02.web.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import edu.web.jsp02.service.UsersService;
import edu.web.jsp02.service.UsersServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UsersDeleteController
 */
@Slf4j
@WebServlet(name = "usersDeleteController", urlPatterns = { "/users/delete" })
public class UsersDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsersService usersService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersDeleteController() {
        usersService = UsersServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doPost()");
		
		// 요청 파라미터 id 값을 찾음.
		Integer id = Integer.valueOf(request.getParameter("id"));
		log.info("id = {}", id);
		
		// postService의 메서드를 이용해서 id로 포스트 글을 삭제
		int result = usersService.delete(id);
		log.info("delete result = {}", result);
		
		response.sendRedirect("/jsp02/users"); // 목록 페이지로 redirect
	}

}
