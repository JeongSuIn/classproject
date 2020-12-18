<%@page import="form.FormLogin"%>
<%@page import="util.CookieBox"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 데이터 받기: 아이디, 비밀번호
String userId = request.getParameter("userid");
String pw = request.getParameter("pw");

String chk = request.getParameter("chk");

if (chk != null && chk.equals("on") && userId != null && !userId.isEmpty()) {
	// 쿠키 생성 저장
	// uid=userId

	response.addCookie(CookieBox.createCookie("uid", userId, "/", 60 * 60 * 24 * 365));
} else {
	response.addCookie(CookieBox.createCookie("uid", userId, "/", 1));
}



// session을 이용해서 로그인 처리 
// id, pw를 비교해서 같으면 로그인 성공 / 다르면 실패
// 로그인 여부 체크
boolean loginChk = false;
if (userId.equals(pw)) {
	// 로그인 처리
	// beans 생성
	FormLogin formLogin = new FormLogin();

	//데이터 바인딩
	formLogin.setId(userId);
	formLogin.setPw(pw);

	//데이터 공유: request의 속성을 이용
	request.setAttribute("login", formLogin);
	
	// 로그인 정보를 session 객체의 속성에 저장
	session.setAttribute("loginInfo", formLogin);

	loginChk = true;

}

/* <!-- login_view.jsp로 포워딩 --> */
if (loginChk) {
%>
<jsp:forward page="loginView.jsp" />
<%
	} else {
%>
<script>
	alert("아이디 또는 비밀번호가 틀립니다. 다시 로그인해주세요.");
	history.go(-1);
</script>
<%
	}
%>



