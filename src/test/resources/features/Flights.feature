Feature: MakeMyTrip Flights Search Functionality

  Background:
    Given user opens MakeMyTrip website
    And user closes the login popup

  Scenario: Verify From and To fields are present
    Then From field should be present on flights page
    And To field should be present on flights page

  Scenario: Verify departure date picker is present
    Then departure date picker should be present

  Scenario: Search flights with valid cities
    When user enters "Delhi" in from city
    And user enters "Mumbai" in to city
    And user selects departure date
    And user clicks on search button
    Then flight results page should be displayed

  Scenario: Search flights with same source and destination
    When user enters "Delhi" in from city
    And user enters "Delhi" in to city
    And user selects departure date
    And user clicks on search button
    Then error or same page should be displayed for flights

  Scenario: Search flights without selecting travel date
    When user enters "Delhi" in from city
    And user enters "Mumbai" in to city
    And user clicks search without date for flights
    Then error or same page should be displayed for flights

  Scenario: Verify flight search results page is displayed
    When user enters "Bangalore" in from city
    And user enters "Chennai" in to city
    And user selects departure date
    And user clicks on search button
    Then flight results page should be displayed

  Scenario: Verify list of available flights
    When user enters "Bangalore" in from city
    And user enters "Chennai" in to city
    And user selects departure date
    And user clicks on search button
    Then list of flights should be displayed
