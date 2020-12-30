package mvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.Command;

// 4. FrontController.java 생성
public class FrontController extends HttpServlet {
	
		// 17. 개선 : init()추가 -> 지정해놓은 객체를 map에 저장한 후 쉽게 요청할 수 있도록 처리
		// Map<String, Command> -> <요청 uri, Command 클래스를 상속하는 객체>
		private Map<String, Command> commands;
	
		
		@Override
		public void init(ServletConfig config) throws ServletException {
			//23. MVC 구조
			commands = new HashMap<String, Command>();
			
			String configPath = config.getInitParameter("configPath");
			
			Properties prop = new Properties();
			
			FileInputStream fis = null;
			// 설정 파일의 실제 경로
			String configFilePath = config.getServletContext().getRealPath(configPath);
			
			try {
				fis = new FileInputStream(configFilePath);
				prop.load(fis);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Iterator itr = prop.keySet().iterator();
			
			while(itr.hasNext()) {
				String command = (String) itr.next();
				String className = prop.getProperty(command);
				
				
				
				// commands Map -> command, className의 인스턴스를 저장
				try {
					Class commandClass = Class.forName(className);
					// Command 인스턴스 생성
					Command commandInstance = (Command) commandClass.newInstance();
					
					// command.put(경로, Command 인스턴스)
					commands.put(command, commandInstance);
					
					System.out.println(command+"="+className);
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					
				} catch (InstantiationException e) {
					e.printStackTrace();
					
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
				
			}
			
			
			
			
			
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
			// 19. Command cmd = null; -> commands.get(command); 수정 & if 추가
			Command cmd = commands.get(command);
			if(cmd==null) {
				cmd =  null;// new InvalidCommand();
			}
			
			// 8. 20.String viewPage = null; -> String viewPage = cmd.getViewPage(request, response); 
			String viewPage = cmd.getViewPage(request, response);
			
		
//		18. 주석 처리	
//		if(command.equals("/greeting")|command.equals("/")) {
//			// 10.
//			cmd = new GreetingCommand();
//		} else if(command.equals("/date")) {
//			cmd = new DateCommand(); // -> 11.로 넘어감.
//		} else if(command.equals("/member/login")) {
//			cmd = new MemberLoginCommand();
//		} else {
//			cmd = new InvalidCommand();
//		}
		
			
		
		
		
		
		// 응답을 위한 View페이지로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
