package financeManager;

import java.util.ArrayList;

public class FinanceHandler {

    private BalanceHandler balanceHandler;
    private TransactionHandler transactionHandler;
    private ReportGenerator reportGenerator;

    public FinanceHandler() {
        this.transactionHandler = new TransactionHandler(this);
        this.balanceHandler = new BalanceHandler(this);
        this.reportGenerator = new ReportGenerator(this);

    }
    public TransactionHandler getTransactionHandler(){
        return this.transactionHandler;
    }

    public BalanceHandler getBalanceHandler(){
        return this.balanceHandler;
    }
    public void getBalance() {
        System.out.println("Balance: " + balanceHandler.getBalance());
    }


    public void addTransaction() {
        transactionHandler.addTransaction();
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


    public void setTransactiontransactions(ArrayList<Transaction> transactions) {
         transactionHandler.setTransactions(transactions);
    }
}