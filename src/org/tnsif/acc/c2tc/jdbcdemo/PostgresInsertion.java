package org.tnsif.acc.c2tc.jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresInsertion {
    public static void main(String[] args) {
        String insertSQL = "INSERT INTO students (id, name, fees, course) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertSQL)) {

            ps.setInt(1, 12);
            ps.setString(2, "Sushma");
            ps.setDouble(3, 20000);
            ps.setString(4, "Java Programming");
            ps.executeUpdate();

            ps.setInt(1, 13);
            ps.setString(2, "Anil");
            ps.setDouble(3, 30000);
            ps.setString(4, "Java Programming");
            ps.executeUpdate();

            System.out.println("Records inserted successfully.");

        } catch (SQLException e) {
            System.out.println("Error inserting records: " + e.getMessage());
        }
    }
}
