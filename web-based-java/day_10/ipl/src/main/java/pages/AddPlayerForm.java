package pages;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;

@WebServlet(value = "/add_player_form", loadOnStartup = 1)
public class AddPlayerForm extends HttpServlet {
	private static final long serialVersionUID = 7975858053820534234L;
	
	private TeamDaoImpl teamDao;
	private PlayerDaoImpl playerDao;

	public void init() throws ServletException {
		try {
			openConnection();
			teamDao = new TeamDaoImpl();
			playerDao = new PlayerDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init() of " + getClass(), e);
		}
	}

	public void destroy() {
		try {
			teamDao.cleanUp();
			playerDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			System.out.println("err in destroy() of " + getClass() + " " + e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();

			session.setAttribute("player_dao", playerDao);
			session.setAttribute("team_dao", teamDao);

			List<String> teamsAbbreviations = teamDao.getTeamsAbbreviations();

			pw.print("<form method='post' action='add_player'>");
			pw.print("<h5> Choose a Team : <select name='abbrevation'>");

			for (String s : teamsAbbreviations)
				pw.print("<h5><option value='" + s + "'</option>" + s + "</h5>");

			pw.print("</h5> </select>");
			pw.print("<h5>Player First Name <input type='text' name='nm'/></h5>");
			pw.print("<h5>Player Last Name <input type='text' name='lnm'/></h5>");

			pw.print("<h5>DoB <input type='date' name='dob'/></h5>");
			pw.print("<h5>Batting Avg <input type='number' name='avg'/></h5>");
			pw.print("<h5>Wickets Taken <input type='text' name='wickets'/></h5>");
			pw.print("<h5><input type='submit' value='Add New Player'/></h5>");
			pw.print("</form>");
		} catch (Exception e) {
			throw new ServletException("err in doGet() of " + getClass(), e);
		}
	}

}
