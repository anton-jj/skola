package userInterface;

import financeManager.Transaction.TransactionType;

public interface Input {
	TransactionType handleTransactionType();
	String[] handleTransactionDetail();
	char handlePrompt();
	int handleMenuPrompt();
}
