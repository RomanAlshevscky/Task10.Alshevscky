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

public class SignOut implements Command {

	private final static Logger logger = LogManager.getLogger(SignOut.class);
	private final static String USERNAME_ATTR = "user";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession(true);
			
			logger.trace(session.getAttribute(USERNAME_ATTR) + " signed out.");
			session.removeAttribute(USERNAME_ATTR);

			request.setAttribute(PagePaths.PAGE_ATTR, PagePaths.MAIN_PAGE);

	}

}
