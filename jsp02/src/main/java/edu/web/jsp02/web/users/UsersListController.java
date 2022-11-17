package edu.web.jsp02.web.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.domain.Users;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import edu.web.jsp02.service.UsersService;
import edu.web.jsp02.service.UsersServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UsersListController
 */
@Slf4j // Logger 객체 자동 생성.
@WebServlet(name = "usersListController", urlPatterns = { "/users" })
public class UsersListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsersService usersService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersListController() {
        usersService = UsersServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doGet()");
		
		// PostService 객체의 메서드를 호출해서 포스트 목록 전체를 읽어옴.
		List<Users> list = usersService.read();
		log.info("# of list = {}", list.size());
		
		// 포스트 목록을 뷰에 전달하기 위해서 request 객체에 속성 값으로 저장.
		request.setAttribute("users", list);
		
		// 뷰로 페이지 이동(forward).
		request.getRequestDispatcher("/WEB-INF/users/list.jsp")
		    .forward(request, response);
	}

}
