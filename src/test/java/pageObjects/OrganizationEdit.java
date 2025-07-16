package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrganizationEdit extends BasePage{
    private final By acco = By.xpath("//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-t76jb0-MuiAvatar-root']");
    private final By org = By.xpath("(//div[@class='MuiBox-root css-fl4iwt'])[4]");
    private final By hamburg = By.cssSelector(".MuiSvgIcon-root.MuiSvgIcon-fontSizeMedium.css-715at-MuiSvgIcon-root");
    private final By editOrg = By.xpath("//li[2]/parent::ul[@class='MuiList-root MuiList-padding css-h4y409-MuiList-root']//li[2]");
    private final By orgasvenue = By.cssSelector(".MuiTypography-root.MuiTypography-body2.MuiFormControlLabel-label.Mui-disabled.css-1aswb9c-MuiTypography-root");
    private final By subscribebutton = By.xpath("//button[normalize-space()='Subscribe']");
    private final By basicplan = By.xpath("//button[normalize-space()='Upgrade to Basic']");
    private final By cardno = By.xpath("//input[@id='cardNumber']");
    private final By cardexpiry = By.xpath("//input[@id='cardExpiry']");
    private final By cardcvc = By.xpath("//input[@id='cardCvc']");
    private final By billingName = By.xpath("//input[@id='billingName']");
    private final By payButton = By.cssSelector("button[type='submit']");
    private final By orgasvenue1 = By.cssSelector(".MuiFormControlLabel-root.MuiFormControlLabel-labelPlacementEnd.css-j204z7-MuiFormControlLabel-root");
    private final By updatebutton = By.xpath("//button[normalize-space()='Update']");


    public void accountorg() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Thread.sleep(2000);
        WebElement accodropdown = wait.until(ExpectedConditions.presenceOfElementLocated(acco));
        Thread.sleep(1000);
        accodropdown.click();
        Thread.sleep(1000);
        WebElement orgopen = wait.until(ExpectedConditions.presenceOfElementLocated(org));
        Thread.sleep(1000);
        orgopen.click();
        Thread.sleep(1000);
    }
    public void setHamburg() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Thread.sleep(2000);
        WebElement hamdropdown = wait.until(ExpectedConditions.presenceOfElementLocated(hamburg));
        Thread.sleep(1000);
        hamdropdown.click();
        Thread.sleep(1000);
        WebElement editorgoption = wait.until(ExpectedConditions.presenceOfElementLocated(editOrg));
        Thread.sleep(1000);
        editorgoption.click();
        Thread.sleep(1000);
            String baseUrl = "https://eventpin-api.mazedigital.us/account/organizations/";
            String dynamicOrgId = "9cbd2e1c-3308-4985-8933-d20547cefd72";
            String fullUrl = baseUrl + dynamicOrgId;
            driver.get(fullUrl);
            driver.navigate().refresh();

        Thread.sleep(5000);
        int retries = 3;
        while (retries > 0) {
            try {
                WebElement venueorg = wait.until(ExpectedConditions.elementToBeClickable(orgasvenue1));
                Thread.sleep(1000);
                venueorg.click();
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Caught stale element, retrying...");
                retries--;
                Thread.sleep(500);
            }
        }
//        WebElement subs = wait.until(ExpectedConditions.presenceOfElementLocated(subscribebutton));
//        Thread.sleep(1000);
//        subs.click();
//        Thread.sleep(1000);
//        WebElement basic = wait.until(ExpectedConditions.presenceOfElementLocated(basicplan));
//        basic.click();
//        Thread.sleep(1000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//        driver.findElement(cardno).sendKeys("4242424242424242");

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//        driver.findElement(cardexpiry).sendKeys("0228");
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//        driver.findElement(cardcvc).sendKeys("554");
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//        driver.findElement(billingName).sendKeys("hello");
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement button = driver.findElement(payButton);
//        js.executeScript("arguments[0].click();", button);


driver.findElement(updatebutton).click();

    }
}
