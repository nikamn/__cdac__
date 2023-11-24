package pojos;

import java.sql.Date;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date dob;
	private boolean votingStatus;
	private String role;

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param dob
	 * @param votingStatus
	 */
	public User(String firstName, String lastName, Date dob, boolean votingStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.votingStatus = votingStatus;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param dob
	 */
	public User(String firstName, String lastName, String email, String password, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

	/**
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param dob
	 * @param votingStatus
	 * @param role
	 */
	public User(int userId, String firstName, String lastName, String email, String password, Date dob,
			boolean votingStatus, String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.votingStatus = votingStatus;
		this.role = role;
	}

	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the votingStatus
	 */
	public boolean isVotingStatus() {
		return votingStatus;
	}

	/**
	 * @param votingStatus the votingStatus to set
	 */
	public void setVotingStatus(boolean votingStatus) {
		this.votingStatus = votingStatus;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "User \n[\n\tuserId=" + userId + ", \n\tfirstName=" + firstName + ", \n\tlastName=" + lastName
				+ ", \n\temail=" + email + ", \n\tdob=" + dob + ", \n\tvotingStatus=" + votingStatus + ", \n\trole="
				+ role + "\n]";
	}

	

}
