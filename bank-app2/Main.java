import financeManager.*;
import utils.FileManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FinanceHandler financeHandler = new FinanceHandler();
        FileManager fileManager = new FileManager();

        try {
            financeHandler.setTransactiontransactions(fileManager.loadData());
            System.out.println("File loaded");
        } catch (Exception e) {
            System.out.print("No data to load\n");
        }

        UserInterface ui = new UserInterface(financeHandler);
        ui.start();

    }
}


