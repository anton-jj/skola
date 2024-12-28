package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static DataBase instance;
    private Connection conn;
    String url = "jdbc:postgresql://localhost/finance?user=postgres&password=password";

    public DataBase() {
        try  {
            conn = DriverManager.getConnection(url);
        }  catch (SQLException e) {
            System.out.println("Error connecting to database" + e.getMessage());
        }
    }


    public static DataBase getInstance() {
        if (instance == null) {
            return new DataBase();
        }
        return instance;
    }

    public Connection getConnection() {
      return this.conn;
  }

  public void createTables(){
      Statement createTable = null;
      try {
          createTable = conn.createStatement();
            createTable.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id SERIAL PRIMARY KEY," +
                    "username TEXT NOT NULL," +
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
