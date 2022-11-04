package edu.web.jsp01.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp01.domain.Contact;

/**
 * Servlet implementation class ContactRegisterController
 */
@WebServlet(name = "ContactRegisterController", urlPatterns = { "/contact/register" })
public class ContactRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactRegisterController() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("contactRegisterController.doGet() 호출");
		
		// View(JSP 페이지)로 "forward" 이동
		request.getRequestDispatcher("/WEB-INF/contact/register.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("contactRegisterController.doPost() 호출");
		
		// 요청 객체의 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 클라이언트에서 보낸 요청 파라미터 값 찾기
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		Contact contact = new Contact(name, phone, email);
		
		// 연락처 정보를 View(JSP)에 전달하기 위해서
		request.setAttribute("contact", contact);
		
		// View(JSP)로 이동(forward)
		request.getRequestDispatcher("/WEB-INF/contact/register-result.jsp")
		    .forward(request, response);
		
	}

}
