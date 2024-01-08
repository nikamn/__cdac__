<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Player Vaidation</title>
</head>
<jsp:setProperty property="*" name="player" />
<body>
	<h4>Status: ${sessionScope.player.addPlayerToTeam()}</h4>
</body>
</html>