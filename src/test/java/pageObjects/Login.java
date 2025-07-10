package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Login extends BasePage {
    private final By loginbtn = By.xpath("//button[normalize-space()='Login']");
    private final By emailField = By.xpath("//input[@id='email']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Log in']");
    private final By addbtn = By.xpath("//button[normalize-space()='Add']");
    private final By name = By.xpath("//input[@id='name']");
    private final By startdate = By.xpath("(//button[@aria-label='Choose date'])[1]");
    private final By starttime = By.xpath("(//button[@aria-label='Choose time'])[1]");
    private final By enddate = By.xpath("//label[contains(text(), 'End Date')]/following::button[@aria-label='Choose date'][1]");
    private final By endtime = By.xpath("//label[contains(text(), 'End Time')]/following::button[@aria-label='Choose time'][1]");
    private final By address = By.xpath("//input[@id='location.address.addressLine1']");
    private final By city = By.xpath("//input[@id='location.address.city']");
    private final By state = By.xpath("//input[@role='combobox']");
    private final By frequency = By.xpath("//div[@id='mui-component-select-frequency']");
    private final By pincolor = By.xpath("//input[@name='pinColor']");
    private final By pinicon = By.xpath("//button[normalize-space()='Select Pin Icon']");
    private final By addeventBtn = By.xpath("//button[normalize-space()='Add']");

    private final Random random = new Random();

    private String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    public void navigateToLoginPage() throws InterruptedException {
        driver.get("https://eventpin-api.mazedigital.us/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(4000);
    }

    public void loginbutton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Thread.sleep(3000);

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

    public void navigateToEventPage() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://eventpin-api.mazedigital.us/account/events");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(1000);
    }

    public void setAddbtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(addbtn));
        addButton.click();
        Thread.sleep(2000);

        driver.findElement(name).sendKeys(getRandomString(6));
        Thread.sleep(1000);

        driver.findElement(startdate).click();
        List<WebElement> allDates = driver.findElements(By.cssSelector("button.MuiPickersDay-root"));
        for (WebElement date : allDates) {
            if (date.getText().equals("15")) {
                date.click();
                break;
            }
        }
        driver.findElement(starttime).click();
        WebElement hour = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@aria-label='4 hours']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hour);
        hour.click();
        WebElement minute = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@aria-label='5 minutes']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", minute);
        minute.click();
        WebElement pm = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@aria-label='AM']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pm);
        pm.click();
        WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='OK']")));
        okBtn.click();
//        Thread.sleep(2000);


        driver.findElement(enddate).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.MuiPickersDay-root")));
        List<WebElement> endDates = driver.findElements(By.cssSelector("button.MuiPickersDay-root"));

        for (WebElement date : endDates) {
            if (date.isDisplayed() && date.getText().equals("20")) {
                date.click();
                break;
            }
        }
        Thread.sleep(1000);

        driver.findElement(endtime).click();
        WebElement hour1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@aria-label='4 hours']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hour1);
        hour1.click();
        WebElement minute1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@aria-label='5 minutes']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", minute1);
        minute1.click();
        WebElement pm1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@aria-label='AM']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pm1);
        pm1.click();
        WebElement okBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='OK']")));
        okBtn1.click();
        Thread.sleep(2000);

        driver.findElement(address).sendKeys(getRandomString(6));
        Thread.sleep(1000);

        driver.findElement(city).sendKeys(getRandomString(6));
        Thread.sleep(1000);
        String[] states = {
                "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
                "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho",
                "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
                "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
                "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
                "New Hampshire", "New Jersey", "New Mexico", "New York",
                "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
                "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
                "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington, D.C.",
                "West Virginia", "Wisconsin", "Wyoming"
        };

        String randomState = states[random.nextInt(states.length)];
        WebElement stateInput = driver.findElement(state);
        stateInput.click();
        Thread.sleep(500);
        stateInput.sendKeys(randomState);
        Thread.sleep(1000);
        stateInput.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(300);
        stateInput.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        int randomNum = (int) (Math.random() * 90000) + 10000;
        String fiveDigit = String.valueOf(randomNum);
        System.out.println("Generated Number: " + fiveDigit);
        WebElement inputField = driver.findElement(By.xpath("//input[@id='location.address.zip']"));
        inputField.clear();
        inputField.sendKeys(fiveDigit);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('location.address.zip').value='" + fiveDigit + "';");
        js.executeScript("document.getElementById('location.address.zip').dispatchEvent(new Event('input'));");
        Thread.sleep(4000);

        WebElement toggleSwitch = driver.findElement(By.xpath("//input[@name='isRecurring']"));
        String isChecked = toggleSwitch.getAttribute("aria-checked");
        if (!"true".equals(isChecked)) {
            toggleSwitch.click();
        }
        String updatedCheck = toggleSwitch.getAttribute("aria-checked");
        System.out.println("Switch checked: " + updatedCheck);
        WebElement freqDropdown = wait.until(ExpectedConditions.elementToBeClickable(frequency));
        freqDropdown.click();
        Thread.sleep(1000);
        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul//li[@role='option']"))
        );
        if (!options.isEmpty()) {
            Random rand1 = new Random();
            int randomIndex = rand1.nextInt(options.size());
            WebElement selectedOption = options.get(randomIndex);
            String selectedText = selectedOption.getText().trim();
            selectedOption.click();
            System.out.println("Selected option index: " + randomIndex);
            System.out.println("Selected option text: " + selectedText);
            Thread.sleep(1000);
        } else {
            System.out.println("No frequency options found!");
        }
        Thread.sleep(3000);

        WebElement colorInput = driver.findElement(pincolor);
        String colorValue = "#DB37E6";
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", colorInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", colorInput, colorValue);
        Thread.sleep(4000);

        driver.findElement(pinicon).click();
        driver.findElement(By.xpath("//div[@class='MuiDialogContent-root css-3fgd3y-MuiDialogContent-root']//div[6][1]")).click();
        Thread.sleep(3000);
        driver.findElement(addeventBtn).click();
        Thread.sleep(3000);
    }
    public void navigateTodiscoverPage() throws InterruptedException {
        driver.get("https://eventpin-api.mazedigital.us/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(4000);
    }
}

