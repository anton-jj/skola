package utils;

import financeManager.Transaction;

import java.io.*;
import java.util.ArrayList;
public class FileManager {
    private String filename;

    public FileManager() {
        this.filename = "transactions.txt";
    }

    public void saveData(ArrayList<Transaction> transactions) throws IOException {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(filename))) {
            oss.writeObject(transactions);
        }
    }

    public ArrayList<Transaction> loadData() throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream((new FileInputStream(filename)))) {
            return (ArrayList<Transaction>) ois.readObject();
        }
    }
}
