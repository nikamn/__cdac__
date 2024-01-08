<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Team Validation</title>
</head>
<jsp:setProperty property="*" name="team" />
<body>
	<c:set var="mesg" value="${sessionScope.team.removeTeam()}"
		scope="session" />
	<c:redirect url="../index.jsp" />
</body>
</html>