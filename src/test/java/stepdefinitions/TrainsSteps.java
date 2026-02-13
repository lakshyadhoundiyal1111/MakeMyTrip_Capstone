package stepdefinitions;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ResultsPage;
import pages.TrainsPage;

public class TrainsSteps {
    
    TrainsPage trainsPage = new TrainsPage(BaseTest.driver);
    ResultsPage resultsPage = new ResultsPage(BaseTest.driver);
    
    @Then("from station field should be present")
    public void fromStationFieldShouldBePresent() {
        try {
            Thread.sleep(1000);
            Assert.assertTrue(trainsPage.isFromFieldPresent(), "From station field not present");
        } catch (Exception e) {
            Assert.fail("Error verifying from station field");
        }
    }
    
    @When("user enters {string} in from station")
    public void userEntersFromStation(String station) {
        trainsPage.enterFromStation(station);
    }
    
    @When("user enters {string} in to station")
    public void userEntersToStation(String station) {
        trainsPage.enterToStation(station);
    }
    
    @When("user selects train travel date")
    public void userSelectsTrainTravelDate() {
        trainsPage.selectTravelDate();
    }
    
    @When("user clicks on train search button")
    public void userClicksTrainSearchButton() {
        trainsPage.clickSearch();
    }
    
    @When("user clicks train search without date")
    public void userClicksTrainSearchWithoutDate() {
        trainsPage.clickSearchWithoutDate();
    }
    
    @Then("train results page should be displayed")
    public void trainResultsPageShouldBeDisplayed() {
        Assert.assertTrue(resultsPage.isResultsPageDisplayed(), "Train results page not displayed");
    }
    
    @Then("train search results should be shown")
    public void trainSearchResultsShouldBeShown() {
        Assert.assertTrue(resultsPage.isResultsPageDisplayed(), "Train search results not shown");
    }
    
    @Then("error or same page should be displayed for trains")
    public void errorOrSamePageDisplayedForTrains() {
        Assert.assertTrue(trainsPage.isDateMandatory(), 
            "Train date should be mandatory (cannot be deselected)");
    }
}
