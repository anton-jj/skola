package financeManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionHandler {
    private ArrayList<Transaction> transactions;
    private FinanceHandler financeHandler;

    public TransactionHandler(FinanceHandler financeHandler){
        this.financeHandler = financeHandler;
        this.transactions = new ArrayList<>();

    }


    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction() {
        Scanner scanner = new Scanner(System.in);
        Transaction.TransactionType type = setType();
        if (type != null) {
            Transaction transaction = createTransaction(scanner, type);
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
            Scanner scanner = new Scanner(System.in);
            System.out.print("List of transaction\n");
            for (int i = 0; i < transactions.size(); i++) {
                Transaction t = transactions.get(i);
                System.out.printf("%d: %s %s - %.2f (Date: %s)\n", i + 1, t.getType().name(), t.getDescription(),
                        t.getAmount(), t.getDate());
                j++;
                if (j == showLess) {
                    System.out.println("---- show more?(y/n) ----");
                    char input = scanner.next().toUpperCase().charAt(0);
                    if (input == 'Y')  continue;
                    else  break;
                }
            }
        }
    }

    private Transaction createTransaction(Scanner scanner, Transaction.TransactionType type) {
        while (true) {
            System.out.println("Make tranaction (amount) (description) (date yyyy-MM-dd): ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.print("Input can't be empty\n");
                continue;
            }
            String[] args = input.split(" ", 3);
            if (args.length < 3) {
                System.out.print("Please fill the fields like the example\n");
                continue;
            }
            try {
                double amount = Double.parseDouble(args[0]);
                String description = args[1];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(args[2], formatter);
                return new Transaction(amount, description, date, type);
            } catch (NumberFormatException e) {
                System.out.print("Invalid amount. Please eneter  a valid number");
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format. Please use yyyy-MM-dd");
            }
        }

    }

    private Transaction.TransactionType setType() {
        Scanner typeScanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter type (Expense/Income)\n");
            String input = typeScanner.nextLine().trim().toUpperCase();
            try {
                return Transaction.TransactionType.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid transacion type. Please enter either 'Expense' or 'Income'\n");
            }
        }
    }
}


