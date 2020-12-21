package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import member.Member;

public class MemberDao {

	// 싱글톤 처리: 코딩 스타일
	// 외부에서 인스턴스를 생성하지 못한다.
	// -> 인스턴스를 반환해주는 메소드가 있어서 인스턴스가 필요한 경우 메소드를 이용해서 얻는다.\

	// 인스턴스 생성을 막는다. -> 생성자의 접근제어자를 private 처리
	private MemberDao() {}

	// 객체 하나를 생성해서 사용한다.
	// 
	private static MemberDao dao = new MemberDao();
	// Dao 객체의 참조변수를 반환해주는 메소드가 필요하다. -> 외부 클래스에서 누구나 접근해서 사용가능해야 한다.
	// static이 아니면 인스턴스 메소드로 변함.
	public static MemberDao getInstance() {
		return dao;
	} // /싱글톤 처리
	

	// Member 테이블의 데이터를 CRUD
	// insert, select, update, delete

	// 데이터 입력
	public int insertMember(Connection conn, Member member) {
		int resultCnt = 0;

		PreparedStatement pstmt = null;

		String sqlInsert = "INSERT INTO open.member(memberid, password, membername) VALUES(?,?,?)";

		// pstmt 생성
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getUserName());

			//
			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultCnt;
	}

	// 로그인을 위한 select
	public Member selectMemberLogin(Connection conn, String uid, String pw) {
		Member member = null;
		
		String sqlSelect = "SELECT * FROM open.member where memberid=? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setNString(1, uid);
			pstmt.setNString(2, pw);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member(
						rs.getString("memberid")
						, rs.getString("password")
						, rs.getNString("membername")
						, rs.getString("memberphoto"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	
}
