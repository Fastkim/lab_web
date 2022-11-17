package edu.web.jsp02.web.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.dto.UsersSignUpDto;
import edu.web.jsp02.service.UsersService;
import edu.web.jsp02.service.UsersServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UsersSignUpController
 */
@Slf4j
@WebServlet(name = "usersSignUpController", urlPatterns = { "/users/signup" })
public class UsersSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsersService usersService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersSignUpController() {
        usersService = UsersServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doGet");
		
		request.getRequestDispatcher("/WEB-INF/users/signup.jsp")
		    .forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doPost");
		
		// 요청 파라미터(아이디, 비밀번호, 이메일)를 분석
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String email = request.getParameter("email");
		
		UsersSignUpDto dto = UsersSignUpDto.builder()
		        .userName(userName).passWord(passWord).email(email)
		        .build();
		
		int result = usersService.signUp(dto);
		log.info("회원 가입 결과 = {}", result);
		
		if (result == 1) { // 회원 가입 성공
		    response.sendRedirect("/jsp02/users/signin"); // 로그인 페이지로 이동
		} else { // 회원 가입 실패
		    response.sendRedirect("jsp02/users/signup"); // 회원 가입 페이지로 이동
		}
	}

}
