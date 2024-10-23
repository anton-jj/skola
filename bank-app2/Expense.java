import java.time.LocalDate;

class Expense extends BaseTransaction{

    public Expense(double amount, String description, LocalDate date) {
        super(amount, description, date);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.EXPENSE;
    }

    @Override
    public int getId() {
        return 0;
    }

}
