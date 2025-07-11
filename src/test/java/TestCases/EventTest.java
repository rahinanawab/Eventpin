package TestCases;

import org.testng.annotations.Test;
import pageObjects.Event;

public class EventTest extends BaseTest {
    @Test(priority = 2, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testEvent() throws InterruptedException {
        eventPage = new Event();
        eventPage.navigateToEventPage();
        eventPage.setAddbtn();
        eventPage.navigateTodiscoverPage();

    }
}