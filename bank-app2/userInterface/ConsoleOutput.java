package userInterface;

import financeManager.Transaction;

public class ConsoleOutput implements Output{

	@Override
	public void displayTransaction(Transaction t) {
		// TODO Auto-generated method stub
		System.out.printf("%s %s - %.2f (Date: %s)\n", t.getType().name().toLowerCase(), t.getDescription(),
				t.getAmount(), t.getDate());
	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub
		System.out.printf("%s \n", message);
	}

	@Override
	public void displayMenu(String menu) {
		// TODO Auto-generated method stub
		System.out.printf("%s \n", menu);
	}

	@Override
	public void displayPrompt(String prompt) {
		System.out.printf("%s \n",prompt);

	}

	@Override
	public void displayError(String error) {
		// TODO Auto-generated method stub
		System.out.printf("%s \n", error);
	}

	public void displayTotal(String message, double income, double expense, double total) {
		System.out.printf(message, income, expense, total);
	}
}
