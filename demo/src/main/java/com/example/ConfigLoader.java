package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + CONFIG_FILE);
            } else {
                // Load key-value pairs from the stream
                properties.load(input); 
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

//Ensure that the config.properties file is placed in the src/main/resources directory (if using Maven or Gradle), 
//as this will allow ClassLoader to locate it properly. 
//Otherwise, you might encounter the "unable to find" message.