package com.tnsif.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostgresTableCreation {
    public static void main(String[] args) {
        // c (for connection) and stmt (for statement), initialized as null so they can
        // later hold the database connection and SQL statement, respectively.
        Connection c = null;
        Statement stmt = null; // sends SQL queries to the database.
        try {
            Class.forName("org.postgresql.Driver"); // dynamically loads the PostgreSQL JDBC driver class at runtime
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", EnvConfig.getPassword());
            System.out.println("Opened database successfully");

            stmt = c.createStatement(); // creates a Statement object used to send SQL commands to the database
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql); // executes the SQL command to create the COMPANY table
            stmt.close();
            c.close(); // releases resources and disconnects from the database
        } catch (Exception e) {
            // e.getClass().getName() tells you the type of exception (e.g. SQLException)
            // e.getMessage() retrieves the specific error message
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}
