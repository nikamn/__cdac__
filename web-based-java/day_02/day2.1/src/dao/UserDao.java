package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import pojos.User;

/**
 * @author nishant
 *
 */
public interface UserDao {

	List<User> getAllUsers() throws SQLException;

	List<User> getSelectedUsers(String role, Date begin, Date end) throws SQLException;

	User authenticateUser(String email, String password) throws SQLException;

	String registerNewVoter(User user) throws SQLException;

	String castVote(int userId, Scanner scanner) throws SQLException;

	String deleteUserDetails(int userId) throws SQLException;

}
