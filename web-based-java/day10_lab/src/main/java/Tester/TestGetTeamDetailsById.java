package Tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import impl.TeamDaoImpl;

public class TestGetTeamDetailsById {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sessionFactory = getFactory()) {
			TeamDao tDao = new TeamDaoImpl();

			System.out.println("Enter team id: ");

			System.out.println(tDao.getTeamDetailsById(sc.nextInt()));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
