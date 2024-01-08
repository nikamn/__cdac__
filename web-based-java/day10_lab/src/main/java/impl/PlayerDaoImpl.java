package impl;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.PlayerDao;
import pojos.Player;
import pojos.Team;

import static utils.HibernateUtils.getFactory;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayerToTeam(Player newPlayer, Integer teamId) throws SQLException {
		String mesg = "Adding new player failed ...!";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			Team team = session.get(Team.class, teamId);

			if (team != null) {
				team.addPlayer(newPlayer);
				session.persist(newPlayer);
			}
			tx.commit();
			mesg = "Added a new player: " + newPlayer.getFirstName() + " to team: " + teamId;
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String removePlayerFromTeam(Integer playerId, Integer teamId) {

		String msg = "Player removal failed! from given team";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			Team team = session.get(Team.class, teamId);
			Player player = session.get(Player.class, playerId);

			team.removePlayer(player);
			tx.commit();
			msg = "Player " + player.getFirstName() + " removed successfully from team " + team.getName();

		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}

		return msg;
	}
}
