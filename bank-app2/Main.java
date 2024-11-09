import java.io.IOException;

import financeManager.FinanceHandler;
import user.Account;
import user.AccountHandler;
import userInterface.LoginUI;
import userInterface.MainUI;
import utils.TransactionStorage;
import utils.UserStorage;
public class Main {

	public static void main(String[] args) throws IOException {


	        UserStorage users = new UserStorage();
	        
	        AccountHandler accountHandler = new AccountHandler(users);
	        
	        LoginUI loginUI = new LoginUI(accountHandler);
	        loginUI.start();
	        
	        Account currentAccount = accountHandler.getCurrent();

	        TransactionStorage transactionStoge = new TransactionStorage(currentAccount.getUsername());
	        FinanceHandler financeHandler = new FinanceHandler(currentAccount);

	        financeHandler.loadTransactions(transactionStoge);
	        
	        MainUI ui = new MainUI(financeHandler);
	        ui.start();
	}
}


