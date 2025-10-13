package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class pombaseclass {
	protected static Properties prop;
	public static void getProperty() {
		new Properties();
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/pomproperites/Locators.properties");

			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
