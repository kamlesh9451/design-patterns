package dev.kp.designpattern.creational.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

enum AppConfigManager  {
    INSTANCE;
    private final Properties properties;

    // Constructor runs once when INSTANCE is created
    AppConfigManager () {
         properties = new Properties();
        try (InputStream input = AppConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            // Load properties from the file
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Access values
        String name = properties.getProperty("app.name");
        String version = properties.getProperty("app.version");
        String author = properties.getProperty("app.author");

        System.out.println("App Name: " + name);
        System.out.println("Version: " + version);
        System.out.println("Author: " + author);
     }

     // Method to get property value by key
     public String getProperty(String key) {
         return properties.getProperty(key);
     }

}


