Feature: MakeMyTrip Hotels Search Functionality

  Background:
    Given user opens MakeMyTrip website
    And user closes the login popup
    And user navigates to hotels page

  Scenario: Verify hotels page loads
    Then city field should be present on hotels page

  Scenario: Search hotels with valid city
    When user enters "Goa" in city field
    And user selects check-in date
    And user selects check-out date
    And user clicks on hotel search button
    Then hotel results page should be displayed

  Scenario: Search hotels without selecting dates
    When user enters "Mumbai" in city field
    And user clicks hotel search without dates
    Then error or same page should be displayed for hotels

  Scenario: Verify hotel results are displayed
    When user enters "Mumbai" in city field
    And user selects check-in date
    And user selects check-out date
    And user clicks on hotel search button
    Then list of hotels should be displayed
