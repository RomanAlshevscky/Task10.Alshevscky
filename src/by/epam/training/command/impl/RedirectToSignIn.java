package by.epam.training.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.command.Command;

public class RedirectToSignIn implements Command {

	private static final Logger logger = LogManager.getLogger(RedirectToSignIn.class);
	private final String LOGIN_PAGE_PATH = "/WEB-INF/jsp/signIn.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		logger.debug("Redirected to login page.");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(LOGIN_PAGE_PATH);
		requestDispatcher.forward(request, response);
		
	}

}
