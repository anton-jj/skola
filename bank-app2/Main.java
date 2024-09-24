import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // ändra description till enum
    // fixa prints så ser bättre ut
    public static void main(String[] args) {
        FinanceManger financeManger = new FinanceManger();
        FileManager fileManager = new FileManager("transactions.txt");
        try {
            financeManger.transactions = fileManager.loadData();
        } catch (Exception e) {
            System.out.print("Ingen tidigare data att ladda \n");
        }

        Scanner scanner = new Scanner(System.in);

        // meny
        while (true) {
            System.out.printf(
                    "1. Add trasaction\n" +
                            "2. Remove trasaction\n" +
                            "3. See current balance\n" +
                            "4. List transactions\n" +
                            "5. Report\n" +
                            "6. quit\n");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    financeManger.addTransaction(scanner);
                    break;
                case 2:
                    financeManger.removeTransaction(scanner);
                    break;
                case 3:
                    System.out.printf("Current balance:%s \n",financeManger.getBalance() );
                    break;
                case 4:
                    financeManger.listTransactions();
                    break;
                case 5:
                    financeManger.report();
                    break;
                case 6:
                    try {
                        fileManager.saveData(financeManger.transactions);
                        System.out.println("Data sparad.");
                    } catch (IOException e) {
                        System.out.println("Fel vid sparande av data.");
                    }
                    System.exit(0);
                    break;
            }
        }

    }
}