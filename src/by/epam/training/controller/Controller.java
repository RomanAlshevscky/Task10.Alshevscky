package by.epam.training.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.command.Command;
import by.epam.training.constants.PagePaths;

public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final CommandProvider provider = new CommandProvider();
	private static final Logger logger = LogManager.getLogger(Controller.class);
	
	public Controller(){
		super();
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html");
		
		String commandParameter = request.getParameter("command");
		logger.trace("command: " + commandParameter);	// это debug
		
		Command command = provider.getCommand(commandParameter);
	 	command.execute(request, response);
	 	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher
				((String)request.getAttribute(PagePaths.PAGE_ATTR));
		requestDispatcher.forward(request, response);
		
		logger.trace(commandParameter+" executed");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doPost(request, response);
	}
}
