package org.example;

import org.example.financeManager.FinanceHandler;
import org.example.user.Account;
import org.example.user.AccountHandler;
import org.example.userInterface.LoginUI;
import org.example.userInterface.MainUI;
import org.example.utils.DataBase;
import org.example.utils.DataBaseUserStorage;
import org.example.utils.TransactionStorage;
import org.example.utils.UserStorage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException {

        DataBase db = new DataBase();
        db.getConnection();
        db.createTables();


        UserStorage users = new UserStorage();
        DataBaseUserStorage dbusers = new DataBaseUserStorage();

        AccountHandler accountHandler = new AccountHandler(users, dbusers);

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