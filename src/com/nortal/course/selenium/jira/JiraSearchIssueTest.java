package com.nortal.course.selenium.jira;

import com.nortal.course.selenium.ScreenshotRule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

@Category(JiraSeleniumTestBase.class)
public class JiraSearchIssueTest extends JiraSeleniumTestBase {

    @Test
    public void searchNonExisting() {
        login();
        ScreenshotRule.makeScreenshot(getDriver(), "searchTest-afterLogin");
        searchIssue("ATL-1000111220011");
        ScreenshotRule.makeScreenshot(getDriver(), "searchTest-afterSearch");
        String notFoundText = "Issue Does Not Exist";
        Assert.assertNotNull("Should display text",
                getDriver().findElement(By.xpath("//*[contains(text(), '" + notFoundText + "')]")));

    }

    private void searchIssue(String searchKeyword) {
        getDriver().findElement(By.id("quickSearchInput")).sendKeys(searchKeyword);
        getDriver().findElement(By.id("quickSearchInput")).sendKeys(Keys.RETURN);
    }
}
