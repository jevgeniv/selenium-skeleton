package com.nortal.course.selenium.jira;

import com.nortal.course.selenium.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateIssuePage extends BasePageObject {
    private final JiraSeleniumTestBase testBase;

    @FindBy(id="summary")
    private WebElement summaryFieldProxy;

    public CreateIssuePage(JiraSeleniumTestBase testBase) {
        super(testBase);
        this.testBase = testBase;
    }

    public boolean isReady() {
        return !testBase.getDriver().findElements(By.id("issuetype-field")).isEmpty()
                && !testBase.getDriver().findElements(By.id("summary")).isEmpty();
    }

    public WebElement getSummaryProxy() {
        return summaryFieldProxy;
    }

}
