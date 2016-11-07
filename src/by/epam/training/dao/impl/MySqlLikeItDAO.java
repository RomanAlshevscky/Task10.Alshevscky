package by.epam.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.bean.entity.TopicEntity;
import by.epam.training.command.impl.CreateAccount;
import by.epam.training.dao.LikeItDAO;
import by.epam.training.dao.dbpool.DBPool;
import by.epam.training.dao.exception.DAOException;

public class MySqlLikeItDAO implements LikeItDAO {

	private static final Logger logger = LogManager.getLogger(MySqlLikeItDAO.class);
	private DBPool dbPool;
	private final String LOGIN_STATEMENT = "SELECT username FROM user WHERE username=? AND password=? ";
	private final String CREATE_ACCOUNT_STATEMENT = "INSERT INTO user (username, password) VALUES (?, ?);";
	private final String RETURN_LAST_TOPICS = "SELECT header, context FROM topic LIMIT ?;";
	public MySqlLikeItDAO(){
		try {
			dbPool = new DBPool();
		} catch (ClassNotFoundException ex){
			logger.error(ex);
		}
	}

	@Override
	public boolean login(String username, String userPasswordHash) throws DAOException {
		try{
			Connection connection = dbPool.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(LOGIN_STATEMENT);
			ps.setString(1, username);
			ps.setString(2, userPasswordHash);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex){
			throw new DAOException(ex);
		}
	}

	@Override
	public boolean createAccount(String username, String userPasswordHash) throws DAOException {
		try{
			Connection connection = dbPool.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(CREATE_ACCOUNT_STATEMENT);
			ps.setString(1, username);
			ps.setString(2, userPasswordHash);
			
			int r = ps.executeUpdate();
			if (r!= 0){
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException ex){
			throw new DAOException(ex);
		}
	}

	@Override
	public List<TopicEntity> getLastTopics(int count) throws DAOException {
		LinkedList<TopicEntity> result = new LinkedList<>();
		try{
			Connection connection = dbPool.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(RETURN_LAST_TOPICS);
			ps.setInt(1, count);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				result.add(new TopicEntity(rs.getString("header"), rs.getString("context")));
			}
			
		} catch (SQLException ex){
			throw new DAOException(ex);
		}
		return result;
	}

}
