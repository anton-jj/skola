package financeManager;

public class BalanceHandler {
    private double balance;
    private TransactionHandler transactionHandler;
    private FinanceHandler finanaceHandler;

    BalanceHandler(FinanceHandler financeHandler){
        this.finanaceHandler = financeHandler;
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
        balance = finanaceHandler.getTransactionHandler().getTransactions().stream()
                .mapToDouble(t -> t.getType() == Transaction.TransactionType.INCOME ?
                        t.getAmount() : - t.getAmount())
                .sum();
    }
}
