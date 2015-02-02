package com.nortal.course.selenium.jira;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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
    public void search_1() {
        login();
        searchIssue("ATL-348");// TODO
    }

    @Test
    public void search_2() {
        login();
        searchIssue("ATL-78263497863498726373");
    }

    private void searchIssue(String searchKeyword) {
        getDriver().findElement(By.id("quickSearchInput")).sendKeys(searchKeyword);
        getDriver().findElement(By.id("quickSearchInput")).sendKeys(Keys.RETURN);
    }

    private void login() {
        getDriver().get(getJiraUrl() + "/login.jsp");
        getDriver().findElement(By.id("login-form-username")).sendKeys("tstcreateissue8"); // TODO
        getDriver().findElement(By.id("login-form-password")).sendKeys("password");
        getDriver().findElement(By.id("login-form-submit")).click();
    }

    private void assertNotEmpty(String s) {
        Assert.assertTrue(s != null && s.length() > 0);
    }

}
