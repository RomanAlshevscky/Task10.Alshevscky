package by.epam.training.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.command.Command;
import by.epam.training.constants.PagePaths;

public class RedirectToRegistration implements Command {

	private static final Logger logger = LogManager.getLogger(RedirectToRegistration.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		logger.debug("Redirected to registration page.");
		request.setAttribute(PagePaths.PAGE_ATTR, PagePaths.LOGIN_PAGE);
	}

}
