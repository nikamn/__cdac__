package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import impl.CandidateDaoImpl;
import impl.UserDaoImpl;
import pojos.User;
import static utils.DBUtils.*;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -5818153729652116410L;
	private UserDaoImpl userDao;
	private CandidateDaoImpl candidateDao;

	public LoginServlet(String nm) {
		System.out.println("in parameterized ctor ...!");
	}

	public LoginServlet() {
		System.out.println("in default ctor: " + getServletConfig());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init() of " + getClass());
		ServletConfig config = getServletConfig();
		System.out.println("from init: " + config);

		String dbURL = config.getInitParameter("url");
		String userName = config.getInitParameter("user_name");
		String password = config.getInitParameter("pwd");

		try {
			openConnection(dbURL, userName, password);
			userDao = new UserDaoImpl();
			candidateDao = new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("error in init() of " + getClass(), e);
		}
	}

	public void destroy() {
		System.out.println("in destroy() of " + getClass());
		try {
			userDao.cleanUp();
			candidateDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("error in destroy() of " + getClass(), e);
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
				System.out.println("HttpSession : " + hs);

				System.out.println("session id from login page : " + hs.getId());
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
			throw new ServletException("err in do-post" + getClass(), e);
		}
	}

}
