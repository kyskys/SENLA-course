package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import annotation.ConfigProperty;
import util.AnnotationHandler;

public class DBConnector {
	private Connection connection = null;
	@ConfigProperty(configName = "config.properties", propertyName = "DBConnector.user", type = String.class)
	private String user;
	@ConfigProperty(configName = "config.properties", propertyName = "DBConnector.password", type = String.class)
	private String password;
	@ConfigProperty(configName = "config.properties", propertyName = "DBConnector.url", type = String.class)
	private String url;

	public DBConnector() {
		AnnotationHandler.configure(this);
	}

	public void init() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		connection = DriverManager.getConnection(url, user, password);
		connection.setSchema("auto_service_db");
	}

	public Connection getConnection() {
		return connection;
	}
}
