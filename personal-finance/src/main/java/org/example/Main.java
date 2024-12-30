package org.example;

import org.example.financeManager.FinanceHandler;
import org.example.user.Account;
import org.example.user.AccountHandler;
import org.example.userInterface.LoginUI;
import org.example.userInterface.MainUI;
import org.example.utils.Database;
import org.example.utils.DataBaseUserStorage;
import org.example.utils.TransactionStorage;

import java.io.IOException;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws IOException {

        Database db = Database.getInstance();
        db.createTables();
        Connection conn = db.getConnection();

        DataBaseUserStorage dbusers = new DataBaseUserStorage();

        AccountHandler accountHandler = new AccountHandler(dbusers);

        LoginUI loginUI = new LoginUI(accountHandler);
        loginUI.start();

        Account currentAccount = accountHandler.getCurrent();

        TransactionStorage transactionStoge = new TransactionStorage(currentAccount.getUsername());
        FinanceHandler financeHandler = new FinanceHandler(currentAccount);

        try {
            financeHandler.loadTransactions(transactionStoge);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MainUI ui = new MainUI(financeHandler);
        ui.start();
    }
}