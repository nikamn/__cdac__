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
<%!// JSP declaration block to add variables and methods (implicit : private)
	HashMap<String, User> userMap;

	// override jspInit
	public void jspInit() {
		System.out.println("in jspInit(): " + Thread.currentThread());
		// create and populate map
		userMap = new HashMap<>();
		userMap.put("Rama Vaidya", new User("Rama Vaidya", "1234", 30));
		userMap.put("Mihir Rao", new User("Mihir Rao", "2234", 34));
	}%>
<body>
	<%
	System.out.println("in scriptlet: " + Thread.currentThread());
	// read request params 
	String userName = request.getParameter("nm");
	String password = request.getParameter("pass");
	// HM based validations(get, check password)
	User user = userMap.get(userName);
	if (user != null) {
		// name exists , now check for password
		if (user.getPassword().equals(password)) {
			// login successful -- store all user details (age) under session scope
			session.setAttribute("user_dtls", user);
			// redirect
			response.sendRedirect(response.encodeRedirectURL("details.jsp"));
		} else {
			// invalid password, retry link
	%>
	<h4 style="color: red;">
		Invalid Password ...! Please <a href="login.jsp">Retry</a> ...!
	</h4>
	<%
	}
	} else {
	// new user : register link
	%>
	<h4 style="color: red;">
		New User ...! Do you want to <a href="register.jsp">Register</a> ...?
	</h4>
	<%
	}

	// new user (no name --> register link)
	// invalid password --> retry link
	// successful login --> store user pojo in session scope
	// redirect
	%>
</body>
<%!public void jspDestroy() {
		System.out.println("in jspDestroy(): " + Thread.currentThread());
	}%>
</html>
