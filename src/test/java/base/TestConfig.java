package base;

import java.io.InputStream;
import java.util.Properties;

public final class TestConfig {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream is = TestConfig.class
                .getClassLoader()
                .getResourceAsStream("store.properties")) {

            if (is == null) {
                throw new RuntimeException("store.properties not found in resources");
            }

            PROPERTIES.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load store.properties", e);
        }
    }

    private TestConfig() {}

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
