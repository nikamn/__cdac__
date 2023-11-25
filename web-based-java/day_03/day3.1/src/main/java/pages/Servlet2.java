package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/test2")
public class Servlet2 extends HttpServlet {

	private static final long serialVersionUID = -4031443071032428996L;

	@Override
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In doGet() of " + getClass());
		rs.setContentType("text/html");
		try (PrintWriter pw = rs.getWriter()) {
			pw.print("<h5>Welcome to Servlets ...!" + LocalDateTime.now() + "</h5>");
		}
	}

}
