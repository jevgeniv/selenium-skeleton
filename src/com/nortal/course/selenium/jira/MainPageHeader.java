package com.nortal.course.selenium.jira;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Elements present on most of non-overlayed pages.
 */
public class MainPageHeader {
    private JiraSeleniumTestBase testBase;

    @FindBy(id = "create_link")
    private WebElement createIssueClickable;

    public void clickCreateIssue() {
        createIssueClickable.click();
    }

}
