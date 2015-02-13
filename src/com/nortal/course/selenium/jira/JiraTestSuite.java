package com.nortal.course.selenium.jira;

import com.nortal.course.selenium.AllTestSuite;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(JiraSeleniumTestBase.class)
@Suite.SuiteClasses( {AllTestSuite.class})
public class JiraTestSuite {
}
