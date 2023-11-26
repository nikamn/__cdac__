package dao;

import java.sql.SQLException;
import java.util.List;
import pojos.Team;

public interface TeamDao {
	List<String> getTeamsAbbreviations() throws SQLException;

	Team getTeamDetails(String abbreviation) throws SQLException;
}
