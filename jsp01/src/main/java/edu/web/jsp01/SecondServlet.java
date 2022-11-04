package edu.web.jsp01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
/*
 * Servlet을 설정하는 방법:
 *  1. 배포관리자(deployment descriptor, web.xml)에서 설정.
 *  2. @WebServlet 애너테이션 이용.
 *  web.xml 또는 애너테이션 중 한가지 방법으로만 설정.
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("secondServlet.doGet() 호출");
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter()
		    .append("<!doctype html>")
		    .append("<html>")
		    .append("<body>")
		    .append("<h1>두번째 서블릿</h1>")
		    .append("<a href='/jsp01'>메인 페이지</a>")
		    .append("</body>")
		    .append("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		doGet(request, response);
	}

}
