package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pojos.User;

public interface UserDao {
	List<User> getSelectedUsers(String role,Date begin,Date end)
			throws SQLException;
}
