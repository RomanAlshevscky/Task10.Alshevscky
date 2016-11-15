package by.epam.training.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.command.Command;
import by.epam.training.constants.PagePaths;
import by.epam.training.service.AccountService;
import by.epam.training.service.exception.ServiceException;
import by.epam.training.service.factory.ServiceFactory;

public class SignIn implements Command {

	private static final Logger logger = LogManager.getLogger(SignIn.class);
	private static final String usernameParameter = "username";
	private static final String userPassParameter = "userPassword";

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		ServiceFactory factory = ServiceFactory.getInstance();
		AccountService loginService = factory.getAccountService();
		
		String username = request.getParameter(usernameParameter);
		String userPassHash = request.getParameter(userPassParameter); //add hash func
		
		logger.debug("username: "+username+" pass: "+ userPassHash);// как мы должны вызывать такой debug?
		// вспоминай лекцию
		
		try {
			if(loginService.doLogin(username, userPassHash)){
				logger.trace("user: "+username+" has signed in");
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				request.setAttribute(PagePaths.PAGE_ATTR, PagePaths.MAIN_PAGE);
			} else {
				logger.trace("login failed");
				request.setAttribute("error", "FAILED: incorrect username or password.");
				request.setAttribute(PagePaths.PAGE_ATTR, PagePaths.LOGIN_PAGE);
			}
		} catch (ServiceException se){
			logger.error(se);
		}
		
	}

}
