package dao;

import java.sql.SQLException;

import pojos.Player;

public interface PlayerDao {
	String addPlayerToTeam(Player newPlayer,int teamId) throws SQLException;
}
