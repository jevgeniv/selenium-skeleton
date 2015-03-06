package com.nortal.course.selenium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Runtime properties & configuration.
 */
public class SeleniumConfig {

    private Properties properties;

    public void init() {
        // "rc" for runtime configuration (as opposed to build-time)
        properties = new Properties(makePropertiesFromFile("selenium-common-rc.properties"));
        loadPropertiesFromFile(properties, "selenium-rc.properties");
    }

    private void loadPropertiesFromFile(Properties p, String filename) {
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filename);
            if (resourceAsStream == null) {
                throw new IllegalStateException("File " + filename + " could not be read");
            }
            p.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException("Error reading properties from file " + filename, e);
        }
    }

    private Properties makePropertiesFromFile(String filename) {
        Properties p = new Properties();
        loadPropertiesFromFile(p, filename);
        return p;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
