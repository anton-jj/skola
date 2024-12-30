package org.example.utils;

import org.example.commands.Command;
import org.example.financeManager.Transaction;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseTransactionStorage implements DataStorage<ArrayList<Transaction>> {
    private final String INSERT_TRANSACTION_SQL =
            "INSERT INTO transactions (description, type, user_id, amount, date) VALUES (?, ?, ?, ?, ?)";
    private final String SELECT_TRANSACTIONS_BY_USER_SQL =
            "SELECT * FROM transactions WHERE user_id = ?";
    private final String DELETE_TRANSACTION_SQL =
            "DELETE FROM transactions WHERE id = ?";
    private final String FIND_USER_SQL = "SELECT id FROM users WHERE username = ?";

    private Connection conn;
    private String username;

    public DatabaseTransactionStorage(Connection conn, String username) {
        this.conn = conn;
        this.username = username;
    }



    @Override
    public void save(ArrayList<Transaction> data) {
        try {
            PreparedStatement userps = conn.prepareStatement(FIND_USER_SQL);
            userps.setString(1, username);
            ResultSet res = userps.executeQuery();

            int userid = 0;

            if (res.next()) {
                userid = res.getInt("id");
            } else {
                throw new RuntimeException("user not found");
            }

            try (PreparedStatement ps = conn.prepareStatement(INSERT_TRANSACTION_SQL)) {
                for (Transaction transactions : data) {
                    ps.setString(1, transactions.getDescription());
                    ps.setString(2, String.valueOf(transactions.getType()));
                    ps.setInt(3, userid);
                    ps.setDouble(4, transactions.getAmount());
                    ps.setDate(5, Date.valueOf(transactions.getDate()));
                    ps.addBatch();
                }
                ps.executeBatch();
            }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error saving transactions");
            }
        }

    @Override
    public ArrayList<Transaction> load() {
        return null;
    }
}
