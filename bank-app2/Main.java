
public class Main {
    public static void main(String[] args) {
        FinanceManger financeManger = new FinanceManger();
        FileManager fileManager = new FileManager("transactions.txt");
        try {
            financeManger.transactions = fileManager.loadData();
        } catch (Exception e) {
            System.out.print("No data to load\n");
        }
        UserInterface ui = new UserInterface(financeManger, fileManager);
        ui.start();


        //private static void saveAndExit(FileManager fileManager, ArrayList<Transaction> transactions) {
        //    try {
        //        fileManager.saveData(transactions);
        //        System.out.println("Data sparad.");
        //    } catch (IOException e) {
        //        System.out.println("Fel vid sparande av data.");
        //    }
        //    System.exit(0);
        //}
    }
}