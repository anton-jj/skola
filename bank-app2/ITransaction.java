import java.time.LocalDate;

public interface ITransaction {
    int getId();
    double getAmount();
    String getDescription();
    LocalDate getDate();
}
