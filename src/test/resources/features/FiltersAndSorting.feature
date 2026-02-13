Feature: MakeMyTrip Filters and Sorting Functionality

  Background:
    Given user opens MakeMyTrip website
    And user closes the login popup
    And user navigates to trains page
    When user enters "Delhi" in from station
    And user enters "Mumbai" in to station
    And user selects train travel date
    And user clicks on train search button

  Scenario: Apply price filter and verify results
    When user applies price filter on trains
    Then filters should be applied on train results

  Scenario: Apply rating filter and verify results
    When user applies rating filter on trains
    Then filters should be applied on train results

  Scenario: Sort search results by price
    When user sorts train results by price
    Then train results should be sorted