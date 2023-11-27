package beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
	private UserDaoImpl userDao;
	private User userDetails;

	private String email;
	private String pass;
	private String fname;
	private String lname;
	private String dob;

	private String message;

	public UserBean() throws SQLException {
		userDao = new UserDaoImpl();
		System.out.println("user bean created...");
	}

	// generate getter n setter
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMessage() {
		return message;
	}

	public String authenticateUser() throws SQLException {
		userDetails = userDao.authenticateUser(email, pass);
		if (userDetails == null) {
			message = "Invalid login, please retry ...!";
			return "login";
		}
		message = "successful login ...!";
		if (userDetails.getRole().equals("admin"))
			return "admin_page";
		if (userDetails.isVotingStatus())
			return "logout";
		return "candidate_list";
	}

	public String registerNewVoter() throws SQLException {
		LocalDate date = LocalDate.parse(dob);
		int age = Period.between(date, LocalDate.now()).getYears();
		if (age >= 21) {
			User user = new User(fname, lname, email, pass, Date.valueOf(date));
			user.setRole("voter");
			return userDao.registerNewVoter(user);
		} else
			return "Voter registration failed : Invalid age ...!";
	}
}
