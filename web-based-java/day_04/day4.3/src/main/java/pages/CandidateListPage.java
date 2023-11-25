package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import pojos.Candidate;
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
			User validUser = (User) session.getAttribute("clnt_details");
			if (validUser != null) {
				pw.print("<h4> Hello , " + validUser.getFirstName() + "</h4>");
				CandidateDaoImpl dao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
				List<Candidate> candidates = dao.getAllCandidates();
				pw.print("<form action='logout'>");
				for (Candidate c : candidates)
					pw.print("<h5><input type='radio' name='candidate_id' value='" + c.getCandidateId() + "'>"
							+ c.getCandidateName() + "</h5>");
				pw.print("<h5> <input type='submit' value='Cast A Vote'/></h5>");
				pw.print("</form>");
			} else
				pw.print("<h4> Session Tracking failed ...! Cookies not enabled ...!</h4>");

		} catch (Exception e) {
			throw new ServletException("Error in doGet() of " + getClass(), e);
		}
	}

}
