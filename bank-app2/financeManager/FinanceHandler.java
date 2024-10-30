package financeManager;

import java.util.ArrayList;

public class FinanceHandler {

    private BalanceHandler balanceHandler;
    private TransactionHandler transactionHandler;
    private ReportGenerator reportGenerator;

    public FinanceHandler() {
        this.balanceHandler = new BalanceHandler(transactionHandler);
        this.transactionHandler = new TransactionHandler(balanceHandler);
        this.reportGenerator = new ReportGenerator(transactionHandler);
    }

    public void getBalance() {
        balanceHandler.printBalance();
    }


    public void addTransaction() {
        transactionHandler.addTransaction();
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

    public ArrayList<Transaction> getTransactions(){
        return transactionHandler.getTransactions();
    }

    public void setTransactiontransactions(ArrayList<Transaction> transactions) {
         transactionHandler.setTransactions(transactions);
    }
}