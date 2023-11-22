package utils;

import java.sql.*;

public class DBUtils {
	private static Connection connection;

	public static Connection openConnection() throws SQLException {

		connection = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/advjava?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
		return connection;
	}

}
