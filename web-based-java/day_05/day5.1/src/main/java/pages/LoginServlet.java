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

import static utils.DBUtils.*;

@WebServlet(urlPatterns = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3480173834693424911L;
	private UserDaoImpl userDao;
	private CandidateDaoImpl candidateDao;

	@Override
	public void init() throws ServletException {
		System.out.println("In init() of " + getClass());
		try {
			openConnection();
			userDao = new UserDaoImpl();
			candidateDao = new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Error in init() of " + getClass(), e);
		}
	}

	@Override
	public void destroy() {
		System.out.println("In destroy() of " + getClass());
		try {
			userDao.cleanUp();
			candidateDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("Error in destroy() of " + getClass(), e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			User user = userDao.authenticateUser(email, pwd);

			if (user == null)
				pw.print("<h4>Invalid Login ...! Please <a href='login.html'>Retry</a> ...!</h4>");
			else {
				HttpSession hs = request.getSession();
				System.out.println("session id from login page: " + hs.getId());
				hs.setAttribute("clnt_details", user);
				hs.setAttribute("user_dao", userDao);
				hs.setAttribute("candidate_dao", candidateDao);

				if (user.getRole().equals("admin"))
					response.sendRedirect("admin_page");
				else {
					if (user.isVotingStatus())
						response.sendRedirect("logout");
					else
						response.sendRedirect("candidate_list");
				}
			}
		} catch (Exception e) {
			throw new ServletException("Error in doPost() of " + getClass(), e);
		}
	}
}
