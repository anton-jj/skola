package financeManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


import utils.InputHandler;

public class TransactionHandler {
    private ArrayList<Transaction> transactions;
    private FinanceHandler financeHandler;
    private InputHandler inputHandler;

    public TransactionHandler(FinanceHandler financeHandler){
        this.financeHandler = financeHandler;
        this.inputHandler = new InputHandler();
        this.transactions = new ArrayList<>();

    }


    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction() {
		Transaction.TransactionType type = inputHandler.getTransactionType();
        if (type != null) {
            Transaction transaction = createTransaction(type);
            if (transaction != null) {
                transactions.add(transaction);
                financeHandler.getBalanceHandler().updateBalance(transaction);
                System.out.print("Transaction added\n");
            }
        }
    }

    public void removeTransaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter index of transaction to remove: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
            financeHandler.getBalanceHandler().updateBalance(transactions.get(index));
            System.out.print("Transaction Removed\n");
        } else {
            System.out.print("Invalid index\n");
        }
    }

    public void listTransactions() {
        int showLess = 20;
        int j = 0;
        if (transactions.isEmpty()) {
            System.out.print("There is no transactions to show\n");
        } else {
            System.out.print("List of transaction\n");
            for (int i = 0; i < transactions.size(); i++) {
                Transaction t = transactions.get(i);
                System.out.printf("%d: %s %s - %.2f (Date: %s)\n", i + 1, t.getType().name(), t.getDescription(),
                        t.getAmount(), t.getDate());
                j++;
                if (j == showLess) {
                    System.out.println("----show more?(y/n) ----");
                    char input = inputHandler.showMore();
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
        	String[] input = inputHandler.getTransactionDetails();

            try {
                double amount = Double.parseDouble(input[0]);
                String description = input[1];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(input[2], formatter);
                return new Transaction(amount, description, date, type);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please eneter  a valid number");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd");
            }
        }

    }

}


