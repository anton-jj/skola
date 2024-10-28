package financeManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class FinanceHandler {

    private BalanceHandler balanceHandler;
    private TransactionHandler transactionHandler;
    private ReportGenerator reportGenerator;

    public FinanceHandler() {
        this.transactionHandler = new TransactionHandler();
        this.balanceHandler = new BalanceHandler();
        this.reportGenerator = new ReportGenerator(transactionHandler);
    }

    public void getBalance() {
        System.out.println("getting balance...");
        System.out.println(balanceManager.getBalance());
    }


    public void addTransaction() {
        transactionManager.addTransaction();
        System.out.println("transaction added");
    }


    public void removeTransaction() {
        transactionHandler.removeTransaction();
    }

    public void listTransactions() {
        transactionHandler.listTransactions();
    }

    public void report() {
        reportGenerator.report();
    }

}