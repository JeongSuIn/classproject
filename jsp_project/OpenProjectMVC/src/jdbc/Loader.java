package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet {

	
	// 서블릿 객체를 실행할 때 처음 한 번 실행해주는 메소드
	// 서블릿은 web.xml에 등록된다. -> 컨테이너가 실행될 때 한 번 서블릿이 실행되도록 설정
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		
		String driver = servletConfig.getInitParameter("driver");
		System.out.println(driver);
		
		if(driver==null) {
			driver="com.mysql.cj.jdbc.Driver";
		}
		
		// Mysql의 드라이버를 로드		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName(driver);
			System.out.println("OpenProjectMVC Mysql 드라이버 로드 성공~~~");
			
		} catch (ClassNotFoundException e) {
			System.out.println("OpenProjectMVC Mysql 드라이버 로드 실패!!!");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	

}
