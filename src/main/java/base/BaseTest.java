package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;

public class BaseTest {
    
    public static WebDriver driver;
    
    public static void setupDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.makemytrip.com");
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    public static WebDriver getDriver() {
        return driver;
    }
}
