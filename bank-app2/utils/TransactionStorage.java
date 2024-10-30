package utils;

import financeManager.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class TransactionStorage implements DataStrorage<ArrayList<Transaction>> {

    private final String filename;

    public TransactionStorage() {
        this.filename = "transactions.csv";
    }

    @Override
    public void save(ArrayList<Transaction> transactions) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Transaction t : transactions) {
                writer.write(String.format("%s,%f,%s,%s%n",
                        t.getDate().toString(),
                        t.getAmount(),
                        t.getType().name(),
                        t.getDescription()
                ));
            }
        }
    }

    @Override
    public ArrayList<Transaction> load() throws IOException {
            ArrayList<Transaction> transactions = new ArrayList<>();
            File file = new File(filename);

            if(!file.exists() || file.length() == 0){
               return transactions;
            }

            try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
                String line;
               while((line = reader.readLine()) != null){
                  String[] parts = line.split(",");
                  if (parts.length == 4){
                      LocalDate date = LocalDate.parse(parts[0]);
                      double amount = Double.parseDouble(parts[1]);
                      Transaction.TransactionType type = Transaction.TransactionType.valueOf(parts[2].toUpperCase());
                      String description = parts[3];
                      transactions.add(new Transaction(amount, description, date, type));
                  }else {
                      System.out.println(line);
                  }
               }

               return transactions;
            }
    }
}
