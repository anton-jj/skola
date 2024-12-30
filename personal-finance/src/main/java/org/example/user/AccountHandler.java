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

    public AccountHandler(DataBaseUserStorage dbStorage)  {
        this.dbStorage = dbStorage;
        this.accounts = new HashMap<>();
        this.accounts = dbStorage.load();
        this.currentAccount = null;
    }

    public boolean deleteAccount(String username) {
        Account account = dbStorage.findUser(username);

        if (account != null) {
           return dbStorage.deleteUser(username);
        }
        return false;
    }

    public Account authenticate(String username, String password) {
        Account account = dbStorage.findUser(username);
        if (account != null)  {
            String hashedPw = account.getPassword();

            if (!PasswordUtil.checkPassword(password, hashedPw)) {
                String newHashedPw = PasswordUtil.hashPassword(password);
            }else {
                currentAccount = account;
                return account;
            }
        }
        return null;
    }

    public Account createAccount(int id, String username, String password)  {
        Account existingUser = dbStorage.findUser(username);

        if (existingUser != null) {
            throw new RuntimeException("User already exists");
        }

        String hashedpw = PasswordUtil.hashPassword(password);
        Account newAccount = new Account(0, username, hashedpw);

        accounts.put(username, newAccount);

        dbStorage.save(accounts);

       return newAccount;
    }

    public Account getCurrent() {
        return currentAccount;
    }
}
