package queries;

public class SQLQueries {

	public static String getAllU = "select * from users";
	public static String insertU = "insert into users values(default,?,?,?,?,?,?,?)";
	public static String getSelectedU = "select first_name,last_name,dob,status from users where role=? and dob between ? and ?";
	public static String deleteU = "delete from users where id=?";
	public static String searchU = "select * from users where email=? and password=?";
	public static String getVotingStatus = "select status from users where id=?";
	public static String updateVotingStatus = "update users set status=1 where id=?";

	public static String getAllC = "Select * from candidates";
	public static String insertC = "insert into candidates values(default,?,?,?)";
	public static String deleteC = "delete from candidates where id=?";
	public static String updateVotesCount = "update candidates set votes=votes+1 where id=?";

}
