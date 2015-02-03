package com.nortal.course.selenium.jira;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class JiraSearchIssueTest extends JiraSeleniumTestBase {

    @Test
    public void searchNonExisting() {
        login();
        searchIssue("ATL-1000111220011");
        String notFoundText = "Issue Does Not Exist";
        Assert.assertNotNull("Should display text",
                getDriver().findElement(By.xpath("//*[contains(text(), '" + notFoundText + "')]")));

    }

    private void searchIssue(String searchKeyword) {
        getDriver().findElement(By.id("quickSearchInput")).sendKeys(searchKeyword);
        getDriver().findElement(By.id("quickSearchInput")).sendKeys(Keys.RETURN);
    }
}
