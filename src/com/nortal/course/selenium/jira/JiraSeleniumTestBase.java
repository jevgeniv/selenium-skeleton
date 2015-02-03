package com.nortal.course.selenium.jira;

import com.nortal.course.selenium.SeleniumConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Base type of Selenium tests.
 */
public class JiraSeleniumTestBase {
    private static SeleniumConfig config;

    private WebDriver driver;

    @BeforeClass
    public static void init() {
        config = new SeleniumConfig();
        config.init();
    }

    @After
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
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
        if (driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    protected LoginPage login() {
        LoginPage loginPage = new LoginPage(this);
        loginPage.login(getJiraUser(), getJiraPassword());
        return loginPage;
    }
}
