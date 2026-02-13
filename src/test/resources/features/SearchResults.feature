Feature: MakeMyTrip Search Results Functionality

  Background:
    Given user opens MakeMyTrip website
    And user closes the login popup
    When user enters "Delhi" in from city
    And user enters "Mumbai" in to city
    And user selects departure date
    And user clicks on search button

  Scenario: Click on a flight from search results
    When user clicks on first result
    Then details page should be opened

  Scenario: Verify details page is displayed
    When user clicks on first result
    Then details page should be displayed

  Scenario: Verify fare or price details are displayed
    When user clicks on first result
    Then fare or price details should be visible
