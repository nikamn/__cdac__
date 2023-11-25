package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -1272607595838122577L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("In init() of " + getClass());
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Error in init() of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("In destroy() of " + getClass());
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("Error in destroy() of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");

			User user = userDao.authenticateUser(email, pwd);

			if (user == null)
				pw.print("<h4> Invalid Login ...! Please <a href='login.html'>Retry</a> ...!</h4>");
			else {
				pw.print("<h4>Successful Login, User Details: " + user + "</h4>");
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
