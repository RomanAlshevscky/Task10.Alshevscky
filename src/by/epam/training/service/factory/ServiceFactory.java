package by.epam.training.service.factory;

import by.epam.training.service.AccountService;
import by.epam.training.service.TopicService;
import by.epam.training.service.impl.Account;
import by.epam.training.service.impl.Topic;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private AccountService accountService = new Account();
	private TopicService topicService = new Topic();
	
	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public AccountService getAccountService() {
		return accountService;
	}

	public TopicService getTopicService() {
		return topicService;
	}

}
