Feature: MakeMyTrip Home Page Functionality

  Background:
    Given user opens MakeMyTrip website

  Scenario: Verify home page loads successfully
    Then home page should be loaded successfully

  Scenario: Verify login popup is handled
    When user closes the login popup
    Then login popup should be closed

  Scenario: Verify presence of Flights tab
    Then Flights tab should be present

  Scenario: Verify presence of Hotels tab
    Then Hotels tab should be present

  Scenario: Verify presence of Trains tab
    Then Trains tab should be present
