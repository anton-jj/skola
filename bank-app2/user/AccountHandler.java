package user;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import utils.PasswordUtil;
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


    public Account authenticate(String username, String password) throws NoSuchAlgorithmException {
        Account account = accounts.get(username);

        if (account != null && !PasswordUtil.checkPassword(account.getPassword(), password)) {
        	currentAccount = account;
            return account;
        }
        return null;
    }

    public Account createAccount(String username, String password) throws NoSuchAlgorithmException {
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
