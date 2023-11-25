package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet {

	private static final long serialVersionUID = -3476259360530188121L;

	@Override
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In doGet() of " + getClass());
		rs.setContentType("text/html");
		try (PrintWriter pw = rs.getWriter()) {
			pw.print("<h4>Welcome Voter ...!</h4>");

			Cookie[] cookies = rq.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies)
					if (c.getName().equals("user_info"))
						pw.print("<h4>Voter Details: " + c.getValue() + "</h4>");
			} else
				pw.print("<h4> Session Tracking failed ...! No cookies allowed ...!</h4>");

		}
	}

}
