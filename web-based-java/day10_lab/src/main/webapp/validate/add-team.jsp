<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Team Vaidation</title>
</head>
<jsp:setProperty property="*" name="team" />
<body>
	<h4>Team Details: ${sessionScope.team.addNewTeam()}</h4>
</body>
</html>