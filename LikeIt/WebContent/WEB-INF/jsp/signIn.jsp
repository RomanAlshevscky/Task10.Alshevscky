<%@ page language="java" contentType="text/html; charset=utf-8"
	import="by.epam.training.bean.entity.User" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">	
	<title>Sign in</title>
</head>
<body>
	<p>Please sign in.</p>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="SIGNIN">	
		<input id="textfield" name="username" type="text" placeholder="Enter username" value="" />
		<br> 
		<input id="textfield" name="userPassword" type="text" placeholder="Enter password" value="" />
		<c:if test="${not (requestScope.error eq null)}">
			<p><c:out value="${requestScope.error}"></c:out></p>
		</c:if>
		<br>
		<input type="submit" value="Sign in">
	</form>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="REDIRECT_TO_REGISTRATION">
		<p>Or sign up, if you have no account.</p>
		<input type="submit" value="Sign up">
	</form>
</body>
</html>