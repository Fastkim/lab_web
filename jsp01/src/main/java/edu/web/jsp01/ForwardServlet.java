package edu.web.jsp01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet(name = "forwardServlet", urlPatterns = { "/ex4" })
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("forwardServlet.doGet() 호출");
		
		// 클라이언트에서 온 요청을 새로운 페이지로 "forward" 방식으로 이동:
		// 같은 서버의 같은 웹 애플리케이션 안에서만 페이지 이동이 가능.
		// request, response 객체가 유지됨.
		// 페이지가 이동하더라도 클라이언트가 최초로 요청한 요청 주소(URL)는 바뀌지 않음.
		// 다른 서버 또는 다른 웹 애플리케이션의 페이지로 이동은 불가능.
		
		request.getRequestDispatcher("example.jsp") // src/main/webapp 폴더 아래의 파일 경로를 씀.
		    .forward(request, response);
	}

}
