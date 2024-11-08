package commands;

import user.Account;
import user.AccountHandler;

public class LoginCommand extends Command{
	

	private AccountHandler accountHandler;

	public LoginCommand(AccountHandler accountHandler) {
		super("login", "login on existing user");
		Command.idCounter = 0;
		this.accountHandler = accountHandler;
	}

	@Override
	public void execute() {

	}

	public boolean authenticate(String username, String password) {
		Account account = accountHandler.authenticate(username, password);
		return account != null;
	}
}
