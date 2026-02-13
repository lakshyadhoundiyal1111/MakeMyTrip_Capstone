package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ResultsPage;

public class SearchResultsSteps {
    
    ResultsPage resultsPage = new ResultsPage(BaseTest.driver);
    
    @When("user clicks on first result")
    public void userClicksOnFirstResult() {
        resultsPage.clickFirstResult();
    }
    
    @Then("details page should be opened")
    public void detailsPageShouldBeOpened() {
        Assert.assertTrue(resultsPage.isDetailsPageDisplayed(), "Details page not opened");
    }
    
    @Then("details page should be displayed")
    public void detailsPageShouldBeDisplayed() {
        Assert.assertTrue(resultsPage.isDetailsPageDisplayed(), "Details page not displayed");
    }
    
    @Then("fare or price details should be visible")
    public void fareOrPriceDetailsShouldBeVisible() {
        Assert.assertTrue(resultsPage.areFareDetailsDisplayed(), "Fare details not visible");
    }
}
