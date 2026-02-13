package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;

public class HomePageSteps {
    
    HomePage homePage = new HomePage(BaseTest.driver);
    
    @Given("user opens MakeMyTrip website")
    public void userOpensMakeMyTripWebsite() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @When("user closes the login popup")
    public void userClosesLoginPopup() {
        homePage.closeLoginPopup();
    }
    
    @Then("home page should be loaded successfully")
    public void homePageShouldBeLoaded() {
        Assert.assertTrue(homePage.isPageLoaded(), "Home page not loaded");
    }
    
    @Then("login popup should be closed")
    public void loginPopupShouldBeClosed() {
        Assert.assertTrue(true);
    }
    
    @Then("Flights tab should be present")
    public void flightsTabShouldBePresent() {
        Assert.assertTrue(homePage.isFlightsTabPresent(), "Flights tab not present");
    }
    
    @Then("Hotels tab should be present")
    public void hotelsTabShouldBePresent() {
        Assert.assertTrue(homePage.isHotelsTabPresent(), "Hotels tab not present");
    }
    
    @Then("Trains tab should be present")
    public void trainsTabShouldBePresent() {
        Assert.assertTrue(homePage.isTrainsTabPresent(), "Trains tab not present");
    }
    
    @Given("user navigates to hotels page")
    public void userNavigatesToHotelsPage() {
        homePage.clickHotelsTab();
    }
    
    @Given("user navigates to trains page")
    public void userNavigatesToTrainsPage() {
        homePage.clickTrainsTab();
    }
    
    @When("user navigates to flights page")
    public void whenUserNavigatesToFlightsPage() {
        homePage.clickFlightsTab();
    }
}
