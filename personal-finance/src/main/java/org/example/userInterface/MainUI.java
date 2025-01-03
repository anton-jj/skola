package org.example.userInterface;

import org.example.commands.Command;
import org.example.commands.CommandHandler;
import org.example.commands.DeleteUserCommand;
import org.example.financeManager.FinanceHandler;
import org.example.user.AccountHandler;

public class MainUI extends UserInterface{
	private CommandHandler command;
	private AccountHandler accountHandler;

	public MainUI(FinanceHandler financeHandler, AccountHandler accountHandler) {
		super();
		this.accountHandler = accountHandler;
		this.command = new CommandHandler(financeHandler, accountHandler);
	}

	@Override
	public void start() {
		while (accountHandler.getCurrent() != null) {
			menu();
			int choice = input.handleMenuPrompt();
			command.executeCommand(choice);
		}
	}

	@Override
	public void menu() {
		output.displayMessage("--------Personal finance--------");
		for(Command c : command.getCommandMap().values()) {
			output.displayComamnds(c);
		}
		output.displayMessage("--------------------------------");
	}
}
