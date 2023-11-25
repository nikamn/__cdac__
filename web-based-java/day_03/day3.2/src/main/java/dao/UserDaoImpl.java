package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;

import pojos.User;

public class UserDaoImpl implements UserDao {

	private Connection connection;
	private PreparedStatement pst1, pst2, pst3, pst4;

	public UserDaoImpl() throws SQLException {
		connection = openConnection();

		pst1 = connection.prepareStatement(
				"select first_name,last_name,dob,status from users where role=? and dob between ? and ?");
		pst2 = connection.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		pst3 = connection.prepareStatement("delete from users where id=?");
		pst4 = connection.prepareStatement("select * from users where email=? and password=?");

		System.out.println("UserDao created ...!");
	}

	@Override
	public List<User> getSelectedUsers(String role, Date begin, Date end) throws SQLException {
		pst1.setString(1, role);
		pst1.setDate(2, begin);
		pst1.setDate(3, end);

		List<User> users = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				users.add(new User(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getBoolean(4)));
		}
		return users;
	}

	@Override
	public String registerNewVoter(User newVoter) throws SQLException {
		pst2.setString(1, newVoter.getFirstName());
		pst2.setString(2, newVoter.getLastName());
		pst2.setString(3, newVoter.getEmail());
		pst2.setString(4, newVoter.getPassword());
		pst2.setDate(5, newVoter.getDob());
		pst2.setBoolean(6, false);
		pst2.setString(7, "voter");

		int rowCount = pst2.executeUpdate();
		if (rowCount == 1)
			return "Voter registered ...!";
		return "Voter registration failed ...!";
	}

	@Override
	public String deleteUserDetails(int userId) throws SQLException {
		pst3.setInt(1, userId);
		int rowCount = pst3.executeUpdate();
		if (rowCount == 1)
			return "Voter deleted ...!";
		return "Voter deletion failed ...!";

	}

	@Override
	public User authenticateUser(String email, String pwd) throws SQLException {
		pst4.setString(1, email);
		pst4.setString(2, pwd);

		try (ResultSet rst = pst4.executeQuery()) {
			if (rst.next())
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, rst.getDate(6),
						rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}

	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		closeConnection();
		System.out.println("UserDao cleaned up !");
	}

}
