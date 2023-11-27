<%@page import="pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation Page</title>
</head>
<%!HashMap<String, User> userMap;

	public void jspInit() {
		System.out.println("in init() of " + Thread.currentThread());
		userMap = new HashMap<>();
		userMap.put("Rama Vaidya", new User("Rama Vaidya", "1234", 30));
		userMap.put("Mihir Rao", new User("Mihir Rao", "2234", 34));
	}%>
<body>
	<%
	System.out.println("in scriptlet: " + Thread.currentThread());

	String userName = request.getParameter("nm");
	String password = request.getParameter("pass");

	User user = userMap.get(userName);
	if (user != null) {
		if (user.getPassword().equals(password)) {
			session.setAttribute("user_dtls", user);
			response.sendRedirect("details.jsp");
		} else {
	%>
	<h4 style="color: red;">
		Invalid Password ...! Please <a href="login.jsp">Retry</a> ...!
	</h4>
	<%
	}
	} else {
	%>
	<h4 style="color: red;">
		New User ...! Do you want to <a href="register.jsp">Register</a> ...?
	</h4>
	<%
	}
	%>
</body>
<%!public void jspDestroy() {
		System.out.println("in destroy() of " + Thread.currentThread());
	}%>
</html>