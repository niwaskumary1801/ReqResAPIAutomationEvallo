package config;

import java.io.FileInputStream;
import java.util.Properties;
public class ConfigManager {

	    private static Properties props = new Properties();

	    static {
	        try {
	            FileInputStream fis = new FileInputStream("Config.properties");
	            props.load(fis);
	        } catch (Exception e) {
	            throw new RuntimeException("Unable to load  to load Config.properties", e);
	        }
	    }

	    public static String get(String key) {
	        return props.getProperty(key);
	    }
	}
