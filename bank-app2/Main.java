import java.util.ArrayList;
import java.util.Scanner;

import financeManager.*;

public class Main {
    public static void main(String[] args) {
        FinanceManger financeManger = new FinanceManger();
        FileManager fileManager = new FileManager("/transactions.txt");
        try {
            financeManger.transactions = fileManager.loadData();
        } catch (Exception e) {
            System.out.print("No data to load\n");
        }

        UserInterface ui = new UserInterface(financeManger);
        ui.start();
    }
}


