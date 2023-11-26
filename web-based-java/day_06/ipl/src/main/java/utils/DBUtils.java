package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;

	public static Connection openConnection() throws SQLException {
		cn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/advjava?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
		return cn;
	}

	public static void closeConnection() throws SQLException {
		if (cn != null)
			cn.close();
	}

	public static Connection getCn() {
		return cn;
	}
}
