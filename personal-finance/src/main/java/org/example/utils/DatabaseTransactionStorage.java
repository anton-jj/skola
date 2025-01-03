package org.example.utils;

import org.example.financeManager.Transaction;
import org.example.user.Account;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseTransactionStorage implements DataStorage<ArrayList<Transaction>> {
    private final String INSERT_TRANSACTION_SQL =
            "INSERT INTO transactions (description, type, user_id, amount, date) VALUES (?, ?, ?, ?, ?)";
    private final String SELECT_TRANSACTIONS_BY_USER_SQL =
            "SELECT * FROM transactions WHERE user_id = ?";
    private final String DELETE_TRANSACTION_SQL =
            "DELETE FROM transactions WHERE id = ?";

    Account currentAccount;

    public DatabaseTransactionStorage(Connection conn, Account currentAccount) {
        this.currentAccount = currentAccount;
    }


    @Override
    public void save(ArrayList<Transaction> data) {
        try (Connection conn = Database.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(INSERT_TRANSACTION_SQL)) {

            int userid = currentAccount.getId();

            if (userid == 0){
                throw new RuntimeException("User ID not valid");
            }

                for (Transaction transactions : data) {
                    ps.setString(1, transactions.getDescription());
                    ps.setString(2, String.valueOf(transactions.getType()));
                    ps.setInt(3, userid);
                    ps.setDouble(4, transactions.getAmount());
                    ps.setDate(5, Date.valueOf(transactions.getDate()));
                    ps.addBatch();
                }

                ps.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving transactions");
        }
    }

    @Override
    public ArrayList<Transaction> load() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_TRANSACTIONS_BY_USER_SQL)) {

            ps.setInt(1, currentAccount.getId());
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String description = res.getString("description");
                String type = res.getString( "type");
                int userId = res.getInt( "user_id");
                double amount = res.getDouble( "amount");
                Date date = res.getDate("date");

                System.out.println("Loaded transaction: " + description + " for user ID: " + userId);

                Transaction.TransactionType transactionType = Transaction.TransactionType.valueOf(type);
                transactions.add(new Transaction(amount, description, date.toLocalDate(), transactionType));
            }
            return transactions;
        } catch (SQLException e) {
            throw new RuntimeException("Error loading transactions");
        }
    }
}
