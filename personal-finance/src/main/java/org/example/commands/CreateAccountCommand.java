package org.example.commands;

import java.security.NoSuchAlgorithmException;

import org.example.user.Account;
import org.example.user.AccountHandler;

public class CreateAccountCommand extends Command{
	private AccountHandler accountHandler;
	
	public CreateAccountCommand(AccountHandler accountHandler) {
		super("create", "create new account");
		Command.idCounter = 1;
		this.accountHandler = accountHandler;
	}

	  public boolean execute(String username, String password)  {
	        Account newAccount = accountHandler.createAccount(0, username, password);
	        return newAccount != null;
	    }

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}
}
