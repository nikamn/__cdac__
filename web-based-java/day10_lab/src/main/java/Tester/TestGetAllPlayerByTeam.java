package Tester;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import impl.TeamDaoImpl;
import pojos.Player;

import static utils.HibernateUtils.*;

public class TestGetAllPlayerByTeam {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			TeamDao tDao = new TeamDaoImpl();

			System.out.println("Enter team id :");

			List<Player> playerListByTeam = tDao.getAllPlayerByTeam(sc.nextInt());
			playerListByTeam.forEach(i -> System.out.println(i));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
