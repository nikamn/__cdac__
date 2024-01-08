package beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import impl.PlayerDaoImpl;
import impl.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

public class PlayerBean implements Serializable {

	private static final long serialVersionUID = -4296910163855717965L;

	private PlayerDaoImpl pDao;
	private TeamDaoImpl tDao;
	private Player p;

	private String teamId;
	private String firstName;
	private String lastName;
	private String dob;
	private String batting_avg;
	private String wickets_taken;

	// default constructor
	public PlayerBean() {
		System.out.println("In default constructor of " + getClass());
		pDao = new PlayerDaoImpl();
		tDao = new TeamDaoImpl();
	}

	// getters/setters
	public PlayerDaoImpl getpDao() {
		return pDao;
	}

	public void setpDao(PlayerDaoImpl pDao) {
		this.pDao = pDao;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBatting_avg() {
		return batting_avg;
	}

	public void setBatting_avg(String batting_avg) {
		this.batting_avg = batting_avg;
	}

	public String getWickets_taken() {
		return wickets_taken;
	}

	public void setWickets_taken(String wickets_taken) {
		this.wickets_taken = wickets_taken;
	}

	// toString
	@Override
	public String toString() {
		return "PlayerBean [teamId=" + teamId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", batting_avg=" + batting_avg + ", wickets_taken=" + wickets_taken + "]";
	}

	// dao method callers
	public String addPlayerToTeam() throws SQLException {
		Team team = tDao.getTeamDetailsById(Integer.parseInt(teamId));

		int age = Period.between(LocalDate.parse(dob), LocalDate.now()).getYears();
		if (team.getMaxAge() < age) {
			return "Players age do not match team requirements ...!";
		} else {
			double bAvg = Double.parseDouble(batting_avg);
			if (team.getMinBattingAvg() > bAvg) {
				return "Players batting average do not match team requirements ...!";
			} else {
				int wTaken = Integer.parseInt(wickets_taken);
				if (team.getMinWicketsTaken() > wTaken) {
					return "Players wickets taken do not match team requirements ...!";
				} else {
					return pDao.addPlayerToTeam(new Player(firstName, lastName, LocalDate.parse(dob), bAvg, wTaken),
							team.getId());
				}
			}
		}
	}
}
