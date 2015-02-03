package com.nortal.course.selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateIssuePage {
    private final JiraSeleniumTestBase testBase;

    @FindBy(id="summary")
    private WebElement summaryField;

    public static CreateIssuePage makeInstance(JiraSeleniumTestBase testBase) {
        CreateIssuePage page = new CreateIssuePage(testBase);
        PageFactory.initElements(testBase.getDriver(), page);
        return page;
    }

    private CreateIssuePage(JiraSeleniumTestBase testBase) {
        this.testBase = testBase;
    }

    public boolean isReady() {
        return !testBase.getDriver().findElements(By.id("issuetype-field")).isEmpty();
    }

    public WebElement getSummaryProxy() {
        return summaryField;
    }

    public WebElement getPriorityField() {
        return testBase.getDriver().findElement(By.id("priority-field"));
    }

}
