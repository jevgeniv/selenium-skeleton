package com.nortal.course.selenium.jira;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by jevgeni on 1/30/15.
 */
public class SeleniumTestConfig {

    private Properties properties;

    public void init() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("selenium-rc.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
