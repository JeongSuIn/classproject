package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class MemberRegService {

	// 싱글톤 패턴
	private MemberRegService() {
	}

	private static MemberRegService service = new MemberRegService();

	public static MemberRegService getInstance() {
		return service;
	}

	// 사용자의 요청을 받아 파일 업로드, 데이터베이스에 데이터를 저장
	public int insertMember(HttpServletRequest request) {
		int resultCnt = 0;
		
		
		// DAO 객체의 insert 메소드로 member 참조변수 전달 
		// + Connection 객체의 참조 변수 전달
		Connection conn = null;
		
		// MemberDao dao = MemberDao.getInstance();
		MemberDao dao = null;
		
		Member member = null;
		
		
		try {
				conn = ConnectionProvider.getConnection();
	
				// MemberDao는 메소드만 있는 경우 객체를 여러개 만들 필요가 없다. -> 싱글톤 처리
				// MemberDao dao = new MemberDao();
				dao = MemberDao.getInstance();
	
			// conn이 0이 아닐 경우
			if (conn != null) {
	
				// 폼에 입력한 사용자 입력 데이터의 한글 처리
				// request.setCharacterEncoding("utf-8");
	
				String userId = null;
				String pw = null;
				String userName = null;
				String userPhoto = null;
	
				// 경로: /upload/member
				String dir = request.getSession().getServletContext().getRealPath("/upload/member");
	
				// (12.24) FileUpload 라이브러리를 이용해서 DB에 입력할 데이터를 받아와야한다.
				if (ServletFileUpload.isMultipartContent(request)) {
	
					DiskFileItemFactory factory = new DiskFileItemFactory();
	
					ServletFileUpload upload = new ServletFileUpload(factory);
	
					// 리스트 형식으로 값을 받음.
					List<FileItem> items = upload.parseRequest(request);
	
					Iterator<FileItem> itr = items.iterator();
	
					while (itr.hasNext()) {
	
						FileItem item = itr.next();
	
						// type=file 여부 확인 -> 각각 필드의 값을 추출.
						if (item.isFormField()) { // 일반 필드
	
							// 분기 처리..?
							String fName = item.getFieldName();
	
							if (fName.equals("userid")) {
								userId = item.getString("utf-8");
							}
	
							if (fName.equals("pw")) {
								pw = item.getString("utf-8");
							}
	
							if (fName.equals("username")) {
								userName = item.getString("utf-8");
							}
	
						} else { // 파일 필드
	
							if (item.getFieldName().equals("userPhoto") && !item.getName().isEmpty()
									&& item.getSize() > 0) {
	
								// 경로를 저장하는 File 객체를 생성
								File saveFilePath = new File(dir);
	
								// 폴더가 존재하는지 여부 확인
								if (!saveFilePath.exists() || !saveFilePath.isDirectory()) {
									saveFilePath.mkdir();
								}
	
								// ex) a 사용자가 photo.jpg 프로필 사진 등록 -> 두 달 후: b 사용자가 photo.jpg라고 등록하면
								// ex) mini.jpg -> {"mini", "jpg"}
								// 새로운 파일 이름 생성: 중복되는 파일의 이름이 있으면 덮어쓰게 된다.->
								System.out.println(item.getName());
								String newFileName = System.nanoTime() + "";// +".";+item.getName().split(".")[1];
	
								// 파일 저장
								item.write(new File(saveFilePath, newFileName));
								// DB에 저장할 파일 이름
								userPhoto = newFileName;
	
							}
						} /* else */
	
					} /* while */
	
					member = new Member();
					member.setUserId(userId);
					member.setPassword(pw);
					member.setUserName(userName);
					member.setUserPhoto(userPhoto);
	
					System.out.println(member);
	
					// SQLException이 발생하면 DB에 저장이 안된다. -> 예외 처리 필요
					try {
	
						// DB에 데이터 저장
						resultCnt = dao.insertMember(conn, member);
						// SQLException이 발생하면 DB에 저장이 안된다. -> 파일은 이미 저장되어 있음.
					} catch (Exception e) {
						e.printStackTrace();
						// 파일 생성
						File delFile = new File(dir, userPhoto);
						if (delFile.exists()) {
							// 파일이 존재한다면 파일 삭제
							delFile.delete(); // 오류가 나도 파일을 삭제함
						}
					}
	
				}

		}
		} catch(SQLException e){
			e.printStackTrace();
		} catch (FileUploadException e) {
			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		request.setAttribute("result", resultCnt);
		request.setAttribute("member", member);

		return resultCnt;
	}

}
