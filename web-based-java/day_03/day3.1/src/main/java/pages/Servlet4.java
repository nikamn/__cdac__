package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet4 extends HttpServlet {

	private static final long serialVersionUID = -3630383901481812446L;

	@Override
	public void destroy() {
		System.out.println("In destroy() of  " + getClass());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("In Init() of " + getClass());
	}

	@Override
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In doGet() of " + getClass());
		rs.setContentType("text/html");
		try (PrintWriter pw = rs.getWriter()) {
			pw.print("<h5>Welcome to Servlets ...!" + LocalDateTime.now() + "</h5>");
		}
	}

}
