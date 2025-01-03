package org.example.utils;

import org.example.user.Account;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DataBaseUserStorage implements DataStorage <Map<String, Account>>{
    private final String SELECT_USER_QUERY_BY_ID = "SELECT * FROM users WHERE id = ?";
    private final String SELECT_USER_QUERY = "SELECT * FROM users WHERE username = ?";
    private final String INSERT_USER_QUERY = "INSERT INTO users (username, password, balance) VALUES (?, ?, ?)";
    private final String UPDATE_USER_QUERY = "UPDATE users SET password = ?, balance = ? WHERE username = ?";
    private final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";

    Connection conn = null;
    Statement statement = null;
    ResultSet res = null;

    public Account findUser(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            conn = Database.getInstance().getConnection();
            ps = conn.prepareStatement(SELECT_USER_QUERY);
            ps.setString(1, username);
            res = ps.executeQuery();

            if (res.next()) {
                int id = res.getInt("id");
                String password = res.getString("password");
                double balance = res.getDouble("balance");
                return new Account(id, username, password, balance);
            }
            return null;
        } catch (SQLException  e) {
            throw new RuntimeException("Could not find user: " + e.getMessage());
        } finally {
            try {
                if (res != null) res.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources " +  e.getMessage());
            }
        }
    }


    @Override
    public void save(Map<String, Account> data) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try  {
            conn = Database.getInstance().getConnection();
            for (Account account : data.values()) {
                String hashedPassword = PasswordUtil.hashPassword(account.getPassword());

                Account existingUser = findUser(account.getUsername());

                if (existingUser != null) {
                    ps = conn.prepareStatement(UPDATE_USER_QUERY);
                    ps.setString(1, account.getPassword());
                    ps.setDouble(2, account.getBalance());
                    ps.setString(3, account.getUsername());
                    ps.executeUpdate();
                } else {
                    ps = conn.prepareStatement(INSERT_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1, account.getUsername());
                    ps.setString(2, account.getPassword());
                    ps.setDouble(3, account.getBalance());
                    ps.executeUpdate();

                    res = ps.getGeneratedKeys();

                    if (res.next()) {
                        int id = res.getInt(1);
                        account.setId(id);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error saving account", e);
        } finally {
            try {
                if (ps != null) ps.close();
                if (res != null) res.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement" +  e.getMessage());
            }
        }
    }


    @Override
    public Map<String, Account> load() {
        Map<String, Account> accounts = new HashMap<>();

        try {
            conn = Database.getInstance().getConnection();
            statement = conn.createStatement();
            res = statement.executeQuery("SELECT * FROM users");

            while (res.next()) {
                int id = res.getInt("id");
                String username = res.getString("username");
                String password = res.getString("password");
                double balance = res.getDouble("balance");

                accounts.put(username, new Account(id, username, password, balance));
            }
        } catch (SQLException e) {
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

    public boolean deleteUser(int id) {
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement ps =  conn.prepareStatement(DELETE_USER_QUERY)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e ) {
            System.err.println("error deleting user" + e);
            return false;
        }
    }

    public Account findUserById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            conn = Database.getInstance().getConnection();
            ps = conn.prepareStatement(SELECT_USER_QUERY_BY_ID);
            ps.setInt(1, id);
            res = ps.executeQuery();

            if (res.next()) {
                String username = res.getString("username");
                String password = res.getString("password");
                double balance = res.getDouble("balance");
                return new Account(id, username, password, balance);
            }
            return null;
        } catch (SQLException  e) {
            throw new RuntimeException("Could not find user: " + e.getMessage());
        } finally {
            try {
                if (res != null) res.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources " +  e.getMessage());
            }
        }

    }
}