import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FinanceManger {
    public ArrayList<Transaction> transactions;
    private double balance;

    public FinanceManger() {
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }

    private void updateBalance(Transaction transaction) {
        if (transaction.getType() == Transaction.TransactionType.INCOME) {
            balance += transaction.getAmount();
        } else {
            balance -= transaction.getAmount();
        }
    }

    public void addTransaction(Scanner scanner) {
        Transaction.TransactionType type = setType(scanner);
        if (type != null) {
            Transaction transaction = createTransaction(scanner, type);
            if (transaction != null) {
                transactions.add(transaction);
                updateBalance(transaction);
                System.out.print("Transaction added\n");
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

    public void removeTransaction(Scanner scanner) {
        System.out.print("enter index of trasation to remove: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < transactions.size()) {
            Transaction removedTransaction = transactions.get(index);
            updateBalance(removedTransaction);
            transactions.remove(index);
            System.out.print("Transaction Removed\n");
        } else {
            System.out.print("Invalid index\n");
        }
        scanner.nextInt();
    }

    public void listTransactions() {
        if (transactions.isEmpty()) {
            System.out.print("There is no transactions to show\n");
        } else {
            dateSort(transactions);
            System.out.print("List of transaction\n");
            for (int i = 0; i < transactions.size(); i++) {
                Transaction t = transactions.get(i);
                System.out.printf("%d: %s - %.2f (Date: %s)\n", i + 1, t.getDescription(), t.getAmount(), t.getDate());

            }
        }
    }

    public void report() {
        if (transactions.isEmpty()) {
            System.out.print("there is no transaction to show\n");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select what you want to see: \n"
                + "1. Transactions today \n" +
                "2. Transactions last week \n" +
                "3. Transactions last month \n" +
                "4. Transactions last year \n");
        int input = scanner.nextInt();
        LocalDate today = LocalDate.now();
        switch (input) {
            case 1:
                List<Transaction> todayTransactions = transactions.stream().filter(t -> t.getDate().isEqual(today))
                        .collect(Collectors.toList());
                printTransactions(todayTransactions, "Transactions today");
                break;
            case 2:
                LocalDate oneWeek = today.minusWeeks(1);
                List<Transaction> lastWeekTransactions = transactions.stream()
                        .filter(t -> t.getDate().isAfter(oneWeek.minusDays(1)) && t.getDate().isBefore(today.plusDays(1)))
                        .collect(Collectors.toList());
                printTransactions(lastWeekTransactions, "Transactions last week");
                break;
            case 3:
                LocalDate oneMonth = today.minusMonths(1);
                List<Transaction> lastMonthTransactions = transactions.stream()
                        .filter(t -> t.getDate().isAfter(oneMonth.minusDays(1)) && t.getDate().isBefore(today.plusDays(1)))
                        .collect(Collectors.toList());
                printTransactions(lastMonthTransactions, "Transactions last month");
                break;
            case 4:
                LocalDate oneYear = today.minusYears(1);
                List<Transaction> lastYearTransactions = transactions.stream()
                        .filter(t -> t.getDate().isAfter(oneYear.minusDays(1)) && t.getDate().isBefore(today.plusDays(1)))
                        .collect(Collectors.toList());
                printTransactions(lastYearTransactions, "Transactions last year");
                break;
        }

    }

    private void dateSort(ArrayList<Transaction> tranactions) {
        int n = tranactions.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (transactions.get(j).compareTo(tranactions.get(j + 1)) > 0) {
                    Transaction temp = tranactions.get(j);
                    transactions.set(j, tranactions.get(j + 1));
                    transactions.set(j + 1, temp);
                }
            }
        }
    }

    private void printTransactions(List<Transaction> transactions, String header) {
        if (transactions.isEmpty()) {
            System.out.print("There is no transactions for this period to show\n");
        }
        System.out.print(header + "\n");
        for (Transaction t : transactions) {
            System.out.printf("%s - %.2f (Date: %s)%n", t.getDescription(), t.getAmount(), t.getDate());
        }
    }

    public Transaction.TransactionType setType(Scanner scanner) {
        while (true) {
            System.out.print("Enter type (Expense/Income)\n");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return Transaction.TransactionType.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid transacion type. Please enter either 'Expense' or 'Income'\n");
            }

        }
    }
}