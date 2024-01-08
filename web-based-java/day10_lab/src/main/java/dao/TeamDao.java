package dao;

import java.util.List;

import pojos.Player;
import pojos.Team;

public interface TeamDao {
	List<String> getTeamsAbbreviations();

	Team getTeamDetailsByAbbr(String abbreviation);

	List<Player> getAllPlayerByTeam(Integer teamId);

	List<Team> getAllTeams();

	Team getTeamDetailsById(int teamId);
	
	String addNewTeam(Team newTeam);

	String removeTeam(String abbr);
}
