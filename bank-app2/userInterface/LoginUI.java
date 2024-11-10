package userInterface;

import java.security.NoSuchAlgorithmException;

import commands.CreateAccountCommand;
import commands.LoginCommand;
import user.AccountHandler;

public class LoginUI extends UserInterface{
	private AccountHandler accountHandler;
	private LoginCommand login;
	private CreateAccountCommand create;

	public LoginUI(AccountHandler accountHandler) {
		super();
		this.accountHandler = accountHandler;
		this.login = new LoginCommand(accountHandler);
		this.create = new CreateAccountCommand(accountHandler);
	}

	@Override 
	public void start() {
		int choice = -1;
		while(choice != 0) {
			menu();
			choice = input.handleMenuPrompt();
			switch(choice) {
			case 1: 
				try {
					if (handleLogin()) return;
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				break;
			case 2: 
				 handleCreateAccount(); 
				break;
			case 0:
				output.displayMessage("Exiting...");
				break; 
			default: 
				output.displayError("Invalid choice, please try agin");
				break;
			}
		}
	}

	@Override
	public void menu() {
		output.displayMenu(
				"------Login-------\n"
						+ "1. Login\n"
						+ "2. create account\n"
						+ "0. Exit\n"
						+ "------------------\n");
	}

	private boolean handleLogin() throws NoSuchAlgorithmException {
		output.displayMessage("Enter username:");
		String username = input.handleStringInput();
		output.displayMessage("Enter password:");
		String password = input.handleStringInput();

		if (login.authenticate(username, password)) {
			output.displayMessage("Login successful!");
			return true;
		} else {
			output.displayError("Login failed. Try again.");
			return false;
		}
	}

	private void handleCreateAccount() {
		output.displayMessage("Enter username:");
		String username = input.handleStringInput();
		output.displayMessage("Enter password:");
		String password = input.handleStringInput();

		try {
			if (create.createAccount(username, password)) {
				System.out.println("Account successfully created!");
			} else {
				System.out.println("Account creation failed. Try again.");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}	
	}
}
