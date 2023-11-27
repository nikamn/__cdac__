<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%!String mesg = "some mesg";%>
<meta charset="ISO-8859-1">
<title>Test3 Page</title>
</head>
<body>
	<%
	String anotherMesg = "another mesg...";
	pageContext.setAttribute("nm", 12345);
	%>
	<%@ include file="test4.jsp"%>
</body>
</html>