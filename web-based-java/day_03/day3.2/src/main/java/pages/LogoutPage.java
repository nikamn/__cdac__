package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class LogoutPage extends HttpServlet{
	
	private static final long serialVersionUID = 1003090770505654614L;

	@Override
	public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws ServletException,IOException
	{
		System.out.println("In doGet() of " + getClass());
		rs.setContentType("text/html");
		try(PrintWriter pw=rs.getWriter()) {
			pw.print("<h4>Logging out ...!</h4>");
		}
	}

}
