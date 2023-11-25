package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/test3", loadOnStartup = 1)
public class Servlet3 extends HttpServlet {

	private static final long serialVersionUID = -3387364318791455979L;

	@Override
	public void destroy() {
		System.out.println("In destroy() of  " + getClass());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("In init() of " + getClass());
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
