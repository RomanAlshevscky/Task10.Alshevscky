package by.epam.training.service.impl;

import by.epam.training.dao.LikeItDAO;
import by.epam.training.dao.exception.DAOException;
import by.epam.training.dao.factory.DAOFactory;
import by.epam.training.service.AccountService;
import by.epam.training.service.exception.ServiceException;

public class Account implements AccountService {

	@Override
	public boolean doLogin(String username, String userPasswordHash) throws ServiceException {
		if (!checkUsername(username) && !checkUserPasswordHash(userPasswordHash)) {
			return false;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		LikeItDAO dao = factory.getLikeItDAO();
		
		try {
			return dao.login(username, userPasswordHash);
		} catch (DAOException ex) {
			throw new ServiceException(ex);
		}
	}

	@Override
	public boolean create(String username, String userPasswordHash) throws ServiceException {
		if (!checkUsername(username) && !checkUserPasswordHash(userPasswordHash)) {
			return false;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		LikeItDAO dao = factory.getLikeItDAO();
		
		try {
			return dao.createAccount(username, userPasswordHash);
		} catch (DAOException ex) {
			throw new ServiceException(ex);
		}
	}
	
	private boolean checkUsername(String username) throws ServiceException{
		if(username == null){
			throw new ServiceException();
		}
		
		if(username == ""){
			return false;
		}
		return true;
	}

	private boolean checkUserPasswordHash(String userPasswordHash) throws ServiceException{
		if(userPasswordHash == null){
			throw new ServiceException();
		}
		
		if(userPasswordHash == ""){
			return false;
		}
		return true;
		
	}

}
