package by.epam.training.dao;

import java.util.List;

import by.epam.training.bean.entity.TopicEntity;
import by.epam.training.dao.exception.DAOException;

public interface LikeItDAO {
	
	boolean login(String userName, String userPasswordHash) throws DAOException;
	boolean createAccount(String userName, String userPasswordHash) throws DAOException;
	List<TopicEntity> getLastTopics(int count) throws DAOException;
}
