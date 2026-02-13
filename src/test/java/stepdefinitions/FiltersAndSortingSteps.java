package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ResultsPage;

public class FiltersAndSortingSteps {
    
    ResultsPage resultsPage = new ResultsPage(BaseTest.driver);
    
    @When("user applies price filter on trains")
    public void userAppliesPriceFilterOnTrains() {
        resultsPage.applyPriceFilter();
    }
    
    @When("user applies rating filter on trains")
    public void userAppliesRatingFilterOnTrains() {
        resultsPage.applyRatingFilter();
    }
    
    @When("user sorts train results by price")
    public void userSortsTrainResultsByPrice() {
        resultsPage.sortResultsByPrice();
    }
    
    @Then("filters should be applied on train results")
    public void filtersShouldBeAppliedOnTrainResults() {
        Assert.assertTrue(resultsPage.areFiltersApplied(), "Filters not applied");
    }
    
    @Then("train results should be sorted")
    public void trainResultsShouldBeSorted() {
        Assert.assertTrue(resultsPage.areResultsSorted(), "Results not sorted");
    }
}