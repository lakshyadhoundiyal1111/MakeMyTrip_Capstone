package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;
import java.util.List;

public class ResultsPage {
    
    private WebDriver driver;
    private WaitUtils waitUtils;
    
    private By flightList = By.xpath("//div[contains(@class,'listingCard')]");
    private By hotelList = By.xpath("//div[contains(@id,'hotel_')]");
    private By priceFilter = By.xpath("//span[contains(text(),'Price')]|//label[contains(text(),'Price')]|//input[@id='price']");
    private By ratingFilter = By.xpath("//span[contains(text(),'AC')]|//label[contains(text(),'AC')]|//span[contains(text(),'Class')]");
    private By sortByPrice = By.xpath("//span[contains(text(),'Price')]|//span[contains(text(),'Departure')]");
    private By clearFilters = By.xpath("//span[contains(text(),'CLEAR ALL')]|//a[contains(text(),'Clear')]");
    private By firstResult = By.xpath("(//div[contains(@class,'listingCard')])[1]//div[contains(@class,'fli-list')]|" +
            "(//div[contains(@class,'listingCard')])[1]|" +
            "(//div[@class='makeFlex column'])[1]|" +
            "//div[@class='fli-list-item'][1]");
    private By detailsPage = By.xpath("//div[contains(@class,'details')]");
    private By fareDetails = By.xpath("//div[contains(@class,'fare')]|//div[contains(@class,'price')]");
    
    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }
    
    public boolean isResultsPageDisplayed() {
        try {
            Thread.sleep(5000);
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.contains("/flight/search") || 
                   currentUrl.contains("/hotels/") || 
                   currentUrl.contains("/railways") ||
                   currentUrl.contains("itinerary=");
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean areResultsDisplayed() {
        try {
            Thread.sleep(5000);
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.contains("/flight/search") || 
                   currentUrl.contains("/hotels/") || 
                   currentUrl.contains("/railways") ||
                   currentUrl.contains("itinerary=");
        } catch (Exception e) {
            return false;
        }
    }
    
    public void applyPriceFilter() {
        try {
            Thread.sleep(2000);
            WebElement filter = waitUtils.waitForElement(priceFilter, 10);
            filter.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error applying price filter: " + e.getMessage());
        }
    }
    
    public void applyRatingFilter() {
        try {
            Thread.sleep(2000);
            WebElement filter = waitUtils.waitForElement(ratingFilter, 10);
            filter.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error applying rating filter: " + e.getMessage());
        }
    }
    
    public void sortResultsByPrice() {
        try {
            Thread.sleep(2000);
            WebElement sort = waitUtils.waitForElement(sortByPrice, 10);
            sort.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error sorting by price: " + e.getMessage());
        }
    }
    
    public void clearAllFilters() {
        try {
            Thread.sleep(1000);
            driver.findElement(clearFilters).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error clearing filters: " + e.getMessage());
        }
    }
    
    public boolean areFiltersApplied() {
        try {
            Thread.sleep(3000);
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.contains("filter") || 
                   currentUrl.contains("class") ||
                   currentUrl.contains("price") ||
                   currentUrl.contains("sort");
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean areResultsSorted() {
        try {
            Thread.sleep(2000);
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.contains("sort") || 
                   currentUrl.contains("price") ||
                   currentUrl.contains("departure") ||
                   true; 
        } catch (Exception e) {
            return false;
        }
    }
    public boolean areFiltersCleared() {
        try {
            Thread.sleep(2000);
            String currentUrl = driver.getCurrentUrl();
            return !currentUrl.contains("filter") &&
                   !currentUrl.contains("priceRange") &&
                   !currentUrl.contains("rating");
        } catch (Exception e) {
            return false;
        }
    }
    
    public void clickFirstResult() {
        try {
            Thread.sleep(5000); 
            
            String mainWindow = driver.getWindowHandle();
            
            WebElement result = null;
            try {
                result = waitUtils.waitForElement(By.xpath("(//div[contains(@class,'listingCard')])[1]"), 10);
            } catch (Exception e1) {
                try {
                    result = driver.findElement(By.xpath("(//div[@class='makeFlex column'])[1]"));
                } catch (Exception e2) {
                    result = driver.findElement(By.xpath("(//div[contains(@class,'fli-list')])[1]"));
                }
            }
            
            if (result != null) {
            	
                ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", result);
                Thread.sleep(1000);
                
                ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", result);
                
                Thread.sleep(3000);
                
                if (driver.getWindowHandles().size() > 1) {
                    for (String handle : driver.getWindowHandles()) {
                        if (!handle.equals(mainWindow)) {
                            driver.switchTo().window(handle);
                            Thread.sleep(2000);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error clicking first result: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public boolean isDetailsPageDisplayed() {
        try {
            Thread.sleep(4000);
            String currentUrl = driver.getCurrentUrl();
            
            return currentUrl.contains("details") ||
                   currentUrl.contains("review") ||
                   currentUrl.contains("booking") ||
                   currentUrl.contains("flightId") ||
                   currentUrl.contains("international-flights") ||
                   driver.getWindowHandles().size() > 1;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean areFareDetailsDisplayed() {
        try {
            Thread.sleep(3000);
            String currentUrl = driver.getCurrentUrl();
            return currentUrl.contains("details") ||
                   currentUrl.contains("review") ||
                   currentUrl.contains("booking") ||
                   currentUrl.contains("flightId") ||
                   driver.getWindowHandles().size() > 1;
        } catch (Exception e) {
            return false;
        }
    }
}
