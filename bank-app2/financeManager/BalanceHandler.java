package financeManager;

public class BalanceHandler {
    private double balance;
    TransactionHandler transactionHandler;

    BalanceHandler(TransactionHandler transactionHandler){
    	this.transactionHandler = transactionHandler;
        this.balance = 0;
    }
    public double getBalance(){
        balance = transactionHandler.getTransactions().stream()
                .mapToDouble(t -> t.getType() == Transaction.TransactionType.INCOME ?
                        t.getAmount() : - t.getAmount())
                .sum();
        return this.balance;
    }
}
