package userInterface;

import java.util.Scanner;

import financeManager.Transaction.TransactionType;

public class InputHandler implements Input{
	private final Scanner scanner ;
	private final ConsoleOutput output;

	public InputHandler() {
		this.scanner = new Scanner(System.in);
		this.output = new ConsoleOutput();
	}

	@Override
	public TransactionType handleTransactionType() {
		while(true) {
			String input = scanner.nextLine().trim().toUpperCase();
			if(input.equals("INCOME")) {
				return TransactionType.INCOME;
			}

			if (input.equals("EXPENSE")) {
				return TransactionType.EXPENSE;
			}
			output.displayError("Invalid transaction you, Please Enter either 'Expense or Income' ");
		}
	}


	@Override
	public String[] handleTransactionDetail() {
		output.displayPrompt("Make transaction (amount) (description) (date yyyy-MM-dd)");
		while(true) {
			String input = scanner.nextLine().trim();
			if (input.isEmpty()) {
				output.displayMessage("Please enter your transaction");
				continue;
			}
			String[] transactionDetails = input.split(" ");
			if (transactionDetails.length < 3) {
				output.displayError("Please fill the fields like the example");
				continue;
			}
			return transactionDetails;
		}
	}

	@Override
	public char handlePrompt() {
		char input = scanner.next().toUpperCase().charAt(0);
		return input;
	}

	@Override
	public int handleMenuPrompt() {
		return scanner.nextInt();
	}

	@Override
	public String handleStringInput() {
		return scanner.next().trim();
	}
}
