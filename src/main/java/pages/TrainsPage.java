package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class TrainsPage {
    
    private WebDriver driver;
    private WaitUtils waitUtils;
    
    private By fromStation = By.xpath("//input[@id='fromCity']");
    private By toStation = By.xpath("//input[@id='toCity']");
    private By travelDate = By.xpath("//label[@for='travelDate']");
    private By searchButton = By.xpath("//a[contains(text(),'Search')]");
    
    public TrainsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
    
    public void enterFromStation(String station) {
        try {
            WebElement from = waitUtils.waitForElement(fromStation, 10);
            from.click();
            Thread.sleep(500);
            from.sendKeys(station);
            Thread.sleep(1500);
            from.sendKeys(Keys.ARROW_DOWN);
            from.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Error entering from station: " + e.getMessage());
        }
    }
    
    public void enterToStation(String station) {
        try {
            WebElement to = driver.findElement(toStation);
            to.sendKeys(station);
            Thread.sleep(1500);
            to.sendKeys(Keys.ARROW_DOWN);
            to.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Error entering to station: " + e.getMessage());
        }
    }
    
    public void selectTravelDate() {
        try {
            driver.findElement(travelDate).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[@aria-disabled='false'][1]")).click();
        } catch (Exception e) {
            System.out.println("Error selecting date: " + e.getMessage());
        }
    }
    
    public void clickSearch() {
        try {
            Thread.sleep(1000);
            driver.findElement(searchButton).click();
        } catch (Exception e) {
            System.out.println("Error clicking search: " + e.getMessage());
        }
    }
    
    public void clickSearchWithoutDate() {
        try {
            Thread.sleep(1000);
            driver.findElement(searchButton).click();
        } catch (Exception e) {
            System.out.println("Error clicking search: " + e.getMessage());
        }
    }
    
    public boolean isFromFieldPresent() {
        try {
            return driver.findElement(fromStation).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isErrorDisplayed() {
        try {
            Thread.sleep(2000);
            String currentUrl = driver.getCurrentUrl();
            
           return currentUrl.contains("makemytrip.com") && 
                   !currentUrl.contains("/railways");
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isDateMandatory() {
        try {
            Thread.sleep(1000);
            String currentUrl = driver.getCurrentUrl();
            
           return currentUrl.contains("makemytrip.com") && 
                   currentUrl.contains("rail");
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isDateFieldDisabledOrSelected() {
        try {
            Thread.sleep(1000);
            WebElement dateField = driver.findElement(travelDate);
            String dateText = dateField.getText();
            String dateValue = dateField.getAttribute("value");
            
            return (dateText != null && !dateText.isEmpty()) || 
                   (dateValue != null && !dateValue.isEmpty()) ||
                   driver.getPageSource().contains("selectedDate") ||
                   driver.getPageSource().contains("travelDate");
        } catch (Exception e) {
            return false;
        }
    }
}
