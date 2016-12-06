package by.epam.training.dao.dbpool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DBPool {

	private static final BasicDataSource dataSource;
	private static final String driverClassName;
	private static final String url;
	private static final String user;
	private static final String password;
	private static final int maxActiveConnections;
	private static final int initConnections;

	static {
		dataSource = new BasicDataSource();// пул соединений пишем своими руками
		// и слушаем задания до конца
		driverClassName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/LikeItTEST";
		user = "root";
		password = "7S8d4R5M}{";
		initConnections = 10;
		maxActiveConnections = 10;
	}

	public DBPool() throws ClassNotFoundException {

		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		dataSource.setInitialSize(initConnections);
		dataSource.setMaxIdle(maxActiveConnections);
		
	}

	public  Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public void putConnection(Connection connection) throws SQLException {
		connection.close();
	}
}
