package Tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import impl.TeamDaoImpl;
import pojos.Team;

public class TestAddNewTeam {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sessionFactory = getFactory()) {
			TeamDao tDao = new TeamDaoImpl();

			System.out.println(
					"Enter team details: name, abbreviation, owner, max_age, min_batting_avg, min_wickets_taken");

			System.out.println(tDao.addNewTeam(
					new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
