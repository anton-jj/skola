import java.time.LocalDate;

public class TransactionDetails {
    private double amount;
    private String description;
    private LocalDate date;

    public TransactionDetails(double amount, String description, LocalDate date) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be nagative");
        }
        this.amount = amount;
        this.description = description;
        this.date = date;

    }

    public double getAmount() { return amount; }

    public String getDescription() { return description; }

    public LocalDate getDate() { return date; }
}