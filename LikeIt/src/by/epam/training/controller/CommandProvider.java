package by.epam.training.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.training.command.Command;
import by.epam.training.command.impl.CreateAccount;
import by.epam.training.command.impl.SignIn;
import by.epam.training.command.impl.SignOut;
import by.epam.training.command.impl.RedirectToSignIn;
import by.epam.training.command.impl.RedirectToRegistration;
import by.epam.training.command.impl.ShowLastTopics;

public class CommandProvider {
	private Map<String, Command> commands = new HashMap<String, Command>();

	CommandProvider() {
		commands.put("SIGNIN", new SignIn());
		commands.put("REDIRECT_TO_REGISTRATION", new RedirectToRegistration());
		commands.put("REDIRECT_TO_SIGNIN", new RedirectToSignIn());
		commands.put("CREATE_ACCOUNT", new CreateAccount());
		commands.put("SIGN_OUT", new SignOut());
		commands.put("SHOW_LAST_TOPICS", new ShowLastTopics());
	}

	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}

}
