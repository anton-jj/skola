package financeManager;

public class BalanceHandler {
    private double balance;
    TransactionHandler transactionHandler;

    BalanceHandler(TransactionHandler transactionHandler){
    	this.transactionHandler = transactionHandler;
        this.balance = 0;
    }
    public double getBalance(){
        if (balance  == 0) {
            initialBalance();
        }
        return this.balance;
    }

    public void updateBalance(Transaction transaction){
       if(transaction.getType() == Transaction.TransactionType.INCOME) {
           balance += transaction.getAmount();
       }else {
           balance -= transaction.getAmount();
       }
    }

    private void initialBalance(){
        balance = transactionHandler.getTransactions().stream()
                .mapToDouble(t -> t.getType() == Transaction.TransactionType.INCOME ?
                        t.getAmount() : - t.getAmount())
                .sum();
    }
}
