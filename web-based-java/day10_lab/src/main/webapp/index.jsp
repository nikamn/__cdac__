<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ipl Page</title>
<link rel="stylesheet" href="style.css">
</head>
<jsp:useBean id="team" scope="session" class="beans.TeamBean" />
<c:set var="mesg" value="" scope="session" />
<body>

	<h1>IPL Management System</h1>
	<div style="color: red;">${sessionScope.mesg}</div>
	<div class="flex">
		<form action="add/add-player.jsp" class="flex-item">
			<button class="button">Add Player</button>
		</form>

		<form action="add/add-team.jsp" class="flex-item">
			<button class="button">Add Team</button>
		</form>
	</div>


	<div class="flex">
		<form action="remove/remove-player.jsp" class="flex-item">
			<button class="button">Remove Player</button>
		</form>

		<form action="remove/remove-team.jsp" class="flex-item">
			<button class="button">Remove Team</button>
		</form>
	</div>
</body>
</html>