<%@ page language="java" contentType="text/html; charset=utf-8"
	import="by.epam.training.bean.entity.User" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">	
	<title>Registration</title>
</head>
<body>
	<p>Create new account:</p>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="CREATE_ACCOUNT">
		<input id="textfield" name="username" type="text" placeholder="Pick a login" value="" />
		<br>
		<input id="textfield" name="userPassword" type="text" placeholder="Create a password" value="" />
		<br>
		<input type="submit" value="Sing up">
	</form>
</body>
</html>