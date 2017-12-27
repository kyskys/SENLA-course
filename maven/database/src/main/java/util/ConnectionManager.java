package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection connection;

	public static PreparedStatement getStatement(String query) {
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			System.out.println("getting statement failed");
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet executeTransaction(PreparedStatement state) {
		try {
			connection.setAutoCommit(false);
			state.executeUpdate();
			connection.commit();
			return 	state.getResultSet();
		} catch (SQLException e) {
			try {
				System.out.println("Transaction failed");
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Rollback failed");
			}
		}
		return null;
	}

	public static void setConnection(Connection con) {
		connection = con;
	}
}
