package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;

public class DeleteMessageService {
	
	// 싱글톤 패턴
	private DeleteMessageService() {}
	private static DeleteMessageService service = new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return service;
	}
	
	// 게시물의 아이디, 비밀번호를 받아서 삭제하고 결과를 반환하는 메소드 생성
	public int deleteMessage(int mid, String pw) {
		int resultCnt = 0;
		
		// Connection, MessageDao, 
		// selectMessage(conn, mid) -> Message: 게시물 존재 유무, 비밀번호 일치 체크
		// deleteMessage() 호출
		
		Connection conn = null;
		MessageDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getinstance();
			
			// 메세지 객체, null를 반환
			Message message = dao.selectMessage(conn, mid);
			
			if(message==null) {
				// 메세지가 존재하지 않는다.
			} else  if() {	// 비밀번호 일치 체크
				// 메세지가 존재
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
	

}
