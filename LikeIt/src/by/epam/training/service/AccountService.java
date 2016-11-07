package by.epam.training.service;

import by.epam.training.service.exception.ServiceException;

public interface AccountService {

	boolean doLogin(String userLogin, String userPasswordHash) throws ServiceException;
    boolean create(String userLogin, String userPasswordHash) throws ServiceException;
	
}
