package financeManager;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import userInterface.ConsoleOutput;
import userInterface.InputHandler;

public class ReportGenerator {
	private InputHandler inputH;
	private ConsoleOutput output;
	private TransactionHandler transactionHandler;
	public ReportGenerator(TransactionHandler transactionHandler){
		this.transactionHandler = transactionHandler;
		this.inputH = new InputHandler();
		this.output = new ConsoleOutput();
	}

	private int displayMenuAndGetChoice() {
		output.displayMenu("Select what you want to see: \n"
				+ "1. Transactions today \n" +
				"2. Transactions last week \n" +
				"3. Transactions last month \n" +
				"4. Transactions last year \n");

		return  inputH.handleMenuPrompt();
	}

	private List<Transaction> getTransactionsForPeriod(int input, LocalDate today){
		LocalDate start; 

		switch (input) {
		case 1:
			start = today; 
			break;
		case 2:
			start = today.minusWeeks(1);
			break;
		case 3:
			start = today.minusMonths(1);
			break;
		case 4:
			start = today.minusYears(1);
			break;
		default: 
			output.displayError("Invalid option selected");
			return null;
		}
		return transactionHandler.getTransactions().stream()
				.filter(t -> !t.getDate().isBefore(start)&& t.getDate().isBefore(today.plusDays(1)))
				.sorted(Comparator.comparing(Transaction::getDate).reversed())
				.collect(Collectors.toList());
	}

	private String getTitle(int input) {
		switch(input) {
		case 1: return "Transactions today"; 
		case 2: return "Transactions last week";
		case 3: return "Transactions last month";
		case 4: return "Transactions last year";
		default: return "Unknown";
		}
	}

	public void report() {
		if (transactionHandler.getTransactions().isEmpty()) {
			output.displayError("there is no transaction to show\n");
			return;
		}
		int input = displayMenuAndGetChoice();

		LocalDate today = LocalDate.now();
		List<Transaction> filteredTransactions = getTransactionsForPeriod(input, today);

		if (filteredTransactions != null) {
			printTransactions(filteredTransactions, getTitle(input));
		}
	}

	private void printTransactions(List<Transaction> transactions, String header) {
		if (transactions.isEmpty()) {
			output.displayMessage("There is no transactions for this period to show\n");
			return;
		}

		output.displayMessage(header );
		double income = transactions.stream().filter(t -> t.getType() == Transaction.TransactionType.INCOME)
				.mapToDouble(t -> t.getAmount()).sum();
		double expense = transactions.stream().filter(t -> t.getType() == Transaction.TransactionType.EXPENSE)
				.mapToDouble(t -> t.getAmount()).sum();

		double total = income - expense;
		IntStream.range(0, transactions.size())
		.forEach(i -> output.displayTransaction(transactions.get(i), i));

		output.displayTotal("Income during period: %.2f\n"
				+ "Expenses during period: %.2f\n"
				+ "Net result for the period: %.2f\n", income, expense, total);
	}
}
