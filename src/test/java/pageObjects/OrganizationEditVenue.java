package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrganizationEditVenue extends BasePage{
    private final By acco = By.xpath("//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-t76jb0-MuiAvatar-root']");
    private final By org = By.xpath("(//div[@class='MuiBox-root css-fl4iwt'])[4]");
    private final By hamburg = By.cssSelector(".MuiSvgIcon-root.MuiSvgIcon-fontSizeMedium.css-715at-MuiSvgIcon-root");
    private final By editOrg = By.xpath("//li[2]/parent::ul[@class='MuiList-root MuiList-padding css-h4y409-MuiList-root']//li[2]");
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
            String dynamicOrgId = "9fd5deae-2e14-4ced-a50c-21e27c74db4c";
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
        driver.findElement(updatebutton).click();
    }
}
