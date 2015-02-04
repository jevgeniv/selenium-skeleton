package com.nortal.course.selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchPage {
    final JiraSeleniumTestBase testBase;

    public SearchPage(JiraSeleniumTestBase testBase) {
        this.testBase = testBase;
    }

    public void doSearch(String searchKeyword) {
        getQuickSearchInput().sendKeys(searchKeyword);
        getQuickSearchInput().sendKeys(Keys.RETURN);
    }

    private WebElement getQuickSearchInput() {
        return testBase.getDriver().findElement(By.id("quickSearchInput"));
    }
}
