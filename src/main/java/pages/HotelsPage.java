package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class HotelsPage {
    
    private WebDriver driver;
    private WaitUtils waitUtils;
    
    private By cityInput = By.xpath("//input[@id='city']");
    private By checkInDate = By.xpath("//label[@for='checkin']");
    private By checkOutDate = By.xpath("//label[@for='checkout']");
    private By applyBtn = By.xpath("//button[contains(text(),'APPLY')]");
    private By searchButton = By.xpath("//button[@id='hsw_search_button']");
    
    public HotelsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
    
    public void enterCity(String city) {
        try {
            WebElement cityField = waitUtils.waitForElement(cityInput, 10);
            cityField.click();
            Thread.sleep(500);
            cityField.sendKeys(city);
            Thread.sleep(1500);
            cityField.sendKeys(Keys.ARROW_DOWN);
            cityField.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Error entering city: " + e.getMessage());
        }
    }
    
    public void selectCheckInDate() {
        try {
            driver.findElement(checkInDate).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[@aria-disabled='false'][1]")).click();
        } catch (Exception e) {
            System.out.println("Error selecting check-in date: " + e.getMessage());
        }
    }
    
    public void selectCheckOutDate() {
        try {
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[@aria-disabled='false'][2]")).click();
        } catch (Exception e) {
            System.out.println("Error selecting check-out date: " + e.getMessage());
        }
    }
    
    public void clickSearch() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(applyBtn)).click();
            Thread.sleep(500);
            driver.findElement(searchButton).click();
        } catch (Exception e) {
            System.out.println("Error clicking search: " + e.getMessage());
        }
    }
    
    public void clickSearchWithoutDate() {
        try {
            Thread.sleep(1000);
            
            try {
                WebElement overlay = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
                overlay.click();
                Thread.sleep(500);
            } catch (Exception e) {
            	
            }
            
            WebElement searchBtn = driver.findElement(searchButton);
            ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", searchBtn);
            
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error clicking search: " + e.getMessage());
        }
    }
    
    public boolean isCityFieldPresent() {
        try {
            return driver.findElement(cityInput).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isErrorDisplayed() {
        try {
            Thread.sleep(2000);
            String currentUrl = driver.getCurrentUrl();
            
            
            return currentUrl.contains("makemytrip.com") && 
                   !currentUrl.contains("/hotels/hotel-listing");
        } catch (Exception e) {
            return false;
        }
    }
}
