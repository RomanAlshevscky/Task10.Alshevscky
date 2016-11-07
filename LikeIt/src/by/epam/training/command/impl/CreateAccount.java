package by.epam.training.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.command.Command;
import by.epam.training.service.AccountService;
import by.epam.training.service.exception.ServiceException;
import by.epam.training.service.factory.ServiceFactory;

public class CreateAccount implements Command {

	private static final Logger logger = LogManager.getLogger(CreateAccount.class);
	private final String LOGIN_PAGE_PATH = "/WEB-INF/jsp/signIn.jsp";
	private final String REGISTRATION_PAGE_PATH = "/WEB-INF/jsp/registration.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServiceFactory factory = ServiceFactory.getInstance();
		AccountService createAccountService = factory.getAccountService();

		String username = request.getParameter("username");
		String userPassHash = request.getParameter("userPassword");//Add hash func
		logger.debug("username: "+username+"pass: "+ userPassHash);
		
		try {
			if (createAccountService.create(username, userPassHash)) {
				logger.trace("username: "+username+" account created.");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(LOGIN_PAGE_PATH);
				requestDispatcher.forward(request, response);
			} else {
				// add parametr to show error message
				request.setAttribute("ERROR", "User with such 'username' already exists.");
				logger.trace("username: "+username+" registration failed.");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(REGISTRATION_PAGE_PATH);
				requestDispatcher.forward(request, response);
			}
		} catch (ServiceException se) {
				logger.error(se);
		}
	}
}
