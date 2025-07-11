package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Organization extends BasePage{
    private final By name = By.xpath("//input[@id='name']");
    private final By email = By.xpath("//input[@id='email']");
    private final By address1 = By.xpath("//input[@id='address.addressLine1']");
    private final By address2 = By.xpath("//input[@id='address.addressLine2']");
    private final By city = By.xpath("//input[@id='address.city']");
    private final By state = By.xpath("//input[@role='combobox']");
    private final By website = By.id("website");
    private final By fburl = By.id("facebookUrl");
    private final By igurl = By.id("instagramUrl");
    private final By twitterurl = By.id("twitterUrl");
    private final By addorgBtn = By.xpath("//button[normalize-space()='Add']");

    private final Random random = new Random();

    private String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    private String getRandomEmail() {
        return getRandomString(8) + "@gmail.com";
    }

    public void navigateToOrgPage() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://eventpin-api.mazedigital.us/account/organizations/create");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(1000);
    }
    public void addOrg() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Thread.sleep(4000);
        driver.findElement(name).sendKeys(getRandomString(6));
        Thread.sleep(1000);
        driver.findElement(email).sendKeys(getRandomEmail());
        Thread.sleep(1000);
        driver.findElement(address1).sendKeys(getRandomString(6));
        Thread.sleep(1000);
        driver.findElement(address2).sendKeys(getRandomString(6));
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
        WebElement inputField = driver.findElement(By.xpath("//input[@id='address.zip']"));
        inputField.clear();
        inputField.sendKeys(fiveDigit);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('address.zip').value='" + fiveDigit + "';");
        js.executeScript("document.getElementById('address.zip').dispatchEvent(new Event('input'));");
        Thread.sleep(4000);

        String[] urls = {
                "https://example.com",
                "https://google.com",
                "https://github.com",
                "https://wikipedia.org",
                "https://stackoverflow.com"
        };
        Random rand = new Random();
        String randomUrl = urls[rand.nextInt(urls.length)];
        driver.findElement(website).sendKeys(randomUrl);
        Thread.sleep(1000);
        String[] fbUrls = {
                "https://www.facebook.com/zuck",
                "https://www.facebook.com/facebook",
                "https://www.facebook.com/natgeo",
                "https://www.facebook.com/microsoft",
                "https://www.facebook.com/Google"
        };
        Random rand1 = new Random();
        String randomFbUrl = fbUrls[rand1.nextInt(fbUrls.length)];
        driver.findElement(fburl).sendKeys(randomFbUrl);
        Thread.sleep(1000);
        String[] instaUrls = {
                "https://www.instagram.com/cristiano/",
                "https://www.instagram.com/instagram/",
                "https://www.instagram.com/natgeo/",
                "https://www.instagram.com/selenagomez/",
                "https://www.instagram.com/therock/"
        };
        Random rand2 = new Random();
        String randomIgUrl = instaUrls[rand2.nextInt(instaUrls.length)];
        driver.findElement(igurl).sendKeys(randomIgUrl);
        Thread.sleep(1000);
        String[] twitterUrls = {
                "https://twitter.com/elonmusk",
                "https://twitter.com/nasa",
                "https://twitter.com/twitter",
                "https://twitter.com/BBCBreaking",
                "https://twitter.com/BarackObama"
        };
        Random rand3 = new Random();
        String randomTwitterUrl = twitterUrls[rand3.nextInt(twitterUrls.length)];
        driver.findElement(twitterurl).sendKeys(randomTwitterUrl);
        Thread.sleep(1000);
        driver.findElement(addorgBtn).click();
        Thread.sleep(3000);
    }
}
