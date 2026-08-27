package org.tnsif.acc.c2tc.jdbcdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresSelect {
    public static void main(String[] args) {
        String selectSQL = "SELECT * FROM students";

        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double fees = rs.getDouble("fees");
                String course = rs.getString("course");

                System.out.println("Id: " + id + ", Name: " + name +
                        ", Fees: " + fees + ", Course: " + course);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching records: " + e.getMessage());
        }
    }
}
