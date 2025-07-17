package TestCases;

import org.testng.annotations.Test;
import pageObjects.OrganizationEdit;
import pageObjects.OrganizationEditVenue;

public class OrganizationEditVenueTest extends BaseTest {
    @Test(priority = 5, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testOrgedit() throws InterruptedException {
        organizationEditVenuePage = new OrganizationEditVenue();
        organizationEditVenuePage.accountorg();
        organizationEditVenuePage.setHamburg();
    }
}
