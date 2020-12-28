package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guestbook.model.Message;

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
			String sql = "INSERT INTO guestbook_message (guest_name, password, message, writedate) "
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
	
}
