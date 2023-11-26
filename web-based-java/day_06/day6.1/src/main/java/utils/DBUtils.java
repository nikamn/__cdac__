package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;

	public static Connection openConnection(String url, String userName, String pwd) throws SQLException {
		cn = DriverManager.getConnection(url, userName, pwd);
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
