package commands;

import java.security.NoSuchAlgorithmException;

import user.Account;
import user.AccountHandler;

public class LoginCommand extends Command{
	

	private AccountHandler accountHandler;

	public LoginCommand(AccountHandler accountHandler) {
		super("login", "login on existing user");
		Command.idCounter = 0;
		this.accountHandler = accountHandler;
	}

	public boolean execute(String username, String password) throws NoSuchAlgorithmException {
		Account account = accountHandler.authenticate(username, password);
		return account != null;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}
}
