package financeManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReportGenerator {
     TransactionHandler transactionHandler;

    public ReportGenerator(TransactionHandler transactionHandler){
        this.transactionHandler = transactionHandler;
    }
    public void report() {
        if (transactions.isEmpty()) {
            System.out.print("there is no transaction to show\n");
            return;
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
                        .filter(t -> t.getDate().isAfter(oneWeek.minusDays(1))
                                && t.getDate().isBefore(today.plusDays(1)))
                        .collect(Collectors.toList());
                printTransactions(lastWeekTransactions, "Transactions last week");
                break;
            case 3:
                LocalDate oneMonth = today.minusMonths(1);
                List<Transaction> lastMonthTransactions = transactions.stream()
                        .filter(t -> t.getDate().isAfter(oneMonth.minusDays(1))
                                && t.getDate().isBefore(today.plusDays(1)))
                        .collect(Collectors.toList());
                printTransactions(lastMonthTransactions, "Transactions last month");
                break;
            case 4:
                LocalDate oneYear = today.minusYears(1);
                List<Transaction> lastYearTransactions = transactions.stream()
                        .filter(t -> t.getDate().isAfter(oneYear.minusDays(1))
                                && t.getDate().isBefore(today.plusDays(1)))
                        .collect(Collectors.toList());
                printTransactions(lastYearTransactions, "Transactions last year");
                break;
        }

    }

    private void printTransactions(List<Transaction> transactions, String header) {
        if (transactions.isEmpty()) {
            System.out.print("There is no transactions for this period to show\n");
            return;
        }
        double income = 0;
        double expense = 0;
        System.out.print(header + "\n");
        for (Transaction t : transactions) {
            System.out.printf("%s - %.2f (Date: %s)%n", t.getDescription(), t.getAmount(), t.getDate());
            if (t.getType() == Transaction.TransactionType.INCOME) {
                income += t.getAmount();
            } else {
                expense += t.getAmount();
            }
        }
        System.out.printf("Income during period: %.2f\nExpenses during period: %.2f\n", income, expense);
    }
}
