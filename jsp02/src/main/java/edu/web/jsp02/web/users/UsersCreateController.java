package edu.web.jsp02.web.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.dto.UsersCreateDto;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import edu.web.jsp02.service.UsersService;
import edu.web.jsp02.service.UsersServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UsersCreateController
 */
@Slf4j
@WebServlet(name = "usersCreateController", urlPatterns = { "/users/create" })
public class UsersCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsersService usersService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersCreateController() {
        usersService = UsersServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doGet()");
		
		// 회원가입 작성 뷰(JSP) 이동
		request.getRequestDispatcher("/WEB-INF/users/create.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doPost()");
		
		// 요청 파라미터 분석: userName, passWord, email 값을 찾음.
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String email = request.getParameter("email");
		
		// PostCreateDto 타입 객체 생성
		UsersCreateDto dto = UsersCreateDto.builder()
		        .userName(userName).passWord(passWord).email(email)
		        .build();
		log.info("dto = {}", dto);
		
		// usersService.create(dto) 메서드 호출 --> usersDao 호출 --> DB에 저장
		int result = usersService.create(dto);
		log.info("create result = {}", result);
		
		// 포스트 목록 페이지 이동(redirect)
		response.sendRedirect("/jsp02/users"); //Get 방식
		
		// PRG(Post - Redirect - Get) 패턴
	}

}
