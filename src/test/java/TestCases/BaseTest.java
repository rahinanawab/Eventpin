package TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjects.*;

public class BaseTest {
    protected Login loginPage;
    protected Event eventPage;
    protected Organization organizationPage;
    protected OrganizationEdit organizationEditPage;
    protected OrganizationEditVenue organizationEditVenuePage;
    protected OrgEvent orgEventPage;

    @BeforeSuite
    public void setUp() {
        BasePage.initializeDriver();
        loginPage = new Login();
        eventPage = new Event();
        organizationPage = new Organization();
        organizationEditPage = new OrganizationEdit();
        organizationEditVenuePage = new OrganizationEditVenue();
        organizationEditVenuePage = new OrganizationEditVenue();
        orgEventPage = new OrgEvent();

    }
//    @AfterSuite
//    public void tearDownSuite() {
//        BasePage.quitDriver();
//    }
}
