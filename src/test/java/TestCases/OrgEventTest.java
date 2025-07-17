package TestCases;

import org.testng.annotations.Test;
import pageObjects.OrgEvent;

public class OrgEventTest extends BaseTest{
    @Test(priority = 6, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testEvent() throws InterruptedException {
        orgEventPage = new OrgEvent();
//        orgEventPage.accountorg();
        orgEventPage.setHamburg();
        orgEventPage.setAddbtn();
        orgEventPage.navigateTodiscoverPage();
    }
}
