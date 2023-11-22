package tester;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStatement {

	public static void main(String[] args) {
		try (
				Connection conn = openConnection();
				Statement st = conn.createStatement();
				ResultSet rst = st.executeQuery("select * from users order by dob desc");) {
			while (rst.next())
				System.out.println("User id " + rst.getInt(1) + ", last name "
						+ rst.getString(3) + ", email " + rst.getString(4) + ", DoB "
						+ rst.getDate(6) + ", voting status " + rst.getBoolean(7));

		} // JVM: rst.close(), st.close(), conn.close()
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
