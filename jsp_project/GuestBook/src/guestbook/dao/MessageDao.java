package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public List<Message> selectList(Connection conn, int firstRow, int messageCountPerPage) throws SQLException {
		List<Message> list= new ArrayList<Message>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from open.guestbook_message order by message_id desc limit ?, ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, messageCountPerPage);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(makeMessage(rs));
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return list;
	}
	
	private Message makeMessage(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt(1));
		message.setGuestName(rs.getString(2));
		message.setPassword(rs.getString(3));
		message.setMessage(rs.getString(4));
		message.setWritedate(rs.getTimestamp(5));
		
		return message;
	}

	public Message selectMessage(Connection conn, int mid) throws SQLException {
		
		Message message = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from open.guestbook_message where message_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				message = makeMessage(rs); // 메세지를 받음.
			}
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return message;
	} // selectMessage

	public int deleteMessage(Connection conn, int mid) throws SQLException {
		int resultCnt = 0;
		
		// 메세지 삭제 처리
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM guestbook_message WHERE message_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			
			resultCnt = pstmt.executeUpdate(); // 결과를 받음.
			
			
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		
		
		return resultCnt;
		
	} // deleteMessage

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

