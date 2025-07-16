package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends BasePage {
    private final By loginbtn = By.xpath("//button[normalize-space()='Login']");
    private final By emailField = By.xpath("//input[@id='email']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Log in']");

    public void navigateToLoginPage() throws InterruptedException {
        driver.get("https://eventpin-api.mazedigital.us/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(5500);
    }

    public void loginbutton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Thread.sleep(4000);

        WebElement loginBtnElement = wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
        loginBtnElement.click();
    }

    public void enterEmail(String email) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("https://eventpin-api.mazedigital.us/");
    }
}

