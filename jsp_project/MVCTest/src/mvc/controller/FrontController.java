package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 4. FrontController.java 생성
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		// 요청 분석: uri를 이용해서 분석
		// http://localhost:8080/mvc/greeting -> /greeting
		String command = request.getRequestURI();
		System.out.println(command);
		// => /mvc/greeting
		System.out.println(command.indexOf(request.getContextPath()));
		if(command.indexOf(request.getContextPath())==0) {
			// => /greeting
			command = command.substring(request.getContextPath().length());
		}
		System.out.println(command);
	}
	
}
