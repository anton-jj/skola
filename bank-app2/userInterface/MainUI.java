package userInterface;

import commands.Command;
import commands.CommandHandler;
import financeManager.FinanceHandler;

public class MainUI extends UserInterface{
	private CommandHandler command;

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
