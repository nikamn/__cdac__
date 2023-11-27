<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voter Registration Status</title>
</head>
<%--invoke ALL matching setters --%>
<jsp:setProperty property="*" name="user" />
<body>
	<%--invoke BL method for voter registration --%>
	<h5>Status : ${sessionScope.user.registerNewVoter()}</h5>
</body>
</html>