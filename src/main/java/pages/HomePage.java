package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WaitUtils;

public class HomePage {
    
    private WebDriver driver;
    private WaitUtils waitUtils;
    
    private By loginPopupClose = By.xpath("//span[@data-cy='closeModal']");
    private By flightsTab = By.xpath("//span[text()='Flights']");
    private By hotelsTab = By.xpath("//span[text()='Hotels']");
    private By trainsTab = By.xpath("//span[text()='Trains']");
    private By pageBody = By.tagName("body");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
    
    public void closeLoginPopup() {
        try {
            WebElement closeBtn = waitUtils.waitForElement(loginPopupClose, 5);
            closeBtn.click();
            Thread.sleep(500);
            
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(pageBody)).click().build().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Login popup handling: " + e.getMessage());
        }
    }
    
    public boolean isPageLoaded() {
        try {
            return driver.getTitle().contains("MakeMyTrip");
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isFlightsTabPresent() {
        try {
            return driver.findElement(flightsTab).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isHotelsTabPresent() {
        try {
            return driver.findElement(hotelsTab).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isTrainsTabPresent() {
        try {
            return driver.findElement(trainsTab).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void clickFlightsTab() {
        driver.findElement(flightsTab).click();
    }
    
    public void clickHotelsTab() {
        driver.findElement(hotelsTab).click();
    }
    
    public void clickTrainsTab() {
        driver.findElement(trainsTab).click();
    }
}
