package TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjects.*;

public class BaseTest {
    protected Login loginPage;
    protected Event eventPage;
    protected Organization organizationPage;

    @BeforeSuite
    public void setUp() {
        BasePage.initializeDriver();
        loginPage = new Login();
        eventPage = new Event();
        organizationPage = new Organization();

    }
    @AfterSuite
    public void tearDownSuite() {
        BasePage.quitDriver();
    }
}
