package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class pombaseclass {

    protected static Properties prop = new Properties();

    public static void getProperty() {
        // Try loading the file from the classpath
        try (InputStream input = pombaseclass.class.getClassLoader()
                .getResourceAsStream("pomproperties/Locators.properties")) {

            if (input == null) {
                System.out.println("❌ Locators.properties not found in classpath!");
                return;
            }

            prop.load(input);
            System.out.println("✅ Locators.properties loaded successfully from classpath!");

        } catch (IOException e) {
            System.out.println("❌ Error loading Locators.properties:");
            e.printStackTrace();
        }
    }
}
