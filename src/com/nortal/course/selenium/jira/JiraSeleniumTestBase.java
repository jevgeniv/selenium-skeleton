package com.nortal.course.selenium.jira;

import org.junit.BeforeClass;

/**
 * Created by jevgeni on 1/30/15.
 */
public class JiraSeleniumTestBase {
    private static SeleniumTestConfig config;

    @BeforeClass
    public static void init() {
        config = new SeleniumTestConfig();
        config.init();
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
}
