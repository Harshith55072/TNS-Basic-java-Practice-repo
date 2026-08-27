package org.tnsif.acc.c2tc.jdbcdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

// Shared helper so the DB credentials aren't repeated in every class.
// UPDATE the URL/USERNAME below to match your own PostgreSQL setup.
// The password is NOT hardcoded here - it's read from a ".env" file
// (at the project root) via the DB_PASSWORD variable, so it never gets
// committed to source control (.env is listed in .gitignore).
public class DBConnectionUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = loadPassword();

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Reads DB_PASSWORD out of a .env file (simple KEY=VALUE format, one per line).
    // Looks in the current working directory first, then falls back to a real
    // environment variable named DB_PASSWORD if no .env file is found.
    private static String loadPassword() {
        Map<String, String> env = readEnvFile(".env");
        if (env.containsKey("DB_PASSWORD")) {
            return env.get("DB_PASSWORD");
        }

        String systemEnvValue = System.getenv("DB_PASSWORD");
        if (systemEnvValue != null) {
            return systemEnvValue;
        }

        throw new IllegalStateException(
                "DB_PASSWORD not found. Add a .env file with DB_PASSWORD=yourpassword " +
                        "in the project root, or set a DB_PASSWORD environment variable.");
    }

    private static Map<String, String> readEnvFile(String path) {
        Map<String, String> values = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#") || !line.contains("=")) {
                    continue;
                }
                int separatorIndex = line.indexOf('=');
                String key = line.substring(0, separatorIndex).trim();
                String value = line.substring(separatorIndex + 1).trim();
                values.put(key, value);
            }
        } catch (Exception e) {
            // .env file not found here - that's fine, loadPassword() falls back to System.getenv()
        }
        return values;
    }
}
