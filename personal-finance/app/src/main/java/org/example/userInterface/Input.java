package org.example.userInterface;

import org.example.financeManager.Transaction.TransactionType;

public interface Input {
	TransactionType handleTransactionType();
	String[] handleTransactionDetail();
	char handlePrompt();
	int handleMenuPrompt();
	String handleStringInput();
}
