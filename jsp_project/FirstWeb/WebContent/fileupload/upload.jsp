<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean result = false;
	String resultMsg="";

	// parameter 이름이 title인 데이터를 저장할 변수
	String title = null;
	// 저장된 파일 이름 
	String fileName = null; 
	
	// 1. multipart/form-data 여부 확인
	boolean isMultipart = ServletFileUpload.isMultipartContent(request); 

	if(isMultipart){
		
		// 2. 업로드 할 파일을 보관 -> FileItem의 Factory객체 설정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 3. 요청을 처리할(form안의 input tag들을 분리) ServletFileUpload 인스턴스 생성 -> 
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 4. 사용자의 요청을 파싱(데이터를 추출해서 원하는 형식으로 만드는 것)
		// FileItem -> 사용자의 요청 파라미터인 input의 객체
		List<FileItem> items = upload.parseRequest(request);
		
		Iterator<FileItem> itr = items.iterator();
		
		while(itr.hasNext()){
			FileItem item = itr.next();
			
			// 폼 필드와 파일을 구분해서 처리
			if(item.isFormField()){
				// true->type=file 인 것을 제외한 나머지 필드
				// 필드이름, 파라미터 이름
				String fName = item.getFieldName();
				
				if(fName.equals("title")){
					title = item.getString("utf-8");
				}
				
				request.setAttribute("title", title);
				
			}else{
				// false-> type=file인 필드
				String fName = item.getFieldName();			// Field의 이름
				String userFileName = item.getName();		// 파일의 이름 
				String contentType = item.getContentType();	// 컨텐트 타입 반환
				Long fileSize = item.getSize();				// 파일의 바이트 사이즈
				
				System.out.println("필드 이름: "+fName);
				System.out.println("파일 이름: "+userFileName);
				System.out.println("컨텐트 타입 변환: "+contentType);
				System.out.println("파일의 바이트 사이즈: "+fileSize);
				
				// 파일을 서버의 특정 폴더에 저장(쓰기)
				if(!userFileName.isEmpty() && fileSize>0){
					
					// 파일을 실제 저장할 폴더의 시스템 경로
					String dir = request.getSession().getServletContext().getRealPath("/upload");
					System.out.println(dir);
					
					File saveFilePath = new File(dir);
					
					// 폴더가 존재하지 않으면 폴더 생성
					if(saveFilePath.exists()){
						saveFilePath.mkdir();
						}
					
					// 파일 쓰기(저장)
					item.write(new File(saveFilePath, userFileName));
					System.out.println("파일 저장 완료!");
					
					// 완료 시에 전달할 데이터
					request.setAttribute("saveFileName", userFileName);
					
					
				}
			}
		}
		
		// 정상 처리
		result = true;
		request.setAttribute("result",result);
		
	}
	
%>

<jsp:forward page="upload_view.jsp"/>