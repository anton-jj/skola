package financeManager;

public class BalanceHandler {
    private double balance;
    private TransactionHandler transactionHandler;

    public BalanceHandler(TransactionHandler transactionHandler){
        this.transactionHandler = transactionHandler;
        this.balance = 0;
    }

    public double getBalance(){
        return this.balance;
    }

    public void updateBalance(Transaction transaction){
       if(transaction.getType() == Transaction.TransactionType.INCOME) {
           balance += transaction.getAmount();
       }else {
           balance -= transaction.getAmount();
       }
    }

    public void printBalance() {
        System.out.println(balance);
    }
}