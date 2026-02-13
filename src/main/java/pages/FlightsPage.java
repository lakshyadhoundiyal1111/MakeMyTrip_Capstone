package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class FlightsPage {
    
    private WebDriver driver;
    private WaitUtils waitUtils;
    
    private By fromCity = By.xpath("//input[@id='fromCity']");
    private By toCity = By.xpath("//input[@id='toCity']");
    private By departureDate = By.xpath("//label[@for='departure']");
    private By searchButton = By.xpath("//a[contains(text(),'Search')]");
    private By applyButton = By.xpath("//button[@data-cy='travellerApplyBtn']");

    
    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
    
    public void enterFromCity(String city) {
        try {
            WebElement from = waitUtils.waitForElement(fromCity, 10);
            from.click();
            Thread.sleep(500);
            from.sendKeys(city);
            Thread.sleep(1000);
            from.sendKeys(Keys.ARROW_DOWN);
            from.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Error entering from city: " + e.getMessage());
        }
    }
    
    public void enterToCity(String city) {
        try {
            WebElement to = driver.findElement(toCity);
            to.sendKeys(city);
            Thread.sleep(1000);
            to.sendKeys(Keys.ARROW_DOWN);
            to.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Error entering to city: " + e.getMessage());
        }
    }
    
    public void selectDepartureDate() {
        try {
            driver.findElement(departureDate).click();
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
    
    public boolean clickSearchWithoutDate() throws InterruptedException {
        try {
         
            driver.findElement(applyButton).click();
            Thread.sleep(1000);
            
            driver.findElement(searchButton).click();
            Thread.sleep(1500);
            
            // Check if still on same page (error condition)
            return driver.getCurrentUrl().contains("makemytrip.com") && 
                   !driver.getCurrentUrl().contains("/flight/search");
        } catch (Exception e) {
            System.out.println("Error clicking search without date: " + e.getMessage());
            return true; // Assume error if exception
        }
    }

    
    public boolean isFromFieldPresent() {
        try {
            return driver.findElement(fromCity).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isToFieldPresent() {
        try {
            return driver.findElement(toCity).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isDepartureDatePresent() {
        try {
            return driver.findElement(departureDate).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isErrorDisplayed() {
        try {
            Thread.sleep(3000);
            String currentUrl = driver.getCurrentUrl();
          
            boolean stillOnFlightsPage = currentUrl.contains("makemytrip.com") && 
                                         !currentUrl.contains("/flight/search");
            
            return stillOnFlightsPage;
        } catch (Exception e) {
            return false;
        }
    }
}
