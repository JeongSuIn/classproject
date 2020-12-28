package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import guestbook.model.Message;
import jdbc.JdbcUtil;

public class MessageDao {
	
	// 싱글톤 패턴 -> Dao 인스턴스는 여러 개가 생성될 필요가 없다.
	private MessageDao() {}

	private static MessageDao dao = new MessageDao();
	
	public static MessageDao getinstance() {
		return dao;
	} 
	
	// 방명록에 데이터를 저장하는 메소드 생성
	public int insertMessage(Connection conn, Message message) throws SQLException { // 저장된 데이터 개수를 반환해야 하기 때문에 int
		
		int resultCnt = 0; // 반환할 결과 개수
		
		PreparedStatement pstmt=null;
		try {
			// 입력을 위한 sql문
			String sql = "INSERT INTO guestbook_message (guest_name, password, message) "
					+ " VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			resultCnt = pstmt.executeUpdate();
			
			
		} finally {
			pstmt.close();
		}
		
		
		
		return resultCnt;
	}

	// 전체 게시물의 개수를 구하는 메소드
	public int selectAllcount(Connection conn) throws SQLException {
		
		int totalCnt=0;
		
		Statement stmt = null;
		
		ResultSet rs = null; // 결과를 담는 변수
		
		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from guestbook_message";			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) { // 다음이 있다면
				totalCnt=rs.getInt(1);
			}
			
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			
			
		}
		
		return totalCnt;
	}
	
}
