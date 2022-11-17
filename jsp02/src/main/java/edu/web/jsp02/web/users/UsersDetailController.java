package edu.web.jsp02.web.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.domain.Users;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import edu.web.jsp02.service.UsersService;
import edu.web.jsp02.service.UsersServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UsersDetailController
 */
@Slf4j
@WebServlet(name = "usersDetailController", urlPatterns = { "/users/detail" })
public class UsersDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsersService usersService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersDetailController() {
        usersService = UsersServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doGet()");
		
		// Query string에 포함된 요청 파라미터 id(Users 번호) 값을 읽음.
		Integer id = Integer.valueOf(request.getParameter("id"));
		log.info("id = {}", id);
		
		// 서비스 객체의 메서드를 호출해서 DB에 저장된 해당 id의 Users를 읽음.
		Users users = usersService.read(id);
		log.info("users = {}", users);
		
		// 뷰에 전달.
		request.setAttribute("users", users);
		request.getRequestDispatcher("/WEB-INF/users/detail.jsp")
		    .forward(request, response);
	}

}
