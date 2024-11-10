package utils;

import financeManager.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class TransactionStorage implements DataStorage<ArrayList<Transaction>> {
	private final String filename;
	private final String directoryName;

	public TransactionStorage(String username) {
		this.filename =  username + "_transactions.csv";
		this.directoryName = "transactions";
	}

	@Override
	public void save(ArrayList<Transaction> transactions) throws IOException {
		File dirr = new File(directoryName);
		File file = new File(dirr, filename);

		if(!dirr.exists()) {
			dirr.mkdir();
			System.out.println("Directory 'transactions' was created");
		}

		if (!file.exists()) {
			System.out.println("File does not exist. Creating new file: " + filename);
			boolean created = file.createNewFile();
			if (created) {
				System.out.println("File created successfully.");
			} else {
				System.out.println("Failed to create file.");
			}
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
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
		File file = new File(directoryName, filename);

		if(!file.exists() || file.length() == 0){
			return transactions;
		}

		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
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
