package mvc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.Command;
import mvc.command.DateCommand;
import mvc.command.GreetingCommand;
import mvc.command.InvalidCommand;
import mvc.command.MemberLoginCommand;

// 4. FrontController.java 생성
public class FrontController extends HttpServlet {
	
		// 17. 개선 : Init()추가 -> 지정해놓은 객체를 map에 저장한 후 쉽게 요청할 수 있도록 처리
		// Map<String, Command> -> <요청 uri, Command 클래스를 상속하는 객체>
		private Map<String, Command> commands = new HashMap<String, Command>();
	
		@Override
		public void init() throws ServletException {
		}
	
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
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
		
		// 6.
		// 요청에 맞는 기능 실행 -> 결과 데이터를 생성
		//Object resultObj = null;
			//8.
			Command cmd = null;
			String viewPage = null;
		
		if(command.equals("/greeting")|command.equals("/")) {
			// 10.
			cmd = new GreetingCommand();
		} else if(command.equals("/date")) {
			cmd = new DateCommand(); // -> 11.로 넘어감.
		} else if(command.equals("/member/login")) {
			cmd = new MemberLoginCommand();
		} else {
			cmd = new InvalidCommand();
		}
		
			// 8. 
			viewPage = cmd.getViewPage(request, response);
		
		
		
		
		// 응답을 위한 View페이지로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
