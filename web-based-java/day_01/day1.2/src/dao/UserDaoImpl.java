package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.User;

import static utils.DBUtils.*;

public class UserDaoImpl implements UserDao {

	// state (fields)
	private Connection connection;
	private PreparedStatement pst1;

	// default constructor
	public UserDaoImpl() throws SQLException {
		// get connection from dbUtils
		connection = openConnection();
		pst1 = connection.prepareStatement("select * from users where role=? and dob between ? and ?");
		System.out.println("user dao created ...!");
	}

	@Override
	public List<User> getSelectedUsers(String role, Date begin, Date end) throws SQLException {
		// set IN parameters
		pst1.setString(1, role);
		pst1.setDate(2, begin);
		pst1.setDate(3, end);

		// execute query : execQuery() --- ResultSet
		List<User> users = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				users.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getDate(6), rst.getBoolean(7), rst.getString(8)));
		}
		return users; // DAO returns populated list of users to tester.
	}

	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("user dao cleaned up ...!");
	}

}
