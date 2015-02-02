package com.nortal.course.selenium.jira;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by jevgeni on 1/30/15.
 */
public class JiraSeleniumTestBase {
    private static SeleniumTestConfig config;

    private WebDriver driver;

    @BeforeClass
    public static void init() {
        config = new SeleniumTestConfig();
        config.init();
    }

    @Before
    public void setUpSelenium() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDownSelenium() {
        driver.quit();
    }

    public String getConfigParameter(String paramKey) {
        return config.getProperty(paramKey);
    }

    public String getJiraUrl() {
        return getConfigParameter("selenium.jira.url");
    }

    public String getJiraUser() {
        return getConfigParameter("selenium.jira.user");
    }

    public String getJiraPassword() {
        return getConfigParameter("selenium.jira.password");
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
