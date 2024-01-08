package dao;

import java.sql.SQLException;

import pojos.Player;

public interface PlayerDao {
	String addPlayerToTeam(Player newPlayer, Integer teamId) throws SQLException;

	String removePlayerFromTeam(Integer playerId, Integer teamId);
}
