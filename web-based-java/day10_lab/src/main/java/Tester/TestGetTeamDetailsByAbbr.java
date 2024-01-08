package Tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import impl.TeamDaoImpl;

public class TestGetTeamDetailsByAbbr {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sessionFactory = getFactory()) {
			TeamDao tDao = new TeamDaoImpl();

			System.out.println("Enter team abbr: ");

			System.out.println(tDao.getTeamDetailsByAbbr(sc.next()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
