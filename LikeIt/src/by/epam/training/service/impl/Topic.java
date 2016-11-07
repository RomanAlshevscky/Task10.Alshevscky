package by.epam.training.service.impl;

import java.util.LinkedList;
import java.util.List;

import by.epam.training.bean.entity.TopicEntity;
import by.epam.training.dao.LikeItDAO;
import by.epam.training.dao.exception.DAOException;
import by.epam.training.dao.factory.DAOFactory;
import by.epam.training.service.TopicService;
import by.epam.training.service.exception.ServiceException;

public class Topic implements TopicService {

	@Override
	public List<TopicEntity> getLastTopics(int count) throws ServiceException {
		if(count <= 0){
			return new LinkedList<TopicEntity>();
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		LikeItDAO dao = factory.getLikeItDAO();
		
		try {
			return dao.getLastTopics(count);
		} catch (DAOException ex) {
			throw new ServiceException(ex);
		}
	}


}
