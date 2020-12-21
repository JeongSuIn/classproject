<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	CookieBox cookieBox = new CookieBox(request);

	String saveId = cookieBox.exists("uid")?cookieBox.getValue("uid") : "";
	String checked = cookieBox.exists("uid")? "checked" : "";
%>  
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입 폼</title>
</head>

<body>
    <h1>회원 가입</h1>
    <hr>
    <form action="regResult.jsp" method="post">
        <table>
            <tr>
                <th><label for="userid">아이디(email)</label></th>
                <td>
                    <input type="email" id="userid" name="userId" value="<%= saveId %>">
                </td>
            </tr>
            <tr>
                <th><label for="pw">비밀번호</label></th>
                <td>
                    <input type="password" id="pw" name="pw"> 
                </td>
            </tr>
            <tr>
                <th><label for="username">이름</label></th>
                <td>
                    <input type="text" id="username" name="userName">
                </td>
            </tr>
            <tr>
                <th><label for="userPhoto">사진</label></th>
                <td>
                    <input type="file" id="userPhoto" name="userPhoto">
                </td>
            </tr>
            <tr>
            	<th></th>
            	<td><input type="checkbox" name="chk" value="on" <%= checked %>>아이디 저장</td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="submit" value="회원가입">
                </td>
            </tr>
        </table>
    </form>
    
</body>
</html>