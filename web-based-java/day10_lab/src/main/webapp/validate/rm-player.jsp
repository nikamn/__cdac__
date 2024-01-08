<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Player Vaidation</title>
</head>
<jsp:setProperty property="*" name="player" />
<body>
	<h4>Status: ${sessionScope.player.removePlayer()}</h4>
</body>
</html>