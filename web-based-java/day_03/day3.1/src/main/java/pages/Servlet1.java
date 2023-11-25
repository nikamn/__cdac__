package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test1")
public class Servlet1 extends HttpServlet {

	private static final long serialVersionUID = 5239899342673397107L;

	@Override
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In doGet() of " + getClass());
		// 1. set response content type
		rs.setContentType("text/html");
		// 2. get PW : to send rs from servlet ---> web clnt
		try (PrintWriter pw = rs.getWriter()) {
			// generate dynamic content (add dyn contents to buffer of PW)
			pw.print("<h5>Welcome to Servlets ...!" + LocalDateTime.now() + "</h5>");
		}
	}

}
