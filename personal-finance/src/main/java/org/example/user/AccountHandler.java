package org.example.user;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.example.utils.PasswordUtil;
import org.example.utils.UserStorage;
import org.example.utils.DataBaseUserStorage;

public class AccountHandler {
    private Map<String, Account> accounts;
    private DataBaseUserStorage dbStorage;
    private Account currentAccount;

    public AccountHandler(UserStorage userStorage, DataBaseUserStorage dbStorage) throws IOException {
        this.dbStorage = dbStorage;
        this.accounts = new HashMap<>();
        this.accounts = dbStorage.load();
        this.currentAccount = null;
    }


    public Account authenticate(String username, String password) throws NoSuchAlgorithmException {
        Account account = dbStorage.findUser(username);

        if (account != null && !PasswordUtil.checkPassword(account.getPassword(), password)) {
        	currentAccount = account;
            return account;
        }
        return null;
    }

    public Account createAccount(int id, String username, String password) throws NoSuchAlgorithmException {
        Account newAccount = new Account(id, username, password);

        accounts.put(username, newAccount);
        dbStorage.save(accounts);
        return newAccount;
    }

    public Account getCurrent() {
        return currentAccount;
    }
}
