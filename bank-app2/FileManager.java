import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    public void saveData(ArrayList<Transaction> transactions) throws IOException {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(filename))) {
            oss.writeObject(transactions);
        }
    }

    public ArrayList<Transaction> loadData() throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (file.length() == 0) { // Kolla om filen är tom
            return new ArrayList<>(); // Returnera en tom lista
        }
        try (ObjectInputStream ois = new ObjectInputStream((new FileInputStream(filename)))) {
            return (ArrayList<Transaction>) ois.readObject();
        }
    }
}
