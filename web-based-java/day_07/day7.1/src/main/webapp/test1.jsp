<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test1 Page</title>
</head>
<body>
	<h4>
		page :
		<%=page%></h4>
	<h4>
		pageContext
		<%=pageContext%></h4>
	<h4>
		Value of JSESSIONID :
		<%=session.getId()%></h4>
	<h4>Value of JSESSIONID : ${cookie.JSESSIONID.value}</h4>
</body>
</html>