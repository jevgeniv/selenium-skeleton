package com.nortal.course.selenium;

import com.nortal.course.selenium.jira.JiraCreateIssueTest;
import com.nortal.course.selenium.jira.JiraSearchIssueTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {JiraSearchIssueTest.class, JiraCreateIssueTest.class, TrivialSearchTest.class, GoogleSuggestTest.class})
public class AllTestSuite {
}
