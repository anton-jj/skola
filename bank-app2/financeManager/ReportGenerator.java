package financeManager;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import userInterface.ConsoleOutput;
import userInterface.InputHandler;

public class ReportGenerator {
	private FinanceHandler financeHandler;
	private InputHandler inputH;
	private ConsoleOutput output;
	public ReportGenerator(FinanceHandler financeHandler){
		this.financeHandler = financeHandler;
		this.inputH = new InputHandler();
		this.output = new ConsoleOutput();
	}

	/*TODO try to split this metod*/
	public void report() {
		if (!financeHandler.getTransactionHandler().getTransactions().isEmpty()) {
			output.displayMenu("Select what you want to see: \n"
					+ "1. Transactions today \n" +
					"2. Transactions last week \n" +
					"3. Transactions last month \n" +
					"4. Transactions last year \n");
			int input = inputH.handleMenuPrompt();
			LocalDate today = LocalDate.now();
			switch (input) {
			case 1:
				List<Transaction> todayTransactions = financeHandler.getTransactionHandler().getTransactions().stream().filter(t -> t.getDate().isEqual(today))
				.collect(Collectors.toList());
				printTransactions(todayTransactions, "Transactions today");
				break;
			case 2:
				LocalDate oneWeek = today.minusWeeks(1);
				List<Transaction> lastWeekTransactions = financeHandler.getTransactionHandler().getTransactions().stream()
						.filter(t -> t.getDate().isAfter(oneWeek.minusDays(1))
								&& t.getDate().isBefore(today.plusDays(1)))
						.collect(Collectors.toList());
				printTransactions(lastWeekTransactions, "Transactions last week");
				break;
			case 3:
				LocalDate oneMonth = today.minusMonths(1);
				List<Transaction> lastMonthTransactions = financeHandler.getTransactionHandler().getTransactions().stream()
						.filter(t -> t.getDate().isAfter(oneMonth.minusDays(1))
								&& t.getDate().isBefore(today.plusDays(1)))
						.collect(Collectors.toList());
				printTransactions(lastMonthTransactions, "Transactions last month");
				break;
			case 4:
				LocalDate oneYear = today.minusYears(1);
				List<Transaction> lastYearTransactions = financeHandler.getTransactionHandler().getTransactions().stream()
						.filter(t -> t.getDate().isAfter(oneYear.minusDays(1))
								&& t.getDate().isBefore(today.plusDays(1)))
						.collect(Collectors.toList());
				printTransactions(lastYearTransactions, "Transactions last year");
				break;
			}
		} else {
			output.displayError("there is no transaction to show\n");
			return;
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
		transactions.forEach(output::displayTransaction);

		output.displayTotal("Income during period: %.2f\n"
				+ "Expenses during period: %.2f\n"
				+ "Net result for the period: %.2f\n", income, expense, total);
	}
}
