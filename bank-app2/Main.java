import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceManger financeManger = new FinanceManger();
        FileManager fileManager = new FileManager("transactions.txt");
        try {
            financeManger.transactions = fileManager.loadData();
        } catch (Exception e) {
            System.out.print("No data to load\n");
        }

        Scanner scanner = new Scanner(System.in);

        // meny
        while (true) {
            displayMenu();

            int choice = getUserChoice(scanner);
            switch (choice) {
                case 1:
                    financeManger.addTransaction(scanner);
                    break;
                case 2:
                    financeManger.removeTransaction(scanner);
                    break;
                case 3:
                    System.out.printf("Current balance:%s \n", financeManger.getBalance());
                    break;
                case 4:
                    financeManger.listTransactions();
                    break;
                case 5:
                    financeManger.report();
                    break;
                case 6:
                    saveAndExit(fileManager, financeManger.transactions);
                    break;
            }
        }

    }

    private static void displayMenu() {
        System.out.printf(
                "1. Add trasaction\n" +
                        "2. Remove trasaction\n" +
                        "3. See current balance\n" +
                        "4. List transactions\n" +
                        "5. Report\n" +
                        "6. quit\n");
    }

    private static int getUserChoice(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter option: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Not valid input, Please enter a number");
            }
        }
    }

    private static void saveAndExit(FileManager fileManager, ArrayList<Transaction> transactions) {
        try {
            fileManager.saveData(transactions);
            System.out.println("Data sparad.");
        } catch (IOException e) {
            System.out.println("Fel vid sparande av data.");
        }
        System.exit(0);
    }
}