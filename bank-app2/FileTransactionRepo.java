import java.io.*;
import java.util.ArrayList;

public class FileTransactionRepo implements ITransactionRepo{
    private String filename;
    private List<ITransaction> transactions;
    private int nextId;

    public FileTransactionRepo(String filename){
       this.filename = filename;
       this.transactions =  new ArrayList<>();
       this.nextId = 1;
       loadFromFile();
    }

    @Override
    public void save(ITransaction transaction) {
        if (transaction.getId() == 0) {
            // new transaction
            ((BaseTransaction.)transaction).setId(nextId++);
            transaction.add(transaction);
        }else {
            transactions.removeIf(t -> t.getId) == transaction.getId();
            transactions.add(transaction);
        }
    saveToFile();
    }

    @Override
    public void delete(int id) {
            transactions.removeIf(t -> t.getId() == id);
            saveToFile();
    }

    @Override
    public List<ITransaction> findAll() {
        return null;
    }

    @Override
    public Optional<ITransaction> findById(int id) {
        return null;
    }

    @Override
    public List<ITransaction> findByDateRange(LocalDate startDate, LocalDate endDate) {
        return null;
    }
    private void saveToFile() throws IOException, ClassNotFoundException {
       try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(filename))){
           oss.writeObject(transactions);
       }
    }
    private void LoadFromFile() throws IOException, ClassNotFoundException{

        }
    }