package user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import utils.UserStorage;

public class AccountHandler {

    private Map<String, Account> accounts;
    private UserStorage userStorage;
    private Account currentAccount;

    public AccountHandler(UserStorage userStorage) throws IOException {
        this.userStorage = userStorage;
        this.accounts = new HashMap<>();
        this.accounts = userStorage.load();
        this.currentAccount = null;

    }

    /*public void login(String username, String password) {
        Account account = authenticate(username, password);
        if (account != null) {
            currentAccount = account;
        } else {
            System.out.println("Invalid username or password");
        }
    } */

    public Account authenticate(String username, String password) {
        Account account = accounts.get(username);
        if (account != null && account.getPassword().equals(password)) {
        	currentAccount = account;
            return account;
        }
        return null;
    }

    public Account createAccount(String username, String password) {
        Account newAccount = new Account(username, password);
        accounts.put(username, newAccount);
        saveAccounts();
        return newAccount;
    }

    private void saveAccounts() {
        try {
            userStorage.save(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    public Account getCurrent() {
        return currentAccount;
    }
}
