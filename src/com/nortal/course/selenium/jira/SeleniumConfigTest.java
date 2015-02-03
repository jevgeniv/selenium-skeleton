package com.nortal.course.selenium.jira;

import org.junit.Assert;
import org.junit.Test;

public class SeleniumConfigTest extends JiraSeleniumTestBase {

    @Test
    public void propertiesAreNotEmpty() {
        assertNotEmpty(getJiraUrl());
        assertNotEmpty(getJiraUser());
        assertNotEmpty(getJiraPassword());
    }

    private void assertNotEmpty(String s) {
        Assert.assertTrue(s != null && s.length() > 0);
    }
}
