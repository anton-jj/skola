package financeManager;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Comparable<Transaction>, Serializable {

   public enum TransactionType {
      INCOME,
      EXPENSE;
   }

   private static final long serialVersionUID = 1L;

   private TransactionType type;
   private double amount;
   private String description;
   private LocalDate date;

   public Transaction(double amount, String description, LocalDate date, TransactionType type) {
      this.amount = amount;
      this.description = description;
      this.date = date;
      this.type = type;
   }

   public TransactionType getType() {
      return type;
   }

   public double getAmount() {
      return amount;
   }

   public String getDescription() {
      return description;
   }

   public LocalDate getDate() {
      return date;
   }

   @Override
   public String toString() {
      return "Transaction{" +
            "date=" + date +
            "description=" + description +
            ", amount=" + amount +
            '}';
   }

   @Override
   public int compareTo(Transaction o) {
      return o.date.compareTo(this.date);
   }

}
