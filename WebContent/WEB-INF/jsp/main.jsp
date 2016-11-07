<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>LikeIt</title>
	<link rel="stylesheet" href="css/main.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
  	<nav class="nav-bar nav-bar_fixed_top">
		<div class="interactBar">
			<h3 class="logo">LikeIt</h3>
			<c:if test="${sessionScope.user eq null}">
				<div class=" buttons">
					<form class="nav-bar_reg-button nav-button" action="Controller"
						method="post">
						<input type="hidden" name="command"
							value="REDIRECT_TO_REGISTRATION"> <input type="submit"
							value="Sign up">
					</form>

					<form class="nav-bar_log-button nav-button" action="Controller"
						method="post">
						<input type="hidden" name="command" value="REDIRECT_TO_SIGNIN">
						<input type="submit" value="Sign in">
					</form>
				</div>
			</c:if>
			<c:if test="${not (sessionScope.user eq null)}">
				<div class=" buttons">
					<form class="nav-bar_sign-out-button nav-button"
						action="Controller" method="post">
						<input type="hidden" name="command" value="SIGN_OUT"> 
						<input type="submit" value="Sign out">
					</form>
				</div>
			</c:if>
		</div>
	</nav>
	<div class="wrapper">
		<c:forEach var="topic" items="${topics}">
		<div>
			<h3><c:out value="${topic.header}" /></h3>
			<p><c:out value="${topic.context}" /></p>
			<br>		
		</div>
		</c:forEach>
	</div>
</body>
</html>