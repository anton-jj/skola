package org.example.utils;

import org.example.commands.Command;
import org.example.financeManager.Transaction;

import java.sql.Connection;
import java.util.ArrayList;

public class DatabaseTransactionStorage implements DataStorage<ArrayList<Transaction>> {
    private final String INSERT_TRANSACTION_SQL =
            "INSERT INTO transactions (description, type, user_id, amount, date) VALUES (?, ?, ?, ?, ?)";
    private final String SELECT_TRANSACTIONS_BY_USER_SQL =
            "SELECT * FROM transactions WHERE user_id = ?";
    private final String DELETE_TRANSACTION_SQL =
            "DELETE FROM transactions WHERE id = ?";
    private Connection conn;
    private String username;

    public DatabaseTransactionStorage(Connection conn, String username) {
        this.conn = conn;
        this.username = username;
    }

    @Override
    public void save(ArrayList<Transaction> data) {

    }

    @Override
    public ArrayList<Transaction> load() {
        return null;
    }
}
