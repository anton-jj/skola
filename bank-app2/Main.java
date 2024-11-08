import java.io.IOException;

import financeManager.FinanceHandler;
import user.Account;
import user.AccountHandler;
import userInterface.LoginUI;
import userInterface.MainUI;
import utils.UserStorage;
public class Main {

	public static void main(String[] args) throws IOException {


	        UserStorage users = new UserStorage();
	        
	        AccountHandler accountHandler = new AccountHandler(users);

	        LoginUI loginUI = new LoginUI(accountHandler);
	        loginUI.start();

	        Account currentAccount = accountHandler.getCurrent();

	        FinanceHandler financeHandler = new FinanceHandler(currentAccount);

	        MainUI ui = new MainUI(financeHandler);
	        ui.start();
	}
}


