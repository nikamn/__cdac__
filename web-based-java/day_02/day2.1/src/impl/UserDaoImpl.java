package impl;

import static utils.DBUtils.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.UserDao;
import pojos.User;
import queries.SQLQueries;

public class UserDaoImpl implements UserDao {

	private Connection connection;
	private PreparedStatement pst;

	// constructor
	public UserDaoImpl() throws SQLException {
		connection = openConnection();
		System.out.println("user dao created ...!");
	}

	// get all users
	@Override
	public List<User> getAllUsers() throws SQLException {
		pst = connection.prepareStatement(SQLQueries.getAllU);

		List<User> users = new ArrayList<>();
		try (ResultSet rst = pst.executeQuery()) {
			while (rst.next())
				users.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getDate(6), rst.getBoolean(7), rst.getString(8)));
		}
		return users;
	}

	// get selected users using role, begin date and end date
	@Override
	public List<User> getSelectedUsers(String role, Date begin, Date end) throws SQLException {
		pst = connection.prepareStatement(SQLQueries.getSelectedU);
		pst.setString(1, role);
		pst.setDate(2, begin);
		pst.setDate(3, end);

		List<User> users = new ArrayList<>();
		try (ResultSet rst = pst.executeQuery()) {
			while (rst.next())
				users.add(new User(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getBoolean(4)));
		}
		return users;
	}

	// register new voter
	@Override
	public String registerNewVoter(User newVoter) throws SQLException {
		pst = connection.prepareStatement(SQLQueries.insertU);

		pst.setString(1, newVoter.getFirstName());
		pst.setString(2, newVoter.getLastName());
		pst.setString(3, newVoter.getEmail());
		pst.setString(4, newVoter.getPassword());
		pst.setDate(5, newVoter.getDob());
		pst.setBoolean(6, false);
		pst.setString(7, "voter");

		int rowCount = pst.executeUpdate();
		if (rowCount == 1)
			return "Voter registered successfully ...!";
		return "Voter registration failed ...!";
	}

	// cast vote by user id
	@Override
	public String castVote(int userId, Scanner scanner) throws SQLException {
		pst = connection.prepareStatement(SQLQueries.getVotingStatus);
		pst.setInt(1, userId);

		try (ResultSet rst = pst.executeQuery()) {
			if (rst.next()) {
				if (rst.getBoolean(1)) {
					return "User has already voted";
				}

				CandidateDaoImpl cDao = new CandidateDaoImpl();
				cDao.getAllCAndidates().forEach(System.out::println);
				System.out.println("Select candidate id you want to vote");
				int candidateId = scanner.nextInt();

				System.out.println(cDao.updateVotesCount(candidateId));

				pst = connection.prepareStatement(SQLQueries.updateVotingStatus);
				pst.setInt(1, userId);
				int rowCount = pst.executeUpdate();
				if (rowCount == 1)
					return "Voter's voting status updated successfully ...!";
				return "Voter's voting status updation failed ...!";
			}

		}

		return "User voted successfully";
	}

	// delete user
	@Override
	public String deleteUserDetails(int userId) throws SQLException {
		pst = connection.prepareStatement(SQLQueries.deleteU);

		pst.setInt(1, userId);
		int rowCount = pst.executeUpdate();
		if (rowCount == 1)
			return "Voter deleted successfully ...!";
		return "Voter deletion failed ...!";

	}

	// authenticate user
	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		pst = connection.prepareStatement(SQLQueries.searchU);

		pst.setString(1, email);
		pst.setString(2, password);

		try (ResultSet rst = pst.executeQuery()) {
			if (rst.next())
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
		}

		return null;

	}

	// clean up
	public void cleanUp() throws SQLException {
		if (pst != null)
			pst.close();
		System.out.println("user dao cleaned up !");
	}

}
