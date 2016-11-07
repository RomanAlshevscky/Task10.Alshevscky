package by.epam.training.dao.factory;

import by.epam.training.dao.LikeItDAO;
import by.epam.training.dao.impl.MySqlLikeItDAO;

public class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();
	
	private LikeItDAO likeItDao = new MySqlLikeItDAO();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		return INSTANCE;
	}
	
	public LikeItDAO getLikeItDAO(){
		return likeItDao;
	}
}
