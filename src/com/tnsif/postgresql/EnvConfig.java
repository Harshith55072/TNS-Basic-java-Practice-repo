package com.tnsif.postgresql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

// Reads the DB password out of a .env file (KEY=VALUE format) instead of
// hardcoding it in source. .env sits at the project root and is gitignored,
// so the real password never ends up in source control.
public class EnvConfig {

    public static String getPassword() {
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
            // .env file not found here - that's fine, getPassword() falls back to System.getenv()
        }
        return values;
    }
}
