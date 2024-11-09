package commands;

import java.security.NoSuchAlgorithmException;

import user.Account;
import user.AccountHandler;

public class CreateAccountCommand extends Command{
	private AccountHandler accountHandler;
	
	public CreateAccountCommand(AccountHandler accountHandler) {
		super("create", "create new account");
		Command.idCounter = 1;
		this.accountHandler = accountHandler;
	}
	@Override
	public void execute() {
		//
	}
	  public boolean createAccount(String username, String password) throws NoSuchAlgorithmException {
	        Account newAccount = accountHandler.createAccount(username, password);
	        return newAccount != null;
	    }

}
