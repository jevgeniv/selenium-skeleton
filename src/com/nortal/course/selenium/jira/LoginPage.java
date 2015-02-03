package com.nortal.course.selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private JiraSeleniumTestBase testBase;

    public LoginPage(JiraSeleniumTestBase testBase) {
        this.testBase = testBase;
        this.driver = testBase.getDriver();
    }

    public void login(String user, String pass) {
        driver.get(testBase.getJiraUrl() + "/login.jsp");
        driver.findElement(By.id("login-form-username")).sendKeys(user);
        driver.findElement(By.id("login-form-password")).sendKeys(pass);
        driver.findElement(By.id("login-form-submit")).click();
    }
}
