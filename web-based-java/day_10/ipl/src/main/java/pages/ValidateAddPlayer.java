package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

@WebServlet(value = "/add_player")
public class ValidateAddPlayer extends HttpServlet {
	private static final long serialVersionUID = -6187367066655633175L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();

			TeamDaoImpl teamDao = (TeamDaoImpl) session.getAttribute("team_dao");
			PlayerDaoImpl playerDao = (PlayerDaoImpl) session.getAttribute("player_dao");

			if (teamDao != null) {
				String abbr = request.getParameter("abbrevation");
				Team team = teamDao.getTeamDetails(abbr);

				String playerName = request.getParameter("nm");
				String lastName = request.getParameter("lnm");
				String date = request.getParameter("dob");
				LocalDate dob = LocalDate.parse(date);
				double battingAvg = Double.parseDouble(request.getParameter("avg"));
				int wicketsTaken = Integer.parseInt(request.getParameter("wickets"));

				int age = Period.between(dob, LocalDate.now()).getYears();
				if (age < team.getMaxAge() && battingAvg > team.getMinBattingAvg()
						&& wicketsTaken > team.getMinWicketsTaken()) {
					Player player = new Player(playerName, lastName, Date.valueOf(dob), battingAvg, wicketsTaken);
					pw.print("<h3> Status " + playerDao.addPlayerToTeam(player, team.getTeamId()) + "</h3>");
				} else
					pw.print("<h3 style color='red;'> Can't add player details , Invalid I/ps</h3>");
			} else
				pw.print("<h5> No Cookies ...! Can't continue ...!</h5>");
			// session.invalidate();
		} catch (Exception e) {
			throw new ServletException("err in doGet() of " + getClass(), e);
		}
	}

}
