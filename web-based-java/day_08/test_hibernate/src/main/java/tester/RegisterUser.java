package tester;

import static utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDao;
import dao.UserDaoImpl;
import pojos.User;

public class RegisterUser {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate up n running : " + sf);

			System.out.println("Enter user details : firstName,  lastName,  email,  password,  dob(yyyy-mm-dd)");
			// create dao instance and call method
			UserDao dao = new UserDaoImpl();
			User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()));
			user.setRole("voter");
			System.out.println(dao.registerUser(user));
		} // JVM : sf.close() ---> DBCP(db conn pool) cleaned up ...!
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
