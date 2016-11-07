package by.epam.training.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.command.Command;
import by.epam.training.service.AccountService;
import by.epam.training.service.exception.ServiceException;
import by.epam.training.service.factory.ServiceFactory;

public class SignIn implements Command {

	private static final Logger logger = LogManager.getLogger(SignIn.class);
	private final String MAIN_PAGE = "index.jsp";
	private final String LOGIN_PAGE = "/WEB-INF/jsp/signIn.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		ServiceFactory factory = ServiceFactory.getInstance();
		AccountService loginService = factory.getAccountService();
		
		String username = request.getParameter("username");
		String userPassHash = request.getParameter("userPassword"); //add hash func
		
		logger.debug("username: "+username+" pass: "+ userPassHash);
		
		try {
			if(loginService.doLogin(username, userPassHash)){
				logger.trace("user: "+username+" has loged in");
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(MAIN_PAGE);
				requestDispatcher.forward(request, response);
			} else {
				logger.trace("login failed");
				request.setAttribute("error", "FAILED: incorrect username or password.");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(LOGIN_PAGE);
				requestDispatcher.forward(request, response);
			}
		} catch (ServiceException se){
			logger.error(se);
		}
		
	}

}
