package com.nortal.course.selenium.jira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Elements present on most of non-overlayed pages.
 */
public class MainPageHeader {
    @FindBy(id = "create_link")
    private WebElement createIssueClickableProxy;

    @FindBy(id = "home_link")
    private WebElement dashBoardsBtn;

    @FindBy(id = "manage_dash_link_lnk")
    private WebElement manageDashboardsBtn;
    private JiraSeleniumTestBase testBase;

    public MainPageHeader(JiraSeleniumTestBase testBase){
        this.testBase = testBase;
        PageFactory.initElements(testBase.getDriver(), this);
    }

    public void clickCreateIssue() {
        createIssueClickableProxy.click(); // ~= driver.findElement(...).select();
    }

    public ManageDashboardsPage getManageDashboardsPage(){
        dashBoardsBtn.click();
        WebDriverWait wait = new WebDriverWait( testBase.getDriver() , 20);
        wait.until(ExpectedConditions.elementToBeClickable(manageDashboardsBtn)).click();
        return new ManageDashboardsPage(testBase);
    }
}