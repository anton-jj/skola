package userInterface;

import financeManager.Transaction;

public interface Output {
	void displayTransaction(Transaction t);
	void displayPrompt(String prompt);
	void displayMessage(String message);
	void displayMenu(String menu);
	void displayError(String error);
	void displayTransaction(Transaction t, int i);
}
