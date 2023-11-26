package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import impl.CandidateDaoImpl;
import impl.UserDaoImpl;
import pojos.User;

@WebServlet("/logout")
public class LogoutPage extends HttpServlet {
	private static final long serialVersionUID = 1003090770505654614L;

	@Override
	public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In doGet() of " + getClass());
		rs.setContentType("text/html");

		try (PrintWriter pw = rs.getWriter()) {
			HttpSession session = rq.getSession();
			System.out.println("session id from logout page: " + session.getId());

			User user = (User) session.getAttribute("clnt_details");
			if (user != null) {
				pw.print("<h5>Hello " + user.getFirstName() + " ...!</h5>");
				if (user.isVotingStatus()) {
					pw.print("<h5>You have already voted ...!</h5>");
				} else {
					UserDaoImpl userDao = (UserDaoImpl) session.getAttribute("user_dao");
					CandidateDaoImpl candidateDao = (CandidateDaoImpl) session.getAttribute("candidate_dao");

					pw.print("<h5>" + userDao.updateVotingStatus(user.getUserId()) + "<h5>");

					int candidateId = Integer.parseInt(rq.getParameter("candidate_id"));

					pw.print("<h5>" + candidateDao.incrementVotes(candidateId) + "<h5>");
				}
			} else
				pw.print("<h4> Session Tracking failed ...! Cookies not enabled ...!</h4>");

			pw.print("<h5>You have logged out ...!</h5>");
			session.invalidate();
		} catch (Exception e) {
			throw new ServletException("error in doGet() of " + getClass(), e);
		}
	}

}
