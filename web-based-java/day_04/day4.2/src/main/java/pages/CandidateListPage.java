package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet {
	private static final long serialVersionUID = -3476259360530188121L;

	@Override
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In doGet() of " + getClass());
		rs.setContentType("text/html");
		
		try (PrintWriter pw = rs.getWriter()) {
			pw.print("<h4>Welcome Voter ...!</h4>");
			HttpSession session = rq.getSession();

			System.out.println("Is session new? -> " + session.isNew());
			System.out.println("Session ID: " + session.getId());

			User validUser = (User) session.getAttribute("clnt_details");
			if (validUser != null)
				pw.print("<h4>User details via HttpSession: " + validUser + "</h4>");
			else
				pw.print("<h4>Session Tracking failed ...! Cookies not enables ...!</h4>");

		}
	}

}
