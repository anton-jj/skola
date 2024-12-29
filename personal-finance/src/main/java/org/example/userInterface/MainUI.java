package org.example.userInterface;

import org.example.commands.Command;
import org.example.commands.CommandHandler;
import org.example.commands.DeleteUserCommand;
import org.example.financeManager.FinanceHandler;

import java.util.ArrayList;

public class MainUI extends UserInterface{
	private CommandHandler command;
	private DeleteUserCommand dc;

	public MainUI(FinanceHandler financeHandler) {
		super();
		this.command = new CommandHandler(financeHandler);
	}

	@Override
	public void start() {
		while (true) {
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
