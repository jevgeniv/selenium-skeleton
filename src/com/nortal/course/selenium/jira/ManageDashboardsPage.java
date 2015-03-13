package com.nortal.course.selenium.jira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by pavel on 17/02/15.
 */
public class ManageDashboardsPage {

    @FindBy(xpath = "//section/header//h1")
    private WebElement header;

    @FindBy(id = "create_page")
    private WebElement createNewDashboard;

    private JiraSeleniumTestBase testBase;

    public ManageDashboardsPage(JiraSeleniumTestBase testBase) {
        this.testBase = testBase;
        PageFactory.initElements(testBase.getDriver(), this);
        assertEquals("Manage Dashboards", header.getText());
    }

    public CreateDashboardPage getCreateDashboardPage(){
        createNewDashboard.click();
        return new CreateDashboardPage(testBase);
    }

    public String getHeaderText(){
        return  header.getText();
    }
}
