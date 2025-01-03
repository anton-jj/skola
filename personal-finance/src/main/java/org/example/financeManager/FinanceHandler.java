package org.example.financeManager;

import org.example.user.Account;
import org.example.utils.DatabaseTransactionStorage;

public class FinanceHandler {

	private TransactionHandler transactionHandler;
	private ReportGenerator reportGenerator;
	private Account account;

	public FinanceHandler(Account account) {
		this.account = account;
		this.transactionHandler = new TransactionHandler(account);
		this.reportGenerator = new ReportGenerator(transactionHandler);
	}


	public void loadTransactions(DatabaseTransactionStorage transactionStorage)  {
		transactionHandler.clearTransactions();
        transactionHandler.setTransactions(transactionStorage.load());
        System.out.println("Transactions loaded.");
    }

	public Account getAccount() {
		return this.account;
	}

	public TransactionHandler getTransactionHandler(){
		return this.transactionHandler;
	}

	public void getBalance() {
		System.out.println("Balance: " + account.getBalance());
	}

	public void addTransaction() {
		transactionHandler.addTransaction();
	}


	public void removeTransaction() {
		transactionHandler.removeTransaction();
	}

	public void listTransactions() {
		transactionHandler.listTransactions();
	}

	public void report() {
		reportGenerator.report();
	}
}