package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//7. command pattern -> 하나의 메소드로만 처리할 수 있도록
public abstract class Command {
	
	// 추상 메소드 생성 -> 요청의 처리, 속성에 결과를 저장하는 기능, view 페이지의 경로를 반환
	abstract public String getViewPage(HttpServletRequest request, HttpServletResponse response); 
}
