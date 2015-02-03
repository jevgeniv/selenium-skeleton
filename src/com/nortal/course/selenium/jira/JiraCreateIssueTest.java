package com.nortal.course.selenium.jira;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class JiraCreateIssueTest extends JiraSeleniumTestBase {

//    private LoginPage loginPage;

    @Test
    public void search_1() {
        login();
        searchIssue("ATL-348");// TODO
    }

    @Test
    public void search_2() {
        login();
        searchIssue("ATL-1000111220011");
    }

    private void searchIssue(String searchKeyword) {
        getDriver().findElement(By.id("quickSearchInput")).sendKeys(searchKeyword);
        getDriver().findElement(By.id("quickSearchInput")).sendKeys(Keys.RETURN);
    }

//    private LoginPage getLoginPage() {
//        if (loginPage == null) {
//            loginPage = new LoginPage(this);
//        }
//        return loginPage;
//    }


}
