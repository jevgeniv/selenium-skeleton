package com.nortal.course.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by karl on 20.02.2015.
 */
public class BasePageObject {
    protected final WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectElement(By locator, String value){
        selectElement(driver.findElement(locator), value);
    }

    public void selectElement(WebElement webElement, String value){
        Select select = new Select(webElement);
        select.selectByValue(value);
    }
}
