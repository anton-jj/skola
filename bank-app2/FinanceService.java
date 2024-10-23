import java.time.LocalDate;

public class FinanceService {
    private ITransactionRepo repo;

    public FinanceService(ITransactionRepo repo){
       this.repo = repo;
    }
    public void addTransaction(ITransaction transaction){
       repo.save(transaction);
    }
    public void removeTransaction(int id){
       repo.delete(id);
    }
    public double getBalance(){
    }
    public List<ITransaction> getTransactionsByDateRange(LocalDate start, LocalDate end) {
    }
}
