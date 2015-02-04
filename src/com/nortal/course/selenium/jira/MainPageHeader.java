package com.nortal.course.selenium.jira;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Elements present on most of non-overlayed pages.
 */
public class MainPageHeader {
    @FindBy(id = "create_link")
    private WebElement createIssueClickableProxy;

    public void clickCreateIssue() {
        createIssueClickableProxy.click(); // ~= driver.findElement(...).select();
    }

}
