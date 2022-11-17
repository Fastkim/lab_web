package edu.web.jsp02.web.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.web.jsp02.domain.Users;
import edu.web.jsp02.service.UsersService;
import edu.web.jsp02.service.UsersServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UsersSigninController
 */
@Slf4j
@WebServlet(name = "usersSigninController", urlPatterns = { "/users/signin" })
public class UsersSigninController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsersService usersService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersSigninController() {
        usersService = UsersServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doGet()");
		
		request.getRequestDispatcher("/WEB-INF/users/signin.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doPost()");
		
		// 로그인 페이지의 요청 파라미터를 분석
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		// UserService 메서드를 호출해서 로그인 처리 - 아이디/비밀번호가 일치하는 유저 정보가 있는 지 체크
		Users users = usersService.signIn(userName, passWord);
		
		
		// 로그인 성공/실패 경우에 redirect
		if (users == null) { // 로그인 실패
		    response.sendRedirect("/jsp02/users/signin"); // 로그인 페이지로 이동
		    return; // doPost() 메서드 종료
		}
		
		// 로그인 성공: 
		// (1) 세션(session)에 로그인 정보 저장.
		HttpSession session = request.getSession();
		// 로그인 사용자 아이디를 세션에 저장
		session.setAttribute("signInUsers", users.getUserName());
		// EL scope: pageScore -> requestScope -> sessionScope -> applicationScope
		
		
		// (2) 적절한 페이지로 이동
		response.sendRedirect("/jsp02/post"); // 포스트 목록 페이지로 이동
		
	}

}
