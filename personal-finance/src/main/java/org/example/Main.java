package org.example;

import org.example.financeManager.FinanceHandler;
import org.example.user.Account;
import org.example.user.AccountHandler;
import org.example.userInterface.LoginUI;
import org.example.userInterface.MainUI;
import org.example.utils.Database;
import org.example.utils.DataBaseUserStorage;
import org.example.utils.DatabaseTransactionStorage;
import org.example.utils.TransactionStorage;

import java.io.IOException;
import java.sql.Connection;

public class Main {
    public static void main(String[] args)  {

        Database db = Database.getInstance();
        db.createTables();
        Connection conn = db.getConnection();

        DataBaseUserStorage dbusers = new DataBaseUserStorage();
        AccountHandler accountHandler = new AccountHandler(dbusers);

        DatabaseTransactionStorage transactionStoge = new DatabaseTransactionStorage(conn,null);
        FinanceHandler financeHandler = new FinanceHandler(null);
        boolean running = true;
        while (running) {

            LoginUI loginUI = new LoginUI(accountHandler);
            loginUI.start();

            Account currentAccount = accountHandler.getCurrent();

            financeHandler = new FinanceHandler(currentAccount);
            transactionStoge = new DatabaseTransactionStorage(conn, currentAccount);

            financeHandler.loadTransactions(transactionStoge);
            MainUI ui = new MainUI(financeHandler, accountHandler);
            ui.start();
        }

    }
}