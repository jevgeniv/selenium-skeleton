package com.nortal.course.selenium.jira;

import com.nortal.course.selenium.ScreenshotRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Category(JiraSeleniumTestBase.class)
public class JiraSearchIssueTest extends JiraSeleniumTestBase {

    @Test
    public void searchNonExisting() {
        login();
        ScreenshotRule.makeScreenshot(getDriver(), "searchTest-afterLogin");
        searchIssue("ATL-1000111220011");
        ScreenshotRule.makeScreenshot(getDriver(), "searchTest-afterSearch");
        String notFoundText = "Issue Does Not Exist";

        // FIXME
        assertTrue("should contain text " + notFoundText , getDriver().findElements(By.xpath("//*[contains(text(), '" + notFoundText + "')]")).size() == 1);

    }

    private void searchIssue(String searchKeyword) {
        SearchPage searchPage = new SearchPage(this);
        searchPage.doSearch(searchKeyword);
    }
}
