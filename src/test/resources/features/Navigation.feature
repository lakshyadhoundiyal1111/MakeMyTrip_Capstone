Feature: MakeMyTrip Navigation Functionality

  Scenario: Verify navigation from Flights to Hotels
    Given user opens MakeMyTrip website
    And user closes the login popup
    When user navigates to hotels page
    Then city field should be present on hotels page

  Scenario: Verify navigation from Hotels to Trains
    Given user opens MakeMyTrip website
    And user closes the login popup
    And user navigates to hotels page
    When user navigates to trains page
    Then from station field should be present

  Scenario: Verify navigation from Trains to Flights
    Given user opens MakeMyTrip website
    And user closes the login popup
    And user navigates to trains page
    When user navigates to flights page
    Then From field should be present on flights page
