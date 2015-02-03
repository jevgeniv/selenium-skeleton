package com.nortal.course.selenium.jira;

import com.google.common.base.Function;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JiraCreateIssueTest extends JiraSeleniumTestBase {
    /*
     * Source: http://tolkiengateway.net/wiki/Uncommon_words
     */
    private final static String uniqueSummaryKeyword = "[BillowIsaLargeWave]";

    @Test
    public void createIssue() {
        login();
        MainPageHeader mainPageHeader = PageFactory.initElements(getDriver(), MainPageHeader.class);
        mainPageHeader.clickCreateIssue();

        // 'final' is a requirement for fields used within inner class.
        // Otherwise the original reference could get "disconnected" from the context.
        final CreateIssuePage createIssuePage = CreateIssuePage.makeInstance(this);

        getWait().until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                // createIssuePage.getSummaryProxy() != null will not work, because the Proxy is always there
                return createIssuePage.isReady();
            }
        });

        createIssuePage.getSummaryProxy().sendKeys("Test issue created by Selenium " + uniqueSummaryKeyword);
    }

}
