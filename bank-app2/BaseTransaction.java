import java.io.Serializable;
import java.time.LocalDate;

abstract class BaseTransaction implements ITransaction, Serializable {
    private int id;
    private TransactionDetails details;

   public BaseTransaction(double amount, String description, LocalDate date) {
       this.details = new TransactionDetail(amount, description, date);
   }
    void setId(int id) { this.id = id;}

    public abstract TransactionType getType();

    @Override
    public int getId(){ return id;}

   @Override
   public double getAmount() { return detail.amount; }

    @Override
   public String getDescription() { return detail.description; }

    @Override
   public LocalDate getDate() { return detail.date; }

}
