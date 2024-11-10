package financeManager;

import java.io.IOException;

import user.Account;
import utils.TransactionStorage;

public class FinanceHandler {

	private BalanceHandler balanceHandler;
	private TransactionHandler transactionHandler;
	private ReportGenerator reportGenerator;
	private Account account;

	public FinanceHandler(Account account) {
		this.account = account;
		this.transactionHandler = new TransactionHandler();
		this.balanceHandler = new BalanceHandler(transactionHandler);
		this.reportGenerator = new ReportGenerator(transactionHandler);

	}


	public void loadTransactions(TransactionStorage transactionStorage) throws IOException {
		try {
			transactionHandler.setTransactions(transactionStorage.load());
			System.out.println("Transactions loaded.");
		} catch (IOException e) {
			System.out.println("No data to load.");
		}
	} 

	public Account getAccount() {
		return this.account;
	}

	public TransactionHandler getTransactionHandler(){
		return this.transactionHandler;
	}

	public BalanceHandler getBalanceHandler(){
		return this.balanceHandler;
	}
	public void getBalance() {
		System.out.println("Balance: " + balanceHandler.getBalance());
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