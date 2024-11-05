package financeManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import userInterface.ConsoleOutput;
import utils.InputHandler;

public class TransactionHandler {
	private ArrayList<Transaction> transactions;
	private FinanceHandler financeHandler;
	private InputHandler inputH;
	private ConsoleOutput output;

	public TransactionHandler(FinanceHandler financeHandler){
		this.financeHandler = financeHandler;
		this.inputH = new InputHandler();
		this.transactions = new ArrayList<>();
		this.output = new ConsoleOutput();
	}

	public ArrayList<Transaction> getTransactions(){
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void addTransaction() {
		output.displayPrompt("Enter Type (INCOME/EXPENSE) \n");
		Transaction.TransactionType type = inputH.readTransactionType();
		if (type != null) {
			Transaction transaction = createTransaction(type);
			if (transaction != null) {
				transactions.add(transaction);
				financeHandler.getBalanceHandler().updateBalance(transaction);
				output.displayMessage("Transaction added\n");
			}
		}
		output.displayError("Invalid transaction ype, Please Enter either 'Expense or Income' ");
	}

	public void removeTransaction() {
		output.displayPrompt("enter index of transaction to remove: ");
		int index = inputH.readIndex() - 1;
		if (index >= 0 && index < transactions.size()) {
			transactions.remove(index);
			financeHandler.getBalanceHandler().updateBalance(transactions.get(index));
			output.displayMessage("Transaction Removed\n");
		} else {
			output.displayError("Invalid index\n");
		}
	}

	public void listTransactions() {
		int showLess = 20;
		int j = 0;
		if (transactions.isEmpty()) {
			output.displayError("There is no transactions to show\n");
		} else {
			System.out.print("List of transaction\n");
			for (int i = 0; i < transactions.size(); i++) {
				Transaction t = transactions.get(i);
				output.displayTransaction(t);
				j++;
				if (j == showLess) {
					output.displayPrompt("----show more?(y/n) ----");
					char input = inputH.showMore();
					if (input == 'Y') {
						continue;
					} else {
						break;
					}
				}
			}
		}
	}

	private Transaction createTransaction(Transaction.TransactionType type) {
		while (true) {
			String[] input = inputH.readTransactionDetails();
			try {
				double amount = Double.parseDouble(input[0]);
				String description = input[1];
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate date = LocalDate.parse(input[2], formatter);
				return new Transaction(amount, description, date, type);
			} catch (NumberFormatException e) {
				output.displayError("Invalid amount. Please eneter  a valid number");
			} catch (DateTimeParseException e) {
				output.displayError("Invalid date format. Please use yyyy-MM-dd");
			}
		}

	}
}