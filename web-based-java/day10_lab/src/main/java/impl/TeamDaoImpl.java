package impl;

import static utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.TeamDao;
import pojos.Player;
import pojos.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<String> getTeamsAbbreviations() {
		List<String> abbrvList = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		String jpql = "select t.abbreviation from Team t";

		try {
			abbrvList = session.createQuery(jpql, String.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}

		return abbrvList;
	}

	@Override
	public Team getTeamDetailsByAbbr(String abbreviation) {

		Team team = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		String jpql = "select t from Team t where t.abbreviation=:abrv";

		try {
			team = session.createQuery(jpql, Team.class).setParameter("abrv", abbreviation).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}

		return team;
	}

	@Override
	public List<Player> getAllPlayerByTeam(Integer teamId) {
		List<Player> allPlayerList = new ArrayList<Player>();

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		String jpql = "select p from Player p where p.team=:team";

		try {
			Team team = session.get(Team.class, teamId);

			if (team != null) {
				allPlayerList = session.createQuery(jpql, Player.class).setParameter("team", team).getResultList();
			}
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}

		return allPlayerList;
	}

	@Override
	public List<Team> getAllTeams() {
		List<Team> teams = new ArrayList<Team>();

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		String jpql = "select t from Team t";

		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}

		return teams;
	}

	@Override
	public Team getTeamDetailsById(int teamId) {
		Team team = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		String jpql = "select t from Team t where t.id=:tId";

		try {
			team = session.createQuery(jpql, Team.class).setParameter("tId", teamId).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}

		return team;
	}

	@Override
	public String addNewTeam(Team newTeam) {
		String mesg = "Could not add new team";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.persist(newTeam);
			tx.commit();
			mesg = "Added team successfully\nTeam details: " + newTeam;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String removeTeam(String abbr) {
		String mesg = "Could not delete team";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			String jpql = "select t from Team t where t.abbreviation=:tabbr";
			Team team = session.createQuery(jpql, Team.class).setParameter("tabbr", abbr).getSingleResult();

			team.getPlayerList().size();
			session.delete(team);
			tx.commit();
			mesg = "Deleted team successfully";
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}

		return mesg;
	}

}
