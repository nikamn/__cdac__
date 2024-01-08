package beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import impl.TeamDaoImpl;
import pojos.Team;

public class TeamBean implements Serializable {

	private static final long serialVersionUID = -3964943922825110737L;

	private TeamDaoImpl tDao;
	private Team team;

	private String name;
	private String abbr;
	private String owner;
	private String maxAge;
	private String minBattingAvg;
	private String minWicketsTaken;

	// default constructor
	public TeamBean() {
		System.out.println("In default constructor of " + getClass());
		tDao = new TeamDaoImpl();
	}

	// getters/setters
	public TeamDaoImpl gettDao() {
		return tDao;
	}

	public void settDao(TeamDaoImpl tDao) {
		this.tDao = tDao;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	public String getMinBattingAvg() {
		return minBattingAvg;
	}

	public void setMinBattingAvg(String minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}

	public String getMinWicketsTaken() {
		return minWicketsTaken;
	}

	public void setMinWicketsTaken(String minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}

	// toString
	@Override
	public String toString() {
		return "TeamBean [name=" + name + ", abbr=" + abbr + ", owner=" + owner + ", maxAge=" + maxAge
				+ ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken + "]";
	}

	// dao method callers
	public List<Team> getAllTeams() {
		return tDao.getAllTeams();
	}

	public String addNewTeam() throws SQLException {
		Team newTeam = new Team(name, abbr, owner, Integer.parseInt(maxAge), Double.parseDouble(minBattingAvg),
				Integer.parseInt(minWicketsTaken));
		return tDao.addNewTeam(newTeam);
	}

	public String removeTeam() {
		System.out.println(abbr + "Hello");
		return tDao.removeTeam(abbr);
	}
}
