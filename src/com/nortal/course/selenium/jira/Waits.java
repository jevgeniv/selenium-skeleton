package com.nortal.course.selenium.jira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by karl on 20.02.2015.
 */
public class Waits {
    protected final WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    protected Wait<WebDriver> getWait() {
        return new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS);
    }
}
