package ehub.com.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility {

	static String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\configReportData.properties";
	static String pathEnvironment = System.getProperty("user.dir") + "\\config.properties";

	public static String getProperty(String key) {
		String value = "";
		try {

			FileInputStream fis = new FileInputStream(path);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (Exception e) {
			System.out.println("Issue in PropertyUtility.getProperty " + e);
		}

		return value;
	}
	
	public static String getPropertyEnvironment(String key) {
		String value = "";
		try {

			FileInputStream fis = new FileInputStream(pathEnvironment);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (Exception e) {
			System.out.println("Issue in PropertyUtility.getPropertyEnvironment " + e);
		}

		return value;
	}
}
