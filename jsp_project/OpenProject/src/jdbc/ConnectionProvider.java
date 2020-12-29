package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	// 컨넥션 객체를 반환하는 메소드
	public static Connection getConnection() throws SQLException {

		Connection conn = null;

		// 2. 데이버베이스 연결: Connection 객체를 얻어온다.
		String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
		String user = "aia";
		String password = "aia";

		conn = DriverManager.getConnection(jdbcUrl, user, password);

		return conn;
	}
}
