package com.nortal.course.selenium.jira;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;

/**
 * Created by karl on 20.02.2015.
 */
public class CreateDashboardPage extends BasePageObject{

    @FindBy(xpath = "(//h1)[2]")
    private WebElement header;

    @FindBy(id = "add-dashboard-submit")
    private WebElement add;

    @FindBy(name = "portalPageName")
    private WebElement nameField;

    @FindBy(xpath = "//div[@class='error']")
    private WebElement nameFieldError;

    @FindBy(id = "share_type_selector")
    private WebElement shareTypeSelector;

    public static String shareGroupValue = "group";
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
    public void add(){
        add.click();
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
