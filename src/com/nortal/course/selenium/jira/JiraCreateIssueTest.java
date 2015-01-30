package com.nortal.course.selenium.jira;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by jevgeni on 1/30/15.
 */
public class JiraCreateIssueTest extends JiraSeleniumTestBase {

    @Test
    public void propertiesAreNotEmpty() {
        assertNotEmpty(getJiraUrl());
        assertNotEmpty(getJiraUser());
        assertNotEmpty(getJiraPassword());
    }

    @Test
    public void login() {
        WebDriver driver = new FirefoxDriver();
        driver.get(getJiraUrl() + "/login.jsp");
        driver.findElement(By.id("login-form-username")).sendKeys("tstcreateissue8"); // TODO
        driver.findElement(By.id("login-form-password")).sendKeys("password");
        driver.findElement(By.id("login-form-submit")).click();

        driver.findElement(By.id("quickSearchInput")).sendKeys("ATL-348"); // TODO
        driver.findElement(By.id("quickSearchInput")).sendKeys(Keys.RETURN);
    }

    private void assertNotEmpty(String s) {
        Assert.assertTrue(s != null && s.length() > 0);
    }

}
