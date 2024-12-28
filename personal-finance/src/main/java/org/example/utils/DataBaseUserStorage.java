package org.example.utils;

import org.example.user.Account;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DataBaseUserStorage implements DataStorage {
    private static final String SELECT_USER_QUERY = "SELECT * FROM users WHERE username = ?";
    private static final String INSERT_USER_QUERY = "INSERT INTO users (username, password) VALUES (?, ?)";
    private static final String UPDATE_USER_QUERY = "UPDATE users SET password = ? WHERE username = ?";

    @Override
    public void save(Object data) {

    }

    @Override
    public Map<String, Account> load() {
        Map<String, Account> accounts = new HashMap<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet res = null;

        try {
            conn = DataBase.getInstance().getConnection();
            statement = conn.createStatement();
            res = statement.executeQuery("SELECT * FROM users");

            while (res.next()) {
                int id = res.getInt("id");
                String username = res.getString("username");
                String password = res.getString("password");

                accounts.put(username, new Account(id, username, password));
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            System.out.println("Error loading accounts from database" + e.getMessage());
        } finally {
            try {
                if (res != null) res.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                System.out.println("Error closing" + e.getMessage());
            }
        }
        return accounts;
    }
}
