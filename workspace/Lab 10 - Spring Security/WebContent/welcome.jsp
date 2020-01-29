<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security</title>
</head>
<body>
Welcome to Spring Security. You are logged in as : <sec:authentication property="principal.username" />
<br/>This page is a secured page and no way we should be able to access it without login first
<br/>
<sec:authorize ifAnyGranted="ROLE_ADMIN">
	THIS IS ONLY VISIBLE TO ADMIN USERS
</sec:authorize>
<br/>
<a href="user.do">Try accessing the Business Layer</a>
<br/>
<p><a href="j_spring_security_logout">Logout</a></p>
</body>
</html>