package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static DataBase instance;
    private Connection conn;
    String url = "jdbc:postgresql://localhost/finance?user=postgres&password=password";

    private DataBase(){

    }

    public static DataBase getInstance() {
        if (instance == null) {
            synchronized (DataBase.class) {
                if (instance == null) {
                    instance = new DataBase();
                    instance.createConnection();
                }
            }
        }
        return instance;
    }

    private void createConnection() {
        try {
            System.out.println("Attempting to connect to database...");
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                System.out.println("Database connected successfully!");
            } else {
                System.out.println("Database connection failed: conn is null.");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
      return this.conn;
  }

  public void createTables(){

        if (conn == null) {
            System.out.println("failed to connect to database");
            return;
        }
        try (Statement createTable = conn.createStatement()) {
            createTable.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id SERIAL PRIMARY KEY," +
                    "username TEXT NOT NULL UNIQUE," +
                    "password TEXT NOT NULL)");

            createTable.execute("CREATE TABLE IF NOT EXISTS transactions (" +
                    "id SERIAL PRIMARY KEY," +
                    "description TEXT, " +
                    "type text, " +
                    "user_id INT REFERENCES users(id), " +
                    "date DATE)");
        } catch (RuntimeException | SQLException e) {
          throw new RuntimeException(e);
        }
  }
}
