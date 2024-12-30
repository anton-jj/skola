package org.example.utils;

import org.example.user.Account;

import javax.xml.crypto.Data;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DataBaseUserStorage implements DataStorage <Map<String, Account>>{
    private final String SELECT_USER_QUERY = "SELECT * FROM users WHERE username = ?";
    private final String INSERT_USER_QUERY = "INSERT INTO users (username, password) VALUES (?, ?)";
    private final String UPDATE_USER_QUERY = "UPDATE users SET password = ? WHERE username = ?";
    private final String DELETE_USER_QUERY = "DELETE FROM users WHERE username = ?";

    Connection conn = null;
    Statement statement = null;
    ResultSet res = null;

    public Account findUser(String username ) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try {
            conn = DataBase.getInstance().getConnection();
            ps = conn.prepareStatement(SELECT_USER_QUERY);
            ps.setString(1, username);
            res = ps.executeQuery();

            if (res.next()) {
                int id = res.getInt("id");
                String password = res.getString("password");
                return new Account(id, username, password);
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

        try  {
            conn = DataBase.getInstance().getConnection();
            for (Account account : data.values()) {
                Account existingUser = findUser(account.getUsername());


                if (existingUser != null) {
                    ps = conn.prepareStatement(UPDATE_USER_QUERY);
                    ps.setString(1, account.getPassword());
                    ps.setString(2, account.getUsername());
                    ps.executeUpdate();
                } else {
                    ps = conn.prepareStatement(INSERT_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1, account.getUsername());
                    ps.setString(2, account.getPassword());
                    ps.executeUpdate();

                    ResultSet genKey = ps.executeQuery();

                    if (genKey.next()) {
                        int id = genKey.getInt(1);
                        account.setId(id);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error saving account", e);
        } finally {
            try {
                if (ps != null) ps.close();

            } catch (SQLException e) {
                System.err.println("Error closing statment" +  e.getMessage());
            }
        }
    }


    @Override
    public Map<String, Account> load() {
        Map<String, Account> accounts = new HashMap<>();

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

    public boolean deleteUser(String username) {
       try (Connection conn = DataBase.getInstance().getConnection();
            PreparedStatement ps =  conn.prepareStatement(DELETE_USER_QUERY)) {

           ps.setString(1, username);
           int rows = ps.executeUpdate();
           return rows > 0;
           } catch (SQLException e ) {
            System.err.println("error deleting user" + e);
            return false;
           }
       }
    }
