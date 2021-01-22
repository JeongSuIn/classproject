<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Index</h1>
	
	<ul> 
		<li>
			<c:url value="/hello" var="hello"/>
			<a href="${hello}">${hello}</a>
		</li>	
		<li>
			<c:url value="/member/login" var="login"/>
			<a href="${login}">${login}</a>
		</li>	
		
		<li>
			<c:url value="/member/search" var="search"/>
			<a href="${search}">${search}</a>
		</li>
		
		<li>
			<c:url value="/order/order" var="order"/>
			<a href="${order}">${order}</a>
		</li>
		<li>
			<c:url value="/cookie/make" var="cookieMake"/>
			<a href="${cookieMake}">${cookieMake}</a>
		</li>
		<li>
			<c:url value="/cookie/view" var="cookieView"/>
			<a href="${cookieView}">${cookieView}</a>
		</li>
		<li>
			<c:url value="/header/headerInfo" var="header_url"/>
			<a href="${header_url}">${header_url}</a>
		</li>
		<li>
			<c:url value="/search/search" var="search"/>
			<a href="${search}">${search}</a>
		</li>
		<li>
			<c:url value="/upload/uploadForm" var="fileupload"/>
			<a href="${fileupload}">${fileupload}</a>
		</li>
		
		<li>
			<c:url value="/member/list" var="memberList"/>
			<a href="${memberList}">${memberList}</a>
		</li>
		
		<li>
			<c:url value="/member/reg" var="memberReg"/>
			<a href="${memberReg}">${memberReg}</a>
		</li>
		
		<li>
			<c:url value="/members/10" var="members"/>
			<a href="${members}">${members}</a>
		</li>
		
		<li>
			<c:url value="/mc/simple" var="simple"/>
			<a href="${simple}">${simple}</a>
		</li>
		
		<li>
			<c:url value="/mc/listXml" var="listXml"/>
			<a href="${listXml}">${listXml}</a>
		</li>
		
		<li>
			<c:url value="/message/listJSon" var="listJSon"/>
			<a href="${listJSon}">${listJSon}</a>
		</li>
		
		<li>
			<c:url value="/rest/ver1/members/25" var="restMember"/>
			<a href="${restMember}">${restMember}</a>
		</li>
		
		<li>
			<c:url value="/rest/ver1/members" var="restMembers"/>
			<a href="${restMembers}">${restMembers}</a>
		</li>
		
		<li>
			<c:url value="/rest/ver1/members/map" var="restMemberMap"/>
			<a href="${restMemberMap}">${restMemberMap}</a>
		</li>
		
		<li>
			<c:url value="/mail/simplemail" var="simplemail"/>
			<a href="${simplemail}">${simplemail}</a>
		</li>
		
	</ul>
</body>
</html>
