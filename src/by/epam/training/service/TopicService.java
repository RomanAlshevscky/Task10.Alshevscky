package by.epam.training.service;

import java.util.List;

import by.epam.training.bean.entity.TopicEntity;
import by.epam.training.service.exception.ServiceException;

public interface TopicService {

	List<TopicEntity> getLastTopics(int count) throws ServiceException;
	
}
