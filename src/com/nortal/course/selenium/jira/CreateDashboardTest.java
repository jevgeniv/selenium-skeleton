package com.nortal.course.selenium.jira;

import com.nortal.course.selenium.ScreenshotRule;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static junit.framework.Assert.assertEquals;

/**
 * Created by pavel on 17/02/15.
 */
@Category(JiraSeleniumTestBase.class)
public class CreateDashboardTest extends JiraSeleniumTestBase{

    @Test
    public void createDashboard() {
        login();
        MainPageHeader header = new MainPageHeader(this);
        //1) Navigate: Dashboard - Manage Dashboards
        ManageDashboardsPage manageDashboards = header.getManageDashboardsPage();
        assertEquals("Manage Dashboards", manageDashboards.getHeaderText());
        //2) Create new dashboard
        CreateDashboardPage createDashboardPage = manageDashboards.getCreateDashboardPage();
        assertEquals("Create New Dashboard", createDashboardPage.getHeaderText());
        //3)Push Add button - check the error message is presented: "You must specify a name to save the dashboard as."
        createDashboardPage.add();
        assertEquals("You must specify a name to save the dashboard as.", createDashboardPage.getNameError());
        //4) Specify the Name of dashboard (try to use something different from "My Dashboard", "Dashboard")
        createDashboardPage.addName();
        //5) In Add Shares select "Group" and in the box next of that "jira-users" and click  +Add
        createDashboardPage.selectShares(CreateDashboardPage.shareGroupValue);
        //6
        createDashboardPage.selectGroup(CreateDashboardPage.groupJiraUsers);
        //
        createDashboardPage.addShares();
        //
        createDashboardPage.add();
        //
        // //table//tr/td[1]/div[2]/a[text()="Fri Mar 06 14:44:55 EET 2015 test dashboard"]

    }

}
