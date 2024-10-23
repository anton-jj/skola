
import java.util.Scanner;
public class UserInterface {
    private FinanceManger financeManager;
    private FileManager fileManager;
    private Scanner scanner;

    public UserInterface(FinanceManger financeManger, FileManager fileManager){
       this.financeManager = financeManger;
       this.fileManager = fileManager;
       this.scanner = new Scanner(System.in);
    }

    public void start(){
        while(true) {
        displayMenu();
        int choice = getUserChoice();
        handleUserChoice(choice);
        }
    }
    private void displayMenu(){
        System.out.println(
                """
                  --------Finance Manager--------
                        1. Add trasaction
                        2. Remove trasaction
                        3. See current balance
                        4. List transactions
                        5. Report
                        6. quit
                 --------------------------------
                        """);
    }

    private int getUserChoice(){
        while(true){
           try {
               System.out.print("Enter option: ");
               return scanner.nextInt();
           } catch (NumberFormatException e) {
               System.out.println("not valid input, please try again");
           }

        }
    }
    private void handleUserChoice(int choice){
        switch (choice) {
            case 1:
                financeManager.addTransaction(scanner);
                break;
            case 2:
                financeManager.removeTransaction(scanner);
                break;
            case 3:
                System.out.printf("Current balance:%.2f \n", financeManager.getBalance());
                break;
            case 4:
                financeManager.listTransactions();
                break;
            case 5:
                financeManager.report();
                break;
            case 6:
                //saveAndExit(fileManager, financeManger.transactions);
                break;
       }
    }
}
