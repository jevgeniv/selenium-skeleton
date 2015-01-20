package com.nortal.course.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

public class TrivialSearchByXpathTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldOpenMainPage() {
        /* protocol specification is important - http:// */
        driver.navigate().to("http://www.neti.ee"); // ~ driver.get("http://www.neti.ee");

        searchFor("nortal");

        // verify something..
        List<WebElement> nortalLinks =
                driver.findElements(By.xpath("//*[@class='result-item']//a//*[contains(text(), 'Nortal')]/ancestor::a"));
                // driver.findElements(new ByChained(By.className("result-item"), By.partialLinkText("Nortal")));
        Assert.assertTrue("there should be more than 1 link with 'Nortal' word", nortalLinks.size() > 1);
        WebElement firstNortalLink = nortalLinks.get(0);

        Assert.assertTrue("First link in search result should lead to 'www.nortal.ee'",
                firstNortalLink.getAttribute("href").contains("www.nortal.ee"));

        firstNortalLink.click();
        Assert.assertEquals("http://www.nortal.ee/", driver.getCurrentUrl());

    }

    private void searchFor(String keyword) {
        WebElement searchBarElem = driver.findElement(By.xpath("//div[@id='search-bar']"));

        WebElement queryInput =
                searchBarElem.findElement(By.xpath(".//input[@name='query']"));
//                driver.findElement(By.id("search-bar")).findElement(By.cssSelector("input.input[name='query']"));
        queryInput.sendKeys(keyword);

        searchBarElem.findElement(By.xpath(".//input[@type='submit']")).click();
    }
}
