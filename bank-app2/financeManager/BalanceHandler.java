package financeManager;

public class BalanceHandler {
    private double balance;

    public BalanceHandler(){
        balance = 0;
    }

    public double getBalance(){
        return balance;
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
