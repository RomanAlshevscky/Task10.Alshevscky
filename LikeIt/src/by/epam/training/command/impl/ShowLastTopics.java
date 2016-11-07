package by.epam.training.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.bean.entity.TopicEntity;
import by.epam.training.command.Command;
import by.epam.training.service.TopicService;
import by.epam.training.service.exception.ServiceException;
import by.epam.training.service.factory.ServiceFactory;

public class ShowLastTopics implements Command {
	private static final Logger logger = LogManager.getLogger(RedirectToSignIn.class);

	private final int TOPIC_TO_SHOW_COUNT = 5;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		logger.debug("Get last topics.");
	
		ServiceFactory factory = ServiceFactory.getInstance();
		TopicService topic = factory.getTopicService();
		
		try{
			List<TopicEntity> result = topic.getLastTopics(TOPIC_TO_SHOW_COUNT);
			request.setAttribute("topics", result);
			request.getRequestDispatcher("topics").include(request, response);
			logger.debug("lastTopics attribute set");
		} catch(ServiceException se){
			logger.error(se);
		}
	}
}
