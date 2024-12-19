package org.example;

import java.io.IOException;

import org.example.financeManager.FinanceHandler;
import org.example.user.Account;
import org.example.user.AccountHandler;
import org.example.userInterface.LoginUI;
import org.example.userInterface.MainUI;
import org.example.utils.TransactionStorage;
import org.example.utils.UserStorage;

public class App {
 

    public static void main(String[] args) throws IOException {
    	

		UserStorage users = new UserStorage();

		AccountHandler accountHandler = new AccountHandler(users);

		LoginUI loginUI = new LoginUI(accountHandler);
		loginUI.start();

		Account currentAccount = accountHandler.getCurrent();

		TransactionStorage transactionStoge = new TransactionStorage(currentAccount.getUsername());
		FinanceHandler financeHandler = new FinanceHandler(currentAccount);

		try {
			financeHandler.loadTransactions(transactionStoge);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MainUI ui = new MainUI(financeHandler);
		ui.start();
    }
}
