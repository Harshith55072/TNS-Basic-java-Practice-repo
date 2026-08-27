package org.tnsif.acc.c2tc.jdbcdemo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresTableCreation {
    public static void main(String[] args) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "fees DOUBLE PRECISION, " +
                "course VARCHAR(50))";

        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL);
            System.out.println("Table 'students' created (or already exists).");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}
