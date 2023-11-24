/**
 * 
 */
package tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.CandidateDao;
import impl.CandidateDaoImpl;
import impl.UserDaoImpl;
import pojos.Candidate;
import pojos.User;
import utils.DBUtils;

/**
 * @author nishant
 *
 */
public class TestVotingApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean exitFlag = false;
		int choice = 0;
		UserDaoImpl userDao = null;
		CandidateDao candidateDao = null;

		try {
			userDao = new UserDaoImpl();
			candidateDao = new CandidateDaoImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);

		do {
			try {
				menu();
				System.out.println("Enter choice");
				choice = scanner.nextInt();

				switch (choice) {
					case 1:
						List<User> allUsers = userDao.getAllUsers();
						System.out.println("All Users ");
						allUsers.forEach(System.out::println);
						break;

					case 2:
						System.out.println("Enter role, begin date and end date");
						List<User> users = userDao.getSelectedUsers(scanner.next(), Date.valueOf(scanner.next()),
								Date.valueOf(scanner.next()));
						System.out.println("Selected Users ");
						users.forEach(System.out::println);
						break;

					case 3:
						System.out.println("Enter email and password");
						User user = userDao.authenticateUser(scanner.next(), scanner.next());
						if (user == null) {
							System.out.println("Authentication Failed ...!");
						} else {
							System.out.println(user);
						}
						break;

					case 4:
						System.out.println("Enter new voter details");
						System.out.println("first_name, last_name, email, password, dob");
						System.out.println(
								userDao.registerNewVoter(new User(scanner.next(), scanner.next(), scanner.next(),
										scanner.next(), Date.valueOf(scanner.next()))));
						break;

					case 5:
						System.out.println("Enter user id to cast vote");
						System.out.println(userDao.castVote(scanner.nextInt(), scanner));
						break;

					case 6:
						System.out.println("Enter user id to delete details");
						System.out.println(userDao.deleteUserDetails(scanner.nextInt()));
						break;

					case 7:
						List<Candidate> allCandidates = candidateDao.getAllCAndidates();
						System.out.println("All Candidates ");
						allCandidates.forEach(System.out::println);
						break;

					case 8:
						System.out.println("Enter new candidate details");
						System.out.println("name, party");
						System.out.println(candidateDao.addNewCandidate(new Candidate(scanner.next(), scanner.next())));
						break;

					case 0:
						if (userDao != null)
							userDao.cleanUp();
						if (candidateDao != null)
							candidateDao.cleanUp();
						DBUtils.closeConnection();
						System.out.println("... Exiting TestVotingApplication ...!");
						exitFlag = true;
						break;

					default:
						System.out.println("Invalid choice! Try Again");
						break;
				}

			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
				e.printStackTrace();
			}

		} while (!exitFlag);

		scanner.close();
	}

	private static void menu() {

		System.out.println("------------------------- MENU ------------------------");
		System.out.println("1. List all users");
		System.out.println("2. List selected users");
		System.out.println("3. Authenticate user");
		System.out.println("4. Add new voter");
		System.out.println("5. Cast vote");
		System.out.println("6. Delete user by id");
		System.out.println("7. List all candidates");
		System.out.println("8. Add new candidate");
		System.out.println("0. Exit");

	}

}
