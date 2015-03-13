package com.nortal.course.selenium.jira;

import com.nortal.course.selenium.BasePageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;

/**
 * Created by karl on 20.02.2015.
 */
public class CreateDashboardPage extends BasePageObject {

    @FindBy(xpath = "//section/header//h1")
    private WebElement header;

    @FindBy(id = "add-dashboard-submit")
    private WebElement add;

    @FindBy(name = "portalPageName")
    private WebElement nameField;

    @FindBy(xpath = "//div[@class='error']")
    private WebElement nameFieldError;

    @FindBy(id = "share_type_selector")
    private WebElement shareTypeSelector;

    @FindBy(id = "groupShare")
    private WebElement groupSelector;

    @FindBy(id = "share_add_group")
    private WebElement addShares;

    @FindBy(id = "delete_dashboard")
    private WebElement delete_dashboards;

    public static String shareGroupValue = "group";
    public static String groupJiraUsers = "jira-users";
    private JiraSeleniumTestBase testContext;

    public CreateDashboardPage(JiraSeleniumTestBase testContext){
        super(testContext.getDriver());
        this.testContext = testContext;
    }

    public void addName(){
        nameField.sendKeys(getUniqueDashboardName());
    }

    public void selectShares(String shareName){
        super.selectElement(shareTypeSelector, shareName);
        testContext.waits();

    }

    public void selectGroup(String shareName){
        super.selectElement(groupSelector, shareName);
        testContext.waits();
    }


    public void add(){
        add.click();
    }

    public void addShares(){
        addShares.click();
    }

    public String getHeaderText(){
        return header.getText();
    }

    public String getNameError(){
        return nameFieldError.getText();
    }

    private String getUniqueDashboardName(){
        return new Date().toString() + " test dashboard";
    }
}
