package omss.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String JDBC_CONNECTION ="jdbc:mysql://localhost/omss";
	public static final String JDBC_USER = "root";
	public static final String JDBC_PASSWORD = "root";
	
	public static Connection getJDBC_connection() {

		Connection connection = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(JDBC_CONNECTION, JDBC_USER,JDBC_PASSWORD);
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Date Base JDBC Sql Error:"+e.getMessage());
		}

		return connection;
	}
}
