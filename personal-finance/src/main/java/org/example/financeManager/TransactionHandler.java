package org.example.financeManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;

import org.example.userInterface.ConsoleOutput;
import org.example.userInterface.InputHandler;

public class TransactionHandler {
	private ArrayList<Transaction> transactions;
	private InputHandler inputH;
	private ConsoleOutput output;

	public TransactionHandler(){
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
		Transaction.TransactionType type = inputH.handleTransactionType();

		if (type != null) {
			Transaction transaction = createTransaction(type);
			if (transaction != null) {
				transactions.add(transaction);
				output.displayMessage("Transaction added\n");
			}else {
				output.displayError("Invalid transaction you, Please Enter either 'Expense or Income' ");
			}
		}
	}

	public void removeTransaction() {
		output.displayPrompt("enter index of transaction to remove: ");
		int index = inputH.handleMenuPrompt() - 1;

		if (index >= 0 && index < transactions.size()) {
			output.displayTransaction(transactions.get(index));
			output.displayMessage("was removed");
			transactions.remove(index);
		} else {
			output.displayError("Invalid index\n");
		}
	}

	public void listTransactions() {
		if (transactions.isEmpty()) {
			output.displayError("There is no transactions to show\n");
		}

		final int showLess = 20;
		int j = 0;	 
		output.displayMessage("List of transaction\n");
		transactions.sort(Comparator.comparing(Transaction::getDate).reversed());

		for (int i = 0; i < transactions.size(); i++) {
			Transaction t = transactions.get(i);
			output.displayTransaction(t, i +1);
			j++;

			if (j >= showLess) {
				output.displayPrompt("----show more?(y/n) ----");
				char input = inputH.handlePrompt();

				if (input != 'Y') {
					break; 
				} 
				j = 0;
			}
		}
	}

	private Transaction createTransaction(Transaction.TransactionType type) {
		while (true) {
			String[] input = inputH.handleTransactionDetail();

			double amount = parseAmount(input[0]);
			if (amount == -1) {
				output.displayError("Invalid amount. Please eneter a valid number");
				continue;
			}

			String description = input[1];
			LocalDate date = parseDate(input[2]);

			if (date == null) {
				output.displayError("Invalid date format. Please use yyyy-MM-dd");
				continue;
			}

			return new Transaction(amount, description, date, type);
		}
	}

	private double parseAmount(String amountString) {
		try {
			return Double.parseDouble(amountString);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private LocalDate parseDate(String dateString) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			return LocalDate.parse(dateString, formatter);
		} catch (DateTimeParseException e) {
			return null;
		}
	}
} 
