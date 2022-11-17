package edu.web.jsp02.web.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.domain.Users;
import edu.web.jsp02.dto.PostUpdateDto;
import edu.web.jsp02.dto.UsersUpdateDto;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import edu.web.jsp02.service.UsersService;
import edu.web.jsp02.service.UsersServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UsersModifyController
 */
@Slf4j
@WebServlet(name = "usersModifyController", urlPatterns = { "/users/modify" })
public class UsersModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsersService usersService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersModifyController() {
        usersService = UsersServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.info("doGet()");
		
		// 요청 파라미터 id(유저 번호) 찾기.
		Integer id = Integer.valueOf(request.getParameter("id"));
		log.info("id = {}", id);
		
		// id(유저 번호)로 레코드 찾기.
		Users users = usersService.read(id);
		
		// 뷰에 전달
		request.setAttribute("users", users);
		request.getRequestDispatcher("/WEB-INF/users/modify.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		// TODO : 포스트 (제목 또는 내용) 수정.
        log.info("doPost()");
        
        // 요청 파라미터 분석.
        Integer id = Integer.valueOf(request.getParameter("id")); // 변경할 회원 번호
        String userName = request.getParameter("userName"); // 변경할 회원아이디
        String passWord = request.getParameter("passWord"); // 변경할 회원패스워드
        String email = request.getParameter("email"); // 변경할 회원이메일
        
        // postService 객체에게 전달할 DTO 생성
        UsersUpdateDto dto = UsersUpdateDto.builder()
                .id(id).userName(userName).passWord(passWord).email(email)
                .build();
        
        // postService 메서드 호출 -> DB에 업데이트 되도록.
        int result = usersService.update(dto);
        log.info("users update result = {}", result);
        
        // 상세보기 이동(Redirect)
        response.sendRedirect("/jsp02/users/detail?id=" + id);
        
        // PRG(Post-Redirect-Get) 패턴
	}

}
