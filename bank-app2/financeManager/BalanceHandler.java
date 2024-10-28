package financeManager;

public class BalanceHandler {
    private double balance;

    public BalanceHandler(){
        this.balance = 0;
    }
    public double getBalance(){
        return balance;
    }
    private void updateBalance(Transaction transaction){
       if(transaction.getType() == Transaction.TransactionType.INCOME) {
           balance += transaction.getAmount();
       }else {
           balance -= transaction.getAmount();
       }
    }
}
