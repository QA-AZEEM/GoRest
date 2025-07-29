package restassured.gorestapi.util;

import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	public static Properties properties = new Properties();
	static String fileName = "config.properties";
	
	static {
		try(InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(fileName)) {
			if(inputStream != null) {
				properties.load(inputStream);
			}else {
				throw new RuntimeException("unable to find the file " + fileName);
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to load the config.properties file " + fileName, e);
		}
	}
	
	public static String get(String key) {
		String evnVal = System.getenv(key);
		if(evnVal != null) {
			return evnVal;
		}return properties.getProperty(key);
	}
}
