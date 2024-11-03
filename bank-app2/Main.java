import financeManager.FinanceHandler;
import userInterface.UserInterface;
import utils.TransactionStorage;

public class Main {
    public static void main(String[] args) {

        TransactionStorage transactionStorage = new TransactionStorage();
        FinanceHandler financeHandler = new FinanceHandler();
        try {
            financeHandler.setTransactiontransactions(transactionStorage.load());
            System.out.println("File loaded");
        } catch (Exception e) {
            System.out.print("No data to load\n");
        }
        UserInterface ui = new UserInterface(financeHandler);
        ui.start();

    }
}


