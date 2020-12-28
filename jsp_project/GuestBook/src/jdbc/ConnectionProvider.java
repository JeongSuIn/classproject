package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	// 컨넥션 객체를 반환하는 메소드
	public static Connection getConnection() {
		
		Connection conn = null;
		
		// 2. 데이터베이스 연결: Connection 객체를 얻어온다.
    	String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
    	String user = "aia";
    	String password = "aia";
    	
    	try {
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			
		} catch (SQLException e) {
			System.out.println("Connection 객체 생성 실패!!!");
			e.printStackTrace();
		}
    	
    	return conn;
	}
}
