package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 12. MemberLoginCommand 생성
public class MemberLoginCommand extends Command {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// 사용자의 요청을 처리하고, 응답에 필요한 데이터를 request 속성에 저장, 응답에 필요한 설정
		// 요청의 응답처리를 하기 위한 view 페이지 경로를 반환
		//String viewPage = null;
		
		// 사용자 요청의 처리
		String result = "로그인 페이지 입니다. " + request.getRequestURI();
		
		// request 속성에 결과를 저장
		request.setAttribute("result", result);
		
		return "/view/member/login.jsp";
	}

	

}
