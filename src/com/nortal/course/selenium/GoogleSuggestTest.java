package com.nortal.course.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GoogleSuggestTest {

    private static final Logger LOG =  LoggerFactory.getLogger(GoogleSuggestTest.class);

    @Test
    public void suggestionsListIsShown() throws Exception {
        // The Firefox driver supports javascript
        WebDriver driver = new FirefoxDriver();
        LOG.debug("web driver instantiated");


        // Go to the Google Suggest home page
        driver.get("http://www.google.com/webhp?complete=1&hl=en");

        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");

        // Sleep until the div we want is visible or 5 seconds is over
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            WebElement resultsDiv = driver.findElement(By.className("sbdd_a"));

            // If results have been returned, the results are displayed in a drop down.
            if (resultsDiv.isDisplayed() && !getSuggestions(driver).isEmpty()) {
                break;
            }
        }

        // And now list the suggestions
        List<WebElement> allSuggestions = getSuggestions(driver);

        for (WebElement suggestion : allSuggestions) {
            LOG.debug(suggestion.getText());
        }

        driver.quit();
    }

    private List<WebElement> getSuggestions(WebDriver driver) {
        return driver.findElements(By.xpath("//li[@class='sbsb_c gbqfsf']"));
    }
}
