package TestCases;

import org.testng.annotations.Test;
import pageObjects.Organization;

public class OrganizationTest extends BaseTest {
    @Test(priority = 3, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testOrg() throws InterruptedException {
        organizationPage = new Organization();
        organizationPage.navigateToOrgPage();
        organizationPage.addOrg();
    }
}
