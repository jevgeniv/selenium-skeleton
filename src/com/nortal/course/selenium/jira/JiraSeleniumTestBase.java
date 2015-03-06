package com.nortal.course.selenium.jira;

import com.google.common.base.Supplier;
import com.nortal.course.selenium.ScreenshotRule;
import com.nortal.course.selenium.SeleniumConfig;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Base type of Selenium tests.
 */
public class JiraSeleniumTestBase {
    private static SeleniumConfig config;

    private WebDriver driver;
    private static JiraSeleniumTestBase instance;
    private Waits waits;

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(new Supplier<WebDriver>() {
        @Override
        public WebDriver get() {
            return getDriver();
        }
    });

    @BeforeClass
    public static void init() {
        config = new SeleniumConfig();
        config.init();
    }

    @Before
    public void setUp() {
        instance = this;
    }

    @AfterClass
    public static void tearDownDriver() {
        if (instance != null && instance.driver != null) {
            instance.driver.quit();
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

    protected Waits waits(){
        if(waits==null){
            this.waits = new Waits(driver);
        }
        return waits;
    }
}
