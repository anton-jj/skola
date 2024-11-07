package userInterface;

import commands.Command;
import financeManager.Transaction;

public class ConsoleOutput implements Output{

	@Override
	public void displayTransaction(Transaction t, int i) {
		System.out.printf("%d. %s %s - %.2f (Date: %s)\n", i, t.getType().name().toLowerCase(), t.getDescription(),
				t.getAmount(), t.getDate());
	}

	@Override
	public void displayMessage(String message) {
		System.out.printf("%s \n", message);
	}

	@Override
	public void displayMenu(String menu) {
		System.out.printf("%s \n", menu);
	}

	@Override
	public void displayPrompt(String prompt) {
		System.out.printf("%s \n",prompt);

	}

	@Override
	public void displayError(String error) {
		System.out.printf("%s \n", error);
	}

	public void displayTotal(String message, double income, double expense, double total) {
		System.out.printf(message, income, expense, total);
	}

	public void displayComamnds(Command command) {
		System.out.printf("%d. %s%n", command.getCommandId(), command.getDescription(), command.getName());
	}

	@Override
	public void displayTransaction(Transaction t) {
		System.out.printf("%s %s - %.2f (Date: %s)\n", t.getType().name().toLowerCase(), t.getDescription(),
				t.getAmount(), t.getDate());
	}
}
