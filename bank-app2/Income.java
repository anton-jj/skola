import java.time.LocalDate;

class Income extends BaseTransaction{


    public Income(double amount, String description, LocalDate date) {
        super(amount, description, date);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.INCOME;
    }
}
