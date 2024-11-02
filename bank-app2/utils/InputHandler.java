package utils;

import java.util.Scanner;

import financeManager.Transaction.TransactionType;

public class InputHandler {
	private final Scanner scanner ;
	
	public InputHandler() {
		this.scanner = new Scanner(System.in);
	}
	
	public TransactionType getTransactionType() {
		
		while(true) {
			System.out.println("Enter Type (INCOME/EXPENSE) \n");
			String input = scanner.nextLine().trim().toUpperCase();
			
			if(input.equals("INCOME")) {
				return TransactionType.INCOME;
			}
			
			if (input.equals("EXPENSE")) {
				return TransactionType.EXPENSE;
			}
			System.out.println("Invalid transaction ype, Please Enter either 'Expense or Income' ");
		}
	}
	
	public String[] getTransactionDetails() {
		System.out.println("Make transaction (amount) (description) (date yyyy-MM-dd)");
		while(true) {
		String input = scanner.nextLine().trim();
		if (input.isEmpty()) {
			System.out.println("Please eneter your transaction \n");
			continue;
		}
		String[] transactionDetails = input.split(" ");
		if (transactionDetails.length < 3) {
			System.out.println("Please fill the fields like the example \n");
			continue;
		}
		return transactionDetails;
		}
	}
	
	public char showMore() {
		char input = scanner.next().charAt(0);
		return input;
	}
}
