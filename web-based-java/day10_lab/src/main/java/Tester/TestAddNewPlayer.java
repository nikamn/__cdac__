package Tester;

import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.SessionFactory;

import dao.PlayerDao;
import impl.PlayerDaoImpl;
import pojos.Player;

import static utils.HibernateUtils.getFactory;

public class TestAddNewPlayer {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sessionFactory = getFactory()) {
			PlayerDao pDao = new PlayerDaoImpl();

			System.out.println("Enter player details : first_name, last_name, dob, batting_avg, wickets_taken");
			Player newPlayer = new Player(sc.next(), sc.next(), LocalDate.parse(sc.next()), sc.nextDouble(),
					sc.nextInt());

			System.out.println("Enter team id");
			System.out.println(pDao.addPlayerToTeam(newPlayer, sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
