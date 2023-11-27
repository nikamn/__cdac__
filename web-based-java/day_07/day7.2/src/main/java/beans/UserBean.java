package beans;

import java.sql.SQLException;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
	private UserDaoImpl userDao; // dependency
	private User userDetails; // result

	// client info
	private String email;
	private String pass;

	// default constructor
	public UserBean() throws SQLException {
		// create user dao instance
		userDao = new UserDaoImpl();
		System.out.println("user bean created...");
	}

	// getters/setters
	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// business logic to authenticate user
	public String authenticateUser() throws SQLException {
		userDetails = userDao.authenticateUser(email, pass);
		if (userDetails == null)
			return "login";
		if (userDetails.getRole().equals("admin"))
			return "admin_page";
		if (userDetails.isVotingStatus())
			return "logout";
		return "candidate_list";
	}

}
