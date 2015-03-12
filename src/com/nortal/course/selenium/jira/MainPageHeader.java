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
    private final WebDriver driver;

    @FindBy(id = "create_link")
    private WebElement createIssueClickableProxy;

    @FindBy(id = "home_link")
    private WebElement dashBoardsBtn;

    @FindBy(id = "manage_dash_link_lnk")
    private WebElement manageDashboardsBtn;

    public MainPageHeader(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateIssue() {
        createIssueClickableProxy.click(); // ~= driver.findElement(...).select();
    }

    public ManageDashboardsPage getManageDashboardsPage(){
        dashBoardsBtn.click();
        WebDriverWait wait = new WebDriverWait(driver , 10);
        wait.until(ExpectedConditions.elementToBeClickable(manageDashboardsBtn)).click();
        return new ManageDashboardsPage(driver);
    }
}
