package Tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.PlayerDao;
import impl.PlayerDaoImpl;

public class TestRemovePlayerFromTeam {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sessionFactory = getFactory()) {
			PlayerDao pDao = new PlayerDaoImpl();

			System.out.println("Enter playerId, teamId :");

			System.out.println(pDao.removePlayerFromTeam(sc.nextInt(), sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
