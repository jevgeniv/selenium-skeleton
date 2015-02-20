package com.nortal.course.selenium.jira;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import sun.applet.Main;

import static junit.framework.Assert.assertEquals;

/**
 * Created by pavel on 17/02/15.
 */
@Category(JiraSeleniumTestBase.class)
public class CreateDashboardTest extends JiraSeleniumTestBase{

    @Test
    public void createDashboard(){
        login();
        MainPageHeader header = new MainPageHeader(getDriver());
        header.getManageDashboardsPage();
        String h1Text = getDriver().findElement(By.xpath("(//h1)[2]")).getText();
        assertEquals("Manage Dashboards", h1Text);
    }

}
