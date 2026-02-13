Feature: MakeMyTrip Trains Search Functionality

  Background:
    Given user opens MakeMyTrip website
    And user closes the login popup
    And user navigates to trains page

  Scenario: Verify trains page loads
    Then from station field should be present

  Scenario: Search trains with valid stations
    When user enters "Delhi" in from station
    And user enters "Mumbai" in to station
    And user selects train travel date
    And user clicks on train search button
    Then train results page should be displayed

  Scenario: Search trains without travel date
    When user enters "Bangalore" in from station
    And user enters "Chennai" in to station
    And user clicks train search without date
    Then error or same page should be displayed for trains

  Scenario: Verify train results page
    When user enters "Bangalore" in from station
    And user enters "Chennai" in to station
    And user selects train travel date
    And user clicks on train search button
    Then train search results should be shown
