package org.tnsif.acc.c2tc.jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresUpdate {
    public static void main(String[] args) {
        String updateSQL = "UPDATE students SET fees = ? WHERE id = ?";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(updateSQL)) {

            ps.setDouble(1, 25000);
            ps.setInt(2, 12);

            int rowsAffected = ps.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");

        } catch (SQLException e) {
            System.out.println("Error updating record: " + e.getMessage());
        }
    }
}
