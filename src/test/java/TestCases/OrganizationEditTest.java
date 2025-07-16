package TestCases;

import org.testng.annotations.Test;
import pageObjects.OrganizationEdit;

public class OrganizationEditTest extends BaseTest {
    @Test(priority = 4, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testOrgedit() throws InterruptedException {
        organizationEditPage = new OrganizationEdit();
        organizationEditPage.accountorg();
        organizationEditPage.setHamburg();
    }
}
