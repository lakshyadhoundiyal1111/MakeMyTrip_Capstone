package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {
    
    @Before
    public void setup() {
        BaseTest.setupDriver("chrome");
    }
    
    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshot(BaseTest.driver, scenario.getName());
        }
        BaseTest.quitDriver();
    }
}
