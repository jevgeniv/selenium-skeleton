package com.nortal.course.selenium.jira;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

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
        SearchPage searchPage = new SearchPage(this);
        searchPage.doSearch(searchKeyword);
    }
}
